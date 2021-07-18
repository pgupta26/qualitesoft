package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class OrderDetailPage {
	
	WebDriver driver;

	public OrderDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement ViewDetail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	
	public boolean verifyBasicThreshold() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[contains(text() ,'Basic Threshold (No Signature Required)')]"));
	}
	
	//********Added by Shubham**************
	public String verifyRerouteWarningMessage(){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-info-panel']//div[contains(@class,'alert-warning')]"), 60));
	}
	
	public String verifyRerouteLocationType(int index){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='address-area']//h5)["+index+"]"), 60));
	}
	
	public String verifyRerouteUpdatedData(int index){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='address-area']//p)["+index+"]"), 60));
	}

}
