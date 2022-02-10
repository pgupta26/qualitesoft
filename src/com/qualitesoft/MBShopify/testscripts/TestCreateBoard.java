package com.qualitesoft.MBShopify.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.CreateBoard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCreateBoard extends InitializeTest {
	@Test
	public void testCreateBoard() {

		WebDriver driver = getDriver();
		CreateBoard create = new CreateBoard(driver);
		WaitTool.sleep(4);
		SeleniumFunction.click(create.createmuzeboard());
		ScreenShot.takeScreenShot(driver, "Create New Muzeboard");
		SeleniumFunction.sendKeys(create.searchTextBox(), "product1");
		SeleniumFunction.click(create.searchbutton());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "Search Product");
		SeleniumFunction.click(create.draggableimage());
		WaitTool.sleep(3);
		// jse.executeScript("window.scrollBy(0,-550)", "");
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WaitTool.sleep(4);
		SeleniumFunction.click(create.addimage());
		ScreenShot.takeScreenShot(driver, "Added Image");
		WaitTool.sleep(2);
		SeleniumFunction.click(create.texticon());
		WaitTool.sleep(4);
		SeleniumFunction.sendKeys(create.addtext(), "testcolor");
		SeleniumFunction.click(create.textbutton());
		WaitTool.sleep(4);
		SeleniumFunction.click(create.bgicon());
		SeleniumFunction.click(create.addbg());
		// jse.executeScript("window.scrollBy(0,250)", "");
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitTool.sleep(4);
		SeleniumFunction.sendKeys(create.bgcolor(), "#8d3232");
		WaitTool.sleep(4);
		// jse.executeScript("window.scrollBy(0,250)", "");
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumFunction.click(create.bgokbutton());
		ScreenShot.takeScreenShot(driver, "Text and color added");
		SeleniumFunction.click(create.savebutton());
		ScreenShot.takeScreenShot(driver, "Open Board detail popup");
		SeleniumFunction.sendKeys(create.boardname(), "testcolor");
		SeleniumFunction.sendKeys(create.boarddesc(), "testcolor");
		WaitTool.sleep(4);
		try {
			robot = new Robot();

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			// WaitTool.sleep(2);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WaitTool.sleep(4);
		SeleniumFunction.click(create.saveboard());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "Board Saved");
		SeleniumFunction.click(create.okbutton());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "After saving board details");


	}
}
