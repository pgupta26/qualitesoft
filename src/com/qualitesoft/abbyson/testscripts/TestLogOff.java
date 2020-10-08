package com.qualitesoft.abbyson.testscripts;

import org.testng.annotations.Test;
import com.qualitesoft.americanmattress.pageobjects.HomePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		

		
		HomePage homePage = new HomePage(driver);
	
		SeleniumFunction.click(homePage.logoutLink());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Logout Succesfully");
		
	}
}
