package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class PaymentPage {
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement paymentLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/settings/payment']"), 60);
	}
	
	public WebElement checkboxBrainTree() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@for='checkboxBrainTree']/span"), 60);
	}
	
	public WebElement settingsBraintree() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='settingsBraintree']"), 60);
	}
	
	public WebElement braintreeMerchantID() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='braintree-merchantid']"), 60);
	}
	
	public WebElement braintreeMerchantAccountID() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='braintree-merchantaccountid']"), 60);
	}
	
	public WebElement braintreePublicKey() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='braintree-publickey']"), 60);
	}
	
	public WebElement braintrePrivateKey() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='braintree-privatekey']"), 60);
	}

	public WebElement braintreSave() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='braintree-form']/div[5]/button"), 60);
	}
	
	public WebElement authrizeNet() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@for='checkboxAuthorizeNet']/span"), 60);
	}
	
	public WebElement settingsAuthrizeNet() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='settingsAuthorizeNet']"), 60);
	}
	
	public WebElement authrizeLoginID() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='authorizenet-inputMws']"), 60);
	}
	
	public WebElement authrizeTransactionKey() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='authorizenet-inputSecretAccessKey']"), 60);
	}
	
	public WebElement authrizeSave() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='authorizenet-form']/div[3]/button"), 60);
	}
	
	public WebElement checkPaypal() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@for='checkboxPaypal']/span"), 60);
	}
	
	public WebElement settingsPaypal() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='settingsPaypal']"), 60);
	}
	
	public WebElement paypalClientID() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='client-id-paypal']"), 60);
	}
	
	public WebElement paypalClient() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='client-secret-paypal']"), 60);
	}
	public WebElement paypalSave() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='paypal-form']/div[4]/button"), 60);
	}
	
}