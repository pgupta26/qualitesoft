package com.qualitesoft.cymax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ShippingInformationPage {
	
	WebDriver driver;
	public ShippingInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void businessCommercial() {
		SeleniumFunction.click(WaitTool.returnWebElement(driver, By.xpath("//input[@value='C']")));
	}
	
	public void companyName(String companyName) {
		SeleniumFunction.sendKeys(WaitTool.returnWebElement(driver, By.name("company-name")), companyName);
	}
	
	public void industry(String industryName) {
		SeleniumFunction.selectByVisibleText(WaitTool.returnWebElement(driver, By.id("ddlIndustry")), industryName);
	}
	
	public void enterNewAddress() {
		SeleniumFunction.click(WaitTool.returnWebElement(driver, By.linkText("Enter a New Address")));
	} 

}
