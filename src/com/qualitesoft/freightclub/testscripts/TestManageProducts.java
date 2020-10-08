package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestManageProducts extends InitializeTest {

	@Test
	public void testManageProducts() {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.manageProductLink();
		//ScreenShot.takeScreenShot(driver, "ManageProductsPage");
		SeleniumFunction.clickJS(driver, landingPage.manageProductLink());
		landingPage.uploadFileProductChrome();
		SeleniumFunction.clickAction(driver, landingPage.uploadButton());
		landingPage.OKButton();
		landingPage.sucessMsgManageProducts();
		SeleniumFunction.clickJS(driver, landingPage.OKButton());
		ScreenShot.takeScreenShot(driver, "ManageProductsUploaded");
	}

}
