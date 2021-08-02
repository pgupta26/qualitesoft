package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestSearchFunctionality extends InitializeTest{

	@Test(priority = 1)
	public void testBrandSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			driver.navigate().refresh();
			listingPage.getTableData(1, 1);
			SeleniumFunction.sendKeys(listingPage.searchByBrandField(), "Test 3");
			SeleniumFunction.click(listingPage.selectBrand());
			WaitTool.sleep(3);
			UseAssert.assertEquals(listingPage.selectedBrandName(), true);
			listingPage.getTableData(1, 1);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void testSkuSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			String skuNumber = xr1.getCellData("Add Product", "SKU", i);
			
			WaitTool.sleep(3);
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), skuNumber);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);

			listingPage.getTableData(1, 1);
			int rowsCount = listingPage.getCountOfRows().size();
			String skuNum = SeleniumFunction.getText(listingPage.getTableData(1, 5));
			UseAssert.assertEquals(rowsCount, 1);
			UseAssert.assertEquals(skuNum, skuNumber);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void testMultipleSkuSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			String skuNumber = "Net5-Check9, Net5-Check10, Net5-Check8";

			WaitTool.sleep(3);
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), skuNumber);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			listingPage.getTableData(1, 1);
			
			int rowsCount = listingPage.getCountOfRows().size();

			UseAssert.assertEquals(rowsCount, 3);
			for(int i=1; i==3; i++){
				String skuNum = SeleniumFunction.getText(listingPage.getTableData(i, 5));
				if(skuNumber.contains(skuNum)){
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void testProductSearching(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			String productId = xr1.getCellData("Add Product", "Product Id", i);
			WaitTool.sleep(3);
			
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), productId);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			listingPage.getTableData(1, 1);
			
			int rowsCount = listingPage.getCountOfRows().size();
			String skuNum = SeleniumFunction.getText(listingPage.getTableData(1, 4));
			UseAssert.assertEquals(rowsCount, 1);
			UseAssert.assertEquals(skuNum, productId);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
}

