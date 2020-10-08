package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class HomeSquareCartPage {
	
	WebDriver driver;

	public HomeSquareCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement checkoutButton(){
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@id='topGotoCheckout'])"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='proceed-to-checkout-btn next-page cymax-click-event cymax-click-event'])"), 10);
	}

	public WebElement continueShoppingButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='btn-continue-shopping']"), 10);
	}
	
	public WebElement deleteProductLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-remove-link cymax-click-event' or @data-eventmessage='Delete Cartrow'])[1]"), 10);
	}
	
	public WebElement addProductQuantity() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-quantity'])"), 10);
	}
	
	public WebElement updateProductQuantity() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-update-link cymax-click-event' or @data-eventmessage='Update Cartrow'])"), 10);
	}
	public String shipping() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Shipping']/following-sibling::div[1]"), 10));
	}

	public String tax() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Tax: ']/following-sibling::div[1]"), 10));
	}

	public String productPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Product Total')]/following-sibling::div[1]"), 10));
	}
}
