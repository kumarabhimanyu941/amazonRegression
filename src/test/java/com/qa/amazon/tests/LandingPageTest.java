package com.qa.amazon.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.amazon.base.Base;
import com.qa.amazon.pages.LandingPage;
import com.qa.amazon.utils.AppConstants;


public class LandingPageTest {

	public Base base;
	public LandingPage landingpage;
	public Properties prop;
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		base=new Base();
		prop= new Properties();
		prop=base.init_prop();
		driver=base.init_driver(prop);
		landingpage = new LandingPage(driver);
	}
	
	
	
	
	@Test
	public void getLandingPageTitleTest() {
	String landingPageTitle=landingpage.getLandingPageTitle();
	Assert.assertEquals(landingPageTitle, AppConstants.LANDING_PAGE_TITLE);
	}
	
	
	@Test
	public void getLandingPageURLTest() {
	String landingPageURL=landingpage.getLandingPageURL();
	Assert.assertEquals(landingPageURL, AppConstants.LANDING_PAGE_URL);
	}
	
	
	

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
