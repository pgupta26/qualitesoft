package com.qualitesoft.freightclub.testscripts.manageorders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestRerouteRequest extends InitializeTest{

	@Test(priority = 1)
	public void verifyRerouteLink(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		SeleniumFunction.click(manageOrderpage.manageOrdersLink());
		manageOrderpage.ActionButton();

		ScreenShot.takeScreenShot(driver, "Manage Order for request reroute");

		if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
			SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		}
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
		boolean status = manageOrderpage.requestRerouteIsPresent();
		Assert.assertEquals(status, true);
		
		manageOrderpage.requestReroute();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Reroute Request Popup");
	}
	@Test(priority = 2)
	public void verifyReroutePopupValidation(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		String popHeader = SeleniumFunction.getText(manageOrderpage.requestReroutePopup());
		Assert.assertEquals(popHeader, "Delivery Reroute Request");

		manageOrderpage.clickSendRequestBtn();
		List<String> actualList = new ArrayList<String>();
		List<String> expectedList = new ArrayList<String>(Arrays.asList("Location Type is required", 
				"Address Line 1 is required", "City is required","State is required","Zip Code is required"
				,"Country is required"));
		
		for(int i=0; i<6; i++){
			String validation = manageOrderpage.getFieldValidation(i+1);
			actualList.add(validation);
		}
		
		Assert.assertEquals(actualList, expectedList);
		
		manageOrderpage.fillRerouteRequestForm("1", "Test Location");
		
	}
	
	@Test(priority = 3)
	public void fillReroutePopupFields(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		manageOrderpage.fillRerouteRequestForm("1", "Test Location");
		
	}

	@DataProvider(name = "RerouteDeliveryData")
	public Object[][] deliveryData(){
		return new Object[][]{
			{"location", "Test Location"},
			{"address", "#123, Los Angeles"},
			{"city", "Los Angeles"},
			{"state", "AL"},
			{"zip", "35004"},
			{"country", "US"}
		};
	}
}
