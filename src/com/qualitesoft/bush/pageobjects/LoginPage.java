package com.qualitesoft.bush.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createNewAccountLink() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Image1']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"Image1\"]"), 10);
	}
	public WebElement HomeSqcreateNewAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-secondary negative width-100-pct']"), 10);
	}
	
	public WebElement amazonEmail(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ap_email']"), 60);
	}
	public WebElement amazonPassword(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ap_password']"), 60);
	}
	public WebElement amazonLoginBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='signInSubmit']"), 60);
	}
	public WebElement amazonSignInBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 60);
	}
	public WebElement continueButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@id='a-autoid-0']//input[@class='a-button-input']"), 60);
	}
}
