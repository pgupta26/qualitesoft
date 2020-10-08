package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement sizeDropDown() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[@id='product-options']//select"), 30);
	}
	
	public WebElement addToCartButton() {
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//a[@class='btn btn-primary btn-add-to-cart']"), 30);

		// WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='addtoCartButton' or @class='customButton add-cart']"), 60);
	}
	public WebElement ProceedButton() {
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 30);

		// WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='addtoCartButton' or @class='customButton add-cart']"), 60);
	}

}
