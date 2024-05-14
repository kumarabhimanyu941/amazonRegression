package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.amazon.base.Base;
import com.qa.amazon.pages.HomePage;

public class HomePageTest {

	public Base base;
	public Properties prop;
    public WebDriver driver;
    public HomePage homepage;
    
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		base = new Base();
		prop=base.init_prop();
		driver=base.init_driver(prop, browser);
		
		homepage = new HomePage(driver);
		
	}
	
	@Test
	public void IsHomePageSearchBoxEnablededTest() {
	Assert.assertTrue(homepage.isHomePageSearchBoxEnabled());	
	
	}
	
	@Test
	public void IsHomePageSearchIconEnablededTest() {
	Assert.assertTrue(homepage.isHomePageSearchIconEnabled());	
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
}
