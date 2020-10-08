package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement closeModalButton() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver,
				By.xpath(".//*[@id='myModal-subscription' or @id='myModal']//button[@class='close']"), 20);
	}

	public WebElement myAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/login?returnurl=%2fcustomer%2fbillinginfo']"), 60);
	}
	public WebElement myAccountLink_vig() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/billinginfo']"), 60);
	}
	
	public WebElement createAnAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/register']"), 60);
	}
	
	public WebElement emailTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Email']"), 60);
	}
	
	public WebElement passwordTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Password']"), 60);
	}
	
	public WebElement loginButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='form_submit']"), 60);
	}
	
	public WebElement pageTitle() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='page-title']"), 60);
	}
	
	public WebElement orderHistoryLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/customer/orderhistory']"), 60);
	}
	
	public WebElement logoutLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/customer/logout']"), 60);
	}

}
