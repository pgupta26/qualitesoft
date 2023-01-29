package com.qualitesoft.channelgatesip.testscripts.orders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestUnprocessedOrder extends InitializeTest {
	
	@Test
	public void aTestOrderDate() {
		
		CommonPage commonPage = new CommonPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Order Management"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Orders"));
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));
		this.testOrderDateFilter(14, "15");
	}
	@Test
	public void bTestOrderDate30Days() {
		
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(orderPage.clickCalendarIcon());
		SeleniumFunction.click(orderPage.selectStatusDate("30 Days"));
		
		this.testOrderDateFilter(29, "30");
	}
	@Test
	public void cTestOrderDate60Days() {
		
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(orderPage.clickCalendarIcon());
		SeleniumFunction.click(orderPage.selectStatusDate("60 Days"));
		
		this.testOrderDateFilter(59, "60");
	}
	@Test
	public void dTestOrderDate90Days() {
		
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));
		
		SeleniumFunction.click(orderPage.clickCalendarIcon());
		SeleniumFunction.click(orderPage.selectStatusDate("90 Days"));
		
		this.testOrderDateFilter(89, "90");
	}
	
	@Test
	public void eTestSearchOrderById() {
		
		OrderPage orderPage = new OrderPage(driver);
		ProductListing listingPage = new ProductListing(driver);
		
		SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));

		String orderId = SeleniumFunction.getText(orderPage.getOrderId());
		SeleniumFunction.sendKeys(orderPage.setOrderIdOnSearchBar(), orderId);
		SeleniumFunction.click(orderPage.clickSearchBtn());
		WaitTool.sleep(5);
		
		String badgeCount = SeleniumFunction.getText(orderPage.getOrderCountOnBadge(keyword));
		String[] paginationArr = SeleniumFunction.getText(orderPage.getPaginationRow()).split(" ");
		String totalRows = paginationArr[5];
		
		UseAssert.assertEquals(badgeCount, "1");
		UseAssert.assertEquals(totalRows, "1");
		UseAssert.assertEquals(SeleniumFunction.getText(orderPage.getOrderStatus()), keyword.toUpperCase());
		
		SeleniumFunction.click(listingPage.clickClearFilter());
		WaitTool.sleep(5);
	}
	
	
	public void testOrderDateFilter(int days, String lastDates) {
		OrderPage orderPage = new OrderPage(driver);
		
		String orderDateFilter = SeleniumFunction.getText(orderPage.getOrderDateFilter());
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY"));
		String beforeDate = LocalDate.now().minusDays( days ).format(DateTimeFormatter.ofPattern("MMM dd, YYYY"));
		
		UseAssert.assertEquals(orderDateFilter, "Order Date ("+beforeDate+" - "+currentDate+") Last "+lastDates+" Day(s)");
		UseAssert.assertEquals(SeleniumFunction.getAttribute(orderPage.getSelectedFilter(keyword), "aria-pressed"), "true");
	}

}
