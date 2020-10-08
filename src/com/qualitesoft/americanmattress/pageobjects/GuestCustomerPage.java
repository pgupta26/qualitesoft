package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class GuestCustomerPage {
	
	WebDriver driver;

	public GuestCustomerPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement emailAddressTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='UserName']"), 60);
	}
	
	public WebElement passwordTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Password']"), 60);
	}
	
	public WebElement signInButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='btnHaveAnAccount']"), 60);
	}

}
