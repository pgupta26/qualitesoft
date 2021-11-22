package com.qualitesoft.freightclub.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;

public class TestLogOff extends InitializeTest{
	
	@Test
	public void testlogoff(){
		WaitTool.sleep(5);
		HomePage homePage = new HomePage(driver);
		try {
			SeleniumFunction.click(homePage.logoff());
		}catch(Exception ex) {
			try {
				Log.info("Log Off Retry...............");
				SeleniumFunction.getCurrentUrl(driver);
				WaitTool.sleep(5);
				SeleniumFunction.click(homePage.logoff());
			}catch(Exception e) {
				throw e;
			}
		}
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Logout");		
	}
}
