package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class BoardApprovalPage {

	WebDriver driver;

	public BoardApprovalPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement approvalButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='approveBtn']"), 10);
	}
	
	public WebElement muzeboardCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@type='checkbox'])[1]"), 10);
	}
	
	public WebElement disapproveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='disapproveBtn']"), 10);
	}
	
	public WebElement selectDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control']"), 10);
	}
	
	public WebElement homesquareLogo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='logo']"), 10);
	}
	
	public WebElement logoutButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='logoutBtn']"), 10);
	}

}
