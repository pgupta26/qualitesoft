package com.qualitesoft.freightclub.testscripts.manageprofiles;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEnableCustomOrder extends InitializeTest {

	@Test
	public void testEnableCustomOrder() {
		ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
		SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
		profileManagementPage.enableTruckLoad(enableOption);
		ScreenShot.takeScreenShot(driver, "Custom Order Button Enabled");
		SeleniumFunction.click(profileManagementPage.saveProfileButtonSurePost());
		WaitTool.sleep(5);

	}
}
