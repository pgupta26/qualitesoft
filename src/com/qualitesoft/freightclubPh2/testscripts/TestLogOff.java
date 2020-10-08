package com.qualitesoft.freightclubPh2.testscripts;


import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;


public class TestLogOff extends InitializeTest{
	
	@Test
	public void testlogoff(){
		WaitTool.sleep(10);
		HomePage homePage = new HomePage(driver);
		SeleniumFunction.click(homePage.logoff());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Logout");		
	}
}
