package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class AboutUsWebsitePage {
	
	WebDriver driver;

	public AboutUsWebsitePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement aboutUsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@contentitem-type='33']"), 10);
	}

}
