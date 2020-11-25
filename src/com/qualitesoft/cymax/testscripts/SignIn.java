package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;

public class SignIn extends InitializeTest{
	
	@Test
	public void testSignIn() {	
			LoginPage loginPage =new LoginPage(driver);
			if(loginPage.alreadyHaveAccountPresent()) {
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
			LoginPage loginPage =new LoginPage(driver);
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
			HomePage homePage = new HomePage(driver);
			if(homePage.cymaxPopup()!=null) {
				SeleniumFunction.click(homePage.cymaxPopup());
			}
			WebElement myAccountLink = homePage.myAccountLink();
			SeleniumFunction.click(myAccountLink);
			MyAccountPage myAccountPage = new MyAccountPage(driver);
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
