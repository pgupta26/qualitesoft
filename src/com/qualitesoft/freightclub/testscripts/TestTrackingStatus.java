package com.qualitesoft.freightclub.testscripts;

import java.util.ArrayList;

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
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "ManageOrdersPage");
		
		//picked order id from excel
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		String orderid=xr.getCellData("Input","OrderId", 5).trim();
		
		String[] trackingStatus = {"InTransit","Delivered"};
		
		for(int trackingIndex=0; trackingIndex < trackingStatus.length; trackingIndex++) {
			
			SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(10);
			
			SeleniumFunction.click(landingPage.ViewDetail());
			WaitTool.sleep(10);
			ScreenShot.takeScreenShot(driver, "ViewDetailsPage");
			WaitTool.sleep(5);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab
			SeleniumFunction.click(landingPage.admintabButton());
			SeleniumFunction.click(landingPage.editButton());
			//Navigate to Update Order Page		
			WaitTool.sleep(5);
			ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab1.get(2));//move to second tab
			WaitTool.sleep(3);
			
			UpdateTrackingStatusPage updateTrackingStatusPage = new UpdateTrackingStatusPage(driver);
			jse.executeScript("window.scrollBy(0,650)", "");
			ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPage");	
			SeleniumFunction.click(updateTrackingStatusPage.trackingId());
			updateTrackingStatusPage.trackingIdDropdown(trackingStatus[trackingIndex]);
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
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
	    WaitTool.sleep(5);
		SeleniumFunction.clickJS(driver,landingPage.trackingNoLink());
		WaitTool.sleep(5);        
		ArrayList<String> newTab6 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab6.get(1));
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,650)", "");
		ScreenShot.takeScreenShot(driver, "TrackShipmentPage");
		driver.close();
		driver.switchTo().window(newTab6.get(0));
	}
}
