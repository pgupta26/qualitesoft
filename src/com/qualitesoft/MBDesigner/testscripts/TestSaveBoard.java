package com.qualitesoft.MBDesigner.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.CreateMuzeboard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestSaveBoard extends InitializeTest{
	@Test
	public void testSaveBoard(){
		WebDriver driver = getDriver();
		WaitTool.sleep(5);
		CreateMuzeboard create = new CreateMuzeboard(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)", "");
		SeleniumFunction.click(create.saveButton());
		SeleniumFunction.sendKeys(create.boardnameTextBox(), "TestBoard");
		SeleniumFunction.sendKeys(create.boarddescTextBox(), "Test");
		SeleniumFunction.sendKeys(create.tagsTextBox(), "Tag1");
		WaitTool.sleep(10);
		create.uploadFileChrome("logo");
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Board Info filled");
		SeleniumFunction.click(create.okButton());
		WaitTool.sleep(25);
		ScreenShot.takeScreenShot(driver, "Board Saved");
		WaitTool.sleep(5);
		
	}
}
