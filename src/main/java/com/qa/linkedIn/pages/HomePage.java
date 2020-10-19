package com.qa.linkedIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.linkedIn.base.BasePage;
import com.qa.linkedIn.utils.CommonUtil;
import com.qa.linkedIn.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;
	CommonUtil commonUtil;

	// By Locators -- OR

	// Splitting logged-in user's Xpath:
	String accountNameBeforeXpath = "//div[text()='";
	String accountNameAfterXpath = "']";

	By searchbox = By.xpath("//input[@placeholder='Search']");
	
	// Splitting selected user's Xpath:
	String userSelectBeforeXpath = "//strong[contains(normalize-space(),'";
	String userSelectAfterXpath = "')]";

	By profileDrpDwn = By.xpath("//button[@type=\"button\"]/span");
	
	By signOut = By.xpath("//a[text()='Sign Out']");

	By welcomeHeading = By.xpath("//h1[text()='Welcome to your professional community']");

	// constructor of the page class:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		commonUtil = new CommonUtil(this.driver);
	}

	// page actions:
	
	// Method to get the logged-in user's Account Name
	public String getLoggedInAccountName(String loggedinUserName) {
		By accountName = commonUtil.combineXpath(accountNameBeforeXpath, loggedinUserName, accountNameAfterXpath);
		elementUtil.waitForElementPresent(accountName, 5);
		if (elementUtil.doIsDisplayed(accountName))
			return elementUtil.doGetText(accountName);
		return null;
	}

	// Method to search the given user string
	private void SearchUser(String searchString) {
		elementUtil.waitForElementPresent(searchbox, 10);
		elementUtil.doClick(searchbox);
		elementUtil.waitForElementToBeClickable(searchbox, 10);
		elementUtil.doSendKeys(searchbox, searchString);
	}

	// Method to search and select the searched user's profile page
	public SearchedUserProfilePage goToSearchedUserProfilePage(String searchString, String searchUserName) {
		SearchUser(searchString);

		By userSelect = commonUtil.combineXpath(userSelectBeforeXpath, searchUserName, userSelectAfterXpath);
		elementUtil.waitForElementPresent(userSelect, 5);
		elementUtil.doActionMoveClick(userSelect);
		return new SearchedUserProfilePage(driver);
	}

	// Method to Sign out from Home Page
	public String userSignOut() {
		elementUtil.waitForElementPresent(profileDrpDwn, 10);
		elementUtil.doClick(profileDrpDwn);
		elementUtil.waitForElementToBeClickable(signOut, 10);
		elementUtil.doActionMoveClick(signOut);
		return elementUtil.doGetText(welcomeHeading);
	}

}
