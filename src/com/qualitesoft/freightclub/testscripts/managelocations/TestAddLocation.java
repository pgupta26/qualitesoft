package com.qualitesoft.freightclub.testscripts.managelocations;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageLocations;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestAddLocation extends InitializeTest {
	
	@Test
	public void testAddLocation(){
		
		Xls_Reader xr=new Xls_Reader(testData);
		int i=Integer.parseInt(Row);
		String companyName = xr.getCellData("Input","CompanyName", i).trim();
		String addressLine1 = xr.getCellData("Input","AddressLine1", i).trim();
		String zipCode = xr.getCellData("Input", "ZipCode", i).trim();	
		String locationType = xr.getCellData("Input", "LocationType", i).trim();
		String earliestPickUp = xr.getCellData("Input", "EarliestPickUp", i).trim();
		String latestPickUp=xr.getCellData("Input","LatestPickUp", i).trim();
		String earliestDropOff = xr.getCellData("Input", "EarliestDropOff", i).trim();	
		String latestDropOff = xr.getCellData("Input", "LatestDropOff", i).trim();
		String contactType = xr.getCellData("Input", "ContactType", i).trim();
		String firstName=xr.getCellData("Input","FirstName", i).trim();
		String lastName=xr.getCellData("Input","LastName", i).trim();
		String phone=xr.getCellData("Input","Phone", i).trim();
		String email=xr.getCellData("Input","Email", i).trim();
		
		ManageLocations manageLocationsPage = new ManageLocations(driver);
		
		SeleniumFunction.clickJS(driver, manageLocationsPage.manageLocationsLink());
		
		if(!manageLocationsPage.isLocationExist(companyName)) {
			//click manage locations link
			manageLocationsPage.addNewPickupLocButton();
			ScreenShot.takeScreenShot(driver, "ManageLocationsPage");
			
			//click add new location button
			SeleniumFunction.clickJS(driver, manageLocationsPage.addNewPickupLocButton());
			
			//enter location details
			SeleniumFunction.sendKeys(manageLocationsPage.companyNameTextfield(), companyName);
			SeleniumFunction.sendKeys(manageLocationsPage.address1Textfield(), addressLine1);
			SeleniumFunction.sendKeys(manageLocationsPage.postalCodeTextfield(), zipCode);
			SeleniumFunction.selectByVisibleText(manageLocationsPage.locationTypeField(), locationType);
			
			if(locationType.equals("Commercial")) {
				SeleniumFunction.selectByVisibleText(manageLocationsPage.earliestPickUpField(), earliestPickUp);
				SeleniumFunction.selectByVisibleText(manageLocationsPage.latestPickUpField(), latestPickUp);
				SeleniumFunction.selectByVisibleText(manageLocationsPage.earliestDropOffField(), earliestDropOff);
				SeleniumFunction.selectByVisibleText(manageLocationsPage.latestDropOffField(), latestDropOff);
			}
			SeleniumFunction.selectByVisibleText(manageLocationsPage.contactType(), contactType);
			SeleniumFunction.sendKeys(manageLocationsPage.firstNameTextfield(), firstName);
			SeleniumFunction.sendKeys(manageLocationsPage.lastNameTextfield(), lastName);
			SeleniumFunction.sendKeys(manageLocationsPage.phonenoTextfield(), phone);
			SeleniumFunction.sendKeys(manageLocationsPage.emailTextfield(), email);
			ScreenShot.takeScreenShot(driver, "ManageLocationsDetails");
			SeleniumFunction.clickJS(driver, manageLocationsPage.saveButton());
			WaitTool.sleep(1);
			ScreenShot.takeScreenShot(driver, "LocationSaved");
		} else {
			Log.info("Location "+companyName+" already exist");
			ScreenShot.takeScreenShot(driver, "LocationExist");
		}
	}
}
