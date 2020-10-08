package com.qualitesoft.channelgatesip.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestInstance extends InitializeTest{ 
	@Test
	public void testInstance(){
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "SIP Home page");
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.siplink());
		
		ScreenShot.takeScreenShot(driver, "Instances are displayed");
		
		
		
	}
}
