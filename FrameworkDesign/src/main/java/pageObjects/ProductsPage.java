package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstactClass.AbstractComponent;

public class ProductsPage extends AbstractComponent{

	WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	By productsBy = By.className("mb-3");
	By addtoCartBtn = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductsList()
	{
		waitUntilElementVisible(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String orderProduct)
	{
		WebElement prod = getProductsList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(orderProduct)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void clickOnAddtoCart(String  orderProduct)
	{
		WebElement prod = getProductByName(orderProduct);
		prod.findElement(addtoCartBtn).click();
		waitUntilElementVisible(toastMessage);
		waitUntilElementInVisible(spinner);
	}
	
	

}
