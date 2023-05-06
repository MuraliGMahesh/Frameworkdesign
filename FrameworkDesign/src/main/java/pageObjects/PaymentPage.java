package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstactClass.AbstractComponent;

public class PaymentPage extends AbstractComponent{

	WebDriver driver;
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrderButton;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryTextBox;
	
	By countrySuggestionList = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName)
	{
		Actions act = new Actions(driver);
		act.sendKeys(countryTextBox, countryName).build().perform();
		waitUntilElementVisible(countrySuggestionList);
		selectCountry.click();
		
	}
	public FinalPage clickOnPlaceOrder()
	{
		
		PlaceOrderButton.click();
		return new FinalPage(driver);
	}
	


}
