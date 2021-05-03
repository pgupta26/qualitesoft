package com.qualitesoft.freightclub.testscripts.manageoverage;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;

public class TestViewOverageDetails extends InitializeTest {

	@Test
	public void testVieewOverageDetails() {
		ManageOverages manageOverages = new ManageOverages(driver);
		OverageDetails overageDetails = new OverageDetails(driver);
		
		//Click on  manage overages link
		SeleniumFunction.click(manageOverages.manageOverages());
		
		//Enter order id in data grid text box 
		SeleniumFunction.sendKeys(manageOverages.OrderIDTextBox(), "");
		
		//Click on view/edit button
		SeleniumFunction.click(manageOverages.viewEdit(1));
		
		//verify overage details fields
		UseAssert.assertEquals(overageDetails.getLabel("Order ID:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Overage ID:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Disputed Date:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Company:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Carrier:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Dispute Age:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Completed Date:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Tracking Number:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Order Status:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Secondary Invoice Amount:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Secondary Invoice Number:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Invoice Created Date:").getText(), "");

		UseAssert.assertEquals(overageDetails.getSelect("Dispute Type:").getText(), "");
		UseAssert.assertEquals(overageDetails.getSelect("Overage Status:").getText(), "");
		UseAssert.assertEquals(overageDetails.getSelect("Secondary Category:").getText(), "");
		UseAssert.assertEquals(overageDetails.getSelect("Secondary Reason:").getText(), "");
		UseAssert.assertEquals(overageDetails.getLabel("Reason Details:").getText(), "");
		
		if(userType.equals("User")) {

			//Fields that will be disabled for user
			Assert.assertTrue(overageDetails.getSelect("Dispute Type:").getAttribute("class").contains("disabled "));
			Assert.assertTrue(overageDetails.getSelect("Overage Status:").getAttribute("class").contains("disabled "));
			Assert.assertTrue(overageDetails.getSelect("Secondary Category:").getAttribute("class").contains("disabled "));
			Assert.assertTrue(overageDetails.getSelect("Secondary Reason:").getAttribute("class").contains("disabled "));
			Assert.assertTrue(overageDetails.getLabel("Reason Details:").getAttribute("disabled").contains("disabled "));
			
			//Verify admin Uploaded document visible is user
			UseAssert.assertEquals(overageDetails.uploadName().getText(), "Overage Sample Document.pdf");
			Assert.assertTrue(overageDetails.dateTime().getText().contains(JavaFunction.currentDate()));
			Assert.assertTrue(overageDetails.viewable().isDisplayed());
			Assert.assertTrue(overageDetails.downloadable().isDisplayed());
			
			//Remove documnet button will not be visible to user
			Assert.assertFalse(overageDetails.removable().isDisplayed());
			
			//Verify admin comment visible to user
			UseAssert.assertEquals(overageDetails.savedComment().getText(), "Missing Data");
			UseAssert.assertEquals(overageDetails.savedUserName().getText(), "freightclubinfo@gmail.com");
		}
	}
}
