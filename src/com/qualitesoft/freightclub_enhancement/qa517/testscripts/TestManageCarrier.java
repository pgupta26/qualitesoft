package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub_enhancement.qa517.pageobjects.ManageCarrierPage;

public class TestManageCarrier extends InitializeTest{

	@Test
	public void testEnableResidentialPickup() {
		try{
			String[] carrierNames=carrierName.split(",");
			ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);
			manageCarrierPage.manageCarriersLink();
			for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
				WaitTool.sleep(5);
				manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
				WaitTool.sleep(5);
				SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				manageCarrierPage.selectResidentialPickUp();
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 10));
				ScreenShot.takeScreenShot(driver, "Enable Residential PickUp");
			}
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testEnableLooseCartoonAccepted() {
		try{
			String[] carrierNames=carrierName.split(",");
			ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);

			manageCarrierPage.manageCarriersLink();
			for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
				WaitTool.sleep(5);
				manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
				WaitTool.sleep(5);
				SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				manageCarrierPage.selectLooseCartoon();
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 10));
				WaitTool.sleep(5);
				ScreenShot.takeScreenShot(driver, "Enable Loose Cartoon");
			}
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testDisableLooseCartoonAccepted() {
		try{
			String[] carrierNames=carrierName.split(",");
			ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);

			manageCarrierPage.manageCarriersLink();
			for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
				WaitTool.sleep(5);
				manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
				WaitTool.sleep(5);
				SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				manageCarrierPage.unselectLooseCartoon();
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 10));
				WaitTool.sleep(5);
				ScreenShot.takeScreenShot(driver, "Disable Loose Cartoon");
			}
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
