package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class MuzeboardOverviewPage {
	
	WebDriver driver;

	public MuzeboardOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement overviewTab() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#overview']"), 60);
	}
	
	public WebElement favouritesTab() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#favorites']"), 60);
	}
	
	public WebElement muzeboardsTab() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#muzeboards']"), 60);
	}
	
	public WebElement createMuzeboardButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@id='createNewProjectBtn']/i)[1]"), 60);
	}
	
	public WebElement logoutLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='logoutBtn']"), 60);
	}
	
	public WebElement editProfileLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='mb-user-btn-edit']"), 60);
	}

}
