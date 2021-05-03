package com.qualitesoft.freightclub.testscripts.manageinvoices;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageInvoices;

public class TestViewSecondaryInvoice extends InitializeTest {
	
	@Test
	public void testViewSecondaryInvoice() {

		//Read data from sheet for selected row
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/Import_Overages.xlsx");
		int i=Integer.parseInt(Row);
				
		ManageInvoices  manageInvoices = new ManageInvoices(driver);
		
		//Click detail 
		SeleniumFunction.click(manageInvoices.detail(i));
		
		//Verify invoice detail 
		UseAssert.assertEquals(manageInvoices.getLabel("Order ID").getText(), xr.getCellData("Input","Original PO #", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Invoice Created Date").getText(), xr.getCellData("Input","Date CREATED", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Tracking Number").getText(), xr.getCellData("Input","Tracking #", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Company Name").getText(), "Test Store M Store");
		UseAssert.assertEquals(manageInvoices.getLabel("Carrier").getText(), xr.getCellData("Input","Carrier", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Quoted Amount").getText(), "$"+xr.getCellData("Input","New Invoice Amount", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Actual Amount").getText(), "$"+xr.getCellData("Input","New Invoice Amount", i));
		UseAssert.assertEquals(manageInvoices.getLabel("Order Status").getText(), "Booked");
		UseAssert.assertEquals(manageInvoices.getLabel("Invoice Type").getText(), "Secondary");
		UseAssert.assertEquals(manageInvoices.getLabel("Reason Details").getText(), "delivery.Inside");
		UseAssert.assertEquals(manageInvoices.getLabel("Secondary Invoice Number").getText(), xr.getCellData("Input","SECONDARY INV #", i));
		
		if(userType.equals("Admin")) {
			
			//Fields that will visible to admin only
			Select invoiceStatusDrpdown = new Select(manageInvoices.getSelect("Invoice Status"));
			UseAssert.assertEquals(invoiceStatusDrpdown.getFirstSelectedOption().getText().trim(), "Invoiced");
			
			Select secondaryCategoryDrdown = new Select(manageInvoices.getSelect("Secondary Category"));
			UseAssert.assertEquals(secondaryCategoryDrdown.getFirstSelectedOption().getText().trim(), "Delivery Complication");
			
			Select secondaryReasonDrpdown = new Select(manageInvoices.getSelect("Secondary Reason"));
			UseAssert.assertEquals(secondaryReasonDrpdown.getFirstSelectedOption().getText().trim(), "Special Delivery");
			
			Select paymentStatusDrpdown = new Select(manageInvoices.getSelect("Payment Status"));
			UseAssert.assertEquals(paymentStatusDrpdown.getAllSelectedOptions().size(), 0);
			
			Assert.assertTrue(manageInvoices.comments().isDisplayed());
			Assert.assertTrue(manageInvoices.saveComment().isDisplayed());
			Assert.assertTrue(manageInvoices.backupDocumentation().isDisplayed());
			
		} else if(userType.equals("User")) {
			
			//Fields that will visible to user only
			UseAssert.assertEquals(manageInvoices.getLabel("Invoice Status").getText(), "Invoiced");
			UseAssert.assertEquals(manageInvoices.getLabel("Secondary Category").getText(), "Delivery Complication");
			UseAssert.assertEquals(manageInvoices.getLabel("Secondary Reason").getText(), "Special Delivery");
			
			//Fields that will not visible to user
			Assert.assertFalse(manageInvoices.getSelect("Payment Status").isDisplayed());
			Assert.assertFalse(manageInvoices.comments().isDisplayed());
			Assert.assertFalse(manageInvoices.saveComment().isDisplayed());
			Assert.assertFalse(manageInvoices.backupDocumentation().isDisplayed());
			Assert.assertFalse(manageInvoices.removable().isDisplayed());
			
			//Uploaded document visible is user
			UseAssert.assertEquals(manageInvoices.uploadName().getText(), "Overage Sample Document.pdf");
			Assert.assertTrue(manageInvoices.dateTime().getText().contains(JavaFunction.currentDate()));
			Assert.assertTrue(manageInvoices.viewable().isDisplayed());
			Assert.assertTrue(manageInvoices.downloadable().isDisplayed());
			
		}	
	}
}
