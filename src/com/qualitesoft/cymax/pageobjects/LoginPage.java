package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createNewAccountLink() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Image1']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"btn-create-account\"]"), 10);
	}
	public WebElement HomeSqcreateNewAccountLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-secondary negative width-100-pct']"), 10);
	}
	
	public boolean alreadyHaveAccountPresent() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[@href='#loginFormDiv']"));
	}
	
	public void alreadyHaveAccount() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#loginFormDiv']"), 20));
	}
	
	public WebElement amazonPay(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h1[contains(text(),'Amazon - Login')]//following::div[1]"), 60);
	}
	public WebElement payPal(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@data-funding-source='paypal']"), 60);
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
	public void userName(String userName) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("txtExistingEmailAddress"), 20), userName);
	}
	
	public void password(String password) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("txtPassword"), 20), password);
	}
	
	public void signInButton() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("btnHaveAnAccount"), 20));
	}
	public WebElement forgotPassword(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Forgot your password?')]"), 60);
	}	
	public void guestUserName(String userName) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("txtEmailAddress"), 20), userName);
	}
	
	public void continueGuest() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("btnSignIn"), 20));
	}
	
	public boolean alreadyGuestPresent() {
		return WaitTool.isElementPresentAndDisplay(driver, By.id("btnSignIn"));
	}			
}
