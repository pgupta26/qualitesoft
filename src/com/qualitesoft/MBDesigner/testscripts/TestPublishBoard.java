package com.qualitesoft.MBDesigner.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.CreateMuzeboard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestPublishBoard  extends InitializeTest{
	@Test
	public void testPublishBoard(){
		WebDriver driver = getDriver();
		WaitTool.sleep(5);
		CreateMuzeboard create = new CreateMuzeboard(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)", "");
		SeleniumFunction.click(create.publishButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "MuzeBoard Information");
		SeleniumFunction.click(create.okButton());
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "MuzeBoard published");
		WaitTool.sleep(10);
		jse.executeScript("window.scrollBy(0,-350)", "");
		SeleniumFunction.click(create.backButton());
		WaitTool.sleep(25);
		jse.executeScript("window.scrollBy(0,250)", "");
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "List Of Muzeboard page");
		
		
	}
}
