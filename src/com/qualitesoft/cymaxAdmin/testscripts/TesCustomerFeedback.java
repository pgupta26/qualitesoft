package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.FeedbackPage;

public class TesCustomerFeedback extends InitializeTest{

	@Test
	public void addNewFeedback(){
		try{
			FeedbackPage feedback = new FeedbackPage(driver);
			
			SeleniumFunction.click(feedback.clickCustomerFeedbackTab());
			WaitTool.sleep(5);
			SeleniumFunction.selectByVisibleText(feedback.selectAssignTo(), "Samatha.B");
			SeleniumFunction.selectByvalue(feedback.selectFeedBackRating(), "2");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackType(), "A-Z Claim");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackVendor(), "Atlantic Furniture");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackChannel(), "Amazon");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackCarrier(), "ABF Freight");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackCause(), "Carrier error");
			WaitTool.sleep(7);
			SeleniumFunction.selectByVisibleText(feedback.selectFeedBackReason(), "Lost shipment");
			SeleniumFunction.sendKeys(feedback.setComment(), "Test Automation Comment");
			SeleniumFunction.sendKeys(feedback.setNotes(), "Test Automation Notes");
			SeleniumFunction.click(feedback.clickSaveBtn());
			WaitTool.sleep(20);
			driver.switchTo().alert().accept();
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "addNewFeedback")
	public void verifyAddedFeedbackDetails(){
		try{
			FeedbackPage feedback = new FeedbackPage(driver);
			int paginationSize = feedback.getPaginationRows().size();
			Log.info("Pagination count is " + paginationSize);
			if(paginationSize >= 2){
				SeleniumFunction.click(feedback.clickLastPaginationBtn(paginationSize));
			}
			xpathRow = SeleniumFunction.getText(feedback.getFeedbackId());
			String type = SeleniumFunction.getText(feedback.getSelectedType(xpathRow));
			String status = SeleniumFunction.getText(feedback.getStatus(xpathRow));
			
			UseAssert.assertEquals(type, "A-Z Claim");
			UseAssert.assertEquals(status, "New");
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "verifyAddedFeedbackDetails")
	public void updateFeedbackDetails(){
		try{
			FeedbackPage feedback = new FeedbackPage(driver);
			
			SeleniumFunction.click(feedback.clickSelectAction(xpathRow));
			SeleniumFunction.selectByVisibleText(feedback.selectStatusOption(), "In Progress");
			
			SeleniumFunction.selectByVisibleText(feedback.selectAssignTo(), "Samta.K");
			SeleniumFunction.selectByvalue(feedback.selectFeedBackRating(), "3");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackType(), "Negative Feedback");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackVendor(), "American Mattress");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackChannel(), "Ebay");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackCarrier(), "Ceva");
			SeleniumFunction.selectByVisibleText(feedback.selectFeedbackCause(), "Vendor error");
			WaitTool.sleep(7);
			SeleniumFunction.selectByVisibleText(feedback.selectFeedBackReason(), "Original item never shipped");
			
			SeleniumFunction.sendKeys(feedback.setReceivedDate(), "11-Nov-2022");
			SeleniumFunction.sendKeys(feedback.setDueDate(), "08-Nov-2022");
			SeleniumFunction.sendKeys(feedback.setFollowupDate(), "09-Nov-2022");
			SeleniumFunction.selectByVisibleText(feedback.selectRemovedStatusOption(), "Yes");
			SeleniumFunction.selectByVisibleText(feedback.selectRemovedTypeOption(), "Agent");
			SeleniumFunction.sendKeys(feedback.setRemovedDate(), "18-Nov-2022");
			
			/*SeleniumFunction.sendKeys(feedback.setComment(), "Test Updated Automation Comment");
			SeleniumFunction.sendKeys(feedback.setNotes(), "Test Updated Automation Notes");*/
			SeleniumFunction.click(feedback.clickSaveBtn());
			WaitTool.sleep(20);
			driver.switchTo().alert().accept();
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "updateFeedbackDetails")
	public void verifyUpdatedFeedbackDetails(){
		try{
			FeedbackPage feedback = new FeedbackPage(driver);
			
			String date = SeleniumFunction.getText(feedback.getDateReceived(xpathRow));
			String type = SeleniumFunction.getText(feedback.getSelectedType(xpathRow));
			String status = SeleniumFunction.getText(feedback.getStatus(xpathRow));
			
			String followupDate = SeleniumFunction.getText(feedback.getFollowUpDate(xpathRow));
			String dateRemoved = SeleniumFunction.getText(feedback.getDateRemoved(xpathRow));
			String removed = SeleniumFunction.getText(feedback.getRemovedStatus(xpathRow));
			
			UseAssert.assertEquals(date, "11 Nov 2022");
			UseAssert.assertEquals(type, "Negative Feedback");
			UseAssert.assertEquals(status, "In Progress");
			UseAssert.assertEquals(followupDate, "09 Nov 2022");
			UseAssert.assertEquals(dateRemoved, "18 Nov 2022");
			UseAssert.assertEquals(removed, "YES");
		}catch(Exception e){
			Assert.fail();
		}
	}
}
