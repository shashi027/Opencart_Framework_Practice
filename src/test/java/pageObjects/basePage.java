package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {
	
	protected WebDriver d;
	
	public basePage(WebDriver d)
	{
		this.d=d;
		
		PageFactory.initElements(d, this);
	}

	

}
