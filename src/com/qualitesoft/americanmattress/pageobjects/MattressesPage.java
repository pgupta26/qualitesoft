package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class MattressesPage {

	WebDriver driver;

	public MattressesPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement firstItemLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='product-info' or @class='product-item'])[2]"), 60);
	}
	
	public WebElement secondItemLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='product-info' or @class='product-item'])[4]"), 60);
	}

}
