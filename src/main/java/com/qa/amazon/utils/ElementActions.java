package com.qa.amazon.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	
	public WebDriver driver;
	public WebDriverWait explicitwait;
	public Actions action;
	
	//Creating the constructor of the ElementActions class
	
    public ElementActions(WebDriver driver) {
    	action = new Actions(driver);
    	explicitwait = new WebDriverWait(driver,Duration.ofSeconds(AppConstants.EXPLICIT_WAIT));
    }
	
	/**
	 * This method will fetch the element from the Webpage using the given locator
	 * @param By locator
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		 element=	driver.findElement(locator);
			
		}
		catch(Exception exception) {
			System.out.println("Some exception occurred while trying to fetch element");
			
		}
		return element;
	}
		
	/**
	 * This method will perform sendKeys operation on the element located using the By locator	
	 * @param locator
	 * @param text
	 */
	public void doSendKeys(By locator,String text) {
		driver.findElement(locator).sendKeys( text);
		
	}	
	
	
	/**
	 * This element will click on the WebElement using the Selenium inbuilt click method
	 * @param locator
	 */
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	/**
	 * This method will click on the given WebElement using the actions class click method
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		WebElement element=getElement(locator);
		action.moveToElement(element).click();
	}
		
	/**
	 * This method will double click on the given WebElement using the actions class click method
	 * @param locator
	 */
	
	public void doActionsDoubleClick(By locator) {
		WebElement element=getElement(locator);
		action.moveToElement(element).doubleClick();	
		
	}
/**
 * This method will explicitly wait for the visibility of the element located by the given locator
 * @param locator
 */
	
	public void waitUntilElementIsVisible(By locator) {
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	/**
	 * This method will explicitly wait for the element located by the given locator to be Clickbale
	 * @param locator
	 */
	public void waitUntilElementIsClickable(By locator) {
		explicitwait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	
	
	
	
	
	
}
