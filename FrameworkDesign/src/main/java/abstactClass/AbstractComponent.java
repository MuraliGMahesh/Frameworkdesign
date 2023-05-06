package abstactClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	
	
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartIcon;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrdersIcon;
	
	public void waitUntilElementVisible(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitUntilWebElementVisible(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitUntilElementInVisible(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage clickOnCartIcon()
	{
		//cartIcon.click();
		/* using this line since ElementClickInterceptedException exception */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cartIcon);
		
//		CartPage cartPage = new CartPage(driver);
//		return cartPage
		return new CartPage(driver);
	}
	
	public OrdersPage clickOnOrdersIcon()
	{
		OrdersIcon.click();
	
//		 OrdersPage ordersPage = new OrdersPage(driver);
//		 return ordersPage;
		return new OrdersPage(driver);
	}

}
