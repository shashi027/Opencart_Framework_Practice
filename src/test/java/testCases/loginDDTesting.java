package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;
import testBase.baseClass;
import utilities.DataProviders;

public class loginDDTesting extends baseClass{

	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="Datadriven")
	public void loginDDTest(String email,String pwd, String exp)
	{
		
		logger.info("**** Starting loginDDtc*****");
		try {
		homePage hp=new homePage(d);
		hp.clickMyaccount();
		hp.clickLogin();
		
		logger.info("**** User clicked on login link in homepage*****");
		loginPage lp=new loginPage(d);
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		lp.clickLogin();
		logger.info("**** User clicked on login by providing user name and pwd*****");
		
		myaccountPage map=new myaccountPage(d);
		boolean targetpage=map.myaccountConfirmationMSG();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if (targetpage == true) 
			{
				map.clickLogoutbtn();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.fail();
				
			}	
		}
		
		
		if(exp.equalsIgnoreCase("invalid"))
		{
		
			if(targetpage==true)
			{
				map.clickLogoutbtn();
				Assert.fail();
				
			}
			else
			{
				
				Assert.assertTrue(true);
			}
			
		}
		
		
		}//try
		
		
		catch(Exception e)
		{
			Assert.fail();
			
		}
	}
	
}
