package com.qualitesoft.channelgatesip.pageobjects;

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
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Enter Public Mailinator Inbox'] | //input[@id='inbox_field']"), 30);
	}
	
	public WebElement goButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("go-to-public"), 30);
	}
	
	public WebElement go() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'GO')]"), 30);
	}
	
	public WebElement firstMail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@class='table-striped jambo_table']/tbody/tr"), 30);
	}
	
	public WebElement mailBody() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//body/div"), 10);
	}
	
	public WebElement backToInbox() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("Back to Inbox"), 10);
	}
	
	public WebElement firstMail1() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Your order has been booked. (QA Testing)')]"), 30);
	}
	
	public WebElement resetPasswordBtn() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Reset Your Password')]"), 30);
	}
	
	public WebElement deleteEmail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@class,'btn-delete')]"), 30);
	}
	
	public WebElement orderConfirmationMsg() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/p[3]"), 30);
	}
	
	public WebElement mailText(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(/html[1]/body[1]/table[1]//h1)["+index+"]"), 30);
	}
	
	public WebElement cgLogoImage(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(/html[1]/body[1]/table[1]//img)["+index+"]"), 30);
	}
}
