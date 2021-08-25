package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestProfileManagement extends InitializeTest {

	@Test
	public void testEnabletCarriers() throws InterruptedException {
			String[] carrierNames=carrierName.split(",");
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			QuickQuote quickQuote = new QuickQuote(driver);
			WaitTool.sleep(2);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "test.automation@mailinator.com");
			profileManagementPage.profileListfilter().sendKeys(Keys.TAB);
			WaitTool.sleep(10);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='User:']"),30));
			ScreenShot.takeScreenShot(driver, "Search User details");
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#carriersTab']"), 10));
			WaitTool.sleep(5);
			profileManagementPage.enableCarrier(carrierNames);
			ScreenShot.takeScreenShot(driver, "Enable Carriers");
	}
	
	@Test
	public void testDisableCarriers() {

		try{
			String[] carrierNames=carrierName.split(",");
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "test.automation@mailinator.com");
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
	
	@Test
	public void testEnableCustomOrder() {

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
			profileManagementPage.enableTruckLoad(enableOption);
			ScreenShot.takeScreenShot(driver, "Custom Order Button Enabled");
			SeleniumFunction.click(profileManagementPage.saveProfileButtonSurePost());
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
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Contact Name:']"), 30));
			WaitTool.sleep(5);
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			profileManagementPage.disableTruckLoad(enableOption);
			ScreenShot.takeScreenShot(driver, "Custom Order Button disabled");
			SeleniumFunction.click(profileManagementPage.saveProfileButtonSurePost());
			WaitTool.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
