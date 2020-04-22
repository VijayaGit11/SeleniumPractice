package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ReadExcelDataPage extends TestBase{
	
	@FindBy(xpath= "//*[@id='usernameOrEmail']")
	static
	WebElement loginID;
	
	@FindBy(xpath = "//*[@type='submit']")
	static
	WebElement submitButton;
	
	@FindBy(xpath= "//*[@id='password']")
	static
	WebElement password;
	
	
	public ReadExcelDataPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void user_Lauches_the_applicaton() {
		driver.get(prop.getProperty("url"));
	   
	}
	
	public void user_enters_and(String username, String pwd) {
		loginID.sendKeys(username);
		submitButton.click();
		password.sendKeys(pwd);
	
}

public void user_login_to_application() {
	submitButton.click();
}


	public void user_closes_the_wordpress_application() {
	 
	   
	}

}
