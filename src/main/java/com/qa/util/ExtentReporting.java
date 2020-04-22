package com.qa.util;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.base.TestBase;

public class ExtentReporting extends TestBase{
	
	ExtentReports extent;
	ExtentTest logger;
	
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
