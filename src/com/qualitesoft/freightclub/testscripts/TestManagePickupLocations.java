package com.qualitesoft.freightclub.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagePickupLocationsPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestManagePickupLocations extends InitializeTest{
	
	@Test
	public void testManagePickupLocations(){
		ManagePickupLocationsPage managePickupLocationsPage = new ManagePickupLocationsPage(driver);
		SeleniumFunction.clickJS(driver, managePickupLocationsPage.managePickupLocLink());
		managePickupLocationsPage.addNewPickupLocButton();
		ScreenShot.takeScreenShot(driver, "ManagePickupLocPage");
		SeleniumFunction.clickJS(driver, managePickupLocationsPage.addNewPickupLocButton());
		ScreenShot.takeScreenShot(driver, "ManagePickupLocDetailPage");
		SeleniumFunction.sendKeys(managePickupLocationsPage.locNameTextfield(), location());
		WaitTool.sleep(2);
		SeleniumFunction.sendKeys(managePickupLocationsPage.address1Textfield(), "Selenium_Address");
		SeleniumFunction.sendKeys(managePickupLocationsPage.postalCodeTextfield(), "90210");
		SeleniumFunction.sendKeys(managePickupLocationsPage.firstNameTextfield(), "Selenium_First");
		SeleniumFunction.sendKeys(managePickupLocationsPage.lastNameTextfield(), "Selenium_Last");
		SeleniumFunction.sendKeys(managePickupLocationsPage.phonenoTextfield(), "9632587415");
		SeleniumFunction.sendKeys(managePickupLocationsPage.emailTextfield(), "selenium@selenium.com");
		ScreenShot.takeScreenShot(driver, "Filled Shipment info");
		SeleniumFunction.clickJS(driver, managePickupLocationsPage.saveButton());
		WaitTool.sleep(2);
		
	}
	
	private static String location() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String emailAddress = "Selenium_Location" + dateFormat.format(date).replaceAll("\\s", "_");
		return emailAddress;
	}
}
