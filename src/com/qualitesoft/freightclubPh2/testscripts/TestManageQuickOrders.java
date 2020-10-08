package com.qualitesoft.freightclubPh2.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestManageQuickOrders extends InitializeTest{
	
	@Test
	public void testManageQuickOrders(){
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.manageOrdersLink();
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		SeleniumFunction.clickJS(driver, landingPage.quickOrderButton());
		ScreenShot.takeScreenShot(driver, "QuickOrderPage");
		landingPage.uploadFileQuickOrderChrome();
		SeleniumFunction.clickAction(driver, landingPage.uploadButton());
		landingPage.OKButton();
		landingPage.sucessMsgManageProducts();
		SeleniumFunction.clickJS(driver, landingPage.OKButton());
		ScreenShot.takeScreenShot(driver, "ManageQuickOrdersUploaded");
		SeleniumFunction.clickJS(driver, landingPage.bookQuickOrdersButton());
		
		landingPage.quickQuoteFirstNameTextfield();
		ScreenShot.takeScreenShot(driver, "QuickOrderDetailsPage");
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
		ScreenShot.takeScreenShot(driver, "QuickOrderDetailsPageFilled");
		SeleniumFunction.clickJS(driver, landingPage.quickQuotesNextButton());
		
		landingPage.quickQuoteAddPalletButton();
		ScreenShot.takeScreenShot(driver, "AddPalletePage");
		//SeleniumFunction.clickJS(driver, landingPage.quickQuoteAddPalletButton());
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletQuantityTextfield(), "25");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWeightTextfield(), "25");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletLengthTextfield(), "5");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletWidthTextfield(), "5");
		SeleniumFunction.sendKeys(landingPage.quickQuotePalletHeightTextfield(), "5");
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
		WaitTool.sleep(2);
		landingPage.quickQuoteAcceptAndContinueButton();
		ScreenShot.takeScreenShot(driver, "Accept&ContinuePopup");
		WaitTool.sleep(18);
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteAcceptAndContinueButton());
		
		landingPage.quickQuoteBookOrderButton();
		ScreenShot.takeScreenShot(driver, "BookingDetailsPage");
		SeleniumFunction.clickJS(driver, landingPage.quickQuoteBookOrderButton());
		
		landingPage.uploadButton();
		ScreenShot.takeScreenShot(driver, "FullOrdersPage");
	}

}
