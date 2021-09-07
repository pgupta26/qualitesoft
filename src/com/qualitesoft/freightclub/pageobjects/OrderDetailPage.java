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
	
	public WebElement getLabel(String label) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='"+label+"']/following::div | //th[text()='"+label+"']/following-sibling::td"), 30);
	}
	
	public WebElement viewDetail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	
	public void expandItemsInThisOrderPanel() {
		WebElement element = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='shipment-items-panel collapsible well well-note']/div"), 30);
		String isCollapsedExist = element.getAttribute("class");
		if(isCollapsedExist.contains("collapsed")) {
			SeleniumFunction.click(element);
		}
	}
	
	public boolean verifyBasicThreshold() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[contains(text() ,'Basic Threshold (No Signature Required)')]"));
	}
	
	//********Added by Shubham**************
	public String verifyRerouteWarningMessage(){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-info-panel']//div[contains(@class,'alert-warning')]"), 60));
	}
	
	public boolean verifyRerouteWarningMessageStatus(){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[@id='details-info-panel']//div[contains(@class,'alert-warning')]"));
	}

	public String verifyRerouteLocationOnDetailPage(){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[contains(text(),'Reroute Location')]//parent::div"), 60));
	}
	
	//******************verify bill details added by Admin on order detail page************
	
	public WebElement adminTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='admin-tab']"), 60);
	}
	
	public WebElement billsTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='bills-tab']"), 60);
	}
	
	public WebElement billDetail(String documentNum, int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//td[text()='"+documentNum+"']//parent::tr//td)["+index+"]"), 60);
	}

}
