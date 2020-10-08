package com.qualitesoft.freightclubPh2.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.SignInPage;




public class TestSignIn extends InitializeTest{
	
	@Test
	public void testSignIn(){
		
		HomePage homePage = new HomePage(driver);
		SeleniumFunction.clickJS(driver, homePage.signInLink());
		ScreenShot.takeScreenShot(driver, "SignInPage");
		
		SignInPage signInPage = new SignInPage(driver);
		SeleniumFunction.sendKeys(signInPage.usernameTextField(), fcusername);
		SeleniumFunction.sendKeys(signInPage.passowrdTextField(), fcpassword);
		ScreenShot.takeScreenShot(driver, "SignInPageFilled");
		SeleniumFunction.clickJS(driver, signInPage.loginButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Quick Quote page");
	}
}
