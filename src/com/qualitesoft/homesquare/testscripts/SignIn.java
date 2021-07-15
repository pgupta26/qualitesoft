package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareLoginPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;

public class SignIn extends InitializeTest{

	@Test
	public void testSignIn() {	
		HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
		WaitTool.sleep(5);
		if(loginPage.alreadyHaveAccountPresent()) {
			WaitTool.sleep(5);
			loginPage.alreadyHaveAccount();
			loginPage.userName(emailAddress);
			loginPage.password("CymaxQa1234");
			ScreenShot.takeScreenShot(driver, "login information entered");
			loginPage.signInButton();
			Log.info("login successfully.");
		}			
	}

	@Test
	public void testHomeSquareSignIn() {	
		HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
		if(loginPage.alreadyHaveAccountPresent()) {
			loginPage.alreadyHaveAccount();
			loginPage.userName(crusername);
			loginPage.password(crpassword);
			ScreenShot.takeScreenShot(driver, "login information entered");
			loginPage.signInButton();
			Log.info("login successfully.");
		}			
	}

	@Test
	public void testLogIn() {	
		WaitTool.sleep(5);
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);

		WebElement myAccountLink = homePage.HomeSqmyAccountLink();
		SeleniumFunction.click(myAccountLink);
		HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
		SeleniumFunction.sendKeys(myAccountPage.emailTextbox(), crusername);
		SeleniumFunction.sendKeys(myAccountPage.passwordTextbox(), crpassword);
		if(suiteName.equals("Bush Suite - Payal")){
			SeleniumFunction.click(myAccountPage.Loginbutton1());
		}else {
			SeleniumFunction.click(myAccountPage.Loginbutton());
		}
		Log.info("login successfully.");	
	}
}
