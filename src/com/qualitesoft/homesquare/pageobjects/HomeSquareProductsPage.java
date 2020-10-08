package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class HomeSquareProductsPage {

	WebDriver driver;

	public HomeSquareProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement diningChair(){

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@class='product-item-img'])[1]"), 10);
	}
	public WebElement firstProductInListing(){

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='productListDiv']/div[1]/div/div/a/img"), 10);
	}
	public String productPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h3[@itemprop='price']"), 10));
	}
}
