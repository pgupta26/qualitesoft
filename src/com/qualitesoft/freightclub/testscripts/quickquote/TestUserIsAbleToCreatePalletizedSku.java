package com.qualitesoft.freightclub.testscripts.quickquote;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToCreatePalletizedSku extends InitializeTest{

	@Test
	public void testUserIsAbleToCreatePalletizedSku() {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		Xls_Reader xr;
		int i;

		xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		i=Integer.parseInt(Row);

		commonOps.shipmentInformation(xr,i);
		commonOps.itemInformation(xr, i, 1);
		commonOps.selectCarrier();
		SeleniumFunction.clickJS(driver, quickQuote.NextButton());

		//verify total carton count
		String actualCartonCount = SeleniumFunction.getText(quickQuote.totalCartonCount());
		String expectedCartonCount = xr.getCellData("Input","NumberOfCartoons", i).trim();
		Assert.assertEquals(actualCartonCount, expectedCartonCount);

		commonOps.shipmentCompletion(xr, i);

		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		commonOps.verifyPalletizedDetail(xr, i, "1");
		commonOps.bookOrder(xr, i);
	}

}