package com.qualitesoft.freightclub.testscripts.manageoverage;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;

public class TestCompletedOverageStatus extends InitializeTest {
	
	@Test
	public void testCompletedOverageStatus() {
			
		ManageOverages manageOverages = new ManageOverages(driver);
		OverageDetails overageDetails = new OverageDetails(driver);
		
		//Select completed overage status
		SeleniumFunction.click(overageDetails.getSelect("Overage Status:"));
		SeleniumFunction.click(overageDetails.setSelect("Overage Status:", "Completed"));
		
		//Save changes
		SeleniumFunction.click(overageDetails.saveChanges());
		
		//Verify overage status
		UseAssert.assertEquals(overageDetails.getSelect("Overage Status:").getText(), "Completed");
		
	}

}
