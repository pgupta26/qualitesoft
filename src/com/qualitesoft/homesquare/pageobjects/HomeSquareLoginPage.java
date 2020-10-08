package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareLoginPage {

	WebDriver driver;

	public HomeSquareLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createNewAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Image1']"), 10);
	}

}
