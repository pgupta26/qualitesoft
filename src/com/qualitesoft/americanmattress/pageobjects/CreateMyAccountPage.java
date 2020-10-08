package com.qualitesoft.americanmattress.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CreateMyAccountPage {

	WebDriver driver;

	public CreateMyAccountPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement firstNameTextField() {

		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='firstName' or @id='Address_FirstName']"), 60);
	}

	public WebElement lastNameTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@name='lastName' or @id='Address_LastName']"), 60);
	}
	
	public WebElement emailAddressTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@name='email' or @id='Email']"), 60);
	}
	
	public WebElement passwordTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='password' or @id='Password']"), 60);
	}
	
	public WebElement confirmPasswordTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ConfirmPassword' or @id='confirmPassword']"), 60);
	}
	
	public WebElement streetAddressTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address_Address1' or @id='address1']"), 60);
	}
	
	public WebElement cityTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address_City' or @id='city']"), 60);
	}
	
	public WebElement countryDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='Country' or @id='country']"), 60);
	}
	
	public List<WebElement> stateDropdownWaitForOptions() {

		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//select[@id='Province' or @id='state']/option"), 60);
	}
	
	public WebElement stateDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='Province' or @id='state']"), 60);
	}
	
	public WebElement postalCodeTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address_ZipCode' or @id='postalCode']"), 60);
	}
	
	public WebElement phoneTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Address_PhoneNumber' or @id='phoneNumber']"), 60);
	}
	
	public WebElement registerButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='form_submit']"), 60);
	}

}
