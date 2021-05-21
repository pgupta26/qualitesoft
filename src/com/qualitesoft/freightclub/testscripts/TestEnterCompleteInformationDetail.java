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
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEnterCompleteInformationDetail extends InitializeTest {
	
	@Test
	public void testEnterCompleteInformationDetail() {
		Xls_Reader xr;
		String testDatasheet= "binaries/FCfiles/FCFile.xlsx";
		xr=new Xls_Reader(testDatasheet);

		String description=xr.getCellData("ShipmentInformation","Description", 2).trim();
		String specialHandlingInstructions=xr.getCellData("ShipmentInformation","SpecialHandlingInstructions", 2).trim();
	
		QuickQuote quickQuote = new QuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//SeleniumFunction.sendKeys(quickQuote.PalletDesc(), description);
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
