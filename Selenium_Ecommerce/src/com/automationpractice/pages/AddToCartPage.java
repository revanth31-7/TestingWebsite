package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniuimimpl.SeleniumImplementation;

public class AddToCartPage {
	
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
	WebElement itemImage;
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]")
	WebElement btnMore;
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement txtQuantity;
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement selectSize;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
	WebElement btnAddToCart;
	@FindBy(css="div#layer_cart a > span")
	WebElement btnCheckout;
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
	WebElement cartText;
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement btnProceedToCheckOut;
	
	
	SeleniumImplementation selenium;
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumImplementation();
		
	}
	
	public boolean validateAddToCart(WebDriver driver) {
		
		selenium.performMouseHover(itemImage, driver);
		selenium.click(btnMore);
		selenium.clear(txtQuantity);
		selenium.setText("3", txtQuantity);
		selenium.selectBtVisibleText(selectSize, "M");
		selenium.click(btnAddToCart);
		selenium.clickUsingJavaScriptExcutor(btnCheckout, driver);
		selenium.refresh(driver);
		selenium.click(btnProceedToCheckOut);
		
		return selenium.ValidateText(driver, cartText, "3");
	}

}
