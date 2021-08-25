package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestProductOnListingPage extends InitializeTest{

	@Test
	public void verifyAddedProductOnListing(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			String skuNumber = xr1.getCellData("Add Product", "SKU", i);
			
			SeleniumFunction.click(listingPage.listingBtn());
			driver.navigate().refresh();
			WaitTool.sleep(10);
			listingPage.getTableData(1, 1);
			
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), skuNumber);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			listingPage.getTableData(1, 1);
			
			String productTitle = SeleniumFunction.getText(listingPage.getTableData(1, 2));
			String productId = SeleniumFunction.getText(listingPage.getTableData(1, 4));
			String sku = SeleniumFunction.getText(listingPage.getTableData(1, 5));
			String availableQuantity = SeleniumFunction.getText(listingPage.getTableData(1, 6));
			String price = SeleniumFunction.getText(listingPage.getTableData(1, 8));
			String channel = SeleniumFunction.getText(listingPage.getTableData(1, 9));
			String active = SeleniumFunction.getText(listingPage.getTableData(1, 10));
			String createdDate = SeleniumFunction.getText(listingPage.getTableData(1, 11));
			xr1.setCellData("Add Product", "Product Id", i, productId);
			
			System.out.println(price);
			UseAssert.assertEquals(productTitle, xr1.getCellData("Add Product", "Product Title", i));
			UseAssert.assertEquals(sku, skuNumber);
			UseAssert.assertEquals(availableQuantity, xr1.getCellData("Add Product", "Available Quantity", i));
			UseAssert.assertEquals(price, baseRateRow); //baseRateRow  "$729.33"
			UseAssert.assertEquals(channel, "0");
			UseAssert.assertEquals(active, "clear");
			UseAssert.assertEquals(createdDate, JavaFunction.currentDateUSFormat());
			
		}catch(Exception e){
			Log.info(e.getMessage());
		}
	}
}
