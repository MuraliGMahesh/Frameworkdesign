package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {
	// code
	ExtentReports extent;
	@Test
	public void submitOrder() {
		extent.createTest("Test Case");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		/*driver.findElement(By.id("userEmail")).sendKeys("testuser99@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("TestUser123");
		driver.findElement(By.id("login")).click();

		String orderProduct = "ZARA COAT 3";
		
		//LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.className("mb-3"));
		System.out.println(products.size());

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(orderProduct)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(orderProduct));

		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String finalMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(finalMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Test case passed"); */
		driver.close();
		extent.flush();

	}
	
	@BeforeTest
	public void extendReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// set the name of  report 
		reporter.config().setReportName("Automation Test Case");
		//set the name of title of webpage
		reporter.config().setDocumentTitle("Results");
	
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Murali");
		
		
	}

}
