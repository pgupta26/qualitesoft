package com.qualitesoft.floatingcart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class FloatingLaunchQuickQuote {

	WebDriver driver;

	public FloatingLaunchQuickQuote(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement signInLinkProd() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='https://app.freightclub.com/QuickQuote/QuickQuote']"), 30);
	}
	public WebElement GetFreeQuoteLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='https://app.freightclub.com/Home/QuickQuote']"), 30);
	}	
	public WebElement logoff() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='navbar-collapse collapse']//ul[2]//li[3]"), 30);
		 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Log off')]"), 30);
	}	

}
