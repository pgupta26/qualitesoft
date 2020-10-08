package com.qualitesoft.freightclub_enhancement.qa538.testPages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManageOrderNotQuotedTab {
	
	WebDriver driver;

	public ManageOrderNotQuotedTab(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement notQuoted() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("incompleteOrders"), 30);
	}
	
	public WebElement orderIDFilter() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/input"), 30);
	}
	
	public WebElement complete() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[4]/div[3]/div/div/div/div[5]/div/button[1]"), 30);
	}
	
	public WebElement fulfillmentCarrier() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='CarriersWrapper']/div/div[1]/input"), 30);
	}
	
	public WebElement serviceLevel() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[3]/div/div[2]/div/div/div/div/strong"), 30);
	}
	
	public WebElement carrierQuoteID() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("CarrierQuote"), 30);
	}
	
	public WebElement COGS() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='shipment-review']/div[1]/div[3]/div/div[4]/div[1]/div/div/input"), 30);
	}
	
	public WebElement recurringExpiry() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("FrequencyExpiry"), 30);
	}
	
	public WebElement markupPercentage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='shipment-review']/div[1]/div[3]/div/div[4]/div[2]/div/div/input"), 30);
	}
	
	public WebElement deliveryFrequency() {
		WebElement test = null;
		try{
			test =  WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='shipment-review']/div[1]/div[3]/div/div[5]/div[1]/select"), 30);
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
		return test;
	}
	
	public WebElement totalWeight() {
		try {
			System.out.println(SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[7]/div/div/div/div/table/tbody/tr/td[1]"), 30)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[7]/div/div/div/div/table/tbody/tr/td[1]"), 30);
	}
	
	public WebElement declaredValue() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[7]/div/div/div/div/table/tbody/tr/td[2]"), 30);
	}
	
	public WebElement handlingUnits() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[7]/div/div/div/div/table/tbody/tr/td[3]"), 30);
	}
	
	public WebElement condition() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"shipment-review\"]/div[1]/div[7]/div/div/div/div/table/tbody/tr/td[4]"), 30);
	}
	
	public WebElement shipmentInformation() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Shipment Information']/following::textarea[1]"), 30);
	}
	
	public WebElement regulatoryDetails() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Regulatory Details')]/following::textarea"), 30);
	}
	
	public WebElement submitQuote() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Submit Quote']"), 30);
	}
	
	public WebElement unableToFulfil() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Unable to Fulfill']"), 30);
	}
}
