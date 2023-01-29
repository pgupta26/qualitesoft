package com.qualitesoft.channelgatesip.testscripts.products;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.testdata.ProductData;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestFilterFunctionality extends InitializeTest{

	@Test
	public void testFilterByBrandOnListingPage(){
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);

		SeleniumFunction.click(commonPage.clickLeftMenuOption("Product Management"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Products"));
		WaitTool.sleep(10);;

		int rowsBeforeFilter = this.getTotalRowsCount(driver);

		listingPage.getTableData(1, 1);
		SeleniumFunction.click(listingPage.filterBtn());


		SeleniumFunction.click(listingPage.clickBrandField());
		SeleniumFunction.click(listingPage.selectCheckbox("Test 3"));
		SeleniumFunction.click(listingPage.clickCloseMultiselectPopup());

		SeleniumFunction.click(listingPage.applyFilterBtn());
		WaitTool.sleep(10);

		int rowsAfterFilter = this.getTotalRowsCount(driver);		

		if(rowsAfterFilter < rowsBeforeFilter) {
			Assert.assertTrue(true);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(1)), "Brand is ( Test 3 )");

		}else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testFilterByStatusOnListingPage(){
		ProductListing listingPage = new ProductListing(driver);
		int rowsBeforeFilter = this.getTotalRowsCount(driver);

		SeleniumFunction.click(listingPage.filterBtn());


		SeleniumFunction.click(listingPage.clickDropdownField("Status"));
		SeleniumFunction.click(listingPage.selectDropdownValue("Active"));

		SeleniumFunction.click(listingPage.applyFilterBtn());
		WaitTool.sleep(10);

		int rowsAfterFilter = this.getTotalRowsCount(driver);		

		if(rowsAfterFilter < rowsBeforeFilter) {
			Assert.assertTrue(true);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(1)), "Brand is ( Test 3 )");
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Status is Active");

		}else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testFilterRemovedAfterAClickOnClearBtn() {
		ProductListing listingPage = new ProductListing(driver);
		int rowsAfterFilter = this.getTotalRowsCount(driver);
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(10);
	
		int rowsBeforeFilter = this.getTotalRowsCount(driver);	
		
		if(rowsAfterFilter < rowsBeforeFilter) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testMultipleFilter() {
		ProductListing listingPage = new ProductListing(driver);
		ProductData data = new ProductData();
		
		int rowsBeforeFilter = this.getTotalRowsCount(driver);

		SeleniumFunction.click(listingPage.filterBtn());

		SeleniumFunction.click(listingPage.clickCategoryField());
		SeleniumFunction.click(listingPage.selectCheckbox("Baby Changing Table Pads"));
		SeleniumFunction.click(listingPage.clickCloseMultiselectPopup());
		
		SeleniumFunction.click(listingPage.clickDropdownField("Status"));
		SeleniumFunction.click(listingPage.selectDropdownValue("Active"));
		
		SeleniumFunction.click(listingPage.clickDropdownField("In Stock"));
		SeleniumFunction.click(listingPage.selectDropdownValue("Yes"));

		SeleniumFunction.click(listingPage.applyFilterBtn());
		WaitTool.sleep(10);

		int rowsAfterFilter = this.getTotalRowsCount(driver);		

		if(rowsAfterFilter < rowsBeforeFilter) {
			Assert.assertTrue(true);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(1)), "Category is (Baby Changing Table Pads )");
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Status is Active");
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "In Stock is Yes");
		}else {
			Assert.assertTrue(false);
		}
	}




	public int getTotalRowsCount (WebDriver driver) {
		ProductListing listingPage = new ProductListing(driver);
		String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
		String[] num = productCounter.split(" ");
		int rows = Integer.parseInt(num[5]);
		return rows;
	}
}
