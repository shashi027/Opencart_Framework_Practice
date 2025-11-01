package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;
import testBase.baseClass;


//login
public class LoginTest extends baseClass{
	
	
	@Test(groups= {"Sanity","Master"})
	public void loginTest()
	{
		try {
		homePage hp =new homePage(d);
		hp.clickMyaccount();
		hp.clickLogin();
		logger.info("User clicked on login button on home page");
		
		
		loginPage lp=new loginPage(d);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		logger.info("Email and password entered into the fields");
		
		lp.clickLogin();
		logger.info("clicked login button on login page");
		
		
		myaccountPage ap=new myaccountPage(d);
		
		Assert.assertEquals(true, ap.myaccountConfirmationMSG());
		}
		
		catch(Exception e)
		{
			logger.debug("Failed");
			Assert.fail();
		}
		
	}
	
	
	

}
