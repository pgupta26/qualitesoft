package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class LoginPage {

	WebDriver driver;
	String pagetitle = "My Constant Retail";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginPageDisplayed() {

		UseAssert.assertEquals(driver.getTitle(), pagetitle);
		Log.info("Page title " + pagetitle + " displayed.");
		
	}
	
	public WebElement signUpLink(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/auth/register']"), 10);
		return webElement;
	}
	
	public WebElement emailField(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='inputEmail']"), 10);
		return webElement;
	}
	
 public WebElement passwordfield(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='inputPassword']"), 10);
		return webElement;
	}

	
 public WebElement signInbutton(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 10);
		return webElement;
	}
 public WebElement termsCondition() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='TermsAgree']"), 10);
	}

	
 
 
}
