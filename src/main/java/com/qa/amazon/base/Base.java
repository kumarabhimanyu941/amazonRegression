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
	public String browserName;
	public Properties prop;
	public String url;
	public FileInputStream fis;
	

	public Properties init_prop() {
		
		String envName=System.getProperty("env");
		
		if(envName==null) {
			try {
				fis=new FileInputStream("./src/main/java/com/qa/amazon/configuration/qa.config.properties");
				System.out.println("Running the test cases on QA env since no environment is passed by the user");
			}
			catch (Exception exception) {
				exception.getMessage();
				exception.printStackTrace();
			}
		}
		
		
		else {
		
		
	   switch (envName.toLowerCase()) {
	case "qa":
		try {
		fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/qa.config.properties");
		System.out.println("Running the test cases on the QA environment");
		}
		catch (Exception exception) {
			exception.getMessage();
			exception.printStackTrace();
		}

	case "stage":
		try {
		fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/stage.config.properties");
		System.out.println("Running the test cases on the stage environment");
		}
		catch (Exception exception) {
			exception.getMessage();
			exception.printStackTrace();
		}
	default:
		System.out.println("Please pass valid environment details.Terminating the test execution");
		
	   }
	   }
		
	  prop = new Properties();
	  
	   try {
	   prop.load(fis);
	   
	   }
	   catch(Exception exception) {
		   System.out.println("Some exception occurred while loading the properties file");
		   exception.getMessage();
		   exception.printStackTrace();
		   
	   }
	  	
	   return prop;
	}
	

	public WebDriver init_driver(Properties prop) {
		
		browserName=prop.getProperty("browser");
		System.out.println("Running the test cases on "+ browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("qaurl"));
		driver.manage().window().maximize();
		
		
		return driver;
	}
	

	
}
