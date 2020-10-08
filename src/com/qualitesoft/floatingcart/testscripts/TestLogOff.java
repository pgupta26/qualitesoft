package com.qualitesoft.floatingcart.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;


public class TestLogOff extends InitializeTest{
	
	@Test
	public void testlogoff(){
		WaitTool.sleep(5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		HomePage homePage = new HomePage(driver);
		SeleniumFunction.click(homePage.logoff());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Logout");		
	}
}
