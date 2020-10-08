package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.OrderPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestOrders extends InitializeTest{

	
	@Test
	public void testOrders() {
		
		WebDriver driver = getDriver();
		
		OrderPage orderPage = new OrderPage(driver);
		
		SeleniumFunction.click(orderPage.ordersLink());
		SeleniumFunction.click(orderPage.orders());
		WaitTool.sleep(10);
		System.out.println("oredr id in order"+crorderId);
		SeleniumFunction.sendKeys(orderPage.orderId(), crorderId);
		//SeleniumFunction.sendKeys(orderPage.orderId(), crorderId);
		WaitTool.sleep(10);
		SeleniumFunction.click(orderPage.applyFilter());
		WaitTool.sleep(10);
		
		SeleniumFunction.click(orderPage.viewOrder());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "viewOrder");
		SeleniumFunction.click(orderPage.closeOrder());
		WaitTool.sleep(10);
	}
}	