package com.qualitesoft.freightclub.testscripts.manageoverage;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestCompletedOverageStatus extends InitializeTest {
	
	@Test
	public void testCompletedOverageStatus() {
			
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
		int i=Integer.parseInt(Row);
		
		ManageOverages manageOverages = new ManageOverages(driver);
		OverageDetails overageDetails = new OverageDetails(driver);
		QuickQuote quickQuote = new QuickQuote(driver);

		//Click on  manage overages link
		SeleniumFunction.click(manageOverages.manageOverages());
		
		//Accept popup
		WaitTool.sleep(10);
		quickQuote.acceptPopup();
		WaitTool.sleep(5);
		
		//Filter data grid by total billed
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(manageOverages.OrderIDTextBox(), xr.getCellData("Sec invoice Master","FC Order ID", i));
		SeleniumFunction.sendKeys(manageOverages.TotalBilledTextBox(6), xr.getCellData("Sec invoice Master","New Invoice Amount", i));
		SeleniumFunction.KeyBoradEnter(driver);
		
		//Click on view/edit button
		SeleniumFunction.click(manageOverages.viewEdit(1));
		
		//Select completed overage status
		SeleniumFunction.getCurrentWindow(driver);
		SeleniumFunction.click(overageDetails.getSelect("Overage Status:"));
		SeleniumFunction.click(overageDetails.setSelect("Overage Status:", "Completed"));
		
		//Save changes
		SeleniumFunction.click(overageDetails.saveChanges());
		
		//Verify overage status
		WaitTool.sleep(20);
		UseAssert.assertEquals(overageDetails.getSelect("Overage Status:").getText(), "Completed");
		
	}
}
