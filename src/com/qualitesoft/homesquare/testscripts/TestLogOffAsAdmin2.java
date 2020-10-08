package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;
import com.qualitesoft.homesquare.pageobjects.HomePage;

public class TestLogOffAsAdmin2 extends InitializeTest{
	
	@Test
	public void testLogOffAsAdmin2(){
		
		BoardApprovalPage boardApprovalPage = new BoardApprovalPage(driver);
		SeleniumFunction.click(boardApprovalPage.logoutButton());
		HomePage homePage = new HomePage(driver);
		homePage.emailSigninTextbox();
		ScreenShot.takeScreenShot(driver, "LoginPage");
	}

}
