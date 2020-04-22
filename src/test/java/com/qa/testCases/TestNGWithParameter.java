package com.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class TestNGWithParameter extends TestBase{
    
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeSuite
	public void chromeProperty() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/Framework/SeleniumPractice/drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    }
	
	@BeforeTest
	public void manageBrowser() {
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
	}
	
//	@Test
//	@Parameters({"url"})
//	public void launchBrowser(String appurl) {
//		driver.get(appurl);
//	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void extentReporting(String testName ) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/" + TestUtil.getCurrentDateTime()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest(testName);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String tempPath = TestUtil.takeScreensotAtEndOfTest(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(tempPath).build());
		}
		extent.flush();
	}
}
