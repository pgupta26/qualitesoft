package com.qualitesoft.freightclub.testscripts.managelocations;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToBookOrderWithAddedLocation extends InitializeTest {
	
	@Test
	public void testUserIsAbleToBookOrderWithAddedLocation () {
		
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		
		Xls_Reader xr=new Xls_Reader(testData);
		int i=Integer.parseInt(Row);
		String customerPO = xr.getCellData("Input","orderReferenceID", i).trim();
		String carrier = xr.getCellData("Input","Carrier", i).trim();
		String packageType = xr.getCellData("Input","packageType", i).trim();
		String packageType2 = xr.getCellData("Input", "packageType2", i).trim();	
		String palletType1 = xr.getCellData("Input", "PalletType1", i).trim();
		String palletType2 = xr.getCellData("Input", "PalletType2", i).trim();
		String shipmentType=xr.getCellData("Input","shipmentType", i).trim();

		//enter shipment information
		commonOps.shipmentInformation(xr,i);
		
		//add item package type information
		commonOps.itemInformation(xr, i, 1, packageType);
		
		//select carrier
		commonOps.selectCarrier();
		quickQuote.selectCarrier(carrier);
		
		//add pallet information
		commonOps.addPalletContents(xr, i, 1, palletType1);

		//enter shipment information
		commonOps.shipmentCompletion(xr, i);
		
		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		if(customerPO.length() <=25) {
			Assert.assertFalse(quickQuote.getCustomerPOValidationMsg().isDisplayed());
			UseAssert.assertEquals(quickQuote.customerPONumber().getText(), customerPO);
		} else {
			if(carrier.equals("FragilePAK")) {
				String expectedCustomerPOValidationMsg = "The carrier has identified that the length of this information is too long for them to input into their system. While we can shorten it to fit, we�d like your input as this information will end up on the carrier label and Bill of Lading.";
				String actualCustomerPOValidationMsg = quickQuote.getCustomerPOValidationMsg().getText().trim();
				Log.info("Customer PO Validation Message: "+actualCustomerPOValidationMsg);
				UseAssert.assertEquals(expectedCustomerPOValidationMsg, expectedCustomerPOValidationMsg);
				SeleniumFunction.click(quickQuote.acceptCustomerPOValidationPopup());
				UseAssert.assertEquals(quickQuote.customerPONumber().getText(), customerPO.substring(0, 25));
			} else {
				Assert.assertFalse(quickQuote.getCustomerPOValidationMsg().isDisplayed());
				UseAssert.assertEquals(quickQuote.customerPONumber().getText(), customerPO.substring(0, 50));
			}
		}
		
		//verify pallet details
		if (!packageType.isEmpty()) {
			if(shipmentType.equals("Parcel") && packageType.equals("SearchaddedProduct")) {
				commonOps.verifyPalletizedDetail(xr, i, "5", packageType);
			} else if(shipmentType.equals("Parcel") || packageType.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetail(xr, i, "4", packageType);
			} else {
				commonOps.verifyPalletizedDetail(xr, i, "3", packageType);
			}
			
		}
		if (!packageType2.isEmpty()) {
			if(shipmentType.equals("Parcel") || packageType2.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetail(xr, i, "4", packageType2);
			} else {
				commonOps.verifyPalletizedDetail(xr, i, "3", packageType2);
			}
		}
		commonOps.bookOrder(xr, i);	
		
	}

}
