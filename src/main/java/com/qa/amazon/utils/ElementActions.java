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
    	this.driver=driver;
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
			System.out.println("SOME EXCEPTION OCUURED WHILE TRYING TO FETCH THE ELEMENT "+ locator);
			
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
	 * This method will return the current page title
	 	 * @return current page title
	 */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method will return the current page URL
	 	 * @return current page title
	 */
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method will fetch and return the text of the element located by the By locator
	 * @param locator
	 * @return text of the element located by the By locator
	 */
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
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
	
	/**
	 * This method will wait until the page contains the given title
	 * @param title
	 */
	public void waitUntilPageContainsTitle(String title) {
		explicitwait.until(ExpectedConditions.titleContains(title));	
				
	}
	/**
	    * This method will move the control to the element located by the given locator
	    * @param locator
	    */
		public void hoverOverElement(By locator) {
			WebElement element=getElement(locator);
			action.moveToElement(element).build().perform();
		}

		/**
		 * This method will check if the given element is present and enabled on the page
		 * @param locator
		 * @return
		 */
		public boolean checkPresenceOfElement(By locator) {
			return driver.findElement(locator).isEnabled();
			
		}
			
			
		/**
		 * This method will check if the given element is present and displayed on the page
		 * @param locator
		 * @return
		 */
		public boolean IsElementDisplayed(By locator) {
			return driver.findElement(locator).isDisplayed();
			
		}
		
			
		}
		
		

