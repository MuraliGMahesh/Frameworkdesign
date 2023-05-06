package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import abstactClass.AbstractComponent;
import baseTest.BaseTest;
import baseTest.RetryFailedCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.FinalPage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;

public class ErrorValidationsTest extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(groups= {"ErrorValidation"} , retryAnalyzer = RetryFailedCase.class)
	public void LoginError() throws IOException 
	{
		loginPage.loginApp("testuser99@gmail.com", "TestUser");
		Assert.assertEquals("Incorrect email  password.",loginPage.validateErrorLogin());

	}
	
	@Test(groups= {"ErrorValidation"} , retryAnalyzer = RetryFailedCase.class)
	public void ProductsError() throws IOException {

		String orderProduct = "ZARA COAT 3";

		ProductsPage productsPage = loginPage.loginApp("testuser99@gmail.com", "TestUser123");

		List<WebElement> products = productsPage.getProductsList();

		productsPage.clickOnAddtoCart(orderProduct);
		CartPage cartPage = productsPage.clickOnCartIcon();

		Boolean match = cartPage.checkAddedProducts("ZARA COAT 4");
		softAssert.assertFalse(match);

}
}