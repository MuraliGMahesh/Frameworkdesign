package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class dummy {

	public static void main(String[] args)
	{
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL)
		    .click(link)
		    .keyUp(Keys.LEFT_CONTROL)
		    .build()
		    .perform();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		//driver.findElement(By.xpath("(//a[text()='Home'])[1]")).click();
	}

}
