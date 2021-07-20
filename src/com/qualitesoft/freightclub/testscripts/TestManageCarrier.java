package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManageCarrierPage;

public class TestManageCarrier extends InitializeTest{

	@Test 
	public void testEnableCarrierDetailsOptions() {
		String[] carrierNames=carrierName.split(",");
		
		ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);
		manageCarrierPage.manageCarriersLink();
		for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
			WaitTool.sleep(5);
			manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
			WaitTool.sleep(5);
			SeleniumFunction.scrollDownByPixel(driver, "1600");
			WaitTool.sleep(5);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 30));
			String[] carrierDetailsOption=carrierDetailsOptions.split(",");
			for(int i=0; i<carrierDetailsOption.length; i++) {
				if(!manageCarrierPage.carrierDetailsOptions(carrierDetailsOption[i]).isSelected()) {
					SeleniumFunction.click(manageCarrierPage.carrierDetailsOptions(carrierDetailsOption[i]));
				}
				WaitTool.sleep(2);
			}	
			SeleniumFunction.scrollDownByPixel(driver, "500");
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 30));
		}
		WaitTool.sleep(2);
	}
	@Test
	public void testEnableResidentialPickup() {
			String[] carrierNames=carrierName.split(",");
			ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);
			manageCarrierPage.manageCarriersLink();
			for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
				WaitTool.sleep(5);
				manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
				WaitTool.sleep(5);
				SeleniumFunction.scrollDownByPixel(driver, "1300");
				WaitTool.sleep(5);
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 30));
				manageCarrierPage.selectResidentialPickUp();
				manageCarrierPage.selectLooseCartoon();
				WaitTool.sleep(5);
				SeleniumFunction.scrollDownByPixel(driver, "500");
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 30));
			}
			WaitTool.sleep(2);
	}
	
	@Test
	public void testDisableLooseCartoonAccepted() {
			String[] carrierNames=carrierName.split(",");
			ManageCarrierPage manageCarrierPage = new ManageCarrierPage(driver);
			manageCarrierPage.manageCarriersLink();
			for(int carriersCount=0; carriersCount<carrierNames.length; carriersCount++) {
				WaitTool.sleep(5);
				manageCarrierPage.filterCarrier(carrierNames[carriersCount]);
				WaitTool.sleep(5);
				SeleniumFunction.scrollDownByPixel(driver, "1300");
				WaitTool.sleep(5);
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Options"), 10));
				manageCarrierPage.unselectLooseCartoon();
				WaitTool.sleep(5);
				SeleniumFunction.scrollDownByPixel(driver, "500");
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Update']"), 10));
				WaitTool.sleep(2);
				ScreenShot.takeScreenShot(driver, "Disable Loose Cartoon");
			}
	}
}
