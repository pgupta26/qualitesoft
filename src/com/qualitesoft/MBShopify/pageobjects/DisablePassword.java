package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class DisablePassword {
	WebDriver driver;

	public DisablePassword(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement LogInButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/div[3]/div/div/div[1]/section/div[2]/div/div/div[2]/table/tbody/tr[1]/td[3]/a"), 120);
	}
	public WebElement onlineStore() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/admin/themes']"), 40);
	}
	public WebElement preference() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/admin/online_store/preferences']"), 40);
	}	
	public WebElement checkbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@class=\"edit_shop\"]/section[4]/div/div[2]/section/div/div/div[1]/label"), 40);
	}	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='ui-button ui-button--primary js-btn-primary js-btn-loadable btn-primary has-loading']"), 40);
	}	
}

