package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;

public class LogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
			HomePage homePage = new HomePage(driver);
			if(suiteName.contains("Homesquare")) {
				WebElement myAccountLink = homePage.HomeSqmyAccountLink();
				SeleniumFunction.click(myAccountLink);
			} else {
				WebElement myAccountLink = homePage.myAccountLink();
				SeleniumFunction.hoverAction(driver,myAccountLink);
			}
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			SeleniumFunction.click(myAccountPage.logOffLink());
			ScreenShot.takeScreenShot(driver, "LogOffPage");
	}
}
