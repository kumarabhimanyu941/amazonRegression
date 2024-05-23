package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.amazon.utils.ElementActions;
import com.qa.amazon.utils.JavaScriptUtil;

public class HomePage {

	
	public WebDriver driver;
	public ElementActions elementactions;
	public JavaScriptUtil javascriptutil;
	public SearchPage searchpage;
	//HomePage locators
	
	By homePageSearchBox= By.xpath("//input[@id='twotabsearchtextbox']");
	By homePageSearchIcon=By.xpath("//input[@id='nav-search-submit-button']");
	By conditionsForUseAndSaleLink=By.xpath("//a[text()='Conditions of Use & Sale']");
    
	
	//Home Page Constructor
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementactions=new ElementActions(driver);
		javascriptutil = new JavaScriptUtil(driver);
		
		
	}
	
	//Home Page Methods
	
	/**
	 * This method will fetch the Home Page title
	 * @return Home Page title
	 */
	public String getHomePageTitle() {
		return elementactions.getCurrentPageTitle();
	}
	
	/**
	 * This method will check if the Home Page Search Box is enabled
	 * @return true or false based on whether the Home Page Search Box is enabled or not
	 */
	
	public boolean isHomePageSearchBoxEnabled() {
		return elementactions.checkIsElementEnabled(homePageSearchBox);
		
	}
	
	/**
	 * This method will check if the Home Page Search Icon is enabled
	 * @return true or false based on whether the Home Page Search Icon is enabled or not
	 */
	
	public boolean isHomePageSearchIconEnabled() {
		return elementactions.checkIsElementEnabled(homePageSearchIcon);
		
	}
	
	/**
	 * This method will scroll to the bottom of the Home Page and check if the conditionsForUseAndSaleLink is Enabled or not.
	 * @param locator
	 * @return true or false based on whether the conditionsForUseAndSaleLink is enabled or not
	 */
	public boolean isConditionsForUseAndSaleLinkEnabled() {
	WebElement ConditionsForUseAndSaleLink =elementactions.getElement(conditionsForUseAndSaleLink);
	javascriptutil.scrollIntoView(ConditionsForUseAndSaleLink);
		return elementactions.checkIsElementEnabled(conditionsForUseAndSaleLink);
	}
	
	
	/**
	 * This method will scroll to the top of the Home Page by scrolling the Home Page Search Box into view.
	 */
	public void scrollToTopOfHomePage() {
		javascriptutil.scrollIntoView(elementactions.getElement(homePageSearchBox));
	}

	/**
	 * This method will perform search for the given search value on the Home Page  
	 * @param searchValue
	 */
	public SearchPage performSearchOnHomePage(String searchValue) {
		elementactions.doSendKeys(homePageSearchBox, searchValue);
		elementactions.doClick(homePageSearchIcon);
		return searchpage;
	}
	
}
