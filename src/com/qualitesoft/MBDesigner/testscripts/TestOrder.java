package com.qualitesoft.MBDesigner.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.CreateMuzeboard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestOrder extends InitializeTest{

	
	@Test
	public void testOrders() {
		
		WebDriver driver = getDriver();
		
		CreateMuzeboard orderPage = new CreateMuzeboard(driver);
		
		SeleniumFunction.click(orderPage.ordersLink());
		SeleniumFunction.click(orderPage.orders());
		WaitTool.sleep(8);
		System.out.println("oredr id in order"+crorderId);
		SeleniumFunction.sendKeys(orderPage.orderId(), crorderId);
		//SeleniumFunction.sendKeys(orderPage.orderId(), crorderId);
		WaitTool.sleep(10);
		SeleniumFunction.click(orderPage.applyFilter());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Orders");
		SeleniumFunction.click(orderPage.viewOrder());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "viewOrder");
		WaitTool.sleep(8);
		SeleniumFunction.click(orderPage.closeOrder());
		WaitTool.sleep(5);
	}
}
