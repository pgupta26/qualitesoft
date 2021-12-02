package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.CreditMemoPage;

public class TestCreditMemo extends InitializeTest{

	@Test
	public void aAddNewCreditMemo(){
		try{
			CreditMemoPage creditPage = new CreditMemoPage(driver);
			
			SeleniumFunction.click(creditPage.clickCreditMemoTab());
			WaitTool.sleep(15);
			SeleniumFunction.click(creditPage.clickAddNewButton());
			WaitTool.sleep(10);
			SeleniumFunction.selectByvalue(creditPage.selectReason(), "Return - No longer needed ");
			WaitTool.sleep(5);
			SeleniumFunction.sendKeys(creditPage.setRequestedAmount(), "100");
			SeleniumFunction.sendKeys(creditPage.setReceivedAmount(), "110");
			SeleniumFunction.sendKeys(creditPage.setRestockingAmount(), "0");
			SeleniumFunction.sendKeys(creditPage.setRestockingReceivedAmount(), "0");
			
			SeleniumFunction.sendKeys(creditPage.setCreditMemoNum(), "123654789");
			SeleniumFunction.sendKeys(creditPage.setReturnTracking(), "785369857852");
			SeleniumFunction.sendKeys(creditPage.setReturnDate(), "11/2/2021");
			SeleniumFunction.sendKeys(creditPage.setVendorComment(), "Test Vendor's comment");
			SeleniumFunction.sendKeys(creditPage.setOINotes(), "Test Operations Internal Notes");
			SeleniumFunction.sendKeys(creditPage.setCINotes(), "Test Cymax Internal Note");
			SeleniumFunction.click(creditPage.clickSaveButton());
			WaitTool.sleep(5);
			driver.switchTo().alert().accept();
			WaitTool.sleep(20);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void bVerifyAddedCreditMemoDetails(){
		try{
			CreditMemoPage creditPage = new CreditMemoPage(driver);
			
			String selectedReason = SeleniumFunction.getText(creditPage.getTableData(4));
			String creditMemoNum = SeleniumFunction.getText(creditPage.getTableData(5));
			String selectedStatus = SeleniumFunction.getText(creditPage.getTableData(6));
			
			UseAssert.assertEquals(selectedReason, "Return - No longer needed");
			UseAssert.assertEquals(creditMemoNum, "123654789");
			UseAssert.assertEquals(selectedStatus, "New");
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void cUpdateAddedCreditMemo(){
		try{
			CreditMemoPage creditPage = new CreditMemoPage(driver);
			
			SeleniumFunction.click(creditPage.getTableData(2));
			WaitTool.sleep(10);
			
			SeleniumFunction.getAttribute(creditPage.setTotalRequested(), "value");
			SeleniumFunction.getAttribute(creditPage.setTotalReceived(), "value");
			
			SeleniumFunction.selectByvalue(creditPage.selectStatus(), "Released to portal");
			SeleniumFunction.sendKeys(creditPage.setReturnDate(), "11/2/2022");
			SeleniumFunction.click(creditPage.clickSaveButton());
			WaitTool.sleep(5);
			driver.switchTo().alert().accept();
			WaitTool.sleep(20);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void dVerifyUpdatedCreditMemoDetails(){
		try{
			CreditMemoPage creditPage = new CreditMemoPage(driver);
			
			String selectedReason = SeleniumFunction.getText(creditPage.getTableData(4));
			String creditMemoNum = SeleniumFunction.getText(creditPage.getTableData(5));
			String selectedStatus = SeleniumFunction.getText(creditPage.getTableData(6));
			
			UseAssert.assertEquals(selectedReason, "Return - No longer needed");
			UseAssert.assertEquals(creditMemoNum, "123654789");
			UseAssert.assertEquals(selectedStatus, "Released to portal");
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
