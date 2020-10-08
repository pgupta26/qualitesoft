package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ReviewYourOrderPage {
	
	WebDriver driver;

	public ReviewYourOrderPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement continueToPaymentButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 60);
	}

}
