package com.qualitesoft.floatingcart.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.floatingcart.pageobjects.FloatingCreateAccount;


public class TestCreateAccount extends InitializeTest {
	@Test
	public void testCreateAccount(){
		FloatingCreateAccount account = new FloatingCreateAccount(driver);
		SeleniumFunction.sendKeys(account.firstName(),"TestSeleniumFirst");
		SeleniumFunction.sendKeys(account.lastName(),"TestSeleniumlast");
		SeleniumFunction.sendKeys(account.companyName(),"Selenium");
		SeleniumFunction.sendKeys(account.password(),"Te&t1234");
		SeleniumFunction.sendKeys(account.confirmPassword(),"Te&t1234");
		SeleniumFunction.sendKeys(account.phone(),"1234567890");
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(account.agreeCheckbox());
		ScreenShot.takeScreenShot(driver, "FilledUserAccountDetails");
		SeleniumFunction.click(account.createButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Account Created");
	}
}

