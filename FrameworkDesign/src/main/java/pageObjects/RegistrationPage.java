package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstactClass.AbstractComponent;

public class RegistrationPage extends AbstractComponent {

	WebDriver driver;
	Select select;
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="userEmail")
	WebElement emailID;
	
	@FindBy(id="userMobile")
	WebElement mobileNumber;
	
	@FindBy(css="[value='Male']")
	WebElement genderMale;
	
	@FindBy(css="[value='Female']")
	WebElement genderFemale;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(css="[formcontrolname='required']")
	WebElement ageCheckBox;
	
	@FindBy(css="[value='Register']")
	WebElement registerButton;
	
	@FindBy(css="[formcontrolname='occupation']")
	WebElement occupation;
	
	@FindBy(xpath = "//h1[@class='headcolor']")
	WebElement sucessRegisterMsg;
	
	
	public void selectOccupation(String occupation1)
	{
		select= new Select(occupation);
		select.selectByVisibleText(occupation1);
	}
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	public void enterEmail(String email )
	{
		emailID.sendKeys(email);
	}
	public void enterPhone(String phone)
	{
		mobileNumber.sendKeys(phone);
	}
	public void selectGenderMale()
	{
		genderMale.click();
	}
	public void selectGenderFemale()
	{
		genderFemale.click();
	}
	public void enterPassword(String passWord)
	{
		userPassword.sendKeys(passWord);
	}
	public void confirmPassword(String ConfirmpassWord)
	{
		confirmPassword.sendKeys(ConfirmpassWord);
	}
	public void ageConsentCheck()
	{
		ageCheckBox.click();
	}
	public void clickRegister()
	{
		registerButton.click();
	}
	public String checkSuccessMsg()
	{
		return sucessRegisterMsg.getText();
	}
		
}
