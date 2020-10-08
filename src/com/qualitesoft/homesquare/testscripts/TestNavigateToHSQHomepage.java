package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.HomePage;

public class TestNavigateToHSQHomepage extends InitializeTest{
	
	@Test
	public void testNavigateToHSQHomepage(){
		
		HomePage homePage = new HomePage(driver);
		SeleniumFunction.click(homePage.homesquareLogo());
		homePage.signUpLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
	}

}
