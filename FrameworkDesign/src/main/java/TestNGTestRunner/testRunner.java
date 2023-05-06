package TestNGTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/cucumberFeatures" ,
		glue =  "stepDefinitions",
		monochrome = true,
		plugin = {"html:reports/cucumber/cucumberreport.html"},
		tags = "@submitOrder"
		
		)
public class testRunner extends AbstractTestNGCucumberTests{
  
}
