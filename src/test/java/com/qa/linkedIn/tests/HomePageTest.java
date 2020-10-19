package com.qa.linkedIn.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.linkedIn.base.BaseTest;
import com.qa.linkedIn.pages.HomePage;

public class HomePageTest extends BaseTest{
	
HomePage homePage ;
	
	@BeforeClass
	public void homePageSetup(){
		loginPage.doSignIn();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	// Test to validate the account holder who logged in.
	@Test(priority=1)
	public void verifyLoggedInUserTest(){
		String accountName = homePage.getLoggedInAccountName(prop.getProperty("accountname"));
		System.out.println("Logged in user account name is : " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}

}
