package com.qualitesoft.googlemerchantpricebenchmarksimulator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement emailField(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='email']"), 10);
		return webElement;
	}
	
 public WebElement passwordfield(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='password']"), 10);
		return webElement;
	}

	
 public WebElement nextbutton(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='identifierNext']"), 10);
		return webElement;
	}
 public WebElement nextpwdbutton(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='passwordNext']"), 10);
		return webElement;
	}
 public WebElement termsCondition() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='TermsAgree']"), 10);
	}

 public WebElement products() {
	 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"left-nav-main_products\"]"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='left-nav-main_products']"), 30);
	}
 public WebElement pricebench() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='skinny-nav-main_products_price']"), 30);
	} 
 public WebElement category() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='IU4TLB-gb-b IU4TLB-gb-a IU4TLB-gb-c']/input[@class='gwt-TextBox IU4TLB-Eb-b']"), 30);
	// return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='HQN3N1B-gb-b HQN3N1B-gb-a HQN3N1B-gb-c']/input[@class='gwt-TextBox HQN3N1B-Eb-b']"), 30);
	 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"gwt-uid-107\"]"), 30);
	} 
 public WebElement downloadicon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAQAAABKfvVzAAAAOUlEQVR4AWMYGuA/Ao5qwAANUEWYsIE0LQ2k2IJQTlgLQjlBLRjKCWtBKCdeS8OgStaYkHQNwwoAAEWCcJenlv+/AAAAAElFTkSuQmCC']"), 30);
	}
 public WebElement usericon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/div[1]/root/div/div/mc-app-bar/div/div[2]/mc-gaia-picker/material-gaia-picker/div/div/img"), 30);
	}
 public WebElement logout() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/div[2]/div[2]/div/div/div/main/div[2]/gaia-picker-footer/material-button"), 30);
	}

}

