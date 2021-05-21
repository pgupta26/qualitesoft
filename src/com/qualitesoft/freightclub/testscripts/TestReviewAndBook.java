package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.ShipmentReviewOrderPage;
import com.qualitesoft.freightclub.testscripts.TestSubmitCustomQuote;

public class TestReviewAndBook  extends InitializeTest {
	
	@Test
	public void testReviewAndBookCustomOrder() {
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			String COGS = xr.getCellData("Input","COGS", i).trim();
			String shipmentInformation = xr.getCellData("Input","DeliveryFrequency", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String customerPONumber=xr.getCellData("Input","orderReferenceID", i).trim();
			
			ShipmentReviewOrderPage reviewOrder = new ShipmentReviewOrderPage(driver);
			TestSubmitCustomQuote submitCustomQuote = new TestSubmitCustomQuote();
			QuickQuote quickQuote = new QuickQuote(driver);

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
			SeleniumFunction.click(quickQuote.Book());
			WaitTool.sleep(15);
			
			SeleniumFunction.click(quickQuote.Okbutton1());
			WaitTool.sleep(20);
	}
	

	@Test
	public void testReviewAndBook() {
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: "+Row);

			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String packageType = xr.getCellData("Input", "packageType", i).trim();

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.scrollUpByPixel(driver, "2500");
			WaitTool.sleep(1);
			if(i == 5 || i == 6 || i == 7) {
				Assert.assertTrue(quickQuote.verifyBasicThresholdAtReview());
				ScreenShot.takeScreenShot(driver, "Basic threshold present at review page");
			} else if(i == 2 || i == 3 || i == 4) {
				Assert.assertFalse(quickQuote.verifyBasicThresholdAtReview());
				ScreenShot.takeScreenShot(driver, "Basic threshold not present at review page");
			}
			
			SeleniumFunction.scrollDownUptoFooter(driver);
			WaitTool.sleep(1);
			SeleniumFunction.click(quickQuote.Book());
			ScreenShot.takeScreenShot(driver, "Order Confirmation "+shipmentType+" "+packageType);
			SeleniumFunction.click(quickQuote.Okbutton1());
			String crorderId=WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60).getText();
			System.out.println("crorderId:" + crorderId.trim());
			
			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);
	}
	
	
	@Test
	public void testReviewAndBook2() {
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			String orderDetails=xr.getCellData("Input","OrderDetails", i).trim();
			String updatedOrderDetails=xr.getCellData("Input","updatedOrderDetails", i).trim();	
			String COGS = xr.getCellData("Input","COGS", i).trim();
			String handlingUnits = xr.getCellData("Input","HandlingUnits", i).trim();
			String totalWeight = xr.getCellData("Input","TotalWeight", i).trim();
			String declareValue=xr.getCellData("Input","DeclaredValue", i).trim();
			String updatedShipmentInformation = xr.getCellData("Input","updatedShipmentInformation", i).trim();
			String updatedRegulatoryDetails = xr.getCellData("Input","updatedRegulatoryDetails", i).trim();
			String customerPONumber=xr.getCellData("Input","orderReferenceID", i).trim();
			String updatedRequiredTemp=xr.getCellData("Input","UpdatedRequiredTmp", i).trim();

			
			float floatCogs = Float.parseFloat(COGS);
			float percentage = ((floatCogs * 6) / 100); 
			float quotedPrice = floatCogs + percentage;
			String quotePrice2 = "$"+quotedPrice;
			
			ShipmentReviewOrderPage reviewOrder = new ShipmentReviewOrderPage(driver);
			QuickQuote quickQuote = new QuickQuote(driver);

			//Verify details
			Assert.assertEquals(SeleniumFunction.getText(reviewOrder.customerPONumber()), customerPONumber);
			Assert.assertEquals(SeleniumFunction.getText(reviewOrder.totalAmount()).replaceAll(",", ""), quotePrice2);
			Assert.assertTrue(SeleniumFunction.getText(reviewOrder.totalWeight()).contains(totalWeight.substring(0, 1)));
			Assert.assertTrue(SeleniumFunction.getText(reviewOrder.declaredValue()).contains(declareValue.substring(0, 1)));
			Assert.assertEquals(SeleniumFunction.getText(reviewOrder.handlingUnits()).trim(), handlingUnits);
			Assert.assertEquals(reviewOrder.shipmentInformation().getAttribute("readonly"),"true");
			Assert.assertEquals(reviewOrder.shipmentInformation().getAttribute("value"),updatedShipmentInformation);
			Assert.assertEquals(reviewOrder.regulatoryDetails().getAttribute("readonly"),"true");
			Assert.assertEquals(reviewOrder.regulatoryDetails().getAttribute("value"), updatedRegulatoryDetails);
			Assert.assertEquals(quickQuote.customOrderDetails(orderDetails).getAttribute("disabled"), "true");
			Assert.assertEquals(quickQuote.customOrderDetails(updatedOrderDetails).getAttribute("disabled"), "true");
			if(orderDetails.equals("Requires refrigeration")) { 
		    	System.out.println("Attribute Value: "+quickQuote.requiredTemp().getAttribute("value"));
		    	Assert.assertEquals(quickQuote.requiredTemp().getAttribute("value"), updatedRequiredTemp);
				Assert.assertEquals(quickQuote.requiredTemp().getAttribute("readonly"),"true");
		    }
			
			ScreenShot.takeScreenShot(driver, "Review page");
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,500)");
		    SeleniumFunction.click(quickQuote.Book());
			WaitTool.sleep(15);
			
			SeleniumFunction.click(quickQuote.Okbutton1());
			WaitTool.sleep(20);
	}
}
