package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.WaitTool;

public class PaymentPage {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement creditCardNumberTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtCreditCardNumber']"), 60);
	}

	public WebElement creditCardNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtNameOnCard']"), 60);
	}

	public WebElement expiryDateDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryMonth']"), 60);
	}

	public WebElement yearDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryYear']"), 60);
	}

	public WebElement securityCodeTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtSecurityCode']"), 60);
	}

	public WebElement placeOrderButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@class='primary-checkout-btn next-page']"), 60);
	}

	public WebElement placeOrderErrorMessage() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver,
				By.xpath(".//*[@class='alert alert-danger messages']"), 30);
	}

	public void validation() {

		placeOrderErrorMessage();
		if (placeOrderErrorMessage() != null) {
			if (driver.findElement(By.xpath(".//*[@class='alert alert-danger messages']//li"))
					.getText() != "duplicate") {
				Log.error(driver.findElement(By.xpath(".//*[@class='alert alert-danger messages']//li")).getText());
				Assert.fail();
			}
		}
	}

}
