package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstactClass.AbstractComponent;
import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.FinalPage;
import pageObjects.LoginPage;
import pageObjects.OrdersPage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

	@Test(dataProvider = "getTestData" , groups= {"Registration"})
	public void registrationTest(HashMap<String, String> input) {

		RegistrationPage registrationPage = loginPage.clickRegisterHere();
		registrationPage.enterFirstName(input.get("firstName"));
		registrationPage.enterLastName(input.get("lastName"));
		registrationPage.enterEmail(input.get("emailId"));
		registrationPage.enterPhone(input.get("phoneNumber"));
		registrationPage.selectOccupation(input.get("occupation"));
		registrationPage.selectGenderMale();
		registrationPage.enterPassword(input.get("passWord"));
		registrationPage.confirmPassword(input.get("confirmPassword"));
		registrationPage.ageConsentCheck();
		registrationPage.clickRegister();
		
		Assert.assertEquals(registrationPage.checkSuccessMsg(), "Account Created Successfully");

	}
	
	@DataProvider
	public  Object[][] getTestData() throws IOException
	{
		List<HashMap<String, String>> data = readJsonToHashMap(System.getProperty("user.dir")+"//src//test//java//DataFiles//Registration.json");
		return new Object[][] {{data.get(0)} , {data.get(1)}};
	}
	
	

}
