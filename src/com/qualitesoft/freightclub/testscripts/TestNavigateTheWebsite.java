package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.freightclub.pageobjects.HomePage;

public class TestNavigateTheWebsite extends InitializeTest{
	
	@Test
	public void testNavigateTheWebsite(){
		HomePage homePage = new HomePage(driver);
		homePage.signInLink();
		ScreenShot.takeScreenShot(driver, "Navigate to the Website");
	}

}
