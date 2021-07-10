package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareAddToCartPage {

	WebDriver driver;

	public HomeSquareAddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement quantityDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),
				10);
	}

	public WebElement addToCartButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@data-eventmessage='Add To Cart']"), 60);
		
	}
	public WebElement plaaddToCartButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Liberty-Furniture-Nostalgia-Arrow-Back-Windsor-Dining-Chair-10-C553S.htm']"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-add-to-cart']"), 60);
	}

	public WebElement quantityDropdownHome() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),10);

	}
}
