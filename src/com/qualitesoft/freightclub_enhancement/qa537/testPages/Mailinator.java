package com.qualitesoft.freightclub_enhancement.qa537.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class Mailinator {
	
	WebDriver driver;

	public Mailinator(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement searchBox() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("addOverlay"), 30);
	}
	
	public WebElement goButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("go-to-public"), 30);
	}
	
	public WebElement firstMail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@class='table table-striped jambo_table']/descendant::tr[2]"), 30);
	}
	
	public WebElement firstMail1() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Your order has been booked. (QA Testing)')]"), 30);
	}
	
	public WebElement reviewedOrderMsg() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/p[2]"), 30);
	}
	
	public WebElement orderConfirmationMsg() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/p[3]"), 30);
	}
	
	
	
	
	

}
