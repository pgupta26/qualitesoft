package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class AddProduct {
	WebDriver driver;

	public AddProduct(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement LogInButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"AppFrameMain\"]/div[3]/div/div/div[1]/section/div[2]/div/div/div[2]/table/tbody/tr[1]/td[3]/a"), 120);
	}
	public WebElement products() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/admin/products']"), 40);
	}
	public WebElement Addproduct() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/admin/products/new']"), 40);
	}
	public WebElement Producttitle() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='product-name']"), 40);
	}
	public WebElement Productdesc() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='product-description_iframecontainer']"), 40);
	}
	public WebElement Uploadimage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-images-content\"]/header/div/div[2]"), 40);
	}
	public WebElement AddvariantButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-multiple-options\"]"), 40);
	}	
	public WebElement variantvalue() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-outer-variants\"]/div/section[4]/div[2]/table/tbody/tr[1]/td[2]/div/ul/li/input"), 40);
	}
	public WebElement saveButton() { 
		
	//	return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"ui-app-frame\"]/header/div[2]/div[2]/div/div[2]/button"), 40);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"create_new_product\"]/div[2]/div/div/div/button"), 40);
	}
	public void uploadLogoChrome() {

		try {
			SeleniumFunction.click(Uploadimage());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
			//WaitTool.sleep(2);
			SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
			//WaitTool.waitForElementPresentAndDisplay(driver,
			//		By.xpath(".//*[@id='uploadprogress']/span[contains(text(),'100%')]"), 40);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}
}

