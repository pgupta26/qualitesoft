package com.qualitesoft.freightclub.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.UpdateTrackingStatusPage;

public class TestTrackingStatus extends InitializeTest{
	
	@Test
	public void testTrackingStatus(){
		
		QuickQuote quickQuote = new QuickQuote(driver);
		LandingPage landingPage = new LandingPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "ManageOrdersPage");
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		
		for(int i=8;i<=10;i++)
		{
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			String[] trackingStatus = {"In Transit","Delivered"};
			
			for(int trackingIndex=0; trackingIndex < trackingStatus.length; trackingIndex++) {
				
				SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
				SeleniumFunction.KeyBoradEnter(driver);
			    WaitTool.sleep(5);
				
				SeleniumFunction.click(landingPage.ViewDetail());
				WaitTool.sleep(5);
				ScreenShot.takeScreenShot(driver, "ViewDetailsPage");
				WaitTool.sleep(2);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(newTab.get(1));//move to second tab
				WaitTool.sleep(5);
				quickQuote.acceptPopup();
				WaitTool.sleep(2);
				SeleniumFunction.click(landingPage.admintabButton());
				SeleniumFunction.scrollDownByPixel(driver, "150");
				SeleniumFunction.click(landingPage.editButton());
				//Navigate to Update Order Page		
				WaitTool.sleep(5);
				ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(newTab1.get(2));//move to second tab
				WaitTool.sleep(3);
				
				UpdateTrackingStatusPage updateTrackingStatusPage = new UpdateTrackingStatusPage(driver);
				jse.executeScript("window.scrollBy(0,650)", "");
				//SeleniumFunction.click(updateTrackingStatusPage.trackingId());
				SeleniumFunction.selectByVisibleText(WaitTool.waitForElementPresentAndDisplay(driver, By.id("OrderStatusType"), 20), trackingStatus[trackingIndex]);
				//updateTrackingStatusPage.trackingIdDropdown(trackingStatus[trackingIndex]);
				SeleniumFunction.sendKeys(updateTrackingStatusPage.cityTextfield(), "Selenium_City");
				SeleniumFunction.sendKeys(updateTrackingStatusPage.zipTextfield(), "92010");
				SeleniumFunction.sendKeys(updateTrackingStatusPage.stateTextfield(), "CA");
				ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPageFilled");
				SeleniumFunction.clickAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield());
				SeleniumFunction.sendKeysAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield(), "01-01-2019");
				WaitTool.sleep(4);
				SeleniumFunction.scrollDownUptoFooter(driver);
				SeleniumFunction.click(updateTrackingStatusPage.submitButton());
				WaitTool.sleep(5);
				driver.close();
				driver.switchTo().window(newTab1.get(1));
				driver.close();
				driver.switchTo().window(newTab.get(0));
			}
			
			/*TrackShipmentPage*/
			WaitTool.sleep(2);
			SeleniumFunction.clickJS(driver,landingPage.trackingNoLink());
			WaitTool.sleep(2);        
			ArrayList<String> newTab6 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab6.get(1));
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,650)", "");
			ScreenShot.takeScreenShot(driver, "TrackShipmentPage");
			driver.close();
			driver.switchTo().window(newTab6.get(0));
		}
	}
}
