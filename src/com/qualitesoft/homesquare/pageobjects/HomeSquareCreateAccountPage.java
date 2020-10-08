package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareCreateAccountPage {
	
	WebDriver driver;

	public HomeSquareCreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement firstNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='FirstName']"), 10);
	}
	
	public WebElement lastNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='LastName']"), 10);
	}
	
	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='EmailAddress']"), 10);
	}
	
	public WebElement passwordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='RegPassword']"), 10);
	}
	
	public WebElement confirmPasswordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='RegRepeatPassword']"), 10);
	}
	
	public WebElement companyNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Company']"), 10);
	}
	
	public WebElement streetAddressTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address1']"), 10);
	}
	
	public WebElement addressLine2TextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address2']"), 10);
	}
	
	public WebElement cityTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='City']"), 10);
	}
	
	public WebElement countryDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ddlCountry']"), 10);
	}
	
	public WebElement stateDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='StateProvince']"), 10);
	}
	
	public WebElement zipCodeTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='PostalCode']"), 10);
	}
	
	public WebElement phoneTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Phone']"), 10);
	}
	
	public WebElement commentTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='generalcomment']"), 10);
	}
	
	public WebElement registerButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Register']"), 10);
	}

}
