package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardCreatePage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardOverviewPage;

public class MuzeboardOverview extends InitializeTest{
	
	@Test
	public void testMuzeboardOverview(){
		
		WebDriver driver = getDriver();
		
		MuzeboardOverviewPage muzeboardOverviewPage = new MuzeboardOverviewPage(driver);
		SeleniumFunction.click(muzeboardOverviewPage.favouritesTab());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "FavouritesTab");
		SeleniumFunction.click(muzeboardOverviewPage.muzeboardsTab());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "MuzeboardTabTab");
		SeleniumFunction.click(muzeboardOverviewPage.overviewTab());
		SeleniumFunction.click(muzeboardOverviewPage.createMuzeboardButton());	
		
		MuzeboardCreatePage muzeboardCreatePage = new MuzeboardCreatePage(driver);
		muzeboardCreatePage.searchTextbox();
		ScreenShot.takeScreenShot(driver, "CreateMuzeboardPage");
	}
}
