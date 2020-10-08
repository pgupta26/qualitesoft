package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ManagePickupLocationsPage {
	
	WebDriver driver;

	public ManagePickupLocationsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement managePickupLocLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Profile/Locations']"), 30);
	}
	
	public WebElement addNewPickupLocButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='add-new-location-btn']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-sm margin-bottom-20 width-100-pct']"), 30);
	}
	
	public WebElement locNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Name']"), 30);
	}
	
	public WebElement address1Textfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Address1']"), 30);
	}
	
	public WebElement postalCodeTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PostalCode']"), 30);
	}
	
	public WebElement firstNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='CFirstName']"), 30);
	}
	
	public WebElement lastNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='CLastName']"), 30);
	}
	
	public WebElement phonenoTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='CPrimaryPhone']"), 30);
	}
	
	public WebElement emailTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='CEmailAddress']"), 30);
	}
	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='submit']"), 30);
	}
}
