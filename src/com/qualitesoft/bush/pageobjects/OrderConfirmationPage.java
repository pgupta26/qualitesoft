package com.qualitesoft.bush.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class OrderConfirmationPage {

	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement orderNumber() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'order-number')]/bold"), 90);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='row']//div[@class='col-sm-8']//div[@class='row confirmation-message cymax-load-event']//div[@class='col-sm-6']//p[@class='order-number']//bold"), 200);
		
	}
	

	public WebElement cymaxLogoImg() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@*='logo']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='cymaxLogo']"), 90);
	}
	public WebElement setPasswordText() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='txtUserPassword']"), 90);
	}	
	public WebElement setPwdButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='set-password-link primary-checkout-btn cymax-click-event']"), 90);
	}	
	
	public WebElement Emailid() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'col-sm-12')]/p/br/b"),90);
	}	
}
