package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class LocationPage{
	
	WebDriver driver;

	public LocationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement locationLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Locations/']"), 60);
	}
	
	public WebElement addNewLocation() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/locations/create/']"), 60);
	}
	
	public WebElement locationName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='storeName']"), 60);
	}
	
	public WebElement streetName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='storeStreet']"), 60);
	}
	
	public WebElement cityName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='storeCity']"), 60);
	}
	
	public WebElement zipCode() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='storeZip']"), 60);
	}
	
	public WebElement countryName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='Country']"), 60);
	}
	
	public WebElement stateName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='State']"), 60);
	}
	
	public WebElement pickUp() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='pickupCheckbox']"), 60);
	}
	
	public WebElement shipping() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='shippingCheckbox']"), 60);
	}
	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='save-button']"), 60);
	}

	public WebElement searchValue() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-bind='value: queryParam']"), 60);
	}
	
	public WebElement applyFilter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: Search']"), 60);
	}
	
	public WebElement editLocation() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='Edit Location']"), 60);
	}

	public void ValidateLocationName(String location) {
		
		String actualLocation=driver.findElement(By.xpath("//span[@data-bind='text : Name']")).getText();
         UseAssert.assertEquals(actualLocation, location);
		
	}
	
	
}	



