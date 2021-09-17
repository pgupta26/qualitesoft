package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestEnterCompleteInformationDetail extends InitializeTest {
	
	@Test
	public void testEnterCompleteInformationDetail() {
		Xls_Reader xr;
		String testDatasheet= "binaries/FCfiles/"+testData;
		xr=new Xls_Reader(testDatasheet);
		String specialHandlingInstructions=xr.getCellData("ShipmentInformation","SpecialHandlingInstructions", 2).trim();

		QuickQuote quickQuote = new QuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int i=Integer.parseInt(Row);
		String palletType1 = xr.getCellData("Input", "PalletType1", i).trim();

		if(testname.equals("Test Verify Request Cancellation Button - QA-537")) {
			SeleniumFunction.scrollDownByPixel(driver, "200");
			CommonOps commonOps = new CommonOps();
			commonOps.addPalletContents(xr, i, 1, palletType1); 
		}
		
		SeleniumFunction.moveToElement(driver, quickQuote.SpecialHandling());
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), specialHandlingInstructions);
		
		jse.executeScript("window.scrollBy(0,400)", "");
		WaitTool.sleep(15);
		
		if(quickQuote.LocationName().isDisplayed()) {
			quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com90001']"), 10));	
			quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com10011']"), 10));
		}
		
		jse.executeScript("window.scrollBy(0,350)", "");
		ScreenShot.takeScreenShot(driver, "Filled Shipment info");
		SeleniumFunction.click(quickQuote.ReviewOrder());
		
	}
}
