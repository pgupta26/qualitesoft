package com.qualitesoft.americanmattress.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ShippingInformationPage {

	WebDriver driver;

	public ShippingInformationPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement reviewOrderButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@class='primary-checkout-btn next-page']"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 60);
	}

	public WebElement zipCodeTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='zip-code']"), 60);
	}

	public WebElement firstNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='first-name']"), 60);
	}

	public WebElement lastNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='last-name']"), 60);
	}

	public WebElement addressTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-1']"), 60);
	}

	public WebElement cityTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='city']"), 60);
	}

	public WebElement countryDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlCountry']"), 60);
	}

	public List<WebElement> stateDropdownWaitForOptions() {

		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//select[@id='ddlState']/option"), 60);
	}

	public WebElement stateDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlState']"), 60);
	}

	public WebElement phoneTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='phone']"), 60);
	}
	public WebElement deliver() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//form[@id='formShippingInformation']//div//div[2]//div//h4//a//span"), 30);
	}
}
