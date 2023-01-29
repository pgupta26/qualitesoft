package com.qualitesoft.channelgatesip.testscripts.orders;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestActionsOnOrderListing extends InitializeTest{

	@Test
	public void aTestGenereateLabelForUnshipperdOrder() {
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Unshipped"));
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Late"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "Shipment Schedule (Late)");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(3)), "Order Status (Unshipped)");
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickExpandAllBtn());
		SeleniumFunction.click(orderPage.clickButtonByText("Generate Label"));
		
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Label created successfully for Order #" + orderId);
	}
	
	@Test
	public void bTestRegenereateLabelForUnshipperdOrder() {
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Unshipped"));
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Late"));
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickExpandAllBtn());
		SeleniumFunction.click(orderPage.clickButtonByText("Re-Generate Label"));
		
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Label created successfully for Order #" + orderId);
	}
	
	@Test
	public void cTestMarkAsPickupForUnshipperdOrder() {
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("Unshipped"));
		SeleniumFunction.click(orderPage.getOrderCountOnBadge("LTL"));
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickExpandAllBtn());
		SeleniumFunction.click(orderPage.clickButtonByText("Mark as Pickup Ready"));
		
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Order #" + orderId + " successfully updated");
	}
	
	@Test
	public void dTestAddTrackingForUnshipperdOrder() {
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickButtonByText("Add Tracking"));
		
		SeleniumFunction.click(orderPage.clickSelectCarrierDropdown());
		SeleniumFunction.click(orderPage.selectCarrier("AIT Worldwide"));
		SeleniumFunction.sendKeys(orderPage.setTrackingNum(), "123654");
		
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Tracking Numbers for Order #" + orderId + " updated successfully");
	}
	
	@Test
	public void eTestUpdateEstDateForUnshipperdOrder() {
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickButtonByText("Update Est Ship Date"));
		
		SeleniumFunction.click(orderPage.selectCurrentDate());
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Estimated Ship Date successfully updated for Order #" + orderId);
	}
	
	@Test
	public void fTestMarkDiscontinuedForUnshipperdOrder() {
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickButtonByText("Mark Discontinued"));
		SeleniumFunction.click(commonPage.clickButtonByText("Yes, Discontinued"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Order #" + orderId + " successfully updated");
	}
	
	@Test
	public void gTestMarkDiscontinuedForUnshipperdOrder() {
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickButtonByText("Mark Backordered"));

		SeleniumFunction.click(orderPage.selectCurrentDate());
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Back Order Date successfully updated for Order #" + orderId);
	}
	
	@Test
	public void hTestBolForUnshipperdOrder() {
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		
		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		
		SeleniumFunction.click(orderPage.clickButtonByText("Mark Backordered"));

		SeleniumFunction.click(orderPage.selectCurrentDate());
		SeleniumFunction.click(commonPage.clickButtonByText("Submit"));
		
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "Back Order Date successfully updated for Order #" + orderId);
	}
	
}
