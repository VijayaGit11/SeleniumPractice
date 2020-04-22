package com.qa.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.base.TestBase;
import com.qa.util.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ReadExcelDataTest extends TestBase{
	
	@Given("^User Lauches the applicaton$")
	public void user_Lauches_the_applicaton(){
//	    TestBase testBase = new TestBase();
//	    testBase.setUpSuite("ReadExcelData");
//	    testBase.initialisation();	
		System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/Framework/FreeCRMTestAutomation/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://wordpress.com/log-in");
		
	}

	@Then("^User loads below fixture file at \"([^\"]*)\"$")
	public void user_loads_below_fixture_file_at(@Transform(ExcelDataToDataTable.class) DataTable table){
	    
	    System.out.println(table.toString());
	    
	    List<String> datalist = table.asList(String.class);
	    		for(String str: datalist) {
	    			System.out.println(str); 
	    		}
	}
	
	@And("^User enters username and password$")
		public void user_enters_username_and_password() {
			driver.findElement(By.xpath("//*[@id='usernameOrEmail']")).sendKeys("vijaya.zambre@gmail.com");;
			driver.findElement(By.xpath("//*[@type='submit']")).click();;
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Wordpress#11");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("^User closes the wordpress application$")
	public void user_closes_the_wordpress_application(){
	    
	   driver.quit();
	}

}
