package com.qualitesoft.channelgatesip.testscripts.orders;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestBadgeCountWithTotalOrderCount extends InitializeTest{

	@Test(enabled = false)
	public void aTestBadgeCountWithTotalOrderCountAfterFilter() {
		
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Order Management"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Orders"));
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
		
		String badgeCount = SeleniumFunction.getText(orderPage.getOrderCountOnBadge(keyword));
		SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));
		
		
		String[] paginationArr = SeleniumFunction.getText(orderPage.getPaginationRow()).split(" ");
		String totalRows = paginationArr[5];
		
		UseAssert.assertEquals(badgeCount, totalRows);
	}
	
}
