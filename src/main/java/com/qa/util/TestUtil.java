package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static String path = System.getProperty("user.dir") + "/screenshots/"+TestUtil.getCurrentDateTime()+".png";
	
	//switch to frame
	public void switchtoFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	//TakeScreenshot
	public static String takeScreensotAtEndOfTest(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshots/"+TestUtil.getCurrentDateTime()+".png";
		FileUtils.copyFile(srcFile , new File(path));
		return path;
	}
	
	
	//getCurrentDateTime
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	//explicit wait
	public static boolean isDisplayed(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
	}
	
	//element enabled with explicit wait
	public static boolean isEnabled(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOf(webElement)).isEnabled();
	}
	
	
	//element selected with explicit wait
		public static boolean isSelected(WebElement webElement) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			return wait.until(ExpectedConditions.visibilityOf(webElement)).isSelected();
		}

}
