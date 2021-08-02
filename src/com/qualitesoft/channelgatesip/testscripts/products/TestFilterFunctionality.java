package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestFilterFunctionality extends InitializeTest{

	@Test
	public void testFilterOnListingPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			driver.navigate().refresh();
			WaitTool.sleep(10);
			listingPage.getTableData(1, 1);
			SeleniumFunction.click(listingPage.filterBtn());
			SeleniumFunction.selectByVisibleText(listingPage.filterOptions(), "Category");
			SeleniumFunction.selectByVisibleText(listingPage.filterOptionValues(), xr1.getCellData("Add Product", "Category", i));
			SeleniumFunction.click(listingPage.applyFilterBtn());
			WaitTool.sleep(10);
			String filterName = SeleniumFunction.getText(listingPage.applyFilterLabel(1));
			UseAssert.assertEquals(filterName, "Category is " + xr1.getCellData("Add Product", "Category", i) + "\n×");
			listingPage.lastPageBtn();
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
}
