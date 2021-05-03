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

public class TestEditSecondaryInvoice extends InitializeTest {

	@Test
	public void testEditSecondaryInvoice() {
		//Read data from sheet for selected row
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/Import_Overages.xlsx");
		int i=Integer.parseInt(Row);

		ManageInvoices  manageInvoices = new ManageInvoices(driver);

		//Type comments
		SeleniumFunction.sendKeys(manageInvoices.comments(), "Missing Data");

		//Click on save comment
		SeleniumFunction.click(manageInvoices.saveComment());

		//Verify saved comment
		UseAssert.assertEquals(manageInvoices.savedComment().getText(), "Missing Data");
		UseAssert.assertEquals(manageInvoices.savedUserName().getText(), "freightclubinfo@gmail.com");


		//Click on bacuup documentation button
		SeleniumFunction.click(manageInvoices.backupDocumentation());

		//Upload document
		SeleniumFunction.uploadFile("Overage Sample Document.pdf");
		
		//Verify uploaded document detail
		UseAssert.assertEquals(manageInvoices.uploadName().getText(), "Overage Sample Document.pdf");
		Assert.assertTrue(manageInvoices.dateTime().getText().contains(JavaFunction.currentDate()));
		Assert.assertTrue(manageInvoices.viewable().isDisplayed());
		Assert.assertTrue(manageInvoices.downloadable().isDisplayed());

		//Admin able to remove document 
		Assert.assertTrue(manageInvoices.removable().isDisplayed());
		
		//Click on save changes
		SeleniumFunction.click(manageInvoices.saveChanges());

		
		/*if(userType.equals("Admin")) {	

		}else if(userType.equals("User")) {

			//Click on dispute button
			SeleniumFunction.click(manageInvoices.dispute());

			//Type overage contact email
			SeleniumFunction.sendKeys(manageInvoices.contactEmail(), "overage123@mailinator.com");
			SeleniumFunction.click(manageInvoices.dispute());
		}*/
	}
}
