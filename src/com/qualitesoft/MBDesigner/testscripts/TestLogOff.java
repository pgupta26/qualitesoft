package com.qualitesoft.MBDesigner.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.CreateMuzeboard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLogOff extends InitializeTest{
	
	@Test
	public void testLogOut(){
		
		CreateMuzeboard topMenuBarPage = new CreateMuzeboard(driver);
		SeleniumFunction.click(topMenuBarPage.profilePicture());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "LogoutLink");
		SeleniumFunction.click(topMenuBarPage.logoutLink());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "LoggedOut");
	}
}
