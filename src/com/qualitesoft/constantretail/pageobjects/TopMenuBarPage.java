package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class TopMenuBarPage {

	WebDriver driver;

	public TopMenuBarPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement profilePicture() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='user-avatar']"), 10);
	}
	
	public WebElement logoutLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Auth/Logout' and @role='menuitem']"), 10);
	}

}
