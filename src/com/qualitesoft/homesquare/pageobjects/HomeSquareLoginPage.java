package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class HomeSquareLoginPage {

	WebDriver driver;

	public HomeSquareLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createNewAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Image1']"), 10);
	}
	
	//**********Copied from cymax

	public boolean alreadyHaveAccountPresent() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[@href='#loginFormDiv']"));
	}
	
	public void alreadyHaveAccount() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#loginFormDiv']"), 20));
	}
	
	public void userName(String userName) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("txtExistingEmailAddress"), 20), userName);
	}
	
	public void password(String password) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("txtPassword"), 20), password);
	}
	
	public void signInButton() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("btnHaveAnAccount"), 20));
	}
	
	public WebElement HomeSqcreateNewAccountLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-secondary negative width-100-pct']"), 10);
	}
	
	public WebElement amazonLoginBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='signInSubmit']"), 60);
	}
	
	public WebElement continueButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@id='a-autoid-0']//input[@class='a-button-input']"), 60);
	}
	
	public WebElement amazonEmail(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ap_email']"), 60);
	}
	public WebElement amazonPassword(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ap_password']"), 60);
	}

}
