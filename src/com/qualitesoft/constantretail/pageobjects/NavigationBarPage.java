package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class NavigationBarPage {

	WebDriver driver;

	public NavigationBarPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement dashboardLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Dashboard')]"), 10);
	}
	
	public WebElement ordersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Orders')]"), 10);
	}
	
	public WebElement allOrdersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'All Orders')]"), 10);
	}
	
	public WebElement productsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Products')]"), 10);
	}
	
	public WebElement allProductsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'All Products')]"), 10);
	}
	
	public WebElement collectionsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Collections')]"), 10);
	}
	
	public WebElement reportsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Reports')]"), 10);
	}
	
	public WebElement subscriptionsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Subscriptions')]"), 10);
	}
	
	public WebElement activeSubscriptionsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@href='/subscriptions/active']"), 10);
	}
	
	public WebElement availableSubscriptionsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@href='/subscriptions/available']"), 10);
	}
	
	public WebElement locationsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Locations')]"), 10);
	}
	
	public WebElement usersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Users')]"), 10);
	}
	
	public WebElement generalLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'General')]"), 10);
	}
	
	public WebElement shippingLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Shipping')]"), 10);
	}
	
	public WebElement taxLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Tax')]"), 10);
	}
	
	public WebElement pagesLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Pages')]"), 10);
	}
	
	public WebElement socialLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Social')]"), 10);
	}
	
	/*=======++++++++++++++++++++++Functions to be used later=======================================*/

	public WebElement addProductButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//button[@data-bind='click: showProductAddModal']"), 60);
	}
	
	public WebElement applyFilterButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//button[@data-bind='click: search']"), 60);
	}
	
	public WebElement aboutUsLinkButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath(".//*[@id='itemsTreeFirst']//span"), 60);
	}

}
