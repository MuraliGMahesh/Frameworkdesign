package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstactClass.AbstractComponent;

public class LoginPage extends  AbstractComponent{
	
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement loginEmail;
	
	@FindBy(id="userPassword")
	WebElement loginPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*=toast-message]")
	WebElement ErrorMsg;
	
	@FindBy(xpath="//a[text()='Register here']")
	WebElement registerHereLink;
	
	public ProductsPage loginApp(String email , String password)
	{
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
		
//		ProductsPage productsPage = new ProductsPage(driver);
//		 return productsPage
		return new ProductsPage(driver);

	}
	
	public void goTOURL()
	{
		driver.get("https://rahulshettyacademy.com/client/");

	}
	
	public String validateErrorLogin()
	{
		waitUntilWebElementVisible(ErrorMsg);
		return ErrorMsg.getText();
		
	}
	
	public RegistrationPage clickRegisterHere()
	{
		registerHereLink.click();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		return registrationPage;
	}
	
	

}
