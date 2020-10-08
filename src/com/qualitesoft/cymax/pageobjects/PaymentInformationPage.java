package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class PaymentInformationPage {
	
	WebDriver driver;
	public PaymentInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectPO() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='purchaseorder']"), 5));
	}
	
	public void selectPaypal() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='paypal']"), 5));
	}
	
	public void payWithPaypal() {
		try {
			//zoid-paypal-buttons-b97ebf042a_mtq6ndq6mjy
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@id,'zoid-paypal-buttons')]"), 10));
			//SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@id='buttons-container']/div/div)[2]"), 10));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
