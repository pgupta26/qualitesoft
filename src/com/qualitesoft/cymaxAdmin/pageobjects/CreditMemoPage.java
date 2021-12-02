package com.qualitesoft.cymaxAdmin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CreditMemoPage {

	WebDriver driver;
	
	public CreditMemoPage(WebDriver driver){
		this.driver = driver;
	}
	
	By creditMemo = By.xpath("//span[contains(@id,'tabCreditMemo_tab')]");
	By addNew = By.xpath("//a[@id='CMaddnew']");
	
	public WebElement clickCreditMemoTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, creditMemo, 60);
	}
	public WebElement clickAddNewButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, addNew, 60);
	}
	By reason = By.xpath("//select[contains(@id,'ddlCMReason')]");
	By requestedAmount = By.xpath("//input[contains(@id,'txtCMAmount')]");
	By receivedAmount = By.xpath("//input[contains(@id,'txtCMRAmount')]");
	By restockingAmount = By.xpath("//input[contains(@id,'txtCMSAmount')]");
	By restockingReceivedAmount = By.xpath("//input[contains(@id,'txtCMRSAmount')]");
	By totalRequested = By.xpath("//input[contains(@id,'txtCMTotal')]");
	By totalReceived = By.xpath("//input[contains(@id,'txtCMRTotal')]");
	By creditMemoNum = By.xpath("//input[contains(@id,'txtCMCCMemo')]");
	By returnTracking = By.xpath("//input[contains(@id,'txtReturnNo')]");
	By returnDate = By.xpath("//input[contains(@id,'txtReturnDate')]");
	By vendorComment = By.xpath("//textarea[contains(@id,'txtCMComment')]");
	By oiNotes = By.xpath("//textarea[contains(@id,'txtOperationsInternalNotes')]");
	By ciNotes = By.xpath("//textarea[contains(@id,'txtIntNote')]");
	By saveButton = By.xpath("//a[contains(@id,'LbnCMsave')]");
	By status = By.xpath("//select[contains(@id,'ddlCMStatus')]");
	
	public WebElement selectReason(){
		return WaitTool.waitForElementPresentAndDisplay(driver, reason, 60);
	}
	public WebElement setRequestedAmount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, requestedAmount, 60);
	}
	public WebElement setReceivedAmount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, receivedAmount, 60);
	}
	public WebElement setRestockingAmount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, restockingAmount, 60);
	}
	public WebElement setRestockingReceivedAmount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, restockingReceivedAmount, 60);
	}
	public WebElement setTotalRequested(){
		return WaitTool.waitForElementPresentAndDisplay(driver, totalRequested, 60);
	}
	public WebElement setTotalReceived(){
		return WaitTool.waitForElementPresentAndDisplay(driver, totalReceived, 60);
	}
	public WebElement selectStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, status, 60);
	}
	public WebElement setCreditMemoNum(){
		return WaitTool.waitForElementPresentAndDisplay(driver, creditMemoNum, 60);
	}
	public WebElement setReturnTracking(){
		return WaitTool.waitForElementPresentAndDisplay(driver, returnTracking, 60);
	}
	public WebElement setReturnDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, returnDate, 60);
	}
	public WebElement setVendorComment(){
		return WaitTool.waitForElementPresentAndDisplay(driver, vendorComment, 60);
	}
	public WebElement setOINotes(){
		return WaitTool.waitForElementPresentAndDisplay(driver, oiNotes, 60);
	}
	public WebElement setCINotes(){
		return WaitTool.waitForElementPresentAndDisplay(driver, ciNotes, 60);
	}
	public WebElement clickSaveButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, saveButton, 60);
	}
	
	public WebElement getTableData(int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'tabCreditMemo_GvCreditMemo')]//tr[2]//td["+colNum+"]"), 60);
	}
	
	By vendorResponse = By.xpath("//textarea[contains(@id,'txtCMNote')]");
	public WebElement setVendorResponse(){
		return WaitTool.waitForElementPresentAndDisplay(driver, vendorResponse, 60);
	}
	
}
