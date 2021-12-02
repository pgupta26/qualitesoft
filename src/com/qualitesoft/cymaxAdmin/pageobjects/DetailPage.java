package com.qualitesoft.cymaxAdmin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class DetailPage {

	WebDriver driver;
	
	public DetailPage(WebDriver driver){
		this.driver = driver;
	}
	
	By skuNum = By.xpath("//a[contains(@id,'EditProduct')]");
	By manufactureNameLink = By.xpath("//a[contains(@href,'manufactures.aspx?manuID')]");
	
	public WebElement clickSkuNum(){
		return WaitTool.waitForElementPresentAndDisplay(driver, skuNum, 60);
	}
	public WebElement clickManufactureNameLink(){
		return WaitTool.waitForElementPresentAndDisplay(driver, manufactureNameLink, 60);
	}
	By popupHeader = By.xpath("//div[contains(@id,'ProductPanel')]//div[contains(@id,'OLmatch_Panel')]");
	By manufactureNameOnPopup = By.xpath("//a[contains(@id,'lnkProdManufacture')]");
	By closePopup = By.xpath("(//input[contains(@id,'ImageButton1')])[1]");
	
	public WebElement getPopupHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, popupHeader, 60);
	}
	public WebElement getManufactureNameOnPopup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, manufactureNameOnPopup, 60);
	}
	public WebElement clickClosePopup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, closePopup, 60);
	}
	By manufactureList = By.xpath("//div[contains(@id,'TabContainer1_header')]");
	By manufactureName = By.xpath("//span[contains(@id,'lblManuName')]");

	public WebElement getManufactureListText(){
		return WaitTool.waitForElementPresentAndDisplay(driver, manufactureList, 60);
	}
	public WebElement getManufactureName(){
		return WaitTool.waitForElementPresentAndDisplay(driver, manufactureName, 60);
	}
}
