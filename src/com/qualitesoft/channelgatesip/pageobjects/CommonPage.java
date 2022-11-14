package com.qualitesoft.channelgatesip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CommonPage {

	WebDriver driver;
	public CommonPage(WebDriver driver){
		this.driver = driver;		
	}
	
	private By userdefaultName = By.cssSelector("span[class*='p-avatar-text']");
	private By userName = By.cssSelector("div[class*='text-base']");
	private By userEmail = By.cssSelector("div[class*='text-sm lowercase']");
	private By toastMessage = By.xpath("(//div[contains(@class,'p-toast-message')]//div)[1]");
	
	public WebElement getDefaultUserName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, userdefaultName, 30);
	}
	public WebElement getUserName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, userName, 30);
	}
	public WebElement getUserEmail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, userEmail, 60);
	}
	
	public WebElement clickLeftMenuOption(String menuText) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'"+menuText+"')]//parent::a"), 60);
	}
	public WebElement clickButtonByText(String menuText) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'"+menuText+"')]//parent::button"), 60);
	}
	
	public WebElement getToastMessageText(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-toastitem//p)["+index+"]"), 180);
	}
	public WebElement getToastMessageHeader(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-toastitem//h4)["+index+"]"), 180);
	}
	
	public WebElement validationMessage(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[contains(@class,'text-xs text-danger')])["+index+"]"), 30);
	}
	public WebElement getToastMessage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, toastMessage, 60);
	}
}

