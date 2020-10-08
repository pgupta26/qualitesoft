package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareCheckoutPage {

	WebDriver driver;

	public HomeSquareCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement shippingSameAsBillingCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ShipSameAsBill']"), 10);
	}

	public WebElement creditCardNumberTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtCreditCardNumber']"), 10);
	}
	
	public WebElement expiryMonthDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ddlExpiryMonth']"), 10);
	}
	
	public WebElement expiryYearDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ddlExpiryYear']"), 10);
	}
	
	public WebElement securityCodeTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtSecurityCode']"), 10);
	}
	
	public WebElement cardHolderNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtNameOnCard']"), 10);
	}
	
	public WebElement paymentRadioButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='CreditCard']"), 10);
	}
	
	public WebElement placeYourOrderButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='SubmitMyOrder']"), 10);
	}
	
	

}
