package com.qa.linkedIn.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is used to initialize the driver on the basis of given browser name
	 * @param browserName
	 * @return driver
	 */
    public WebDriver init_driver(Properties prop) {
    	
    	String browserName = prop.getProperty("browser").trim();
		
		System.out.println("browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver();		
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();			
		} else {
			System.out.println(browserName + " is not found, please pass the correct browser....");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		return driver;
	}
    
    /**
	 * this method is used to initialize the properties from config.properties file
	 * @return prop
	 */
    public Properties init_prop() {
		prop = new Properties();
		try{
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\linkedIn\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
