package com.qualitesoft.freightclubPh2.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.SignInPage;

public class TestManageProfiles extends InitializeTest{
	
	@Test
	public void testManageProfiles(){
		
		ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
		profileManagementPage.manageProfileLink();
		SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
		ScreenShot.takeScreenShot(driver, "ProfileManagementPage");
		//profileManagementPage.companyNameLink();	
		//SeleniumFunction.click(profileManagementPage.companyNameLink());
		//SeleniumFunction.click(profileManagementPage.profileListfilter());
	    SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "10011");//10685
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    WaitTool.sleep(10);
	    jse.executeScript("window.scrollBy(0,550)", "");
	    SeleniumFunction.click(profileManagementPage.paymentType());
	    WaitTool.sleep(3);
        profileManagementPage.paymentTypeOptions("OnAccount");
	    WaitTool.sleep(5);
	    ScreenShot.takeScreenShot(driver, "OnAccount Payment Selected");		
		jse.executeScript("window.scrollBy(0,550)", "");
		WaitTool.sleep(5);
		if(Row.equalsIgnoreCase("M Store")) {
			String isChecked=driver.findElement(By.xpath("//div[@class='margin-bottom-20 margin-top-5']/input[2]")).getAttribute("disabled");
			if(!(isChecked == null)) {
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='margin-bottom-20 margin-top-5']/input[1]"), 10));
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='margin-bottom-20 margin-top-5']/input[2]"), 10));
			}
    	}
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,1250)", "");
		//change on 1st Nov
		SeleniumFunction.click(profileManagementPage.saveProfileButtonSurePost());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Profile Updated Succesfully");
		WaitTool.sleep(5);
	}
}
