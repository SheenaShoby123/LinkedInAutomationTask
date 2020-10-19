package com.qa.linkedIn.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.linkedIn.base.BaseTest;
import com.qa.linkedIn.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	// Test to validate the title of the Login Page.
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		loginPage.doSignIn();
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	// Test to enter username and password.
	@Test(priority=2)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
