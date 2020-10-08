package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement diningChair(){

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"products-list\"]/li[1]/div/div/a/img"), 10);
	}
	public WebElement firstProductInListing(){

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"products-list\"]/li[1]/div/div/a/img"), 10);
	}
	public WebElement HomeSqdiningChair(){

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@class='product-item-img product-click-event'])[1]"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='product-description list-product-title'])[1]"), 10);
	}

	public void murphyBed() {
		SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='1652636']"), 10));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='1652636']"), 10));
	}

	public String productPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.id("product-main-price"), 10));
	}

}
