package com.qualitesoft.homesquare.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardBoardPage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardCreatePage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardOverviewPage;

public class TestEditMuzeboardDetails extends InitializeTest{
	
	@Test
	public void testEditMuzeboardDetails(){
		
		
		MuzeboardCreatePage muzeboardCreatePage = new MuzeboardCreatePage(driver);
		SeleniumFunction.click(muzeboardCreatePage.viewYourBoardLink());
		
		MuzeboardBoardPage muzeboardBoardPage = new MuzeboardBoardPage(driver);
		muzeboardBoardPage.shopTheLookText();
		ScreenShot.takeScreenShot(driver, "MuzeboardBoardPage");
		Log.info("Text found: " + SeleniumFunction.getText(muzeboardBoardPage.shopTheLookText()));
		muzeboardBoardPage.addToCartButton();
		SeleniumFunction.click(muzeboardBoardPage.boardLink());
		muzeboardBoardPage.boardEditLink();
		ScreenShot.takeScreenShot(driver, "MuzeboardEditPage");
		SeleniumFunction.click(muzeboardBoardPage.boardEditLink());
		
		muzeboardCreatePage.backgroundTabLink();
		ScreenShot.takeScreenShot(driver, "BoardBuilderPage");
		SeleniumFunction.click(muzeboardCreatePage.backgroundTabLink());
		
		Point coordinates = muzeboardCreatePage.searchItemBackground().getLocation();
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
		SeleniumFunction.click(muzeboardCreatePage.saveButton());
		WebElement boardNameTextbox = muzeboardCreatePage.boardNameTextbox();
		ScreenShot.takeScreenShot(driver, "InfoPopup");
		SeleniumFunction.click(muzeboardCreatePage.saveBoardButton());
		WaitTool.sleep(16);
		ScreenShot.takeScreenShot(driver, "BoardSaved");
		SeleniumFunction.click(muzeboardCreatePage.backToBoardsLink());
		
		MuzeboardOverviewPage muzeboardOverviewPage = new MuzeboardOverviewPage(driver);
		muzeboardOverviewPage.favouritesTab();
		ScreenShot.takeScreenShot(driver, "OverviewPage");
	}

}
