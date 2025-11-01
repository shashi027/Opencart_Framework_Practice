package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends basePage{

	
	public registerPage(WebDriver d)
	{
		super(d);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtMobileNum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPrivacy;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	 public void setFirstName(String firstName) {
	        txtFirstName.clear();
	        txtFirstName.sendKeys(firstName);
	    }

	    public void setLastName(String lastName) {
	        txtLastName.clear();
	        txtLastName.sendKeys(lastName);
	    }

	    public void setEmail(String email) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }

	    public void setMobileNumber(String mobile) {
	        txtMobileNum.clear();
	        txtMobileNum.sendKeys(mobile);
	    }

	    public void setPassword(String password) {
	        txtPassword.clear();
	        txtPassword.sendKeys(password);
	    }

	    public void setConfirmPassword(String confirmPassword) {
	        txtConfirmPassword.clear();
	        txtConfirmPassword.sendKeys(confirmPassword);
	    }

	   public void acceptPrivacyPolicy()
	   {
		   if(!checkPrivacy.isSelected())
		   {
			   checkPrivacy.click();
		   }
	   }

	    public void clickContinue() {
	        btnContinue.click();
	    }

	    public String getConfirmationMessage() {
	        return msgConfirmation.getText();
	    }
	
	
	
}
