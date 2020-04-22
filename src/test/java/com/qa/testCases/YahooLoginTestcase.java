package com.qa.testCases;

import org.testng.annotations.Test;

import com.qa.pages.YahooLoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YahooLoginTestcase extends TestNGWithParameter{
	
	TestNGWithParameter launchBrowser = new TestNGWithParameter();
	YahooLoginPage loginPage;
	
//	@Test
//	@Given("^User launches yahoo mail$")
//	public void user_launches_yahoo_mail() {
//		launchBrowser.chromeProperty();
//		launchBrowser.manageBrowser();

//	}
	
	@Test
	@When("^User clicks on mail icon$")
	public void user_clicks_on_mail_icon(){
		loginPage = new YahooLoginPage();
		loginPage.user_clicks_on_email_icon();
	    
	}

	@Test
	@And("^User enters yahooUsername$")
	public void user_enters_yahooUsername(DataTable userName){
	    loginPage.user_enters_yahooUsername(userName);
	    
	}
	
	@Test
	@Then("^User clicks on next button$")
	public void user_clicks_on_next_button(){
		loginPage.user_clicks_on_next_button();	    
	}

}
