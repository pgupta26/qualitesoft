package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManageLocations {
	
	WebDriver driver;

	public ManageLocations(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement manageLocationsLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Profile/Locations']"), 30);
	}
	
	public WebElement addNewPickupLocButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-sm margin-bottom-20 width-100-pct']"), 30);
	}
	
	public WebElement searchLocation() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("locationsListFilter"), 30);
	}
	
	public boolean isLocationExist(String locationName) { 
		SeleniumFunction.sendKeys(this.searchLocation(), locationName);
		WaitTool.sleep(2);
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[text()='No items to display']"));
	}
	
	public WebElement companyNameTextfield() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Name']"), 30);
	}
	
	public WebElement address1Textfield() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Address1']"), 30);
	}
	
	public WebElement postalCodeTextfield() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PostalCode']"), 30);
	}
	
	public WebElement locationTypeField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("LocationType"), 30);
	}
	
	public WebElement earliestPickUpField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("earliestPickup"), 30);
	}
	
	public WebElement latestPickUpField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("latestPickup-select"), 30);
	}
	
	public WebElement earliestDropOffField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("earliestDropOff"), 30);
	}
	
	public WebElement latestDropOffField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("latestDropOff-select"), 30);
	}
	
	public WebElement contactType() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("ContactType"), 30);
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
