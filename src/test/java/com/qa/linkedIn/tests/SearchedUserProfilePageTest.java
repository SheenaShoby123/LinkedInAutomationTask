package com.qa.linkedIn.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.linkedIn.base.BaseTest;
import com.qa.linkedIn.pages.HomePage;
import com.qa.linkedIn.pages.SearchedUserProfilePage;
import com.qa.linkedIn.utils.Constants;

public class SearchedUserProfilePageTest extends BaseTest{
	
	HomePage homePage ;
	SearchedUserProfilePage searchedUserProfilePage;
	
	@BeforeClass
	public void homePageSetup(){
		loginPage.doSignIn();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	// Test to verify the Searched User.
	@Test(priority=1)
	public void verifySearchedUser(){
		searchedUserProfilePage = homePage.goToSearchedUserProfilePage(Constants.SEARCH_STRING,Constants.SEARCHED_USERNAME);
		String searchedUsername = searchedUserProfilePage.getSearchedUsername(Constants.SEARCHED_USERNAME);
		System.out.println("Searched username is : " + searchedUsername);
		Assert.assertEquals(searchedUsername, Constants.SEARCHED_USERNAME);
	}
	
	// Test to verify the message sent to Searched User.
	@Test(priority=2)
	public void verifyMsgSent(){
		String message = searchedUserProfilePage.getMsgSentToSearchedUser(Constants.MESSAGE_SENT_TO_SEARCHED_USER);
		System.out.println("Message sent is : " + message);
		Assert.assertEquals(message, Constants.MESSAGE_SENT_TO_SEARCHED_USER);
	}
	
	// Test to verify User Signed Out.
	@Test(priority=3)
	public void verifyUserSignedOut(){
		homePage = searchedUserProfilePage.closeMsgContainer();
		String welcomeMessage = homePage.userSignOut();
		Assert.assertEquals(welcomeMessage, Constants.WELCOME_MESSAGE);
	}
	
}
