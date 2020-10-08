package com.qualitesoft.freightclub_enhancement.qa518.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CarrierMarkupsPage {
	WebDriver driver;
	
	public CarrierMarkupsPage(WebDriver driver){
		this.driver=driver;
	}
	public WebElement selectShipMethod(String xpathRow){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//th[text()='Ship Method']//following::th["+xpathRow+"]//select[1]"), 60);
	}

	public WebElement selectIncDec(String xpathRow){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//th[text()='Ship Method']//following::th["+xpathRow+"]//select[2]"), 60);
	}
	
	public WebElement groundMarkups(String xpathRow){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='markupsTab']//tr[1]//td["+xpathRow+"]//input[1]"), 60);
	}
	public WebElement nextDayAirEarlyAM(String xpathRow){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='markupsTab']//tr[7]//td["+xpathRow+"]//input[1]"), 60);
	}
	public WebElement standard(String xpathRow){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='markupsTab']//tr[8]//td["+xpathRow+"]//input[1]"), 60);
	}
	public WebElement clickCarrierMarkups(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Carrier Markups')]"), 60);
	}
	public WebElement clkUpdateBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Update')]"), 60);
	}
}
