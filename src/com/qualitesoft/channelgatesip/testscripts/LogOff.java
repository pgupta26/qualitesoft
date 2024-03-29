package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class LogOff extends InitializeTest{

	@Test
	public void testLogOff(){
		WaitTool.sleep(5);
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.profile());
		SeleniumFunction.click(login.logout());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "LogOffPage");
		login.emailField();
	}

}
