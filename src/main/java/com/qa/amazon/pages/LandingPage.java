package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementActions;

public class LandingPage {
	
	public WebDriver driver;
	public ElementActions elementactions;

	//Landing Page locators
	
	By amazonLogo = By.xpath("//a[@aria-label='Amazon.in']");
	By landingPageSearchBox= By.xpath("//input[@id='twotabsearchtextbox']");
	By helloSignInLogo= By.xpath("//span[text()='Hello, sign in']");
	By SignInBtn = By.xpath("//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		elementactions= new ElementActions(driver);
	}
	
	
	
	//Landing Page Methods
	
	/**
	 * This method will fetch and return landing page title
	 * @return Landing Page title
	 */
	public String getLandingPageTitle() {
		return elementactions.getCurrentPageTitle();
	}
	
	
	
	/**
	 * This method will return the landing page url
	 * @return Landing Page URL
	 */
	public String getLandingPageURL() {
		return elementactions.getCurrentPageURL();
	}
	
	
	
	/**
	 * This method will fetch and return the text of the Sign In logo on the landing page
	 * @return text of the Sign In logo on the landing page
	 */
	public String getHelloSignInIconText() {
		return elementactions.doGetText(helloSignInLogo);
		
	}

	

	/**
	 * This method will fetch and return the text of the Amazon logo on the landing page
	 * @return text of the amazon logo on the landing page
	 */
	public String getAmazonLogoText() {
		return elementactions.doGetText(amazonLogo);
		
	}
	
   /**
    * This method will verify if the Sign In Button is present and enabled or not.
    * @return
    */
	public boolean verifyPresenceOfSignInBtn() {
		elementactions.hoverOverElement(helloSignInLogo);
		return elementactions.checkIsElementEnabled(SignInBtn);
		
	}
	
	
	/**
	 * This method will click on the SignIn button
	 * @return SignInPage object
	 */
	public SignInPage clickOnSignInBtn() {
		elementactions.hoverOverElement(helloSignInLogo);
		elementactions.doClick(SignInBtn);
		return new SignInPage(driver);
		
	}
	
	
	
}
