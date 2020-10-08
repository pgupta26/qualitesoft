package com.qualitesoft.MBDesigner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class BoardList {
	WebDriver driver;

	public BoardList(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement BoardIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//figure[@class='overlay overlay-hover']"), 60);
	}	
	public WebElement previewButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-outline preview-btn']"), 60);
	}
	public WebElement shopthislookButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-outline color-inverted margin-bottom-10']"), 60);
	}
	public WebElement proceedButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='primary-checkout-btn next-page']"), 60);
	}	
	public WebElement guestemail() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='GuestUserName']"), 60);
	}
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnSignIn']"), 60);
	}	
	public WebElement firstNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='first-name']"), 60);
	}
	public WebElement lastNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='last-name']"), 60);
	}	
	public WebElement companynameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='company-name']"), 60);
	}	
	public WebElement add1Textbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-1']"), 60);
	}
	public WebElement add2Textbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-2']"), 60);
	}
	public WebElement zipTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='zip-code']"), 60);
	}	
	public WebElement cityTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='city']"), 60);
	}
	public WebElement countrydropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='country']"), 60);
	}
	public WebElement statedropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='state']"), 60);
	}
	public WebElement phone() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='phone']"), 60);
	}
	public WebElement reviewButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='primary-checkout-btn next-page']"), 60);
	}
	public WebElement creditCardNo() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='credit-card-number']"), 60);
	}
	public WebElement cardName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='credit-card-name']"), 60);
	}
	public WebElement expMonth() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='credit-card-expiry-month']"), 60);
	}
	public WebElement expYear() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='credit-card-expiry-year']"), 60);
	}
	public WebElement securityCode() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='credit-card-cvv']"), 60);
	}
	
}
