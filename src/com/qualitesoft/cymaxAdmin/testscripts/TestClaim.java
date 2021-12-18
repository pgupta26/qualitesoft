package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.ClaimPage;

public class TestClaim extends InitializeTest{

	@Test
	public void aCreateNewClaim(){
		ClaimPage claimpage = new ClaimPage(driver);
		
		SeleniumFunction.click(claimpage.clickClaimsTab());
		WaitTool.sleep(10);
		SeleniumFunction.click(claimpage.clickNewClaims());
		WaitTool.sleep(15);
		SeleniumFunction.click(claimpage.clickCheckbox());
		WaitTool.sleep(10);
		SeleniumFunction.selectByvalue(claimpage.selectType(), "Damages");
		SeleniumFunction.selectByvalue(claimpage.selectCarrier(), "ABF Freight");
		
		carrierDetailsOptions = SeleniumFunction.getAttribute(claimpage.selectVendor(), "value");
		shipping = SeleniumFunction.getAttribute(claimpage.getTrackingNum(), "value");
		
		Log.info("Tracking Number is " + shipping);
		SeleniumFunction.sendKeys(claimpage.setProductClaimed(), "10");
		SeleniumFunction.sendKeys(claimpage.setFreight(), "10");
		SeleniumFunction.selectByVisibleText(claimpage.selectAssignTo(), "banita.verma");
		
		SeleniumFunction.sendKeys(claimpage.setClaimDueDate(), "2022/11/01");
		SeleniumFunction.sendKeys(claimpage.setFollowUpDate(), "2022/11/01");
		SeleniumFunction.sendKeys(claimpage.setFieldDate(), "2022/11/01");
		SeleniumFunction.sendKeys(claimpage.setResponseDate(), "2022/11/01");
		
		SeleniumFunction.selectByvalue(claimpage.selectPakageDamage(), "Y");
		SeleniumFunction.selectByvalue(claimpage.selectProductImage(), "Y");
		SeleniumFunction.sendKeys(claimpage.setClaimPickup(), "2022/11/01");
		SeleniumFunction.sendKeys(claimpage.setNotes(), "Test New Notes");
		
		SeleniumFunction.selectByvalue(claimpage.selectPod(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectPictures(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectInvoice(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectClaimForm(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectConcealed(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectResolved(), "N");
		SeleniumFunction.selectByvalue(claimpage.selectReadyToFile(), "Y");
		
		SeleniumFunction.selectByvalue(claimpage.selectResponce(), "Paid - Adjusted Amount");
		SeleniumFunction.sendKeys(claimpage.setCreditRefNum(), "0");
		SeleniumFunction.sendKeys(claimpage.setAmountReceived(), "0");
		SeleniumFunction.sendKeys(claimpage.setProductReceived(), "0");
		SeleniumFunction.sendKeys(claimpage.setNotes2(), "Test notes 2");
		ScreenShot.takeFullScreenShot("Add Claims page");
		this.clickSaveBtnAndAcceptAlert();
	}
	
	@Test
	public void bVerifyAddedClaim(){
		this.verifyAddedClaimDetailsOnListing(shipping, "N", "Damages", "ABF Freight","New");
	}
	
	@Test
	public void cUpdateAddedClain(){
		ClaimPage claimpage = new ClaimPage(driver);
		int totalRows = claimpage.getRowsNum().size();
		
		SeleniumFunction.click(claimpage.clickClaimId(totalRows));
		WaitTool.sleep(20);
		SeleniumFunction.selectByvalue(claimpage.selectStatus(), "Filed");
		SeleniumFunction.selectByvalue(claimpage.selectClaimForm(), "Y");
		SeleniumFunction.selectByvalue(claimpage.selectType(), "Defect Allowance");
		SeleniumFunction.selectByvalue(claimpage.selectCarrier(), "Ceva");
		ScreenShot.takeFullScreenShot("Edit Claims page");
		this.clickSaveBtnAndAcceptAlert();
		driver.navigate().refresh();
		WaitTool.sleep(10);
	}
	
	@Test
	public void dVerifyUpdatedClaim(){
		this.verifyAddedClaimDetailsOnListing(shipping, "Y", "Defect Allowance", "Ceva","Filed");
	}
	
	public void verifyAddedClaimDetailsOnListing(String ex_trackingnum, String exType, String extype, String company, String exstatus){
		ClaimPage claimpage = new ClaimPage(driver);
		
		int totalRows = claimpage.getRowsNum().size();
		String trackingNum = SeleniumFunction.getText(claimpage.getDataFromTable(totalRows, 3));
		String claimType = SeleniumFunction.getText(claimpage.getDataFromTable(totalRows, 4));
		String type = SeleniumFunction.getText(claimpage.getDataFromTable(totalRows, 6));
		String shippingCompany = SeleniumFunction.getText(claimpage.getDataFromTable(totalRows, 8));
		String status = SeleniumFunction.getText(claimpage.getDataFromTable(totalRows, 9));
		
		UseAssert.assertEquals(trackingNum, ex_trackingnum);
		UseAssert.assertEquals(claimType, exType);
		UseAssert.assertEquals(type, extype);
		UseAssert.assertEquals(shippingCompany, company);
		UseAssert.assertEquals(status, exstatus);
	}
	
	public void clickSaveBtnAndAcceptAlert(){
		ClaimPage claimpage = new ClaimPage(driver);
		
		SeleniumFunction.click(claimpage.clickCreateClaimBtn());
		WaitTool.sleep(20);
		SeleniumFunction.acceptAlert(driver, 20);
	}
}
