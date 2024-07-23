package com.qa.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import CustomFrameworkException.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public String browserName;
	public Properties prop;
	public String url;
	public FileInputStream fis;
	public String envName;

	public Properties init_prop() {

		prop = new Properties();
		envName = System.getProperty("env");
        System.out.println("Given environment name is: "+ envName);
		try {
			if (envName == null) {
				System.out.println("Running test cases on QA environment since no environment is passed");
				fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/qa.config.properties");
			}

			switch (envName.toLowerCase()) {
			case "qa":
				fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/qa.config.properties");
				break;

			case "stage":
				fis = new FileInputStream("./src/main/java/com/qa/amazon/configuration/stage.config.properties");
				break;

			default:
				System.out.println("Invalid environment name.Please pass correct environment");
				throw new FrameworkException("INVALIENVIRONMENTEXCEPTION");

			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		try {
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return prop;
	}

	public WebDriver init_driver(Properties prop, String browserName) {

		// browserName=prop.getProperty("browser");
		System.out.println("Running the test cases on " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browserName.equalsIgnoreCase("edge")) {
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
