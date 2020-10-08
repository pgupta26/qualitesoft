package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class TaxPage {
	
	WebDriver driver;

	public TaxPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement taxLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/settings/tax']"), 60);
	}
	
	public WebElement allTaxes() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='product']"), 60);
	}
	
	public WebElement setUpTax() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='country']"), 60);
	}
	
	public WebElement saveAllTax() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='productTaxes']/div/div[2]/button"), 60);
	}
    
	public WebElement checkboxAlaska() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='countryTaxes']/div[2]/div[2]/table/tbody/tr[2]/td[4]/input"), 60);
	}
	
	public WebElement albamaFedTax() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='countryTaxes']/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/input"), 60);
	}
	
	public WebElement albamaStateTax() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='countryTaxes']/div[2]/div[2]/table/tbody/tr[1]/td[3]/div/input"), 60);
	}
	
	public WebElement saveTax() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='countryTaxes']/div[1]/div[2]/button"), 60);
	}

}
