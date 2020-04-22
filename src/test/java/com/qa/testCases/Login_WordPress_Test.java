package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.WorldPressLoginPage;
import com.qa.util.ReadExcelData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_WordPress_Test extends TestBase{
	
	TestBase testBase = new TestBase();
	WorldPressLoginPage loginPage;
	
	@Test
	@Given("^User launches the worldpress app$")
	public void user_launches_the_worldpress_app(){
		TestBase testBase = new TestBase();
	    testBase.setUpSuite("WordPressLoginTest");
	    testBase.initialisation();
	    
	}

	@Test(dataProvider="wordpressData")
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String pwd) {
		//user_enters_username_and_password(worldpressdetails);
		loginPage = new WorldPressLoginPage();
		loginPage.user_enters_and(username, pwd);
	}

	@Test
	@When("^User login to application$")
	public void user_login_to_application(){
		loginPage.user_login_to_application();
	    
	}
	
	@Then("^User closes the chrome browser$")
	public void user_closes_the_browser() throws IOException {
		driver.quit();
		TestBase.tearDown_Report();
	}
	
	
	//Dataprovider
	@DataProvider(name="wordpressData")
	public Object[][] passData(){	
		ReadExcelData readData = new ReadExcelData("C:/Users/HP/Documents/Framework/SeleniumPractice/src/main/java/testData/TestData_WordPress.xlsx");
		int rows=readData.getRowCount(0);
		int columns = readData.getColumnCount(0);
		Object[][] data = new Object[rows][columns];
		for(int i=1; i<rows;i++) {
			for(int k=0; k<columns-1;k++) {
			data[i][k]= readData.getData(0, i, k);
			System.out.println(data);
//			data[i][k]= readData.getData(0, i, 1);
			}
		
		}
		return data;
	}
		

}
