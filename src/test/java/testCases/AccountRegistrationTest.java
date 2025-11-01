package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.registerPage;
import testBase.baseClass;

public class AccountRegistrationTest extends baseClass{

	@Test(groups={"Regression","Master"})
	public void verify_acc_reg() throws InterruptedException
	{
		try {
		logger.info("**** register test started ***");
		homePage hm=new homePage(d);
		hm.clickMyaccount();
		logger.info("**** Clicked on Myaccount ***");
		Thread.sleep(2000);
		hm.clickRegister(); 
		logger.info("**** Clicked on register ***");
		
		
		
		
		registerPage rp=new registerPage(d);
		rp.setFirstName(randomalph().toUpperCase());
		rp.setLastName(randomalph().toUpperCase());
		rp.setEmail(randomalph()+"@gmail.com");
		rp.setMobileNumber(randomNum());
		
		String pswrd=randomAlphNum();
		
		rp.setPassword(pswrd);
		rp.setConfirmPassword(pswrd);
		
		rp.acceptPrivacyPolicy();
		
		logger.info("**** Customer details provided  ***");
		
		rp.clickContinue();
		logger.info("**** Clicked on Continue ***");
		
		String actualmessage=rp.getConfirmationMessage();
		
		
		
		if(actualmessage.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		}
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
	}
	
}
