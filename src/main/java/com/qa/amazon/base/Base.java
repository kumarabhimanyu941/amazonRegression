package com.qa.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


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
	

	public WebDriver init_driver(Properties prop,String browserName) {
		
		//browserName=prop.getProperty("browser");
		System.out.println("Running the test cases on "+ browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("qaurl"));
		driver.manage().window().maximize();
		
		
		return driver;
	}
	
	public String getScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
}
