package com.qualitesoft.MBShopify.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.CreateNewStore;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCreateNewStore extends InitializeTest{
	@Test
	public void testCreateNewStore(){
		WebDriver driver = getDriver();
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "MB Shopify Page");
		CreateNewStore create = new CreateNewStore(driver);
		SeleniumFunction.click(create.partnerloginButton());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "Partner Login Page");
		SeleniumFunction.sendKeys(create.userEmail(),"hemant.sharma@qualitesoft.com");
		SeleniumFunction.click(create.continueButton());
		WaitTool.sleep(8);
		SeleniumFunction.sendKeys(create.userPassword(),"123456");
		SeleniumFunction.click(create.loginButton());
		SeleniumFunction.click(create.createstoreButton());
		ScreenShot.takeScreenShot(driver, "New Development store");
		SeleniumFunction.sendKeys(create.storeName(),"testAutomation");
		SeleniumFunction.sendKeys(create.password(),"12345");
		SeleniumFunction.sendKeys(create.confirmPassword(),"12345");
		SeleniumFunction.click(create.saveButton());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "Store Created");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		WaitTool.sleep(3);
		driver.navigate().refresh();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		WaitTool.sleep(3);
		ScreenShot.takeScreenShot(driver, "Recently created store list");
		
	}
}
