package com.qualitesoft.bush.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.HomePage;
import com.qualitesoft.bush.pageobjects.MyAccountPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class LogOff extends InitializeTest{
	
	@Test
	public void testLogOff(){
		HomePage homePage = new HomePage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement myAccountLink = homePage.myAccountLink();
		SeleniumFunction.hoverAction(driver,myAccountLink);
		SeleniumFunction.click(myAccountPage.logOffLink());
		WaitTool.sleep(5);
		//myAccountPage.logoutText();
		ScreenShot.takeScreenShot(driver, "LogOffPage");
	}

}
