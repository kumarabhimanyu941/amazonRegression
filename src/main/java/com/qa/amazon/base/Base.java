package com.qa.amazon.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public String browser;
	public Properties prop;
	public String url;
	
	
	@BeforeTest
	public void init_prop() {
		try {
		FileInputStream fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/qa.config.properties");
		prop = new Properties();
		prop.load(fis);
		browser=prop.getProperty("browser");
		}
		catch(Exception exception) {
			exception.getMessage();
			exception.printStackTrace();
		}
		
	}
	
	@Test
	public void init_driver() {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("qaurl"));
		driver.manage().window().maximize();
		
		driver.quit();
	}
	

	
}
