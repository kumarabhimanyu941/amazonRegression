package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.qa.amazon.base.Base;
import com.qa.amazon.pages.LandingPage;
import com.qa.amazon.pages.SignInPage;
import com.qa.amazon.utils.AppConstants;

public class SignInPageTest {

	
	public WebDriver driver;
	public Base base;
	public Properties prop;
	public LandingPage landingpage;
	public SignInPage signinpage;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		prop=new Properties();
		base=new Base();
		prop=base.init_prop();
		driver=base.init_driver(prop, browser);
		landingpage = new LandingPage(driver);
		signinpage=landingpage.clickOnSignInBtn();
		
	}
	
	@Test
	public void isSignInLogoDisplayedTest() {
		Assert.assertTrue(signinpage.isSignInLogoDisplayed());
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
		
	}
	
	
	
	
	
}
