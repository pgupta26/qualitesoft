package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestProfileManagement extends InitializeTest {

	@Test
	public void testEnabletCarriers() {

		try{
			String[] carrierNames=carrierName.split(",");
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "prodtest@mailinator.com");
			WaitTool.sleep(10);
			ScreenShot.takeScreenShot(driver, "Search User details");
			QuickQuote quickQuote = new QuickQuote(driver);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#carriersTab']"), 10));
			WaitTool.sleep(5);
			profileManagementPage.enableCarrier(carrierNames);
			ScreenShot.takeScreenShot(driver, "Enable Carriers");

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testDisableCarriers() {

		try{
			String[] carrierNames=carrierName.split(",");
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "prodtest@mailinator.com");
			WaitTool.sleep(10);
			ScreenShot.takeScreenShot(driver, "Search User details");
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#carriersTab']"), 10));
			WaitTool.sleep(5);
			profileManagementPage.disableCarrier(carrierNames);
			ScreenShot.takeScreenShot(driver, "Disable "+carrierNames);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
