package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymaxAdmin.pageobjects.LoginPage;

public class TestLogin extends InitializeTest{

	@Test
	public void loginAsAdmin(){
		LoginPage login = new LoginPage(driver);
		
		SeleniumFunction.sendKeys(login.setUsername(), crusername);
		SeleniumFunction.sendKeys(login.setPassword(), crpassword);
		ScreenShot.takeScreenShot(driver, "Login Page");
		SeleniumFunction.click(login.clickLoginBtn());
		login.clickLogoutBtn();
	}
}
