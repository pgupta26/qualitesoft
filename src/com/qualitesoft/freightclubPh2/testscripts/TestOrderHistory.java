package com.qualitesoft.freightclubPh2.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.SignInPage;

public class TestOrderHistory extends InitializeTest{
	
	@Test
	public void testOrderhistory(){
		WaitTool.sleep(15);
		LandingPage landingPage = new LandingPage(driver);
		//landingPage.OrderHistoryLink();
		//SeleniumFunction.clickJS(driver, landingPage.OrderHistoryLink());
		SeleniumFunction.click(landingPage.OrderHistoryLink());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "OrderHistoryPage");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");//scroll down
		SeleniumFunction.clickJS(driver, landingPage.OrderHistoryLastpage());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Order History Last Page");

	}
}
