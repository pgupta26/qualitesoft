package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class AddToCartPage {

	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement quantityDropdown() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Main.Qty']"),10);
	}
	
	public WebElement quantityDropdownHome() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),10);

	}
	public WebElement addToCartButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@data-eventmessage='Add To Cart']"), 30);
	}
	public WebElement keepshoppingButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/div[4]/div[1]/div[1]/a"), 30);
	}
	
}
