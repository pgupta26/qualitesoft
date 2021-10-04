package com.qualitesoft.freightclub.testscripts.manageproducts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManageProducts;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestUserIsAbleToCreatePalletizedSkuWithMultipleCarton extends InitializeTest {

	@Test
	public void testUserIsAbleToCreatePalletizedSkuWithMultipleCarton() {
		
		ManageProducts manageProducts = new ManageProducts(driver);
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/ManageProducts.xlsx");
		
		SeleniumFunction.clickJS(driver, manageProducts.manageProductLink());
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		
		commonOps.addProductDetail(xr, 5);
		commonOps.addProductCarton(xr, 5, 1);
		SeleniumFunction.click(quickQuote.addadditionalItem());
		commonOps.addProductCarton(xr, 6, 2);
		SeleniumFunction.click(quickQuote.addadditionalItem());
		commonOps.addProductCarton(xr, 7, 3);
		
		SeleniumFunction.click(manageProducts.saveproduct());
		
		//set product name in excel
		xr.setCellData("Input","ProductName", 5, InitializeTest.Productname);
		WaitTool.sleep(5);

	}
}
