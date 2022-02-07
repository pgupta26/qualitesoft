package com.qualitesoft.FCsalesinquiryformsubmission.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;

public class TestNavigateTheWebsite extends InitializeTest{
	
	@Test
	public void testNavigateTheWebsite(){
		
		HomePage homePage = new HomePage(driver);
		//SeleniumFunction.clickJS(driver, homePage.contactUsLink());
		//homePage.signInLink();
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Navigate to the Website");
		
		
	}

}
