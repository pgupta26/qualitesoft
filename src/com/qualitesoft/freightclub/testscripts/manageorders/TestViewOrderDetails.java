package com.qualitesoft.freightclub.testscripts.manageorders;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.OrderDetailPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestViewOrderDetails extends InitializeTest {

	@Test
	public void testViewOrderDetails() {

		try {
			ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
			OrderDetailPage	orderDetailsPage= new OrderDetailPage(driver);
			QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
			CommonOps commonOps = new CommonOps();

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
			int i=Integer.parseInt(Row);

			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			String orderId=xr.getCellData("Input","OrderId", i).trim();
			String weight=xr.getCellData("Input","Weight", i).trim();
			String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
			String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
			String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			String expectedCategory=xr.getCellData("Input","category", i).trim();			
			String expectedDeclareValue=xr.getCellData("Input","DeclaredValue", i).trim();
			String expectedNumberOfCartoons=xr.getCellData("Input","NumberOfCartoons", i);
			String pickUpDate=xr.getCellData("Input","pickUpDate", i);
			String amount=xr.getCellData("Input","Amount", i);
			String quantity=xr.getCellData("Input","Quantity", i);

			String expectedDimension = "L"+DimensionL+" x W"+DimensionW+" x H"+DimensionH+" in";
			expectedDeclareValue = "$"+expectedDeclareValue+".00";


			String customer=xr.getCellData("CreateAccount","CompanyName", 2).trim();
			String email=xr.getCellData("CreateAccount","Email", 2).trim();
			String phoneNumber=xr.getCellData("CreateAccount","PhoneNumber", 2).trim();
			String extn=xr.getCellData("CreateAccount","Extension", 2).trim();

			commonOps.openManageOrdersPageAndSearchOrder(orderId);
			SeleniumFunction.click(manageOrderPage.ViewDetail());
			SeleniumFunction.getCurrentWindow(driver);
			WaitTool.sleep(3);
			quickQuote.acceptPopup();

			UseAssert.assertEquals(orderDetailsPage.getLabel("Order ID:").getText(), orderId);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Created Date:").getText(), pickUpDate);

			UseAssert.assertEquals(orderDetailsPage.getLabel("Shipment Type:").getText(), shipmentType);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Customer PO #:").getText(), orderReferenceID);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Quoted Amount:").getText(), amount);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Service Level:").getText(), serviceLevel);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Status:").getText(), "Booked");
			UseAssert.assertEquals(orderDetailsPage.getLabel("Customer:").getText(), customer);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Payment Type:").getText(), "OnAccount");

			UseAssert.assertEquals(orderDetailsPage.getLabel("Booking Date:").getText(), pickUpDate);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Contact Name:").getText(), customer);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Company Email:").getText(), email);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Phone Number:").getText(), phoneNumber+" ext. "+extn);

			SeleniumFunction.scrollDownUptoFooter(driver);
			orderDetailsPage.expandItemsInThisOrderPanel();
			UseAssert.assertEquals(orderDetailsPage.getLabel("Quantity:").getText(), quantity);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Weight:").getText(), weight+"lbs");
			UseAssert.assertEquals(orderDetailsPage.getLabel("Dimensions:").getText(), expectedDimension);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Declared Value:").getText(),expectedDeclareValue);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Carton Count:").getText(), expectedNumberOfCartoons);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Categories:").getText(), expectedCategory);
			UseAssert.assertEquals(orderDetailsPage.getLabel("Special Handling Instructions").getText(), "Test Special Handling Instructions");

			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentUrl(driver);
			
		}catch(Exception ex) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentUrl(driver);
			Assert.fail();
		}catch(AssertionError ae) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentUrl(driver);
			Assert.fail();
		}

	}
}
