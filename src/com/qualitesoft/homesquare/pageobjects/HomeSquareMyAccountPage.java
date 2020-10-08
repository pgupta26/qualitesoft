package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareMyAccountPage {

	WebDriver driver;

	public HomeSquareMyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement bedroomLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/bedroom-furniture--PC330.htm']"),
				3600);
	}
	public WebElement bedsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/beds--C331.htm']"), 10);
	}

	public WebElement kitchenAndDiningLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"),
				3600);
	}

	public WebElement diningChairsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm']"), 10);
	}

	public WebElement orderId() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath(".//*[@id='tcAccount_tp0_orderList_List_row_0']/td[1]/a"), 30);
	}

	public WebElement logOffLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='Logout.aspx']"), 10);
	}

	public WebElement logoutText() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//b[text()='Logout']"), 10);
	}

}
