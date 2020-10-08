package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class ProductList {
	
	WebDriver driver;

	public ProductList(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement addProductLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@class='site-menu-title' and contains(text(),'Products')]"), 60);
	}
	
/*	public WebElement productsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//span[@class='site-menu-title' and contains(text(),'Products')]"), 10);
	}
	*/
	
	public WebElement productLists() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/products/collections']"), 60);
	}
	public WebElement productListsnew() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id="+"collectionsPage"+"]/div[1]/div/div/div/div/div/div/button"), 60);
	}
	public WebElement addNewProductList() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//button[@type='button' and @data-bind='click: AddModal']"), 60);
	}
	
/*	public void uploadLogoChrome() {

		try {
			SeleniumFunction.click(uploadLogoButton());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
			SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}*/
	
	public WebElement listDetailsTitle() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='modal-title']"), 60);
	}
	
	public WebElement listDetailsDecription() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@id='modal-description']"), 60);
	}
	
	public WebElement listDetailsSEOMetdata() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@id='modal-seotags']"), 60);
	}
	
	public WebElement listType() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@data-bind='value: Type']"), 60);
	}
	
	public WebElement listProductsTab() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#productInList']"), 60);
	}
	
	public WebElement keywords() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='productInList']/div[2]/div/div/input"), 60);
	}
	
	public WebElement searchIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='search']"), 60);
	}
	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='collection-save-button']"), 60);
	}
	
	public WebElement editButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@title='Edit Product List']"), 60);
	}
	
	public WebElement deletePrductList() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@title='Delete Product List']"), 60);
	}
	
	public WebElement optionGroupNameTexbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-bind='value: Name']"), 60);
	}
	
	public WebElement optionValuesTexbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-bind='value: Description']"), 60);
	}
	
	public WebElement newOptionValueLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-bind='click: function() { $root.addOptionValue($data) }']"), 60);
	}
	
	public WebElement newOptionValueLink2() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@data-bind='value: Description'])[2]"), 60);
	}
	
	public WebElement saveVariantsButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Save Variants']/ancestor::a"), 60);
	}
	
	public WebElement updateSaveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@data-bind='click: updateOrAddProduct'])[2]"), 60);
	}
	
	public WebElement viewProductIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='View Product']"), 60);
	}

	public WebElement checkAll() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='checkAll']"), 60);
	}
	public WebElement addkeywords() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='add']"), 60);
	}


}