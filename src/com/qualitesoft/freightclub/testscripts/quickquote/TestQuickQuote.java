package com.qualitesoft.freightclub.testscripts.quickquote;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestQuickQuote extends InitializeTest {
	
	@Test
	public void testQuickQuote() {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
		int i=Integer.parseInt(Row);
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
		if (!packageType2.isEmpty()) {
			SeleniumFunction.click(quickQuote.addadditionalItem());
			WaitTool.sleep(2);
			SeleniumFunction.scrollDownUptoFooter(driver);
			commonOps.itemInformation(xr, i, 2, packageType2);
		}
		
		//select carrier
		commonOps.selectCarrier();
		quickQuote.selectCarrier(carrier);
		
		//add pallet information
		if (!palletType1.isEmpty()) {
			commonOps.addPalletContents(xr, i, 1, palletType1);
		}
		
		if (!palletType2.isEmpty()) {
			WaitTool.sleep(2);
			if(!palletType2.equals("Generic Pallet")) {
				SeleniumFunction.scrollDownByPixel(driver, "150");
				SeleniumFunction.click(quickQuote.addadditionalItem());
			}
			if(palletType2.equals("New Product")) {
				SeleniumFunction.scrollDownByPixel(driver, "400");
				commonOps.addPalletContents(xr, i, 1, palletType2);
			} else {
				commonOps.addPalletContents(xr, i, 2, palletType2);
			}
		}

		//enter shipment information
		commonOps.shipmentCompletion(xr, i);
		
		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		
		//verify pallet details
		if (!packageType.isEmpty()) {
			if(shipmentType.equals("Parcel") || packageType.equals("Non-Palletized")) {
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
