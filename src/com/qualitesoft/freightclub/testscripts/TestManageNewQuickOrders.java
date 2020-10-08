package com.qualitesoft.freightclub.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestManageNewQuickOrders extends InitializeTest{
	
	private String refid = "678987";
	
	@Test
	public void testManageNewQuickOrders(){
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.manageOrdersLink();
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		SeleniumFunction.clickJS(driver, landingPage.quickOrderButton());
		ScreenShot.takeScreenShot(driver, "NewQuickOrderPage");
		
		landingPage.newQuickOrderButton();
		SeleniumFunction.clickJS(driver, landingPage.newQuickOrderButton());
		landingPage.quickQuoteRefIdTextfield();
		ScreenShot.takeScreenShot(driver, "NewQuickOrderDetailsPage1");
		SeleniumFunction.sendKeys(landingPage.quickQuoteRefIdTextfield(), refid);
		SeleniumFunction.sendKeys(landingPage.quickQuoteZipcodeTextfield(), "90210");
		SeleniumFunction.sendKeys(landingPage.dropOffZipCode(), "90210");
		SeleniumFunction.sendKeys(landingPage.costOfShipmentTextfield(), "50");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddPalletButton());
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletQuantityTextfield(), "25");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWeightTextfield(), "25");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletLengthTextfield(), "5");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWidthTextfield(), "5");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletHeightTextfield(), "5");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddPalleteNextButton());
		landingPage.quickQuoteAcceptAndContinueButton();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Accept&ContinuePopup");
		WaitTool.sleep(12);
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAcceptAndContinueButton());
		
		landingPage.quickQuoteFirstNameDropTextfield();
		ScreenShot.takeScreenShot(driver, "NewQuickOrderDetailsPage2");
		SeleniumFunction.sendKeys(landingPage.quickQuoteFirstNameTextfield(), "Pickup_First");
		SeleniumFunction.sendKeys(landingPage.quickQuoteLastNameTextfield(), "Pickup_Last");
		SeleniumFunction.sendKeys(landingPage.quickQuoteStreetAddressTextfield(), "Pickup_Address");
		SeleniumFunction.sendKeys(landingPage.quickQuotePhonenoTextfield(), "9632587416");
		SeleniumFunction.sendKeys(landingPage.quickQuoteemailTextfield(), "selenium@email.com");
		SeleniumFunction.sendKeys(landingPage.quickQuoteFirstNameDropTextfield(), "Drop_First");
		SeleniumFunction.sendKeys(landingPage.quickQuoteLastNameDropTextfield(), "Drop_Last");
		SeleniumFunction.sendKeys(landingPage.quickQuoteaddressDropTextfield(), "Drop_Address");
		SeleniumFunction.sendKeys(landingPage.quickQuotePhonenoDropTextfield(), "9632587416");		
		SeleniumFunction.sendKeys(landingPage.quickQuoteemailDropTextfield(), "selenium@email.com");
		ScreenShot.takeScreenShot(driver, "NewQuickOrderDetailsPageFilled");
		SeleniumFunction.clickJS(driver, landingPage.quickQuotesNextButton());
		
		landingPage.quickQuoteAddPalletButton();
		ScreenShot.takeScreenShot(driver, "AddPalletePage");
//		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddPalletButton());
//		SeleniumFunction.sendKeys(landingPage.quickQuotePalletQuantityTextfield(), "25");
//		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWeightTextfield(), "25");
//		SeleniumFunction.sendKeys(landingPage.quickQuotePalletLengthTextfield(), "5");
//		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWidthTextfield(), "5");
//		SeleniumFunction.sendKeys(landingPage.quickQuotePalletHeightTextfield(), "5");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddNewSKUButton());
		SeleniumFunction.sendKeys(landingPage.quickQuoteQuantitySKUTextfield(), "20");
		SeleniumFunction.sendKeys(landingPage.quickQuoteCostSKUTextfield(), "20");		
		SeleniumFunction.sendKeys(landingPage.quickQuoteQuantityCartonSKUTextfield(), "20");
		SeleniumFunction.sendKeys(landingPage.quickQuoteWeightCartonSKUTextfield(), "6");
		SeleniumFunction.sendKeys(landingPage.quickQuoteLengthCartonSKUTextfield(), "6");
		SeleniumFunction.sendKeys(landingPage.quickQuoteWidthCartonSKUTextfield(), "6");
		SeleniumFunction.sendKeys(landingPage.quickQuoteHeightCartonSKUTextfield(), "6");
		ScreenShot.takeScreenShot(driver, "AddPalletePageFilled");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddPalleteNextButton());
		landingPage.quickQuoteAcceptAndContinueButton();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Accept&ContinuePopup");
		WaitTool.sleep(8);
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAcceptAndContinueButton());
		
		WaitTool.sleep(4);
		
		landingPage.quickQuoteBookOrderButton();
		ScreenShot.takeScreenShot(driver, "BookingDetailsPage");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteBookOrderButton());
		
		if(SeleniumFunction.getText(landingPage.fullOrderRefno()).equalsIgnoreCase(refid)){
			Log.info("Ref id found and matched on full order page.");
		}else{
			Log.error("Ref id not found and matched on full order page.");
			Assert.fail();
		}
		ScreenShot.takeScreenShot(driver, "FullOrdersPage");
		
		
	}
}
