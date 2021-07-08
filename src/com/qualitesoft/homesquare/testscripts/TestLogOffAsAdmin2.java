package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;

public class TestLogOffAsAdmin2 extends InitializeTest{
	
	@Test
	public void testLogOffAsAdmin2(){
		
		BoardApprovalPage boardApprovalPage = new BoardApprovalPage(driver);
		SeleniumFunction.click(boardApprovalPage.logoutButton());
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		homePage.emailSigninTextbox();
		ScreenShot.takeScreenShot(driver, "LoginPage");
	}

}
