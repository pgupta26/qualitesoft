package com.qualitesoft.freightclub.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class BillOfLadingPage {

WebDriver driver;
	
	public BillOfLadingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement billOfLading() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("link-bol"), 10);
	}
	
	public WebElement wayBillTextBox() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-text-field='WaybillNo']"), 10);
	}
	
	public WebElement customerPoTextBox() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-text-field='ClientRefNo']"), 10);
	}
	
	public WebElement orderIdTextBox() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-text-field='OrderId']"), 10);
	}
	
	public List<WebElement> getNumberOfRows(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//div[@id='bill-of-lading-grid']//tbody//tr"), 20);
	}
	
	
	
	
}
