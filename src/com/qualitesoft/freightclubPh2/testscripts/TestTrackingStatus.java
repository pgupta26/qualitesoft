package com.qualitesoft.freightclubPh2.testscripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.UpdateTrackingStatusPage;

public class TestTrackingStatus extends InitializeTest{
	
	@Test
	public void testTrackingStatus(){
		
		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		//landingPage.veiwDetailButton();
		ScreenShot.takeScreenShot(driver, "ManageOrdersPage");
		
		//picked order id from excel
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
        /*Pickup status*/
		String orderid=xr.getCellData("Input","OrderId", 3).trim();
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
	    WaitTool.sleep(5);
		
		SeleniumFunction.click(landingPage.ViewDetail());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "ViewDetailsPage");
		SeleniumFunction.click(landingPage.updateTrackingStatusButton());		
		//Navigate to Update Order Page
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		
		UpdateTrackingStatusPage updateTrackingStatusPage = new UpdateTrackingStatusPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPage");		
		SeleniumFunction.click(updateTrackingStatusPage.trackingId());
		updateTrackingStatusPage.trackingIdDropdown("PickedUp");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.cityTextfield(), "Selenium_City");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.zipTextfield(), "92010");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.stateTextfield(), "CA");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPageFilled");
		SeleniumFunction.clickAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield());
		SeleniumFunction.sendKeysAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield(), "01-01-2021");
		WaitTool.sleep(4);
		SeleniumFunction.click(updateTrackingStatusPage.submitButton());
		WaitTool.sleep(5);
		
        /*InTransit status*/
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
	    WaitTool.sleep(5);
		
		SeleniumFunction.click(landingPage.ViewDetail());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "ViewDetailsPage");
		SeleniumFunction.click(landingPage.updateTrackingStatusButton());		
		//Navigate to Update Order Page
		ArrayList<String> newTab3 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab3.get(2));//move to second tab
		jse.executeScript("window.scrollBy(0,650)", "");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPage");
		WaitTool.sleep(5);
		SeleniumFunction.click(updateTrackingStatusPage.trackingId());
		updateTrackingStatusPage.trackingIdDropdown("InTransit");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.cityTextfield(), "Selenium_City");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.zipTextfield(), "92010");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.stateTextfield(), "CA");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPageFilled");
		SeleniumFunction.clickAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield());
		SeleniumFunction.sendKeysAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield(), "01-01-2019");
		WaitTool.sleep(4);
		SeleniumFunction.click(updateTrackingStatusPage.submitButton());
		WaitTool.sleep(5);
		
        /*Delivered status*/
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
	    WaitTool.sleep(5);
		
		SeleniumFunction.click(landingPage.ViewDetail());
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "ViewDetailsPage");
		//jse.executeScript("window.scrollBy(0,-250)", "");
		SeleniumFunction.click(landingPage.updateTrackingStatusButton());		
		//Navigate to Update Order Page
		ArrayList<String> newTab4 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab4.get(3));//move to second tab
		jse.executeScript("window.scrollBy(0,650)", "");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPage");		
		SeleniumFunction.click(updateTrackingStatusPage.trackingId());
		updateTrackingStatusPage.trackingIdDropdown("Delivered");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.cityTextfield(), "Selenium_City");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.zipTextfield(), "92010");
		SeleniumFunction.sendKeys(updateTrackingStatusPage.stateTextfield(), "CA");
		ScreenShot.takeScreenShot(driver, "UpdateTrackingStatusPageFilled");
		SeleniumFunction.clickAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield());
		SeleniumFunction.sendKeysAction(driver, updateTrackingStatusPage.dateOfUpdateTextfield(), "01-01-2019");
		WaitTool.sleep(4);
		SeleniumFunction.click(updateTrackingStatusPage.submitButton());
		WaitTool.sleep(5);
		
		/*TrackShipmentPage*/
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
	    WaitTool.sleep(5);
		SeleniumFunction.clickJS(driver,landingPage.trackingNoLink());
		WaitTool.sleep(5);        
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab1.get(4));//move to tracking page 
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,650)", "");
		ScreenShot.takeScreenShot(driver, "TrackShipmentPage");
		driver.close();
		driver.switchTo().window(newTab1.get(0));
		SeleniumFunction.click(landingPage.Okbutton1());
	}

}
