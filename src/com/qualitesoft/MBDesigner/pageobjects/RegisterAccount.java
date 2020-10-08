package com.qualitesoft.MBDesigner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class RegisterAccount {
	WebDriver driver;

	public RegisterAccount(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement firstNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='FirstName']"), 60);
	}
	public WebElement lastNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='LastName']"), 60);
	}	
	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Email']"), 60);
	}
	public WebElement passwordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Password']"), 60);
	}
	public WebElement ConfirmPasswordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='ConfirmPassword']"), 60);
	}	
	public WebElement storeNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='StoreName']"), 60);
	}	
	public WebElement agreeCheckBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='TermsAgree']"), 60);
	}
	public WebElement signUpButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-block submit btn-lg']"), 60);
	}	
	public WebElement rightArrow() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='fa fa-chevron-right']"), 60);
	}
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary center-block btn-lg']"),60);
	}		
}

