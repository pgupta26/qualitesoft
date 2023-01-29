package com.qualitesoft.channelgatesip.testscripts.orders;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestUnshippedMultiFilter extends InitializeTest{

	@Test
	public void aTestBadgeCountWithTotalOrderCountAfterFilter() {
		
		ProductListing listingPage = new ProductListing(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Unshipped"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Order Status (Unshipped)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Late"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Late)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Due Today"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Due Today)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Pre-ship Time"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Pre-ship Time)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Ground"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Pre-ship Time)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(4)), "Shipment Method (Ground)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("LTL"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Pre-ship Time)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(4)), "Shipment Method (LTL)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Yes"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Pre-ship Time)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(4)), "Shipment Method (LTL)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(5)), "Cancellation Requested (Yes)");
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("No"));
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Pre-ship Time)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(4)), "Shipment Method (LTL)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(5)), "Cancellation Requested (No)");
	}
}
