package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementActions;

public class SignInPage {
	
	public LandingPage landingpage;
	public ElementActions elementactions;
	public WebDriver driver;
	public SignInPage signinpage;

	//SignIn Page Locators
	By SignInLogo = By.xpath("//h1[@class='a-spacing-small']");
	
	//SignIn Page Constructor
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		elementactions=new ElementActions(driver);
		landingpage = new LandingPage(driver);
	}
	
	
	/**
	 * This method will check the presence of the SignIn logo on the SignIn page
	 * @return
	 */
	public boolean isSignInLogoDisplayed() {
		elementactions.waitUntilElementIsVisible(SignInLogo);
		return elementactions.IsElementDisplayed(SignInLogo);
		
	}
}
