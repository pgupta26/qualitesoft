package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class CreateNewStore {
	WebDriver driver;

	public CreateNewStore(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement partnerloginButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"ShopifyMainNav\"]/ul[2]/li[2]/a"), 120);
	}
	public WebElement userEmail() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='email']"), 120);
	}
	public WebElement userPassword() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='password']"), 120);
	}
	public WebElement loginButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 40);
	}
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='ui-button ui-button--primary ui-button--size-large']"), 40);
	}	
	public WebElement createstoreButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/header/div[1]/div[2]/div/a"), 30);
	}
	public WebElement storeName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='signup_shop_name']"), 120);
	}
	public WebElement password() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='signup_password']"), 30);
	}
	public WebElement confirmPassword() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='confirm_password']"), 30);
	}
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@form='new_signup']"), 40);
	}	
}

