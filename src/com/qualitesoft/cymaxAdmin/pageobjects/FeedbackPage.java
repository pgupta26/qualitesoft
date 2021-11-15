package com.qualitesoft.cymaxAdmin.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class FeedbackPage {

	WebDriver driver;
	
	public FeedbackPage(WebDriver driver){
		this.driver = driver;
	}
	
	By customerFeedback = By.xpath("//span[contains(@id,'tabFeedBack_tab')]");
	By assignTo = By.xpath("//select[contains(@id,'ddlFeedBackAssignedTo')]");
	By feedBackRating = By.xpath("//select[contains(@id,'ddlFeedBackRating')]");
	By feedbackType = By.xpath("//select[contains(@id,'ddlFeedBackType')]");
	By feedbackVendor = By.xpath("//select[contains(@id,'ddlFeedBackVendor')]");
	By feedbackChannel = By.xpath("//select[contains(@id,'ddlFeedBackChannel')]");
	By feedbackCarrier = By.xpath("//select[contains(@id,'ddlFeedBackCarrier')]");
	By feedbackCause = By.xpath("//select[contains(@id,'ddlFeedbackCause')]");
	By feedBackReason = By.xpath("//select[contains(@id,'ddlFeedBackReason')]");
	By comment = By.xpath("//textarea[contains(@id,'txtFBBuyerComments')]");
	By notes = By.xpath("//textarea[contains(@id,'txtFBNotes')]");
	By saveBtn = By.xpath("//input[contains(@id,'btnSaveFeedBack')]");
	By clearBtn = By.xpath("//input[contains(@id,'fbTab_btnReset')]");
	
	public WebElement clickCustomerFeedbackTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, customerFeedback, 120);
	}
	public WebElement selectAssignTo(){
		return WaitTool.waitForElementPresentAndDisplay(driver, assignTo, 120);
	}
	public WebElement selectFeedBackRating(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedBackRating, 120);
	}
	public WebElement selectFeedbackType(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedbackType, 120);
	}
	public WebElement selectFeedbackVendor(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedbackVendor, 120);
	}
	public WebElement selectFeedbackChannel(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedbackChannel, 120);
	}
	public WebElement selectFeedbackCarrier(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedbackCarrier, 120);
	}
	public WebElement selectFeedbackCause(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedbackCause, 120);
	}
	public WebElement selectFeedBackReason(){
		return WaitTool.waitForElementPresentAndDisplay(driver, feedBackReason, 120);
	}
	public WebElement setComment(){
		return WaitTool.waitForElementPresentAndDisplay(driver, comment, 120);
	}
	public WebElement setNotes(){
		return WaitTool.waitForElementPresentAndDisplay(driver, notes, 120);
	}
	public WebElement clickSaveBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, saveBtn, 120);
	}
	public WebElement clickClearBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, clearBtn, 120);
	}

	public WebElement clickSelectAction(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[1]"), 120);
	}
	public WebElement getDateReceived(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[3]"), 120);
	}
	public WebElement getSelectedType(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[4]"), 120);
	}
	public WebElement getStatus(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[5]"), 120);
	}
	public WebElement getFollowUpDate(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[6]"), 120);
	}	
	public WebElement getDateRemoved(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[7]"), 120);
	}
	public WebElement getRemovedStatus(String id){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table[contains(@id,'gvCustFeedback')]//td[contains(text(),'"+id+"')]//parent::tr//td[8]"), 120);
	}	
	
	By selectStatus = By.xpath("//select[contains(@id,'ddlFeedBackStatus')]");
	By receivedDate = By.xpath("//input[contains(@id,'txtFBReceivedDate')]");
	By dueDate = By.xpath("//input[contains(@id,'txtFBDueDate')]");
	By setFollowUpDate = By.xpath("//input[contains(@id,'txtFBFollowUpDate')]");
	By removedDate = By.xpath("//input[contains(@id,'txtFBRemovedDate')]");
	By selectRemovedStatus = By.xpath("//select[contains(@id,'ddlFeedBackRemoved')]");
	By selectRemovedType = By.xpath("//select[contains(@id,'ddlFeedbackRemovalType')]");
	By a = By.xpath("");
	
	public WebElement selectStatusOption(){
		return WaitTool.waitForElementPresentAndDisplay(driver, selectStatus, 120);
	}
	public WebElement setReceivedDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, receivedDate, 120);
	}
	public WebElement setDueDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, dueDate, 120);
	}
	public WebElement setFollowupDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, setFollowUpDate, 120);
	}
	public WebElement setRemovedDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, removedDate, 120);
	}
	public WebElement selectRemovedStatusOption(){
		return WaitTool.waitForElementPresentAndDisplay(driver, selectRemovedStatus, 120);
	}
	public WebElement selectRemovedTypeOption(){
		return WaitTool.waitForElementPresentAndDisplay(driver, selectRemovedType, 120);
	}
	
	By getFeedbackId = By.xpath("//td[contains(text(),'A-Z Claim')]//parent::tr//td[2]");
	
	public WebElement getFeedbackId(){
		return WaitTool.waitForElementPresentAndDisplay(driver, getFeedbackId, 120);
	}
	
    By tableSize = By.xpath("(//table[contains(@id,'tabFeedBack_fbTab_gvCustFeedback')]//following::table)[1]//td");
	
	public List<WebElement> getPaginationRows(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, tableSize, 120);
	}
	
	public WebElement clickLastPaginationBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("((//table[contains(@id,'tabFeedBack_fbTab_gvCustFeedback')]//following::table)[1]//td)["+index+"]"), 120);
	}
	
}
