package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class PaypalCheckout {
	
	WebDriver driver;
	public PaypalCheckout(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LogIn() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplaySoft(driver, By.className("btn full ng-binding"), 10));
	}
	
	public void email(String userName) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("email"), 20), userName);
	}
	
	public void  next() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("btnNext"), 20));
	}
	
	public void password(String password) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("password"), 20), password);
	}
	
	public void signInButton() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("btnLogin"), 20));
	}
	
	public void changeLink() {
		try {
			WaitTool.waitForElementToBeClickable(driver, By.linkText("Change"), 20);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Change"), 20));	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String infoMessage() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='infoMessages']/ul/li"), 10));
	}
	
	public void payNow() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("confirmButtonTop"), 10));
		Log.info("Test");
	}
	
	public void payPalLogIn() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplaySoft(driver, By.linkText("Log In"), 10));
	}

}
