package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareOrderConfirmationPage {

	WebDriver driver;

	public HomeSquareOrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement orderNumber() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='OrderNumber']"), 10);
	}

	public WebElement cymaxLogoImg() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@*='logo']"), 10);
	}

}
