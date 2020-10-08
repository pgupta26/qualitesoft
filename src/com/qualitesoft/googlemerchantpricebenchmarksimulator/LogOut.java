package com.qualitesoft.googlemerchantpricebenchmarksimulator;



import java.io.File;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.googlemerchantpricebenchmarksimulator.pageobjects.LoginPage;

public class LogOut extends InitializeTest{
	@Test
	public void testLogOut(){
		
		LoginPage loginPage = new LoginPage(driver);
		 WaitTool.sleep(5);
         driver = getDriver();
         SeleniumFunction.click(loginPage.usericon());
         SeleniumFunction.click(loginPage.logout());
         WaitTool.sleep(5);
		 ScreenShot.takeScreenShot(driver, "LoggedOut");
		
			
	}
}

