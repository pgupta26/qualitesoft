package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class MuzeboardBoardPage {
	
	WebDriver driver;

	public MuzeboardBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement shopTheLookText() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='board-product-list']//h2"), 10);
	}
	
	public WebElement addToCartButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnAddToCart']"), 10);
	}
	
	public WebElement boardLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#boardImage']"), 10);
	}
	
	public WebElement boardEditLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@role='tabpanel']//a[@class='btn btn-default btn-icon margin-right-5 btn-edit']"), 10);
	}

}
