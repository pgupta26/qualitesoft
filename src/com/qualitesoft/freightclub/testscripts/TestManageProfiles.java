package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestManageProfiles extends InitializeTest{
	
	@Test
	public void testManageProfiles(){
		
		ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
		QuickQuote quickQuote = new QuickQuote(driver);
		SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "ProfileManagementPage");
		SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "17226");
		profileManagementPage.profileListfilter().sendKeys(Keys.TAB);
		WaitTool.sleep(10);
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='User:']"),30));
		
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    WaitTool.sleep(9);
	    jse.executeScript("window.scrollBy(0,550)", "");
	    SeleniumFunction.selectByVisibleText(profileManagementPage.paymentType(), "OnAccount");
	    WaitTool.sleep(5);
	    ScreenShot.takeScreenShot(driver, "OnAccount Payment Selected");		
		jse.executeScript("window.scrollBy(0,1550)", "");
		WaitTool.sleep(5);
		SeleniumFunction.click(profileManagementPage.saveProfileButtonSurePost());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Profile Updated Succesfully");
		WaitTool.sleep(5);
	}
}
