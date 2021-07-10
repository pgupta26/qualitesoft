package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;

public class TestLoginAsAdmin extends InitializeTest{
	
	@Test
	public void testLoginAsAdmin(){
		
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		
		SeleniumFunction.sendKeys(homePage.emailSigninTextbox(), "mbadmin@homesquare.com");
		SeleniumFunction.sendKeys(homePage.passowrdSigninTextbox(), "Slainte");
		SeleniumFunction.click(homePage.designerCheckbox());
		ScreenShot.takeScreenShot(driver, "SigninPageFilled");
		SeleniumFunction.click(homePage.loginButton());
		
		BoardApprovalPage boardApprovalPage = new BoardApprovalPage(driver);
		boardApprovalPage.approvalButton();
		ScreenShot.takeScreenShot(driver, "BoardApprovalPage");
	}

}
