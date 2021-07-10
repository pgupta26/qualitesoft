package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;

public class LogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
			if(suiteName.contains("Homesquare")) {
				WebElement myAccountLink = homePage.HomeSqmyAccountLink();
				SeleniumFunction.click(myAccountLink);
			} else {
				WebElement myAccountLink = homePage.HomeSqmyAccountLink();
				SeleniumFunction.hoverAction(driver,myAccountLink);
			}
			
			HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
			SeleniumFunction.click(myAccountPage.logOutLink());
			ScreenShot.takeScreenShot(driver, "LogOffPage");
	}
}
