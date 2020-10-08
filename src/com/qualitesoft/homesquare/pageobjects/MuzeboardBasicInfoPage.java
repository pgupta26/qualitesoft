package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class MuzeboardBasicInfoPage {

	WebDriver driver;

	public MuzeboardBasicInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement firstNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='FirstName']"), 10);
	}
	
	public WebElement lastNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='LastName']"), 10);
	}
	
	public WebElement businessNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='BusinessName']"), 10);
	}
	
	public WebElement categoryDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@placeholder='Choose Category']"), 10);
	}
	
	public WebElement companyTypeCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='Type'])[1]"), 10);
	}
	
	public WebElement countryDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='country']"), 10);
	}
	
	public WebElement stateDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='body_State']"), 10);
	}
	
	public WebElement cityTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='City']"), 10);
	}
	
	public WebElement phoneTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Phone']"), 10);
	}
	
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='continueBtn']"), 10);
	}
}
