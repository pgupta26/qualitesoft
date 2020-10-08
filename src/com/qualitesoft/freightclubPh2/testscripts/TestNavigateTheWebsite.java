package com.qualitesoft.freightclubPh2.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.freightclub.pageobjects.HomePage;

public class TestNavigateTheWebsite extends InitializeTest{
	
	@Test
	public void testNavigateTheWebsite(){
		
		HomePage homePage = new HomePage(driver);
		//SeleniumFunction.clickJS(driver, homePage.contactUsLink());
		homePage.signInLink();
		ScreenShot.takeScreenShot(driver, "Navigate to the Website");
		
		
	}

}
