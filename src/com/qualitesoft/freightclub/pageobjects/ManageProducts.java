package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManageProducts {
	
	WebDriver driver;
	
	public ManageProducts(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement manageProductLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/Product/UploadProducts')]"), 30);
	}
	
	public WebElement createproduct() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Create New Product')]"), 60);
	}
	
	public WebElement palletType(String palletType) {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-input items has-options full has-items']"), 30));
		WaitTool.sleep(3);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'"+palletType+"')]"), 30);
	}
	
	public WebElement SKU() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='SKU']"), 30);
	}
	
	public WebElement productName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Name']"), 30);
	}
	
	public WebElement declaredValue() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='DeclaredValue']"), 30);
	}
	
	public WebElement weight() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@id='product-pallets-table']/descendant::td[@class='form-inline weight']/descendant::input"), 30);
	}
	
	public WebElement length() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@id='product-pallets-table']/descendant:: input[@placeholder='Lenght']"), 30);
	}
	
	public WebElement width() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@id='product-pallets-table']/descendant:: input[@placeholder='Width']"), 30);
	}
	public WebElement height() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@id='product-pallets-table']/descendant:: input[@placeholder='Height']"), 30);
	}
	
	public WebElement cartoonweight(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"product-cartons-table\"]/tbody/tr/td[2]/div[1]/input)["+itemIndex+"]"), 30);
	}
	
	public WebElement cartoonlength(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"product-cartons-table\"]/tbody/tr/td[3]/div[1]/input)["+itemIndex+"]"), 30);
	}
	
	public WebElement cartoonwidth(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"product-cartons-table\"]/tbody/tr/td[3]/div[2]/input)["+itemIndex+"]"), 30);
	}
	
	public WebElement cartoonheight(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"product-cartons-table\"]/tbody/tr/td[3]/div[3]/input)["+itemIndex+"]"), 30);
	}
	
	public WebElement category(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"product-cartons-table\"]/tbody/tr/td[4]/select)["+itemIndex+"]"), 30);
	}
	
	public WebElement popupCateogory(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[text()='Got it!'])["+itemIndex+"]"), 30);
	}
	
	public WebElement addadditionalCarton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-info btn-xs'])[1]"), 30);
	}
	
	public WebElement saveproduct() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='createProductModal']/div/div/div[3]/div/div[2]/button"), 30);
	}

}
