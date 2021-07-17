package com.qualitesoft.freightclub.testscripts.manageorders;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestInitiateClaim extends InitializeTest{

	@Test
	public void testInitiateClaim(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			
			manageOrderpage.ActionButton();
			manageOrderpage.selectStatus(testData);
			ScreenShot.takeScreenShot(driver, "Manage Order with selected status");

			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}
			WaitTool.sleep(2);
			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			manageOrderpage.initiateClaim();
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Initiate Claim Popup");

			WebElement popupHeader = manageOrderpage.initiateClaimPopup();
			String popHeader = SeleniumFunction.getText(popupHeader);
			Assert.assertEquals(popHeader, "Initiate Claim");
			
			manageOrderpage.selectClaimType(Row);
			manageOrderpage.clickInitiateClaimButton();
			
			//Navigate to Update Order Page
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.close();
			driver.switchTo().window(newTab.get(0));

		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}

