package com.qualitesoft.vignettes.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.HomePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-950)", "");
		
		
		HomePage homePage = new HomePage(driver);
	
		ScreenShot.takeScreenShot(driver, "Order History");
		SeleniumFunction.click(homePage.logoutLink());	
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Logout");
	}
}
