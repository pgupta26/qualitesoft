package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.testdata.ProductData;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestSearchFunctionality extends InitializeTest{

	@Test(priority = 1)
	public void testSkuSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			ProductData data = new ProductData();
			
			
			//String skuNumber = xr1.getCellData("Add Product", "SKU", i);
			
			WaitTool.sleep(3);
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), data.getSku());
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);

			listingPage.getTableData(1, 1);
			int rowsCount = listingPage.getCountOfRows().size();
			String sku = SeleniumFunction.getText(listingPage.getProductSku());
			
			UseAssert.assertEquals(rowsCount, 1);
			UseAssert.assertEquals(sku, data.getSku());
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void testMultipleSkuSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			/*String skuNumber = "Net5-Check9, Net5-Check10, Net5-Check8";*/

			WaitTool.sleep(3);
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), keyword);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			listingPage.getTableData(1, 1);
			
			int rowsCount = listingPage.getCountOfRows().size();

			UseAssert.assertEquals(rowsCount, 3);
			
			for(int i=1; i==3; i++){
				String skuNum = SeleniumFunction.getText(listingPage.getProductSkus(i));
				if(keyword.contains(skuNum)){
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void testProductSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			
			Xls_Reader xr1=new Xls_Reader("testdata/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			
			String productid = xr1.getCellData("Add Product", "Product Id", i);
			WaitTool.sleep(3);
			
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), productid);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			listingPage.getTableData(1, 1);
			
			int rowsCount = listingPage.getCountOfRows().size();
			String productId = SeleniumFunction.getText(listingPage.getProductIdAndChannel(3));
			UseAssert.assertEquals(rowsCount, 1);
			UseAssert.assertEquals(productId, productid);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
}

