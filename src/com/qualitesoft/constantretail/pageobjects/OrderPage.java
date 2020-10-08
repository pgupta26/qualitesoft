package com.qualitesoft.constantretail.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class OrderPage{
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement ordersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-menu='2-0']"), 60);
	}

	public WebElement orders() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-slug='Orders']"), 60);
	}
	
	public WebElement applyFilter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: search']"), 60);
	}
	
	public WebElement orderId() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='orderID']"), 60);
	}
	
	public WebElement viewOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-link view-order-details']"), 60);
	}
	
	public WebElement closeOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='close']"), 60);
	}
	
}	
