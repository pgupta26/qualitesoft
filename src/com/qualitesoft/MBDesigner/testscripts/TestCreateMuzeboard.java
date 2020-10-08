package com.qualitesoft.MBDesigner.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.CreateMuzeboard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCreateMuzeboard extends InitializeTest{
	@Test
	public void testCreateMuzeboard(){
		WebDriver driver = getDriver();
		WaitTool.sleep(5);
		CreateMuzeboard create = new CreateMuzeboard(driver);
		SeleniumFunction.click(create.createMuzeboardButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Create New Muzeboard");
		SeleniumFunction.sendKeys(create.serachProductTextBox(), "pillow");
		SeleniumFunction.click(create.serachIcon());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Search Result");
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"638985\"]"), 120);
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"canvas\"]"), 120);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"638985\"]")); ////*[@id=\"1458865\"]
		WebElement target = driver.findElement(By.xpath("//*[@id=\"canvas\"]"));
		WaitTool.sleep(12);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(element)
		   .moveToElement(target)
		   .release(target)
		   .build();
		dragAndDrop.perform();
		WaitTool.sleep(15);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		ScreenShot.takeScreenShot(driver, "Item Dragged");
	
	}
}
