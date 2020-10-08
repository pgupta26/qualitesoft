package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.SignInPage;

public class TestSignIn extends InitializeTest {
	
	@Test
	public void testCustomerLogin(){
		try {
			SignInPage signInPage = new SignInPage(driver);
			SeleniumFunction.sendKeys(signInPage.usernameTextField(), crusername);
			SeleniumFunction.sendKeys(signInPage.passowrdTextField(), crpassword);
			WaitTool.sleep(1);
			if(!signInPage.usernameTextField().getAttribute("value").equals(crusername)) {
				System.out.println("Login detail not inserted in first attempt.");
				SeleniumFunction.sendKeys(signInPage.usernameTextField(), crusername);
				SeleniumFunction.sendKeys(signInPage.passowrdTextField(), crpassword);
			}
			ScreenShot.takeScreenShot(driver, "Login detail inserted");
			SeleniumFunction.clickJS(driver, signInPage.loginButton());
			WaitTool.sleep(5);
			ScreenShot.takeScreenShot(driver, "Login Successfully");
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
