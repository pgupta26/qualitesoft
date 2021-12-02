package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymaxAdmin.pageobjects.LoginPage;

public class TestLogout extends InitializeTest{

	@Test
	public void logoutFromPortal(){
		try{
			LoginPage login = new LoginPage(driver);
			
			SeleniumFunction.click(login.clickLogoutBtn());
			login.setUsername();
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			driver.navigate().refresh();
		}catch(Exception e) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			driver.navigate().refresh();
			Assert.fail();
		}
	}
}
