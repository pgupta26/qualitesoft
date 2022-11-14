package com.qualitesoft.channelgatesip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class WhiteLabelProductPage {

	WebDriver driver;
	
	public WhiteLabelProductPage(WebDriver driver){
		this.driver = driver;		
	}
	
	private By brandField = By.xpath("//p-multiselect[contains(@class,'p-element p-inputwrapper')]");
	private By whiteLabelBrandField = By.xpath("//p-dropdown[@placeholder='Select a White Label Brand']");
	private By exportBtn = By.xpath("//span[contains(text(),'Export your catalog')]");
	private By createWhiteLabelBtn = By.xpath("//span[contains(text(),'Create White Label')]//parent::button");
	
	
	public WebElement clickBrandField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, brandField, 60);
	}
	public WebElement clickWhiteLabelBrandField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, whiteLabelBrandField, 60);
	}
	public WebElement clickExportBtn() {
		return WaitTool.waitForElementPresentAndDisplay(driver, exportBtn, 60);
	}
	public WebElement clickCreateWhiteLabelBtn() {
		return WaitTool.waitForElementPresentAndDisplay(driver, createWhiteLabelBtn, 60);
	}
}
