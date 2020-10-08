package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;
import com.qualitesoft.homesquare.pageobjects.HomePage;

public class TestLoginAsAdmin2 extends InitializeTest{
	
	@Test
	public void testLoginAsAdmin2(){
		
		HomePage homePage = new HomePage(driver);
		WebElement signUpLink = homePage.signUpLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(signUpLink);
		
		SeleniumFunction.click(homePage.signInLink());
		
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
