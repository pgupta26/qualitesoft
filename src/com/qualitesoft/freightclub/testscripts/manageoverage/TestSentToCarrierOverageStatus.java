package com.qualitesoft.freightclub.testscripts.manageoverage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.OverageDetails;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.Mailinator;

public class TestSentToCarrierOverageStatus extends InitializeTest {
	
	@Test
	public void testSentToCarrierOverageStatus() {
		
		ManageOverages manageOverages = new ManageOverages(driver);
		OverageDetails overageDetails = new OverageDetails(driver);
		
		//Click on  manage overages link
		SeleniumFunction.click(manageOverages.manageOverages());
		
		//Enter order id in data grid text box 
		SeleniumFunction.sendKeys(manageOverages.OrderIDTextBox(), "");
		
		//Verify overage status in data grid
		UseAssert.assertEquals(manageOverages.gridData(1, 6).getText(), "In Review");	
		
		//Click on view/edit button
		SeleniumFunction.click(manageOverages.viewEdit(1));
		
		//Verify overage status
		UseAssert.assertEquals(overageDetails.getSelect("Overage Status:").getText(), "In Review");
		
		//Verify document uploaded by user
		UseAssert.assertEquals(overageDetails.uploadName().getText(), "Overage Sample Document.pdf");
		Assert.assertTrue(overageDetails.dateTime().getText().contains(JavaFunction.currentDate()));
		Assert.assertTrue(overageDetails.viewable().isDisplayed());
		Assert.assertTrue(overageDetails.downloadable().isDisplayed());
		Assert.assertTrue(overageDetails.removable().isDisplayed());
		
		//Verify comment made by user
		UseAssert.assertEquals(overageDetails.savedComment().getText(), "");
		UseAssert.assertEquals(overageDetails.savedUserName().getText(), "");

		//Select overage status
		SeleniumFunction.click(overageDetails.getSelect("Overage Status:"));
		SeleniumFunction.click(overageDetails.setSelect("Overage Status:", "Sent to Carrier"));
		
		//Clear and enter customer email
		String customerEmail = SeleniumFunction.getText(overageDetails.getLabelFromModal("sentToCarrierModal", "Customer Email"));
		Log.info("Customer Email: "+customerEmail);
		SeleniumFunction.sendKeys(overageDetails.getLabelFromModal("sentToCarrierModal", "Customer Email"), "");
		
		//Clear and enter carrier email
		String carrierEmail = SeleniumFunction.getText(overageDetails.getLabelFromModal("sentToCarrierModal", "Carrier Email"));
		Log.info("Carrier Email: "+carrierEmail);
		SeleniumFunction.sendKeys(overageDetails.getLabelFromModal("sentToCarrierModal", "Carrier Email"), "");
		
		//Get header
		String header = SeleniumFunction.getText(overageDetails.getLabelFromModal("sentToCarrierModal", "Header"));
		Log.info("Header Message: "+header);
		
		//Body
		SeleniumFunction.sendKeys(overageDetails.getLabelFromModal("sentToCarrierModal", "Body"), "");
		
		//Send email
		SeleniumFunction.click(overageDetails.sendEmail("sentToCarrierModal"));
		
		//Open new window and navigate mailinator
		SeleniumFunction.executeJS(driver, "window.open('');");
		SeleniumFunction.getCurrentWindow(driver);
		SeleniumFunction.open(driver, "https://www.mailinator.com/");
		
		Mailinator mailinator = new Mailinator(driver);

		SeleniumFunction.sendKeys(mailinator.searchBox(), "");
		WaitTool.sleep(2);
		SeleniumFunction.click(mailinator.goButton());
		WaitTool.sleep(30);
		SeleniumFunction.click(mailinator.firstMail());
		SeleniumFunction.selectFrame(driver, "html_msg_body");
		UseAssert.assertEquals(mailinator.mailBody().getText(), "");
		SeleniumFunction.closeWindow(driver);
		SeleniumFunction.closeWindow(driver);
		SeleniumFunction.getCurrentWindow(driver);
	    	
	}
}
