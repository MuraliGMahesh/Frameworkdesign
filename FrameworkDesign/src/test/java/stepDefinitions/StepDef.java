 package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.FinalPage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;

public class StepDef extends BaseTest{
	
	public LoginPage loginPage;
	public ProductsPage productsPage;
	FinalPage finalPage;
	
	
	@Given("I am on Login Page")
	public void I_am_on_Login_Page() throws IOException {
		
		loginPage = launchApplication();
		
	}

	@Given("^I login to website with username (.+) and password (.+)$")
	public void i_login_to_website_with_username_and_password(String username , String password) {
		
		 productsPage = loginPage.loginApp(username , password);
	}

	@When("^I add product (.+) to the cart$")
	public void i_add_product_to_the_cart(String productName) {
		
		List<WebElement> products = productsPage.getProductsList();
		productsPage.clickOnAddtoCart(productName);
		

	}

	@And("^checkout (.+) and submit the order$")
	public void checkout_zara_coat_and_submit_the_order(String productName) {
		CartPage cartPage = productsPage.clickOnCartIcon();

		Boolean match = cartPage.checkAddedProducts(productName);
		Assert.assertTrue(match);
		PaymentPage paymentPage = cartPage.clickOnCheckOut();

		paymentPage.selectCountry("india");

		 finalPage = paymentPage.clickOnPlaceOrder();

		 
		
		
	}

	@Then("{string} message is dispalyed on confirmation page")
	public void message_is_dispalyed_on_confirmation_page(String string) {
		String confirmationMsg = finalPage.getFinalMessage();
		Assert.assertTrue(confirmationMsg.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is dispalyed")
	public void login_error_message(String errorMsg) {
		Assert.assertEquals(errorMsg,loginPage.validateErrorLogin());
		driver.close();
	}
	
	
	
	
	
	
	
}
