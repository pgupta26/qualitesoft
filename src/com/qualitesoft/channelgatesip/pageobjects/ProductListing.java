package com.qualitesoft.channelgatesip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ProductListing {

	WebDriver driver;
	public ProductListing(WebDriver driver){
		this.driver = driver;		
	}

	public WebElement dialogTitle(){
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[contains(@id,'dialog-help-intro')]"), 60);
		return webElement;
	}

	public WebElement skipTourBtn(){
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//h4[contains(@id,'dialog-help-intro')]//following::button)[1]"), 60);
		return webElement;
	}

}
