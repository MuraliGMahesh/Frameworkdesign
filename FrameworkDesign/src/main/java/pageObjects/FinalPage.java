package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstactClass.AbstractComponent;

public class FinalPage extends AbstractComponent {


	WebDriver driver;
	public FinalPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMsg ;
	
	@FindBy(xpath="//button[text()=' Sign Out ']")
	WebElement signOutBtn;
	
	
	
	public String getFinalMessage()
	{
		return confirmationMsg.getText();
		
	}
	
	public void clickOnSignOut()
	{
		
		signOutBtn.click();
	}

	

}
