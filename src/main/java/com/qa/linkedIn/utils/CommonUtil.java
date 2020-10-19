package com.qa.linkedIn.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUtil {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	public CommonUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	// Method to combine xpath
	public By combineXpath(String beforeXpath, String string, String afterXpath) {
		By fullXpath = By.xpath(beforeXpath+string+afterXpath);
		return fullXpath;
	}

}
