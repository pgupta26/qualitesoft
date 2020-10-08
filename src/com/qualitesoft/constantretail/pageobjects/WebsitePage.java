package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class WebsitePage {

	WebDriver driver;

	public WebsitePage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement closePopup() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='modal-dialog']//button[@class='close'])[4]"), 10);
	}

	public WebElement logInRegister() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='createAccount']"), 10);
	}

	public WebElement resetPassword() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/resetpassword']"), 10);
	}
	
	public WebElement myShoppingCart() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='cartUrl'])[3]"), 10);
	}
	
	public WebElement myOrderHistory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/orderhistory']"), 10);
	}
	
	public WebElement aboutUs() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/pages/about-us']"), 10);
	}
	
	public WebElement contactUs() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/pages/contact-us']"), 10);
	}
	
	public WebElement termsAndConditions() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/pages/terms-and-conditions']"), 10);
	}
	
	public WebElement emailAddressTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='inputEmail']"), 10);
	}

}
