package com.automstionpractice.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.automationpractice.pages.AddToCartPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class AddToCartTest {
	
	AddToCartPage page;
	public WebDriver driver;
	public ExtentReports extent; 
	public ExtentTest test;
   
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\drivers\\chromedriver\\chromedriver.exe");
		extent = new ExtentReports("D:\\github_training\\reports\\TestResults.html",true);
		String baseUrl = "http://automationpractice.com/index.php?";
		
		test=extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "OpenBrowser test is initiated");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		test .log(LogStatus.PASS, "Browser is open and window is maximized");
		driver.get(baseUrl);
		test.log(LogStatus.PASS, "String URl is opened in Chrome browser");
		extent.endTest(test);
		extent.flush();
		page= new AddToCartPage(driver);
		
	}
 
	@Test
	public void validateAddToCart() {
		Assert.assertTrue(page.validateAddToCart(driver));
		
	}
	
	   @AfterTest
	    public void validateLogin() {
	    	LoginPage page=new LoginPage(driver);
	    	page.ValidateLogin();
	    	
	   }
}
