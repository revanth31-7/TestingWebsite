package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement pass;
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement btnSubmit;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ValidateLogin() {
		email.sendKeys("revanth1435@gmail.com");
		pass.sendKeys("admin");
		btnSubmit.click();
	}
	

}
