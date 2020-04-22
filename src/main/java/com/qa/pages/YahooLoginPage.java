package com.qa.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import cucumber.api.DataTable;

public class YahooLoginPage extends TestBase{
	
	@FindBy(xpath="//a[@id='header-mail-button']")
	WebElement mailButton;
	
	@FindBy(xpath= "//input[@id='login-username']")
	WebElement usernameInput;
	
	@FindBy(xpath="//input[@id='login-signin']")
	WebElement submitButton;
	
	public YahooLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void  user_clicks_on_email_icon() {
		mailButton.click();
	}
	
	public void user_enters_yahooUsername(DataTable username) {
		for (Map<String, String> usrname : username.asMaps(String.class, String.class)) {
			usernameInput.sendKeys(usrname.get("username"));
		}
	}
	
	public void user_clicks_on_next_button() {
		submitButton.click();
	}
	
}
