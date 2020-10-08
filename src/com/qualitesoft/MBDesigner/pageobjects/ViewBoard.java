package com.qualitesoft.MBDesigner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ViewBoard {
	WebDriver driver;

	public ViewBoard(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement viewBoradButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='View Boards List on Store site']"), 60);
	}	
		
}
