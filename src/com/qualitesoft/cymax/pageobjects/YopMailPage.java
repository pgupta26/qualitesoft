package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class YopMailPage {
	
	WebDriver driver;
	
	public YopMailPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	public void emailAddress(String emailAddress) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.id("login"), 20), emailAddress);
	}
	
	public void checkInbox() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='Check Inbox']"), 10));
	}
	
	public void selectCymaxStore() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[text()='Cymax Stores']/parent::span/following-sibling::span[contains(text(),'Order')])[1]"), 10));
	}
	
	public String[] getPrice() {
			String price = driver.findElement(By.xpath("//*[@id='mailmillieu']/div[2]/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td[3]")).getText();
			String[] lines = price.split("\\r?\\n");
			return lines;	
	}
}
