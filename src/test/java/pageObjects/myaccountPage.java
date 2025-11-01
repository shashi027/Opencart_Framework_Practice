package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class myaccountPage extends basePage{

	public myaccountPage(WebDriver d)
	{
		super(d);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgMyAccount;
	
	
	@FindBy(xpath="//aside[@id='column-right']//a[text()='Logout']")
	WebElement btnLogout;
	
	
	public boolean myaccountConfirmationMSG() 
	{
		try {
		return msgMyAccount.isDisplayed();
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogoutbtn() 
	{
		btnLogout.click();
	}
	
	
}
