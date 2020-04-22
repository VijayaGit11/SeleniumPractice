package com.qa.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class WorldPressLoginPage extends TestBase{

	@FindBy(xpath= "//*[@id='usernameOrEmail']")
	static
	WebElement loginID;
	
	@FindBy(xpath = "//*[@type='submit']")
	static
	WebElement submitButton;
	
	@FindBy(xpath= "//*[@id='password']")
	static
	WebElement password;
	
	
	public WorldPressLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	(dataProvider="wordpressData")
//	public void user_enters_username_and_password(DataTable worldpressdetails){
//		for (Map<String, String> data : worldpressdetails.asMaps(String.class, String.class)) {
//			loginID.sendKeys(data.get("#"));
//			submitButton.click();
//			password.sendKeys(data.get("#"));
//		}
//		
//	}
	
	public void user_enters_and(String username, String pwd) {
			loginID.sendKeys(username);
			submitButton.click();
			password.sendKeys(pwd);
		
	}
	
	public void user_login_to_application() {
		submitButton.click();
	}
	
	
}
