package com.qualitesoft.freightclub_enhancement.qa517.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class OrderDetailPage {
	
	WebDriver driver;

	public OrderDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement ViewDetail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	
	public boolean verifyBasicThreshold() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[contains(text() ,'Basic Threshold (No Signature Required)')]"));
	}

}
