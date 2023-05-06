package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsNG {
	
	
	public static ExtentReports getExtentReports() 
	{
		String path = System.getProperty("user.dir")+"\\reports\\extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// set the name of  report 
		reporter.config().setReportName("Automation Test Case");
		//set the name of title of webpage
		reporter.config().setDocumentTitle("Results");
	
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Murali");
		return extent;
		
		
	}

}
