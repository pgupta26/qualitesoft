package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardBoardPage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardCreatePage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardDetailsPage;

public class MuzeboardPublish extends InitializeTest{
	
	@Test
	public void testPublishBoard(){
		
		MuzeboardCreatePage muzeboardCreatePage = new MuzeboardCreatePage(driver);
		SeleniumFunction.click(muzeboardCreatePage.publishButton());
		ScreenShot.takeScreenShot(driver, "InfoPopupFilled");
		SeleniumFunction.click(muzeboardCreatePage.saveBoardButton());
		WaitTool.sleep(8);
		MuzeboardBoardPage muzeboardBoardPage = new MuzeboardBoardPage(driver);
		muzeboardBoardPage.boardLink();
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "MuzeboardBoardPage");	
		
		SeleniumFunction.click(muzeboardBoardPage.boardLink());
		SeleniumFunction.click(muzeboardBoardPage.boardEditLink());
		
	}
}
