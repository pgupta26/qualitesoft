package com.qualitesoft.MBShopify.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.DisablePassword;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestDisablePassword extends InitializeTest{
	@Test
	public void testDisablePassword(){
		WebDriver driver = getDriver();
		//WaitTool.sleep(5);
		DisablePassword dis = new DisablePassword(driver);
		SeleniumFunction.click(dis.LogInButton());
		WaitTool.sleep(8);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		
		ScreenShot.takeScreenShot(driver, "Admin Products");
		SeleniumFunction.click(dis.onlineStore());
		ScreenShot.takeScreenShot(driver, "Online Store");
		SeleniumFunction.click(dis.preference());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,750)", "");
		SeleniumFunction.click(dis.checkbox());
		jse.executeScript("window.scrollBy(0,550)", "");	
		SeleniumFunction.click(dis.saveButton());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "Disable Password");	
		driver.close();
		driver.switchTo().window(newTab.get(0));
		WaitTool.sleep(2);

		
	}
}
