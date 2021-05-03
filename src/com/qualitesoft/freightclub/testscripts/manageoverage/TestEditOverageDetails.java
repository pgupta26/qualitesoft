package com.qualitesoft.freightclub.testscripts.manageoverage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;

public class TestEditOverageDetails extends InitializeTest {

	@Test
	public void testEditOverageDetails() {

		ManageOverages manageOverages = new ManageOverages(driver);
		OverageDetails overageDetails = new OverageDetails(driver);

		if(userType.equals("Admin")) {
			
			//Select overage status
			SeleniumFunction.click(overageDetails.getSelect("Overage Status:"));
			SeleniumFunction.click(overageDetails.setSelect("Overage Status:", "More Information Required"));

			//Select secondary category
			SeleniumFunction.click(overageDetails.getSelect("Secondary Category:"));
			SeleniumFunction.click(overageDetails.setSelect("Secondary Category:", "Missing Data"));

			//Select secondary reason
			SeleniumFunction.click(overageDetails.getSelect("Secondary Reason:"));
			SeleniumFunction.click(overageDetails.setSelect("Secondary Reason:", "Incorrect Dimensions"));

			//Enter reason details
			SeleniumFunction.sendKeys(overageDetails.getLabel("Reason Details:"), "Automation Test Reason");
		} 

		//Type comments
		SeleniumFunction.sendKeys(overageDetails.comments(), "Missing Data");

		//Click on save comment
		SeleniumFunction.click(overageDetails.saveComment());

		//Verify saved comment
		UseAssert.assertEquals(overageDetails.savedComment().getText(), "Missing Data");
		UseAssert.assertEquals(overageDetails.savedUserName().getText(), "freightclubinfo@gmail.com");


		//Click on bacuup documentation button
		SeleniumFunction.click(overageDetails.documents());

		//Upload document
		SeleniumFunction.uploadFile("Overage Sample Document.pdf");

		//Verify uploaded document detail
		UseAssert.assertEquals(overageDetails.uploadName().getText(), "Overage Sample Document.pdf");
		Assert.assertTrue(overageDetails.dateTime().getText().contains(JavaFunction.currentDate()));
		Assert.assertTrue(overageDetails.viewable().isDisplayed());
		Assert.assertTrue(overageDetails.downloadable().isDisplayed());
		
		if(userType.equals("Admin")) {
			//Verify removeable button visible to admin
			Assert.assertTrue(overageDetails.removable().isDisplayed());
			
			//Click on save changes
			SeleniumFunction.click(overageDetails.saveChanges());
		} else if(userType.equals("User")) {
			//Verify removeable button will not visible to user
			Assert.assertFalse(overageDetails.removable().isDisplayed());
			
			//Click submit for review
			SeleniumFunction.click(overageDetails.submitForReview());
			
			//Verify overage status
			UseAssert.assertEquals(overageDetails.getSelect("Overage Status:").getText(), "In Review");
			
			//Close current window and switch to parent window
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			
			//Verify grid button text
			UseAssert.assertEquals(SeleniumFunction.getText(manageOverages.viewEdit(1)), "View");
		}
	}
}
