package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalProperties.properties");
		prop.load(fis);
		
		// to give browser parameter from maven command
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*"); // chrome v111.x have issue with selenium v.4.7.0 and greater
			if(browserName.contains("headless")){
					chromeOptions.addArguments("--headless");  // only if tests need be run in headless
					}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException
	{
	    driver = initializeDriver();
	    loginPage = new LoginPage(driver);
		loginPage.goTOURL();
		return loginPage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> readJsonToHashMap(String filePath) throws IOException
	{
		//convert json to string
		String dataInString = FileUtils.readFileToString(new File (filePath),StandardCharsets.UTF_8);
		
		//convert string to Hashmap using jackson databind api
		//will  return list of hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String , String>> data = mapper.readValue(dataInString, new TypeReference <List<HashMap<String , String>>>() {
		});
		return data;
	}
	
	public String getScreenshot(String testcaseName , WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File (System.getProperty("user.dir")+"//reports//screenshots//"+testcaseName+".png");
		FileUtils.copyFile(source, destination);
		/* to return File /screenshot */
		//return destination;
		
		/* to return path of the screenshot */
		return System.getProperty("user.dir")+"//reports//screenshots//"+testcaseName+".png";
		
	}
}
