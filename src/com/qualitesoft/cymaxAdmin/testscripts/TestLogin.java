package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymaxAdmin.pageobjects.LoginPage;

public class TestLogin extends InitializeTest{

	@Test
	public void loginAsAdmin(){
		try{
			LoginPage login = new LoginPage(driver);
			
			SeleniumFunction.sendKeys(login.setUsername(), crusername);
			SeleniumFunction.sendKeys(login.setPassword(), crpassword);
			SeleniumFunction.click(login.clickLoginBtn());
			login.clickLogoutBtn();
		}catch(Exception e) {
			Assert.fail();
		}
	}
}
