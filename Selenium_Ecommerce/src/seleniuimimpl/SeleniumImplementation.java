package seleniuimimpl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumImplementation {
	Actions action;
	
	public void performMouseHover(WebElement element, WebDriver driver) {
		
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void setText(String text,WebElement element) {
		element.sendKeys(text);
	}
	public void selectBtVisibleText(WebElement selectSize, String text) {
		Select s= new Select(selectSize);
		s.selectByVisibleText(text);
		
	}
	public void clickUsingJavaScriptExcutor(WebElement element , WebDriver driver) {
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public boolean ValidateText(WebDriver driver , WebElement element , String expectedText) {
		String observedText = element.getText();
		System.out.println(observedText);
		if(observedText.equals(expectedText)) {
			return true;
			
		}
		return false;
		
	}
	

}
