package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.testdata.ProductData;
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
			ProductData data = new ProductData();
			CommonPage commonPage = new CommonPage(driver);
			
			Xls_Reader xr1=new Xls_Reader("testdata/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			
			SeleniumFunction.click(commonPage.clickLeftMenuOption("Listing"));
			
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), data.getSku());
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			
			listingPage.getTableData(1, 1);
			
			String productTitle = SeleniumFunction.getText(listingPage.getProductTitle());
			String productId = SeleniumFunction.getText(listingPage.getProductIdAndChannel(3));
			String sku = SeleniumFunction.getText(listingPage.getProductSku());
			String availableQuantity = SeleniumFunction.getText(listingPage.getProductQtyPriceAndDates(6));
			String price = SeleniumFunction.getText(listingPage.getProductQtyPriceAndDates(7));
			String channel = SeleniumFunction.getText(listingPage.getProductIdAndChannel(5));
			String active = SeleniumFunction.getAttribute(listingPage.getProductActiveIcon(), "class");
			String createdDate = SeleniumFunction.getText(listingPage.getProductQtyPriceAndDates(10));
			String contentScore = SeleniumFunction.getText(listingPage.getProductQtyPriceAndDates(12));
			
			xr1.setCellData("Add Product", "Product Id", i, productId);
			xr1.setCellData("Add Product", "Content Score", i, contentScore);
			
			UseAssert.assertEquals(productTitle, data.getProductTitle());
			UseAssert.assertEquals(sku, data.getSku());
			UseAssert.assertEquals(availableQuantity, data.getAvailableQuantity());
			UseAssert.assertEquals(price, baseRateRow); //baseRateRow  "$729.33"
			UseAssert.assertEquals(channel, "0");
			UseAssert.assertEquals(active, "pi pi-times text-warning");
			UseAssert.assertEquals(createdDate, JavaFunction.currentPSTDate("MMM dd, yyyy"));
			
		}catch(Exception e){
			Log.info(e.getMessage());
		}
	}
}
