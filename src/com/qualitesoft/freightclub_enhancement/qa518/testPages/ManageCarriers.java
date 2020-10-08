package com.qualitesoft.freightclub_enhancement.qa518.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ManageCarriers {

	public By managecarrier=By.xpath("//a[contains(text(),'Manage Carriers')]");
	public By settings=By.xpath("//a[contains(text(),'Settings')]");
	//public By upscheckbox=By.xpath("//td[contains(text(),'UPS Freight')]//preceding::td[2]");
	public By upscheckbox=By.xpath("//td[contains(text(),'UPS Freight')]//preceding::td[2]//label");
	
	WebDriver driver;
	public ManageCarriers(WebDriver driver){
		this.driver=driver;
	}
	public WebElement clkManageCarrier(){
		return WaitTool.waitForElementPresentAndDisplay(driver, managecarrier, 60);
	}
	public WebElement clkSetting(){
		return WaitTool.waitForElementPresentAndDisplay(driver, settings, 60);
	}public WebElement UPSToggleBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, upscheckbox, 60);
	}
}
