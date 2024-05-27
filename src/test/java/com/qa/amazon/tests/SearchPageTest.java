package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.amazon.base.Base;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.SearchPage;
import com.qa.amazon.utils.AppConstants;

public class SearchPageTest {

	public WebDriver driver;
	public Base base;
	public HomePage homepage;
	public SearchPage searchpage;
	public Properties prop;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browserName) {
		base = new Base();
		prop = base.init_prop();
		driver = base.init_driver(prop, browserName);
		homepage = new HomePage(driver);

	}

	@Test
	public void performHomePageSearchTest() {

		searchpage = homepage.performSearchOnHomePage(AppConstants.HOMEPAGE_SEARCH_VALUE);
		Assert.assertTrue(searchpage.isSearchPageResultMsgDisplayed());

	}

	
	@Test
	public void verifySearchPageURLTest() {
		Assert.assertTrue(searchpage.getSearchPageURL().contains(AppConstants.SEARCH_PAGE_URL_CONTENT));
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
