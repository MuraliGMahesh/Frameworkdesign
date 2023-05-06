package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstactClass.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-of-type(2)")
	List<WebElement> orderPageProducts;
	
	public Boolean checkOrdersPage(String orderProduct)
	{
		Boolean match = orderPageProducts.stream()
		.anyMatch(product->product.getText().equalsIgnoreCase(orderProduct));
		return match;
	}
	
}
