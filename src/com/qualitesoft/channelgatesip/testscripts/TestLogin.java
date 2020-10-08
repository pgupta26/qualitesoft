package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLogin extends InitializeTest{ 
	@Test
	public void testInstance(){
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Login Page");
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.sendKeys(login.emailField(),"shikha.parmar@qualitesoft.com");
		SeleniumFunction.sendKeys(login.passwordfield(),"123456");
		ScreenShot.takeScreenShot(driver, "Login filled details");
		SeleniumFunction.click(login.signInbutton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "After Login ");
		
		
	}
}
