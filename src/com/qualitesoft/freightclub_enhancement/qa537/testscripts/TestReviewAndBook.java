package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub_enhancement.qa537.testPages.ShipmentReviewOrderPage;

public class TestReviewAndBook extends InitializeTest {

	@Test
	public void testReviewAndBook() {
		try{
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			String COGS = xr.getCellData("Input","COGS", i).trim();
			String shipmentInformation = xr.getCellData("Input","DeliveryFrequency", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String customerPONumber=xr.getCellData("Input","orderReferenceID", i).trim();
			
			ShipmentReviewOrderPage reviewOrder = new ShipmentReviewOrderPage(driver);
			TestSubmitCustomQuote submitCustomQuote = new TestSubmitCustomQuote();
			
			Assert.assertEquals(SeleniumFunction.getText(reviewOrder.customerPONumber()), customerPONumber);
			float floatCogs = Float.parseFloat(COGS);
			float percentage = ((floatCogs * 6) / 100); 
			float quotedPrice = floatCogs + percentage;
			String quotePrice2 = "$"+quotedPrice;
			Assert.assertEquals(SeleniumFunction.getText(reviewOrder.totalAmount()).replaceAll(",", ""), quotePrice2);
			
			submitCustomQuote.verifyNonPalletizedDetail("4");
			submitCustomQuote.verifyPalletizedDetail("3");
			submitCustomQuote.verifyAddedProductDetail("5");
			
			Assert.assertEquals(reviewOrder.shipmentInformation().getAttribute("value"),shipmentInformation);
			Assert.assertEquals(reviewOrder.regulatoryDetails().getAttribute("value"), regulatoryDetails);
			ScreenShot.takeScreenShot(driver, "Review page");
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,500)");
			SeleniumFunction.click(reviewOrder.book());
			WaitTool.sleep(15);
			
			QuickQuote quickQuote = new QuickQuote(driver);
			quickQuote.Okbutton();
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.sleep(20);
		}catch(AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
