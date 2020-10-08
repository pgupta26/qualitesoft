package com.qualitesoft.homesquare.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardCreatePage;

public class MuzeboardNewBoardCreation extends InitializeTest {

	@Test
	public void testNewBoardCreation() {

		MuzeboardCreatePage muzeboardCreatePage = new MuzeboardCreatePage(driver);
		SeleniumFunction.sendKeys(muzeboardCreatePage.searchTextbox(), "chairs");
		SeleniumFunction.click(muzeboardCreatePage.searchButton());
		// muzeboardCreatePage.searchItems();
		ScreenShot.takeScreenShot(driver, "SearchResults");

		muzeboardCreatePage.searchItem();
		WaitTool.sleep(240);
		Point coordinates = muzeboardCreatePage.searchItem().getLocation();
		Robot robot = null;
		try {
			robot = new Robot();
			robot.mouseMove(coordinates.getX() + 30, coordinates.getY() + 75);
			WaitTool.sleep(2);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			WaitTool.sleep(2);
			robot.mouseMove(coordinates.getX() - 100, coordinates.getY() + 75);
			WaitTool.sleep(2);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			Log.error(e.getMessage());
		}

		ScreenShot.takeScreenShot(driver, "DragAndDropped");
	}
}
