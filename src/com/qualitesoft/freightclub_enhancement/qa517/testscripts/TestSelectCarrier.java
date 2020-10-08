package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestSelectCarrier extends InitializeTest {

	@Test
	public void testVerifySelectedCarriers() {

		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("return document.readyState").toString().equals("complete");
			WaitTool.sleep(20);
			//quickQuote.waitForQuotesToAppear();
			jse.executeScript("window.scrollBy(0,3000)", "");
			quickQuote.expandCarries();
			WaitTool.sleep(5);
			
			Assert.assertTrue(quickQuote.verifyCarrier(carrierName));
			ScreenShot.takeScreenShot(driver, carrierName+ "Succssfully verified");

			int i=Integer.parseInt(Row);
			if(i == 5 || i == 6 || i == 7 | i == 13) {
				System.out.println("Is Carrier Present: "+quickQuote.verifyBasicThreshold(carrierName));
				Assert.assertTrue(quickQuote.verifyBasicThreshold(carrierName));
				ScreenShot.takeScreenShot(driver, "Basic threshold pressent for "+carrierName);
			} else if(i == 2 || i == 3 || i == 4 |i == 12) {
				Assert.assertFalse(quickQuote.verifyBasicThreshold(carrierName));
				ScreenShot.takeScreenShot(driver, "Basic threshold not present for "+carrierName);

			} else {
				Log.info("Do nothing");
			}
			
			quickQuote.selectCarrier(carrierName);

		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testFCTestCarriersVisible() {

		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("return document.readyState").toString().equals("complete");
			WaitTool.sleep(20);
			jse.executeScript("window.scrollBy(0,3000)", "");
			quickQuote.expandCarries();
			WaitTool.sleep(2);
			
			Assert.assertTrue(quickQuote.verifyCarrier(carrierName));
			ScreenShot.takeFullScreenShot("FC Test Carrier Present");

		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testFCTestCarriersNotVisible() {

		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("return document.readyState").toString().equals("complete");
			WaitTool.sleep(20);
			jse.executeScript("window.scrollBy(0,3000)", "");
			quickQuote.expandCarries();
			WaitTool.sleep(2);
			
			Assert.assertFalse(quickQuote.verifyCarrier(carrierName));
			ScreenShot.takeFullScreenShot("FC Test Carrier not Present");
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
