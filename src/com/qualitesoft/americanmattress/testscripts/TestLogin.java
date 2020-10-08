package com.qualitesoft.americanmattress.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLogin extends InitializeTest{ 
	@Test
	public void testCartPages(){
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Home Page");
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		SeleniumFunction.sendKeys(shoppingCartPage.email(),"qa_raj.r@cymax.com");
		SeleniumFunction.sendKeys(shoppingCartPage.password(),"Welcome@2");
		ScreenShot.takeScreenShot(driver, "Login filled details");
		SeleniumFunction.click(shoppingCartPage.signup());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "After Login ");
		
		
	}
}
