package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.OrderConfirmationPage;



public class TestHomeSquareLogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		
/*		MyAccountPage myAccountPage = new MyAccountPage(driver);
		SeleniumFunction.click(myAccountPage.logOffLink());
		myAccountPage.logoutText();
		ScreenShot.takeScreenShot(driver, "LogOffPage");*/
		
		HomePage homePage = new HomePage(driver);
	WebElement myAccountLink = homePage.HomeSqmyAccountLink();// click on user account	
				SeleniumFunction.hoverAction(driver,myAccountLink);
		MyAccountPage myAccountPage = new MyAccountPage(driver);	
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
