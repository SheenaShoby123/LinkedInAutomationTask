package com.qa.linkedIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.linkedIn.base.BasePage;
import com.qa.linkedIn.utils.Constants;
import com.qa.linkedIn.utils.ElementUtil;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By Locators -- OR
	By signInBtn = By.xpath("//a[@class='nav__button-secondary']");
	By emailId = By.id("username");
	By password = By.id("password");
	By submitBtn = By.xpath("//button[@type='submit']");

	// constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// page actions:
	
	// Method to Sign In to the application
	public void doSignIn() {
		elementUtil.waitForElementToBeVisible(signInBtn, 10);
		elementUtil.doClick(signInBtn);
	}

	// Method to Login Page Title
	public String getLoginPageTitle() {
		return elementUtil.doGetPageTitle(10, Constants.LOGIN_PAGE_TITLE);
	}

	// Method to Login to the application using the username and password
	public HomePage doLogin(String username, String pwd) {
		System.out.println("login to app with --> " + username + " : " + pwd);
		elementUtil.waitForElementPresent(emailId, 5);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.waitForElementToBeClickable(submitBtn, 5);
		elementUtil.doClick(submitBtn);

		return new HomePage(driver);
	}

}
