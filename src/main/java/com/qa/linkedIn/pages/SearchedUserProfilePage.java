package com.qa.linkedIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.linkedIn.base.BasePage;
import com.qa.linkedIn.utils.CommonUtil;
import com.qa.linkedIn.utils.ElementUtil;

public class SearchedUserProfilePage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;
	CommonUtil commonUtil;

	// By Locators -- OR

	// Splitting searched user's name Xpath:
	String searchedUserNameBeforeXpath = "//li[text()='";
	String searchedUserNameAfterXpath = "']";

	By msgBtn = By.xpath("//a[text()='Message']");

	By writeMsg = By.xpath("//div[@aria-label='Write a message…']");

	By sendBtn = By.xpath("//button[@type='submit']");

	By closeMsg = By.xpath(
			"//button[@class='msg-overlay-bubble-header__control artdeco-button artdeco-button--circle artdeco-button--inverse artdeco-button--1 artdeco-button--tertiary ember-view']"
					+ "//li-icon[@type='cancel-icon']//*[local-name()='svg']");

	By message = By.xpath(
			"(//div[@class='msg-s-event-listitem__message-bubble msg-s-event-listitem__message-bubble--msg-fwd-enabled'])[last()]");

	// constructor of the page class:
	public SearchedUserProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		commonUtil = new CommonUtil(this.driver);
	}

	// page actions:

	// Method to get the Searched user's name
	public String getSearchedUsername(String searchedUser) {
		By searchedUserName = commonUtil.combineXpath(searchedUserNameBeforeXpath, searchedUser,
				searchedUserNameAfterXpath);
		elementUtil.waitForElementPresent(searchedUserName, 5);
		if (elementUtil.doIsDisplayed(searchedUserName))
			return elementUtil.doGetText(searchedUserName);
		return null;
	}

	// Method to sent message to the searched user
	public String getMsgSentToSearchedUser(String messageToSent) {
		elementUtil.waitForElementToBeClickable(msgBtn, 10);

		elementUtil.doClick(msgBtn);

		elementUtil.waitForElementPresent(writeMsg, 5);
		elementUtil.doSendKeys(writeMsg, messageToSent);

		elementUtil.waitForElementToBeClickable(sendBtn, 10);
		elementUtil.doClick(sendBtn);

		return elementUtil.doGetText(message);
	}

	// Method to close message container and go back to home page
	public HomePage closeMsgContainer() {
		elementUtil.waitForElementToBeClickable(closeMsg, 10);
		elementUtil.doClick(closeMsg);
		return new HomePage(driver);
	}

}
