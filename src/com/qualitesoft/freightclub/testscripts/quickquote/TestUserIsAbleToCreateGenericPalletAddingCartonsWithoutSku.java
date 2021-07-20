package com.qualitesoft.freightclub.testscripts.quickquote;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToCreateGenericPalletAddingCartonsWithoutSku extends InitializeTest {
	
	@Test
	public void testUserIsAbleToCreateGenericPalletAddingCartonsWithoutSku() {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		
		Xls_Reader xr;
		xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int i=Integer.parseInt(Row);
		String carrier = xr.getCellData("Input","Carrier", i).trim();

		commonOps.shipmentInformation(xr,i);
		commonOps.itemInformation(xr, i, 1);
		commonOps.selectCarrier();
		quickQuote.selectCarrier(carrier);
		
		commonOps.addPalletContents(xr, i, 1);
		SeleniumFunction.click(quickQuote.addadditionalItem());
		commonOps.addPalletContents(xr, (i+1), 2);
		
		//verify total carton count
		String actualCartonCount = SeleniumFunction.getText(quickQuote.totalCartonCount());
		String expectedCartonCount = xr.getCellData("Input","NumberOfCartoons", 14).trim();
		Assert.assertEquals(actualCartonCount, expectedCartonCount);
		
		commonOps.shipmentCompletion(xr, i);
		
		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		commonOps.verifyPalletizedDetail(xr, 14, "3");
		commonOps.bookOrder(xr, i);
	}

}
