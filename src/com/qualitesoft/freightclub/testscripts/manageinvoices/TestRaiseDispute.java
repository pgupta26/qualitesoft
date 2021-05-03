package com.qualitesoft.freightclub.testscripts.manageinvoices;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageInvoices;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;

public class TestRaiseDispute extends InitializeTest {
	
	@Test
	public void testRaiseDispute() {
		
		//Read data from sheet for selected row
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/Import_Overages.xlsx");
		int i=Integer.parseInt(Row);
		
		ManageInvoices  manageInvoices = new ManageInvoices(driver);
		OverageDetails overageDetails = new OverageDetails(driver);
		
		//Click on dispute button
		SeleniumFunction.click(manageInvoices.dispute());

		//Type overage contact email
		SeleniumFunction.sendKeys(manageInvoices.contactEmail(), "overage123@mailinator.com");
		SeleniumFunction.click(manageInvoices.confirm());
		
		//Switch to overage window
		SeleniumFunction.getCurrentWindow(driver);
		UseAssert.assertEquals(driver.getTitle(), "Overage Details - Freight Club");
		UseAssert.assertEquals(overageDetails.getLabel("Order ID:").getText().trim(), xr.getCellData("Input", "SECONDARY INV #", i).trim());
	}
}
