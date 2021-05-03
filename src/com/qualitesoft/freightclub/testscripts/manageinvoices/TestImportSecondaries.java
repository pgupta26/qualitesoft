package com.qualitesoft.freightclub.testscripts.manageinvoices;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageInvoices;

public class TestImportSecondaries extends InitializeTest {
	
	@Test
	public void testImportSecondaries() {
		ManageInvoices  manageInvoices = new ManageInvoices(driver);
		
		//Click on manage invoices
		SeleniumFunction.click(manageInvoices.manageInvoices());
		
		//Click on import secondary
		SeleniumFunction.click(manageInvoices.importSecondaries());
		
		//Upload overage file
		SeleniumFunction.uploadFile("Import_Overages.xlsx");
		
		//Click on upload files
		SeleniumFunction.click(manageInvoices.uploadFiles());
		
		//Verify upload success message
		UseAssert.assertEquals(manageInvoices.successMessage().getText(), "4 invoices were successfully uploaded");
		
		//Click on ok button under upload invoice results dialog
		SeleniumFunction.click(manageInvoices.ok());
		
		//Verify done  button after file uploaded successfully
		UseAssert.assertEquals(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[@class='k-icon k-i-tick']")), true);
		
		
		//Read data from sheet for selected row
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/Import_Overages.xlsx");
		int i=Integer.parseInt(Row);
		
		//Type order id/number in data grid
		SeleniumFunction.sendKeys(manageInvoices.OrderIDTextBox(), xr.getCellData("Input","Original PO #", i).trim());
		
		//Press enter key
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(5);
		
		//Verify overage id detail in data grid
		UseAssert.assertEquals(manageInvoices.gridData(i, 1).getText(), xr.getCellData("Input","Original PO #", i).trim());
		UseAssert.assertEquals(manageInvoices.gridData(i, 2).getText(), "Secondary");
		UseAssert.assertEquals(manageInvoices.gridData(i, 3).getText(), "Test Store M Store");
		UseAssert.assertEquals(manageInvoices.gridData(i, 4).getText(), "TestOrder1");
		UseAssert.assertEquals(manageInvoices.gridData(i, 5).getText(), "Invoiced");
		UseAssert.assertEquals(manageInvoices.gridData(i, 6).getText().trim(), xr.getCellData("Input","Date CREATED", i).trim());
		UseAssert.assertEquals(manageInvoices.gridData(i, 7).getText(), "");
		UseAssert.assertEquals(manageInvoices.gridData(i, 8).getText().trim(), "USD "+xr.getCellData("Input","New Invoice Amount", i).trim());
		UseAssert.assertEquals(manageInvoices.gridData(i, 9).getText(), "Yes");
	}
}
