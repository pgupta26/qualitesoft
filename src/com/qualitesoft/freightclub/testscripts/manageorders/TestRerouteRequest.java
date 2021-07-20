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
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.OrderDetailPage;

public class TestRerouteRequest extends InitializeTest{

	CommonOps commonOps = new CommonOps();

	@Test
	public void verifyRerouteLink(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			commonOps.openManageOrdersPageAndSearchOrder("51487615");

			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			boolean status = manageOrderpage.requestRerouteIsPresent();
			Assert.assertEquals(status, true);

			manageOrderpage.clickRequestRerouteLink();
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Reroute Request Popup");
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}

	}
	@Test
	public void verifyReroutePopupValidation(){
		try{
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
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void validateFieldsForLocationType(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			validateRerouteRequestPopupFields("Residential", true, false);
			validateRerouteRequestPopupFields("Commercial", false, false);
			UseAssert.assertEquals(manageOrderpage.locationType(2).isDisplayed(), true);
			UseAssert.assertEquals(manageOrderpage.locationType(3).isDisplayed(), true);
			validateRerouteRequestPopupFields("Amazon FBA Warehouse", false, false);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void fillReroutePopupFields(){
		try{
			Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
			int i=Integer.parseInt(Row);
			fillRerouteRequestPopup(xr1.getCellData("Reroute Request", "Residential Location", i));
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void verifyRerouteRequestOnDetailPage(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			OrderDetailPage orderDetailPage =new OrderDetailPage(driver);

			commonOps.openManageOrdersPageAndSearchOrder("51487615");

			SeleniumFunction.click(manageOrderpage.ViewDetail());

			SeleniumFunction.getCurrentWindow(driver);	
			WaitTool.sleep(3);

			String warningMessage = orderDetailPage.verifyRerouteWarningMessage();
			UseAssert.assertEquals(warningMessage, "Order Pending Reroute. Reroute was requested on " + JavaFunction.currentDateUSFormat());

			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void acceptRequestByAdmin(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			if(manageOrderpage.acceptFeedbackPopupStatus() == true){
				manageOrderpage.acceptFeedbackPopup();
			}

			commonOps.openManageOrdersPageAndSearchOrder("51487615");
			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			manageOrderpage.clickConfirmReroute();
			String successMessage = manageOrderpage.verifyToastMessage();
			UseAssert.assertEquals(successMessage, "Reroute successfully confirmed.");
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void deniedRequestByAdmin(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			if(manageOrderpage.acceptFeedbackPopupStatus() == true){
				manageOrderpage.acceptFeedbackPopup();
			}
			commonOps.openManageOrdersPageAndSearchOrder("51487615");
			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			manageOrderpage.clickDeniedReroute();

			String rerouteDeniedPopup = SeleniumFunction.getText(manageOrderpage.deniedReroutePopup());
			UseAssert.assertEquals(rerouteDeniedPopup, "Reroute Denied");
			manageOrderpage.setRerouteDeniedReason("Incorrect address reroute denied reason");
			manageOrderpage.clickProceedDenialBtn();
			String successMessage = manageOrderpage.verifyToastMessage();
			UseAssert.assertEquals(successMessage, "Reroute successfully denied.");
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void verifyRerouteLocationOnDetailPage(){
		try{
			commonOps.openManageOrdersPageAndSearchOrder("51487615");
			verifyUpdatedDetailsOnDetailPage();
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void verifyRerouteDetailPage(){
		try{
			commonOps.openManageOrdersPageAndSearchOrder("51487615");
			verifyUpdatedDetailsOnDetailPage();
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	public static void validateRerouteRequestPopupFields(String locationType, boolean value1,boolean value2){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

		
		SeleniumFunction.selectByVisibleText(manageOrderpage.locationType(1), locationType);
		WaitTool.sleep(2);
		UseAssert.assertEquals(manageOrderpage.checkboxStatus("Delivery Appointment Required").isSelected(), value1);
		UseAssert.assertEquals(manageOrderpage.checkboxStatus("Limited Access").isSelected(), value2);
	}

	public static void fillRerouteRequestPopup(String locationType){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
		int i=Integer.parseInt(Row);

		SeleniumFunction.selectByVisibleText(manageOrderpage.locationType(1), locationType);
		WaitTool.sleep(2);

		manageOrderpage.fillRerouteRequestForm("Location Name", xr1.getCellData("Reroute Request", "Location Name", i));
		manageOrderpage.fillRerouteRequestForm("Address", xr1.getCellData("Reroute Request", "Address", i));
		manageOrderpage.fillRerouteRequestForm("City", xr1.getCellData("Reroute Request", "City", i));
		manageOrderpage.fillRerouteRequestForm("State", xr1.getCellData("Reroute Request", "State", i));
		manageOrderpage.fillRerouteRequestForm("Zip Code", xr1.getCellData("Reroute Request", "Zip Code", i));
		manageOrderpage.fillRerouteRequestForm("Country", xr1.getCellData("Reroute Request", "Country", i));
		manageOrderpage.clickSendRequestBtn();
		String successMessage = manageOrderpage.verifyToastMessage();
		UseAssert.assertEquals(successMessage, "Reroute successfully requested.");
	}

	public static void verifyUpdatedDetailsOnDetailPage(){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		OrderDetailPage orderDetailPage =new OrderDetailPage(driver);

		SeleniumFunction.click(manageOrderpage.ViewDetail());

		SeleniumFunction.getCurrentWindow(driver);
	
		WaitTool.sleep(3);

		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
		int i=Integer.parseInt(Row);

		String locationName = xr1.getCellData("Reroute Request", "Location Name", i);
		String address = xr1.getCellData("Reroute Request", "Address", i);
		String city =  xr1.getCellData("Reroute Request", "City", i);
		String state =  xr1.getCellData("Reroute Request", "State", i);
		String zipCode =  xr1.getCellData("Reroute Request", "Zip Code", i);

		UseAssert.assertEquals(orderDetailPage.verifyRerouteLocationOnDetailPage(), 
				"Reroute Location\n" + locationName + " (Residential)\n" + address + "\n" + city + ", " + state + " " + zipCode + "\nExtra Services\nDelivery Appointment Required");
		SeleniumFunction.closeWindow(driver);
		SeleniumFunction.getCurrentWindow(driver);
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
