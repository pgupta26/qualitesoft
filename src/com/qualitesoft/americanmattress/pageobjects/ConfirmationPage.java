package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ConfirmationPage {
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement returnToHomepageButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='btn-checkout btn-default-checkout btn-primary-checkout text-uppercase expand']"), 60);
	}
	public WebElement myAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/login?returnurl=%2fcustomer%2fbillinginfo']"), 60);
	}
	public WebElement myaccount() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/billinginfo']"), 60);
	}
	public WebElement orderhistory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/customer/orderhistory']"), 60);
	}
	public WebElement email() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Email']"), 60);
	}
	public WebElement password() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Password']"), 60);
	}
	public WebElement signin() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 60);
	}
}
