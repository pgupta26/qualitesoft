package com.qualitesoft.channelgatesip.testscripts.orders;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestFilterFunctionality extends InitializeTest{
	
	@Test
	public void testFilterByBrandOnListingPage(){
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Order Management"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Orders"));
		WaitTool.sleep(10);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));

		int rowsBeforeFilter = this.getTotalRowsCount(driver);

		listingPage.getTableData(1, 1);
		SeleniumFunction.click(listingPage.filterBtn());


		SeleniumFunction.click(listingPage.clickBrandField());
		SeleniumFunction.sendKeys(listingPage.searchFilterOptionText(), "!nspire (ID - 5825)");
		SeleniumFunction.click(listingPage.selectCheckbox("!nspire (ID - 5825)"));
		SeleniumFunction.click(listingPage.clickCloseMultiselectPopup());

		SeleniumFunction.click(listingPage.applyFilterBtn());
		WaitTool.sleep(10);

		int rowsAfterFilter = this.getTotalRowsCount(driver);		

		if(rowsAfterFilter < rowsBeforeFilter) {
			Assert.assertTrue(true);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Brand is ( !nspire )");

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
