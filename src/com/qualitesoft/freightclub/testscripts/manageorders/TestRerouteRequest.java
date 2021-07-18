package com.qualitesoft.freightclub.testscripts.manageorders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.OrderDetailPage;

public class TestRerouteRequest extends InitializeTest{

	@Test
	public void verifyRerouteLink(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		openManageOrdersPageAndSearchOrder("51487559");

		SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
		boolean status = manageOrderpage.requestRerouteIsPresent();
		Assert.assertEquals(status, true);

		manageOrderpage.clickRequestRerouteLink();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Reroute Request Popup");
	}
	@Test
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

	}

	@Test
	public void validateFieldsForLocationType(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		validateRerouteRequestPopupFields("Residential", true, false);
		validateRerouteRequestPopupFields("Commercial", false, false);
		UseAssert.assertEquals(manageOrderpage.locationType(2).isDisplayed(), true);
		UseAssert.assertEquals(manageOrderpage.locationType(3).isDisplayed(), true);
		validateRerouteRequestPopupFields("Amazon FBA Warehouse", false, false);
	}

	@Test
	public void fillReroutePopupFields(){
		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
		int i=Integer.parseInt(Row);
		fillRerouteRequestPopup(xr1.getCellData("Reroute Request", "Residential Location", i));
	}

	@Test
	public void verifyRerouteRequestOnDetailPage(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		OrderDetailPage orderDetailPage =new OrderDetailPage(driver);

		openManageOrdersPageAndSearchOrder("51487559");

		SeleniumFunction.click(manageOrderpage.ViewDetail());

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab		
		WaitTool.sleep(3);

		String warningMessage = orderDetailPage.verifyRerouteWarningMessage();
		UseAssert.assertEquals(warningMessage, "Order Pending Reroute. Reroute was requested on " + JavaFunction.currentDateUSFormat());

		driver.close();
		driver.switchTo().window(newTab.get(0));
	}

	@Test
	public void acceptRequestByAdmin(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

		if(manageOrderpage.acceptFeedbackPopupStatus() == true){
			manageOrderpage.acceptFeedbackPopup();
		}
		
		openManageOrdersPageAndSearchOrder("51487559");
		SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
		manageOrderpage.clickConfirmReroute();
		String successMessage = manageOrderpage.verifyToastMessage();
		UseAssert.assertEquals(successMessage, "Reroute successfully confirmed.");
	}
	
	@Test
	public void deniedRequestByAdmin(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

		if(manageOrderpage.acceptFeedbackPopupStatus() == true){
			manageOrderpage.acceptFeedbackPopup();
		}
		openManageOrdersPageAndSearchOrder("51487559");
		SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
		manageOrderpage.clickDeniedReroute();
		
		String rerouteDeniedPopup = SeleniumFunction.getText(manageOrderpage.deniedReroutePopup());
		UseAssert.assertEquals(rerouteDeniedPopup, "Reroute Denied");
		manageOrderpage.setRerouteDeniedReason("Incorrect address reroute denied reason");
		manageOrderpage.clickProceedDenialBtn();
		String successMessage = manageOrderpage.verifyToastMessage();
		UseAssert.assertEquals(successMessage, "Reroute successfully denied.");
	}

	@Test
	public void verifyRerouteLocationOnDetailPage(){
		openManageOrdersPageAndSearchOrder("51487559");
		verifyUpdatedDetailsOnDetailPage();
	}

	@Test
	public void verifyRerouteDetailPage(){
		openManageOrdersPageAndSearchOrder("51487559");
		verifyUpdatedDetailsOnDetailPage();
	}
	
	public static void validateRerouteRequestPopupFields(String locationType, boolean value1,boolean value2){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		SeleniumFunction.selectByVisibleText(manageOrderpage.locationType(1), locationType);
		WaitTool.sleep(2);
		UseAssert.assertEquals(manageOrderpage.checkboxStatus(1).isSelected(), value1);
		UseAssert.assertEquals(manageOrderpage.checkboxStatus(2).isSelected(), value2);
	}

	public static void openManageOrdersPageAndSearchOrder(String orderId){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		SeleniumFunction.click(manageOrderpage.manageOrdersLink());
		manageOrderpage.ActionButton();

		ScreenShot.takeScreenShot(driver, "Manage Order for request reroute");

		if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
			SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		}

		manageOrderpage.searchFields("1", orderId);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(10);
	}
	
	public static void fillRerouteRequestPopup(String locationType){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
		int i=Integer.parseInt(Row);

		SeleniumFunction.selectByVisibleText(manageOrderpage.locationType(1), locationType);
		WaitTool.sleep(2);

		manageOrderpage.fillRerouteRequestForm("1", xr1.getCellData("Reroute Request", "Location Name", i));
		manageOrderpage.fillRerouteRequestForm("2", xr1.getCellData("Reroute Request", "Address", i));
		manageOrderpage.fillRerouteRequestForm("3", xr1.getCellData("Reroute Request", "City", i));
		manageOrderpage.fillRerouteRequestForm("4", xr1.getCellData("Reroute Request", "State", i));
		manageOrderpage.fillRerouteRequestForm("5", xr1.getCellData("Reroute Request", "Zip Code", i));
		manageOrderpage.fillRerouteRequestForm("6", xr1.getCellData("Reroute Request", "Country", i));
		manageOrderpage.clickSendRequestBtn();
		String successMessage = manageOrderpage.verifyToastMessage();
		UseAssert.assertEquals(successMessage, "Reroute successfully requested.");
	}
	
	public static void verifyUpdatedDetailsOnDetailPage(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		OrderDetailPage orderDetailPage =new OrderDetailPage(driver);

		SeleniumFunction.click(manageOrderpage.ViewDetail());

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab		
		WaitTool.sleep(3);

		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
		int i=Integer.parseInt(Row);

		String locationName = xr1.getCellData("Reroute Request", "Location Name", i);
		String address = xr1.getCellData("Reroute Request", "Address", i);
		String city =  xr1.getCellData("Reroute Request", "City", i);
		String state =  xr1.getCellData("Reroute Request", "State", i);
		String zipCode =  xr1.getCellData("Reroute Request", "Zip Code", i);
		
		UseAssert.assertEquals(orderDetailPage.verifyRerouteLocationType(1), locationName + " (Residential)");
		UseAssert.assertEquals(orderDetailPage.verifyRerouteLocationType(2), "Extra Services");

		UseAssert.assertEquals(orderDetailPage.verifyRerouteUpdatedData(1), address + "\n" + city + ", " + state + " " + zipCode);
		UseAssert.assertEquals(orderDetailPage.verifyRerouteUpdatedData(2), "Delivery Appointment Required");

		driver.close();
		driver.switchTo().window(newTab.get(0));
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
