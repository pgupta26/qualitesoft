package com.qualitesoft.channelgatesip.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;

public class LogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		WaitTool.sleep(5);
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.profile());
		SeleniumFunction.click(login.logout());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "LogOffPage");
	}

}
