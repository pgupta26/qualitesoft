package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestOrderHistory extends InitializeTest{
	
	@Test
	public void testOrderhistory(){
		WaitTool.sleep(15);
		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.click(landingPage.OrderHistoryLink());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "OrderHistoryPage");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		SeleniumFunction.click(landingPage.OrderHistoryLastpage());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Order History Last Page");

	}
}
