package com.qualitesoft.cymaxAdmin.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ReturnAndCancellation {

	WebDriver driver;
	
	public ReturnAndCancellation(WebDriver driver){
		this.driver = driver;
	}
	
	By returnTab = By.xpath("//span[contains(@id,'tcOrder_tpCancellationReturn_tab')]");
	By status = By.xpath("//select[contains(@name,'tbReturnAndCancellation$CancelStatus')]");
	By selectedStatus = By.xpath("//select[contains(@name,'CancelStatus')]//option[@selected='selected']");
	By custEmailDate = By.xpath("//input[contains(@name,'CancelCustomerEmailDate')]");
	By followUpDate = By.xpath("//input[contains(@name,'dtFollowUp')]");
	By depostionDate = By.xpath("//input[contains(@name,'txtDepostionDate')]");
	By update = By.xpath("//input[@value='Update']");
	
	By returnDetails = By.xpath("//div[contains(@id,'Detail_header')]//span[contains(@id,'ReturnDetailsNew')]");
	By chooseFile = By.xpath("//div[contains(@id,'updFileUpReturn')]//input[@type='file']");
	By uploadBtn = By.xpath("//div[contains(@id,'updFileUpReturn')]//input[@type='submit']");
	By uploadedPhotos = By.xpath("//div[contains(@id,'upReturnPhotos')]//td[2]");
	
	public WebElement clickReturnAndCancellationTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, returnTab, 120);
	}
	
	public WebElement selectStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, status, 120);
	}
	
	public WebElement clickUpdateBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, update, 120);
	}
	
	public WebElement getSelectedStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, selectedStatus, 120);
	}
	
	public WebElement setCustEmailDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, custEmailDate, 120);
	}
	
	public WebElement setFollowUpDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, followUpDate, 120);
	}
	
	public WebElement setDepostionDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, depostionDate, 120);
	}
	
	public WebElement clickReturnDetailsSubtab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, returnDetails, 120);
	}
	
	public WebElement setChooseFile(){
		return WaitTool.waitForElementPresentAndDisplay(driver, chooseFile, 120);
	}
	
	public WebElement clickUploadBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, uploadBtn, 120);
	}
	
	public List<WebElement> getUploadedPhotosText(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, uploadedPhotos, 60);
	}
	
	//***********************Fedex Label Tab***************
	By fedExLabel = By.xpath("//div[contains(@id,'Detail_header')]//span[contains(@id,'PnlFedexReturnLabel_tab')]");
	By rma = By.xpath("//input[@id='FRMANumber']");
	By firstName = By.xpath("//input[@id='FSTName']");
	By companyName = By.xpath("//input[@id='FSTCompanyName']");
	By address = By.xpath("//input[@id='FSTAddr1']");
	By city = By.xpath("//input[@id='FSTCity']");
	By postalCode = By.xpath("//input[@id='FSTZip']");
	By phoneNum = By.xpath("//input[@id='FSTPhone']");
	By date = By.xpath("//input[@id='FedexDropOffDate']");
	By submitBtn = By.xpath("//input[@id='submitLabelFedex']");
	By warningPopup = By.xpath("//span[text()='Yes']//parent::button");
	
	public WebElement clickFedExLabel(){
		return WaitTool.waitForElementPresentAndDisplay(driver, fedExLabel, 120);
	}
	public WebElement setRma(){
		return WaitTool.waitForElementPresentAndDisplay(driver, rma, 120);
	}
	public WebElement setFirstName(){
		return WaitTool.waitForElementPresentAndDisplay(driver, firstName, 120);
	}
	public WebElement setCompanyName(){
		return WaitTool.waitForElementPresentAndDisplay(driver, companyName, 120);
	}
	public WebElement setAddress(){
		return WaitTool.waitForElementPresentAndDisplay(driver, address, 120);
	}
	public WebElement setCity(){
		return WaitTool.waitForElementPresentAndDisplay(driver, city, 120);
	}
	public WebElement setPostalCode(){
		return WaitTool.waitForElementPresentAndDisplay(driver, postalCode, 120);
	}
	public WebElement setPhoneNum(){
		return WaitTool.waitForElementPresentAndDisplay(driver, phoneNum, 120);
	}
	public WebElement setDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, date, 120);
	}
	public WebElement clickSubmitBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, submitBtn, 120);
	}
	public List<WebElement> checkAcceptWarning(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, warningPopup, 120);
	}
	
	public WebElement acceptWarning(){
		return WaitTool.waitForElementPresentAndDisplay(driver, warningPopup, 120);
	}
}
