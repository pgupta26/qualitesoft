package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;

public class TestNavigateToHSQHomepage extends InitializeTest{
	
	@Test
	public void testNavigateToHSQHomepage(){
		
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		SeleniumFunction.click(homePage.homesquareLogo());
		homePage.signUpLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
	}

}
