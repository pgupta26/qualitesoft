package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestVerifyCarriers extends InitializeTest {
	
	@Test
	public void testVerifyCarrier() {

		QuickQuote quickQuote = new QuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("return document.readyState").toString().equals("complete");
		WaitTool.sleep(20);
		jse.executeScript("window.scrollBy(0,3000)", "");
		quickQuote.expandCarries();
		WaitTool.sleep(2);
		
		String[] carrierNames= carrierName.split(",");
		
		for(int carrierNamesIndex=0; carrierNamesIndex < carrierNames.length; carrierNamesIndex++)
					Assert.assertTrue(quickQuote.verifyCarrier(carrierNames[carrierNamesIndex]));
		ScreenShot.takeFullScreenShot("Carrier successfully verified.");
		SeleniumFunction.clickJS(driver, quickQuote.NextButton());
	}
}
