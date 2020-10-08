package com.qualitesoft.constantretail.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.TopMenuBarPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;

public class LogOut extends InitializeTest{
	
	public LogOut(){
		
	}
	
	@Test
	public void testLogOut(){
		
		TopMenuBarPage topMenuBarPage = new TopMenuBarPage(driver);
		SeleniumFunction.click(topMenuBarPage.profilePicture());
		ScreenShot.takeScreenShot(driver, "LogoutLink");
		SeleniumFunction.click(topMenuBarPage.logoutLink());
		ScreenShot.takeScreenShot(driver, "LoggedOut");
	}

}
