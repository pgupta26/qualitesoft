package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.Messages;
import com.qualitesoft.freightclub.pageobjects.Mailinator;


public class EmailVerification extends InitializeTest {
	
	public void verifyEmailBody(String expectedEmailBody) {
		Log.info("Expected Message:"+expectedEmailBody);
		WaitTool.sleep(3);
		String actualMessage = driver.findElement(By.tagName("body")).getText().replaceAll("[\\t\\n\\r]+"," ");
		Log.info("Actual Messag1e:"+actualMessage);
		Assert.assertEquals(expectedEmailBody, actualMessage);
	}
	
	@Parameters({ "notificationType"})
	@Test
	public void testEmailNotifications(String notificationType) {
		try {
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			//filter record by order id
			String orderid = xr.getCellData("Input","OrderId", i).trim();
			String poNumber = xr.getCellData("Input","orderReferenceID", i).trim();
			String regulatoryDetails =  xr.getCellData("Input","RegulatoryDetails", i).trim();

			String trackingID = xr.getCellData("Input","Tracking#", i).trim();
			String wayBill =  xr.getCellData("Input","WayBill", i).trim();
			String additionalDocsNeeded =  xr.getCellData("ClaimDetail","AddiotionalDocsEmailBody", i).trim();
			String expectedMsg = null;
			String claimType =  xr.getCellData("ClaimDetail","ClaimType", i).trim();

			SeleniumFunction.executeJS(driver, "window.open('');");
			SeleniumFunction.getCurrentWindow(driver);
			SeleniumFunction.open(driver, "https://www.mailinator.com/");

			Mailinator mailinator = new Mailinator(driver);

			SeleniumFunction.sendKeys(mailinator.searchBox(), fcusername);
			WaitTool.sleep(2);
			SeleniumFunction.click(mailinator.goButton());
			WaitTool.sleep(20);
			SeleniumFunction.click(mailinator.firstMail());
				WaitTool.sleep(5);
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("pills-textbuthtml-tab"), 20));
				WaitTool.sleep(2);
				SeleniumFunction.selectFrame(driver, "texthtml_msg_body");
				
				switch(notificationType) {
					case "Custom Quote Requested - User":
						expectedMsg = Messages.custom_quote_requested_user.replace("{orderID}", orderid);
						break;
						
					case "Custom Quote Requested - Carrier":
						expectedMsg = Messages.custom_quote_requested_carrier.replace("{orderID}", orderid);
						break;
						
					case "Order Ready For Booking":
						expectedMsg = Messages.order_ready_for_booking.replace("{orderID}", orderid).replace("{poNumber}", poNumber).replace("{regulatoryDetails}", regulatoryDetails);
						break;
						
					case "Order Confirmation Mail - User - LTL":
						expectedMsg = Messages.order_confirmation_mail_user_ltl.replace("{orderID}", orderid);
						break;
						
					case "Order Confirmation Mail - User":
						if(i==2) {
							 expectedMsg = Messages.order_confirmation_mail_user;
						}else if(i==3) {
							 expectedMsg = Messages.order_confirmation_mail_user1;
						}
						expectedMsg = expectedMsg.replace("{orderID}", orderid);
						break;
						
					case "Order Confirmation Mail - Admin":
						if(i==2) {
							 expectedMsg = Messages.order_confirmation_mail_admin;
						}else if(i==3) {
							 expectedMsg = Messages.order_confirmation_mail_admin1;
						}
						expectedMsg = expectedMsg.replace("{orderID}", orderid);
						break;
						
					case "Custom Order Cannot Be Fulfilled":
						expectedMsg = Messages.custom_order_cannot_be_fulfilled.replace("{orderID}", orderid);
						break;
						
					case "Sent To Carrier":
						expectedMsg = Messages.sent_to_carrier.replace("{orderID}", orderid);
						break;
						
					case "Reroute Requested - Customer":
						expectedMsg = Messages.reroute_requested_customer.replace("{orderID}", orderid);
						break;
						
					case "Reroute Requested - Carrier":
						expectedMsg = Messages.reroute_requested_carrier.replace("{orderID}", orderid);
						break;
						
					case "Reroute Request Approved - Customer":
						expectedMsg = Messages.reroute_request_approved_customer.replace("{orderID}", orderid);
						break;
						
					case "Reroute Request Approved - Carrier":
						expectedMsg = Messages.reroute_request_approved_carrier.replace("{orderID}", orderid);
						break;
						
					case "Reroute Request Decline - Customer":
						expectedMsg = Messages.reroute_request_decline_customer.replace("{orderID}", orderid);
						break;
						
					case "Claim initiated - Customer":
						expectedMsg = Messages.email_customer_claim_initiated;
						break;
						
					case "Claim initiated - Customer - Loss":
						expectedMsg = Messages.email_customer_claim_initiated_loss;
						break;

					case "Claim initiated - Carrier":
						if(claimType.equals("Damage")) {
							expectedMsg = Messages.email_carrier_claim_initiated.replace("{trackingID}", trackingID).replace("{wayBill}", wayBill);
						} else {
							expectedMsg = Messages.email_carrier_claim_initiated_loss.replace("{trackingID}", trackingID).replace("{wayBill}", wayBill);
						}
						break;
						
					case "Customer - Additional Docs Needed":
						expectedMsg = Messages.email_customer_additional_docs_needed.replace("{AdditionalDocsEmailBody}", additionalDocsNeeded);
						break;
					
					case "Customer - Pending Documentation":
						expectedMsg = Messages.email_customer_pending_documentation;
						break;
					
					case "Customer - Filed Claim Status":
						expectedMsg = Messages.email_customer_filed.replace("{trackingID}", trackingID).replace("{wayBill}", wayBill);
						break;
						
					default:
						Log.info("Please provide valid notiification type");
						
				}
				
				verifyEmailBody(expectedMsg);
				SeleniumFunction.selectParentframe(driver);
				SeleniumFunction.click(mailinator.deleteEmail());
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			
		}catch(Exception ex) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			throw ex;
		}catch(AssertionError ex) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			throw ex;
		}
	}
}
