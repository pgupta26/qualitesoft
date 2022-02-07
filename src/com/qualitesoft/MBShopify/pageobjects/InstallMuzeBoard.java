package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class InstallMuzeBoard {
	WebDriver driver;

	public InstallMuzeBoard(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement Apps() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameAside\"]/div[1]/div[2]/div/div/nav/ul[1]/li[5]"), 120);
	}
	public WebElement AppName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/div[3]/div/div[1]/div/section/div/div[2]/table/tbody/tr[1]/td[1]/a"), 40);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/div[2]/div/div/div/section/div/div[2]/table/tbody/tr[1]/td[1]/a"), 40);
	}
	public WebElement moreaction() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"TitleBar\"]/div[2]/div[2]/div/div[2]/div/button"), 40);
	}	
	public WebElement createappstore() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"ui-popover--1\"]/div[2]/div/div/ul/li[3]/ul/li/a"), 40);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/div[3]/div/div[2]/div/section/div[3]/div/div/div[2]/a"), 40);
	}	
	public WebElement editapp() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/a"), 40);
	}	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='button button-small button-primary']"), 40);
	}	
	public WebElement ViewApplisting() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='button button-small']"), 40);
	}
	public WebElement Get() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppInfo\"]/a"), 40);
	}	
	public WebElement LogIn() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"login-submit\"]"), 40);
	}
	public WebElement Installunlisted() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"oauth-authorize\"]/div/div/div/div[2]/div/div/div/div[2]/form/button"), 40);
	}	
}

