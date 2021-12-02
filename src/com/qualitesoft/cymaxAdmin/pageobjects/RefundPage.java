package com.qualitesoft.cymaxAdmin.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class RefundPage {

	WebDriver driver;
	
	public RefundPage(WebDriver driver){
		this.driver = driver;
	}
	
	By refundTab = By.xpath("//span[contains(@id,'tcOrder_tabRefund_tab')]");
	
	By refundReason = By.xpath("//select[contains(@id,'cbRefundReason')]");
	By category = By.xpath("(//select[contains(@id,'cbSubCategory')])[2]");
	By subCategory = By.xpath("//select[contains(@id,'cbThirdSubCategory')]");
	
	By checkbox = By.xpath("(//table[contains(@id,'tabRefund_gvRefundItems')]//input[contains(@id,'chkSelect')])[1]");
	By balanceSuggested = By.xpath("(//table[contains(@id,'tabRefund_gvRefundItems')]//input[contains(@id,'txtSuggested')])[1]");
	By comment = By.xpath("//input[contains(@id,'txtCommentRefund')][1]");
	By submitButton = By.xpath("//input[contains(@id,'btnSendToApprove')]");
	By recoveryWarning = By.xpath("(//div[contains(@id,'pnlRecoveryValidation')]//input[@type='submit'])[1]");
	
	
	public WebElement clickRefundTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, refundTab, 60);
	}
	public WebElement selectRefundReason(){
		return WaitTool.waitForElementPresentAndDisplay(driver, refundReason, 60);
	}
	public WebElement selectCategory(){
		return WaitTool.waitForElementPresentAndDisplay(driver, category, 60);
	}
	public WebElement selectSubcategory(){
		return WaitTool.waitForElementPresentAndDisplay(driver, subCategory, 60);
	}
	public WebElement clickCheckbox(){
		return WaitTool.waitForElementPresentAndDisplay(driver, checkbox, 60);
	}
	public WebElement setBalanceSuggested(){
		return WaitTool.waitForElementPresentAndDisplay(driver, balanceSuggested, 60);
	}
	public WebElement setComment(){
		return WaitTool.waitForElementPresentAndDisplay(driver, comment, 60);
	}
	public WebElement clickSubmitButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, submitButton, 60);
	}
	public WebElement acceptRecoveryWarning(){
		return WaitTool.waitForElementPresentAndDisplay(driver, recoveryWarning, 60);
	}
	
	public WebElement getTableData(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@id,'_tabRefund_gvRefundHead')]/tbody/tr["+index+"]//td"), 60);
	}
	
	//*************************Table locators/************
	public List<WebElement> getCountOfRows(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//table[@class='Grid tableFullWidth']//following-sibling::tr//td[10]"), 60);
	}
	public WebElement getCellData(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@class='Grid tableFullWidth']//following-sibling::tr["+rowNum+"]//td["+colNum+"]"), 60);
	}
	public WebElement checkbox(int rowNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@class='Grid tableFullWidth']//following-sibling::tr["+rowNum+"]//td[1]//input"), 60);
	}
	
	By refundModalHeader = By.xpath("//h4[@id='refundModalLabel']");
	By refundReasonId = By.xpath("//select[@id='ddlRefundReason']");
	By refundCategory = By.xpath("//select[@id='ddlRefundCat']");
	By refundSubCategory = By.xpath("//select[@id='ddlRefundSubCat']");
	By saveChanges = By.xpath("//button[@id='refundFormSubmitBtn']");
	
	public WebElement clickEditIcon(int rowNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[@class='Grid tableFullWidth']//following-sibling::tr["+rowNum+"]//td[3]//a"), 60);
	}
	public WebElement updateSelectRefundReason(){
		return WaitTool.waitForElementPresentAndDisplay(driver, refundReasonId, 60);
	}
	public WebElement updateSelectCategory(){
		return WaitTool.waitForElementPresentAndDisplay(driver, refundCategory, 60);
	}
	public WebElement updateSelectSubcategory(){
		return WaitTool.waitForElementPresentAndDisplay(driver, refundSubCategory, 60);
	}
	public WebElement clickSaveChanges(){
		return WaitTool.waitForElementPresentAndDisplay(driver, saveChanges, 60);
	}
}
