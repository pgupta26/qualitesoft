package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;

public class TestLogoffAsAdmin extends InitializeTest{
	
	@Test
	public void testLogoffAsAdmin(){
		
		BoardApprovalPage boardApprovalPage = new BoardApprovalPage(driver);
		SeleniumFunction.click(boardApprovalPage.logoutButton());
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		homePage.emailSigninTextbox();
		ScreenShot.takeScreenShot(driver, "LoginPage");
	}

}
