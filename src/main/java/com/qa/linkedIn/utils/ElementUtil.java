package com.qa.linkedIn.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}
		return element;
	}
	
	public void doClick(By locator){
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	
	//**********************Actions Methods ********************
	
	public void doActionMoveClick(By locator) {
		WebElement source = getElement(locator);
		Actions ac = new Actions(driver);
		ac.moveToElement(source).click().build().perform();
	}
	
	//***************************wait utils ******************************
	
	public String doGetPageTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public WebElement waitForElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	

}
