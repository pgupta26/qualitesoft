package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;



public class TestHomeSquareLogOff extends InitializeTest{

	@Test
	public void testLogOff(){

		/*		MyAccountPage myAccountPage = new MyAccountPage(driver);
		SeleniumFunction.click(myAccountPage.logOffLink());
		myAccountPage.logoutText();
		ScreenShot.takeScreenShot(driver, "LogOffPage");*/

		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		WebElement myAccountLink = homePage.HomeSqmyAccountLink();// click on user account	
		SeleniumFunction.hoverAction(driver,myAccountLink);
		HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);	
		SeleniumFunction.click(myAccountPage.HomeSqlogoLoggOff());// go to home page
		WaitTool.sleep(2);
		//WebElement myAccountLink = homePage.HomeSqmyAccountLink();// click on user account	
		//SeleniumFunction.hoverAction(driver,myAccountLink);
		//ScreenShot.takeScreenShot(driver, "HomePage before logout");
		//SeleniumFunction.click(myAccountPage.logOffLink());
		//myAccountPage.logoutText();
		ScreenShot.takeScreenShot(driver, "LogOffPage");
	}

}
