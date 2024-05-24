package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementActions;

public class SearchPage {

	public WebDriver driver;
	public ElementActions elementactions;

	By searchpageresultmsg = By.xpath("//span[contains(text(),'results for')]");

	// Search Page Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
	}

	/**
	 * This method will verify if the result message on the search page is displyed
	 * or not.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isSearchPageResultMsgDisplayed() {

		return elementactions.IsElementDisplayed(searchpageresultmsg);
	}

}
