package com.qualitesoft.cymaxAdmin.pageobjects;

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
	By category = By.xpath("//select[contains(@id,'cbSubCategory')]");
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
}
