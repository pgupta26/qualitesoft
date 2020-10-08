package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardOverviewPage;

public class MuzeboardLogout extends InitializeTest{
	
	@Test
	public void testMuzeboardLogout(){
		
		MuzeboardOverviewPage muzeboardOverviewPage = new MuzeboardOverviewPage(driver);
		SeleniumFunction.click(muzeboardOverviewPage.logoutLink());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "LoginPage");
	}
}
