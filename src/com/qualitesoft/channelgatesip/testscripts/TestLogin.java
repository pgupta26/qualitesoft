package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestLogin extends InitializeTest{ 
	
	@Test(priority = 1)
	public void testInstance(){
		
		LoginPage login = new LoginPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		
		SeleniumFunction.sendKeys(login.emailField(), emailAddress);
		SeleniumFunction.sendKeys(login.passwordfield(), password);
		ScreenShot.takeScreenShot(driver, "Login filled details");
		SeleniumFunction.click(login.signInbutton());
		
		String userEmail = SeleniumFunction.getText(commonPage.getUserEmail());
		UseAssert.assertEquals(userEmail, emailAddress);
		
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "After Login ");	
	}
}
