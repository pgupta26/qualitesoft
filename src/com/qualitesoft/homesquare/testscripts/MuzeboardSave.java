package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardCreatePage;

public class MuzeboardSave extends InitializeTest{
	
	@Test
	public void testSaveBoard(){
		
		MuzeboardCreatePage muzeboardCreatePage = new MuzeboardCreatePage(driver);
		SeleniumFunction.click(muzeboardCreatePage.saveButton());
		WebElement boardNameTextbox = muzeboardCreatePage.boardNameTextbox();
		ScreenShot.takeScreenShot(driver, "InfoPopup");
		SeleniumFunction.sendKeys(boardNameTextbox, "Selenium_Board");
		SeleniumFunction.sendKeys(muzeboardCreatePage.descriptionTextbox(), "Selenium_Description");
		//SeleniumFunction.sendKeys(muzeboardCreatePage.tagsTextbox(), "Selenium_Tags");
		
		muzeboardCreatePage.uploadInspiredPicChrome();
		WaitTool.sleep(2);
		
		ScreenShot.takeScreenShot(driver, "InfoPopupFilled");
		SeleniumFunction.click(muzeboardCreatePage.saveBoardButton());
		WaitTool.sleep(16);
		ScreenShot.takeScreenShot(driver, "SeleniumBoard");
	}
}
