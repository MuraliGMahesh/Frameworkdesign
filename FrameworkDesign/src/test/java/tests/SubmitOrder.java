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
import org.testng.asserts.SoftAssert;

import abstactClass.AbstractComponent;
import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.FinalPage;
import pageObjects.LoginPage;
import pageObjects.OrdersPage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;

public class SubmitOrder extends BaseTest {

	//String orderProduct = "ZARA COAT 3";
	SoftAssert softAssert = new SoftAssert();
	@Test(dataProvider = "getTestData" , groups= {"submitOrder"})
	public void submitOrder(HashMap<String, String> input) throws IOException {

		

		ProductsPage productsPage = loginPage.loginApp(input.get("email"), input.get("password"));

		List<WebElement> products = productsPage.getProductsList();

		productsPage.clickOnAddtoCart(input.get("productName"));
		CartPage cartPage = productsPage.clickOnCartIcon();

		Boolean match = cartPage.checkAddedProducts(input.get("productName"));
		softAssert.assertTrue(match);
		PaymentPage paymentPage = cartPage.clickOnCheckOut();

		paymentPage.selectCountry("india");

		FinalPage finalPage = paymentPage.clickOnPlaceOrder();

		String confirmationMsg = finalPage.getFinalMessage();
		softAssert.assertTrue(confirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		finalPage.clickOnSignOut();
		System.out.println("Test case passed");

	}
	
	@Test(dataProvider = "getTestData" , dependsOnMethods = {"submitOrder"}) // add dataPprovider="getTestData" and groups to run this test
	public void OrdersPageTest(HashMap<String, String> input)
	{
		ProductsPage productsPage = loginPage.loginApp(input.get("email"),input.get("password"));
		OrdersPage ordersPage = productsPage.clickOnOrdersIcon();
		softAssert.assertTrue(ordersPage.checkOrdersPage(input.get("productName")));
	}
	
	
	/* Method to pass data using data provider without using HashMap */
	/*@DataProvider
	public Object getTestData()
	{
		return new Object[][] {{"testuser99@gmail.com","TestUser123","ZARA COAT 3"} , {"dummyemailjl@hotmail.com","Dummy123","ADIDAS ORIGINAL"}};
	}*/
	
	/* Method to pass data using data provider with using HashMap */
	/*@DataProvider
	public  Object getTestData()
	{
		HashMap<String , String> map = new HashMap<String , String>();
		map.put("email", "testuser99@gmail.com");
		map.put("password", "TestUser123");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String , String> map1 = new HashMap<String , String>();
		map1.put("email", "dummyemailjl@hotmail.com");
		map1.put("password", "Dummy123");
		map1.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] {{map} , {map1}};
	}*/
	
	/* Method to pass data using data provider with using HashMap and read file from jSON*/
	@DataProvider
	public  Object[][] getTestData() throws IOException
	{
		List<HashMap<String, String>> data = readJsonToHashMap(System.getProperty("user.dir")+"//src//test//java//DataFiles//SubmitOrderData.json");
		return new Object[][] {{data.get(0)} , {data.get(1)}};
	}

	
}
