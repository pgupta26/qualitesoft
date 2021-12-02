package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.RefundPage;

public class TestRefund extends InitializeTest{

	@Test
	public void aSubmitRefund(){
		try{
			RefundPage refundpage = new RefundPage(driver);
			
			SeleniumFunction.click(refundpage.clickRefundTab());
			WaitTool.sleep(20);
			SeleniumFunction.selectByVisibleText(refundpage.selectRefundReason(), "Credit");
			WaitTool.sleep(20);
			SeleniumFunction.selectByVisibleText(refundpage.selectCategory(), "Carrier error");
			WaitTool.sleep(20);
			SeleniumFunction.selectByVisibleText(refundpage.selectSubcategory(), "Delivery issues");
			WaitTool.sleep(3);
			SeleniumFunction.click(refundpage.clickCheckbox());
			WaitTool.sleep(3);
			SeleniumFunction.sendKeys(refundpage.setBalanceSuggested(), "5");
			SeleniumFunction.sendKeys(refundpage.setComment(), "Test Refund Comment");
			SeleniumFunction.click(refundpage.clickSubmitButton());
			WaitTool.sleep(15);
			SeleniumFunction.scrollIntoView(driver, refundpage.acceptRecoveryWarning());
			SeleniumFunction.clickJS(driver, refundpage.acceptRecoveryWarning());
			WaitTool.sleep(15);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void bVerifyAddedDetailsOnTable(){
		try{
			this.verifyAmountAndCommentOnTable("Test Refund Comment", "$5", "Credit\nCarrier error\nDelivery issues");
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void cUpdateRefundDetails(){
		try{
			RefundPage refundpage = new RefundPage(driver);
			
			int totalRows = refundpage.getCountOfRows().size();
			SeleniumFunction.click(refundpage.checkbox(totalRows));
			WaitTool.sleep(15);
			SeleniumFunction.click(refundpage.clickCheckbox());
			WaitTool.sleep(20);
			SeleniumFunction.sendKeys(refundpage.setBalanceSuggested(), "7");
			SeleniumFunction.sendKeys(refundpage.setComment(), "Test Updated Refund Comment");
			SeleniumFunction.click(refundpage.clickSubmitButton());
			WaitTool.sleep(10);
			SeleniumFunction.scrollIntoView(driver, refundpage.acceptRecoveryWarning());
			SeleniumFunction.click(refundpage.acceptRecoveryWarning());
			
			WaitTool.sleep(15);
			SeleniumFunction.click(refundpage.clickEditIcon(totalRows));
			SeleniumFunction.selectByVisibleText(refundpage.updateSelectRefundReason(), "Credit");
			WaitTool.sleep(3);
			SeleniumFunction.selectByVisibleText(refundpage.updateSelectCategory(), "Cymax error");
			WaitTool.sleep(3);
			SeleniumFunction.selectByVisibleText(refundpage.updateSelectSubcategory(), "Listing error");
			
			SeleniumFunction.click(refundpage.clickSaveChanges());	
			WaitTool.sleep(5);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void dVerifyUpdatedDetailsOnTable(){
		try{
			RefundPage refundpage = new RefundPage(driver);
			
			SeleniumFunction.click(refundpage.clickRefundTab());
			WaitTool.sleep(20);
			this.verifyAmountAndCommentOnTable("Test Updated Refund Comment", "$7", "Credit\nCymax error\nListing error");
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void verifyAmountAndCommentOnTable(String ex_comment, String ex_amount, String ex_reason){
		RefundPage refundpage = new RefundPage(driver);
		WaitTool.sleep(5);
		int totalRows = refundpage.getCountOfRows().size();
		String comment = SeleniumFunction.getText(refundpage.getCellData(totalRows, 10));
		String amount = SeleniumFunction.getText(refundpage.getCellData(totalRows, 6));
		String reason = SeleniumFunction.getText(refundpage.getCellData(totalRows, 7));
		
		UseAssert.assertEquals(comment, ex_comment);
		UseAssert.assertEquals(amount, ex_amount);
		UseAssert.assertEquals(reason, ex_reason);
	}
}
