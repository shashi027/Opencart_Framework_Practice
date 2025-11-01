package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j


public class baseClass {
  
	public  WebDriver d;
	public Logger logger;
	public Properties p;

	@SuppressWarnings("deprecation")
	@BeforeClass(groups="Setup")
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException
	{
		//loading config.properties file
		
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		FileInputStream file=new FileInputStream("./src/test/resources/config.properties");
		
		p=new Properties();
		p.load(file);
		
		//loggs
		logger=LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if (os.equalsIgnoreCase("windows")) 
			{
			    cap.setPlatform(Platform.WIN11);
			} 
			
			else if (os.equalsIgnoreCase("mac")) 
			{
			    cap.setPlatform(Platform.MAC);
			} 
			else if (os.equalsIgnoreCase("linux")) 
			{
			    cap.setPlatform(Platform.LINUX);
			} 
			else 
			{
			    System.out.println("Invalid OS");
			    return;
			}
			
		switch(browser.toLowerCase())
		{
		
		case "chrome":cap.setBrowserName("chrome"); break;
		case "edge":cap.setBrowserName("MicrosoftEdge");break;
		case "firefox":cap.setBrowserName("firefox"); break;
		default:System.out.println("Invalid browser");
		return;
		
		}
		
		d=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (browser.toLowerCase()) {
			case "chrome":d=new ChromeDriver(); break;
			case "edge":d=new EdgeDriver();break;

			default:System.out.println("Invalid browser name provided"); return;
			
			}
		}
		
		
		
		
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get(p.getProperty("appURL"));
		d.manage().window().maximize();
		
	}
	
	@AfterClass(groups="TearDown")
	public void tearDown()
	{
		d.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomalph()
	{
		String genAlph=RandomStringUtils.randomAlphabetic(5);
		return genAlph;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNum()
	{
		String genNum=RandomStringUtils.randomNumeric(10);
		return genNum;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphNum()
	{
		String genAlph=RandomStringUtils.randomAlphabetic(3);
		String genNum = RandomStringUtils.randomNumeric(3);

		return genAlph + "@" + genNum;
			
	}
	
	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) d;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
	
}
