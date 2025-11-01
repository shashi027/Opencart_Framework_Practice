package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{

	JavascriptExecutor js;
	
	public homePage(WebDriver d)
	
	{
		super(d);
		js = (JavascriptExecutor) d;
	}
	
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegistration;
	
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")
	WebElement lnkLogin;
	
	
	public void clickMyaccount()
	{
		//lnkMyaccount.click();
		js.executeScript("arguments[0].click()", lnkMyaccount);
		
	}
	
	public void clickRegister()
	{
		//lnkRegistration.click();
		js.executeScript("arguments[0].click()", lnkRegistration);
	}
	
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
}
