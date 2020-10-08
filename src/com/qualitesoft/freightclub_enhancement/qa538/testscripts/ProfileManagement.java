package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class ProfileManagement extends InitializeTest {
	
	@Test
	public void testEnableCustomOrder() {
		
		try{
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			QuickQuote quick = new QuickQuote(driver);

			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Making freight club better"+JavaFunction.getRandomNumber(100, 1000));
			quick.acceptPopup();
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), searchUser);
			WaitTool.sleep(15);
			ScreenShot.takeScreenShot(driver, "Search User details");
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Contact Name:']"), 10));
			WaitTool.sleep(5);
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			WaitTool.sleep(1);
			profileManagementPage.enableTruckLoad(enableOption);
			ScreenShot.takeScreenShot(driver, "Custom Order Button Enabled");
			SeleniumFunction.click(profileManagementPage.saveProfileBtn());
			WaitTool.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testDisableCustomOrder() {
		
		try{
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			QuickQuote quick = new QuickQuote(driver);
			
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			WaitTool.sleep(2);
			quick.acceptPopup();
			WaitTool.sleep(2);
			
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), searchUser);
			WaitTool.sleep(15);
			ScreenShot.takeScreenShot(driver, "Search User details");
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Contact Name:']"), 10));
			WaitTool.sleep(5);
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			profileManagementPage.disableTruckLoad(enableOption);
			ScreenShot.takeScreenShot(driver, "Custom Order Button disabled");
			SeleniumFunction.click(profileManagementPage.saveProfileBtn());
			WaitTool.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
