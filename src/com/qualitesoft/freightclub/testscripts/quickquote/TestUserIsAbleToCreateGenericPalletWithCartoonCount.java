package com.qualitesoft.freightclub.testscripts.quickquote;

import org.testng.annotations.*;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToCreateGenericPalletWithCartoonCount extends InitializeTest {

	@Test
	public void testUserIsAbleToCreateGenericPalletWithCartoonCount() {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int i=Integer.parseInt(Row);
		
		commonOps.shipmentInformation(xr,i);
		commonOps.itemInformation(xr, i, 1);
		commonOps.selectCarrier();
		String carrier = xr.getCellData("Input","Carrier", i).trim();
		quickQuote.selectCarrier(carrier);

		commonOps.addPalletContents(xr, i, 1);
		commonOps.shipmentCompletion(xr, i);
		
		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		commonOps.verifyPalletizedDetail(xr, i, "3");
		commonOps.bookOrder(xr, i);
	}
}
