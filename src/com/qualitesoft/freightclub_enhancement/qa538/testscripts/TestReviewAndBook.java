package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub_enhancement.qa538.testPages.ShipmentReviewOrderPage;

public class TestReviewAndBook extends InitializeTest {

	@Test
	public void testReviewAndBook() {
		try{

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
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
			SeleniumFunction.click(reviewOrder.book());
			WaitTool.sleep(15);
			
			quickQuote.Okbutton();
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.sleep(20);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
