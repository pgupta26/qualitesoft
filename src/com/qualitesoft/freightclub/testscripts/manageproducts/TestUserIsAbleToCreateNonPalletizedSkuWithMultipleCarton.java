package com.qualitesoft.freightclub.testscripts.manageproducts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.ManageProducts;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToCreateNonPalletizedSkuWithMultipleCarton extends InitializeTest {
	
	@Test
	public void testUserIsAbleToCreateNonPalletizedSkuWithMultipleCarton() {
		
		ManageProducts manageProducts = new ManageProducts(driver);
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/ManageProducts.xlsx");
		int i=Integer.parseInt(Row);

		
		SeleniumFunction.clickJS(driver, manageProducts.manageProductLink());
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		
		commonOps.addProductDetail(xr, 2);
		commonOps.addProductCarton(xr, 2, 1);
		SeleniumFunction.click(quickQuote.addadditionalItem());
		commonOps.addProductCarton(xr, 3, 2);
		SeleniumFunction.click(quickQuote.addadditionalItem());
		commonOps.addProductCarton(xr, 4, 3);
		
		SeleniumFunction.click(manageProducts.saveproduct());
		
		//set product name in excel
		xr.setCellData("Input","ProductName", i,commonOps.Productname);
		WaitTool.sleep(5);

	}
}
