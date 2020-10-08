package com.qualitesoft.MBDesigner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class CreateMuzeboard {
	WebDriver driver;

	public CreateMuzeboard(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement createMuzeboardButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/boards/create/']"), 120);
	}
	public WebElement serachProductTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='searchInput']"), 120);
	}
	public WebElement serachIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='input-search-btn font-size-18']"), 120);
	}	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnSave']"), 120);
	}
	public WebElement publishButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnPublish']"), 120);
	}	
	public WebElement boardnameTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='board-name']"), 120);
	}
	public WebElement boarddescTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@id='board-description']"), 120);
	}
	public WebElement tagsTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='bootstrap-tagsinput']//input"), 120);
	}	
	public WebElement browseImage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='inspired-image-pickfiles']"), 120);
	}
	public WebElement okButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='save-board']"), 120);
	}
	public void uploadFileChrome(String file) {

		try {
			SeleniumFunction.clickAction(driver, browseImage());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\muzeboard\\" + file+".jpg" };
			SeleniumFunction.runAutoItScript("manageproductuploadchrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}
	public WebElement backButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/boards']"), 120);
	}
	public WebElement ordersLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-menu='2-0']"), 60);
	}
	public WebElement orders() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-slug='Orders']"), 60);
	}
	public WebElement applyFilter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: search']"), 60);
	}
	
	public WebElement orderId() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='orderID']"), 60);
	}
	
	public WebElement viewOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-link view-order-details']"), 60);
	}
	
	public WebElement closeOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='close']"), 60);
	}
	public WebElement profilePicture() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='user-avatar']"), 30);
	}
	
	public WebElement logoutLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Auth/Logout?muzeboard=true' and @role='menuitem']"), 30);
	}
}

