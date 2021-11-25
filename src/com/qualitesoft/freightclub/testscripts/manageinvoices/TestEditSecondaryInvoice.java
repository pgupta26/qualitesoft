package com.qualitesoft.freightclub.testscripts.manageinvoices;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageInvoices;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEditSecondaryInvoice extends InitializeTest {
	
	@Test
	public void testEditSecondaryInvoice() {
		
		Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageInvoiceTestData.xlsx");
		int i=Integer.parseInt(Row);
		
		ManageInvoices  manageInvoices = new ManageInvoices(driver);
		QuickQuote quickQuote = new QuickQuote(driver);

		//Accept popup
		WaitTool.sleep(10);
		quickQuote.acceptPopup();
		WaitTool.sleep(5);
		quickQuote.acceptPopup();

		//Type comments
		SeleniumFunction.sendKeys(manageInvoices.comments(), xr1.getCellData("EditSecondaryInvoice", "AdminComment", i));

		//Click on save comment
		SeleniumFunction.click(manageInvoices.saveComment());

		//Verify saved comment
		UseAssert.assertEquals(manageInvoices.savedComment().getText(), xr1.getCellData("EditSecondaryInvoice", "AdminComment", i));
		UseAssert.assertEquals(manageInvoices.savedUserName().getText(), xr1.getCellData("EditSecondaryInvoice", "AdminUserName", i));

		//Click on bacuup documentation button
		WaitTool.sleep(2);
		Actions actions = new Actions(driver);
		actions.moveToElement(manageInvoices.backupDocumentation()).click().build().perform();

		//Upload document
		SeleniumFunction.uploadFile(xr1.getCellData("EditSecondaryInvoice", "AdminDocumentName", i));
		WaitTool.sleep(10);
		
		//Verify uploaded document detail
		int backupDocumemtGridDataSize = manageInvoices.backupDocumentGridData().size();
		UseAssert.assertEquals(manageInvoices.uploadName(backupDocumemtGridDataSize).getText(), xr1.getCellData("EditSecondaryInvoice", "AdminDocumentName", i));
		//Assert.assertTrue(manageInvoices.dateTime(backupDocumemtGridDataSize).getText().contains(JavaFunction.currentDate()));
		Assert.assertTrue(manageInvoices.viewable(backupDocumemtGridDataSize).isDisplayed());
		Assert.assertTrue(manageInvoices.downloadable(backupDocumemtGridDataSize).isDisplayed());

		//Admin able to remove document 
		Assert.assertTrue(manageInvoices.removable(backupDocumemtGridDataSize).isDisplayed());
		
		//Click on save changes
		SeleniumFunction.click(manageInvoices.saveChanges());
	}
}
