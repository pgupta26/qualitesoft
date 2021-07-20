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
import com.qualitesoft.freightclub.pageobjects.Mailinator;


public class EmailVerification extends InitializeTest {
	
	public void verifyEmailBody(String expectedEmailBody) {
		Log.info("Expected Message:"+expectedEmailBody);
		WaitTool.sleep(3);
		String actualMessage = driver.findElement(By.tagName("body")).getText().replaceAll("[\\t\\n\\r]+"," ");
		Log.info("Actual Message:"+actualMessage);
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
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			String poNumber=xr.getCellData("Input","orderReferenceID", i).trim();
			
			SeleniumFunction.executeJS(driver, "window.open('');");
			SeleniumFunction.getCurrentWindow(driver);
			SeleniumFunction.open(driver, "https://www.mailinator.com/");

			Mailinator mailinator = new Mailinator(driver);

			SeleniumFunction.sendKeys(mailinator.searchBox(), fcusername);
			WaitTool.sleep(2);
			SeleniumFunction.click(mailinator.goButton());
			WaitTool.sleep(20);
			SeleniumFunction.click(mailinator.firstMail());
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("pills-textbuthtml-tab"), 20));
				SeleniumFunction.selectFrame(driver, "texthtml_msg_body");
				if(notificationType.equalsIgnoreCase("Custom Quote Requested - User")) {
					String expectedMsg="== == == Test Automation has submitted a custom order quote request == *Order Details:* * OrderID:*{orderID} * Customer Name:*Test Automation Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test1234 FC Team, please review and update the quote. Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				} else if(notificationType.equalsIgnoreCase("Custom Quote Requested - Carrier")) {
					String expectedMsg="== == == Test Automation has submitted a custom order quote request == *Order Details:* * OrderID:*{orderID} *Customer Name:* Test Automation | 7460 *Shipment Details:* Handling UnitsTotal WeightConditionDeclared ValueFull Truckload70 lbsUsed$1000 *Shipment Information* Test1234 Test1234 *Pick-up Details: * Pick Up Company Address Line1, LOS ANGELES, CA, 90001 * Drop-off Details: * Drop Off Company Address Line2, NEW YORK, NY, 10011 *Additional Information:* *Custom Order Details* [X] Driver required for loading & unloading [ ] Regulated items that require further inspection [ ] Prohibited or restricted items [ ] Dangerous or hazardous goods [ ] Requires refrigeration *Regulatory Details.* Test1234 Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				} else if(notificationType.equalsIgnoreCase("Order Ready For Booking")) {
					String expectedMsg="The Freight Club team has reviewed your custom order request {orderID} and has provided a quote. Review the order and proceed with the booking through the Manage Orders - Open Quotes page. *Order Details:* * OrderID:*{orderID} * PO Number:*{poNumber} Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test4321 Thanks again for choosing Freight Club and have a great day! Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					expectedMsg = expectedMsg.replace("{orderID}", orderid).replace("{poNumber}", poNumber);
					this.verifyEmailBody(expectedMsg);	
				} else if(notificationType.equalsIgnoreCase("Order Confirmation Mail - User")) {
					String expectedMsg = null;
					if(i==2) {
						 expectedMsg="Thank you for submitting your order, this is a confirmation of your booking. *Order Details:* * OrderID:*{orderID} *Customer Name:* Test Automation * Carrier Name:* Estes Express Lines *Carrier QuoteID: *102 *Shipment Details* Handling UnitsTotal WeightConditionDeclared ValueBags70 lbsUsed$1000 *Shipment Information* Test4321 *Custom Order Details* [ ] Driver required for loading & unloading [ ] Regulated items that require further inspection [ ] Prohibited or restricted items [ ] Dangerous or hazardous goods [ ] Requires refrigeration *Regulatory Details.* Test4321 AutoCom90001 address line1, address line 2, LOS ANGELES, CA, 90001 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 AutoCom10011 address line 1, address line 2, NEW YORK, NY, 10011 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 Test4321 Please note that labels and bills of lading for custom orders are not available through the application. We will be reaching out to you with a carrier bill of lading to use with your shipment. If you have questions or would like to chat with a representative to discuss alternate options please contact our support team. Thanks again for choosing Freight Club and have a great day! Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					}else if(i==3) {
						 expectedMsg="Thank you for submitting your order, this is a confirmation of your booking. *Order Details:* * OrderID:*{orderID} *Customer Name:* Test Automation * Carrier Name:* FC Test Carrier *Carrier QuoteID: *222 *Shipment Details* Handling UnitsTotal WeightConditionDeclared ValueBags70 lbsUsed$1000 *Shipment Information* Test4321 *Custom Order Details* [ ] Driver required for loading & unloading [ ] Regulated items that require further inspection [ ] Prohibited or restricted items [ ] Dangerous or hazardous goods [ ] Requires refrigeration *Regulatory Details.* Test4321 AutoCom90001 address line1, address line 2, LOS ANGELES, CA, 90001 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 AutoCom10011 address line 1, address line 2, NEW YORK, NY, 10011 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 Test4321 Please note that labels and bills of lading for custom orders are not available through the application. We will be reaching out to you with a carrier bill of lading to use with your shipment. If you have questions or would like to chat with a representative to discuss alternate options please contact our support team. Thanks again for choosing Freight Club and have a great day! Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					}
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				}else if(notificationType.equalsIgnoreCase("Order Confirmation Mail - Admin")) {
					String expectedMsg = null;
					if(i==2) {
						 expectedMsg="Test Automation has submitted a booked the following custom order: *Order Details:* * OrderID:* {orderID} * Customer Name: *Test Automation * Carrier Name: *Estes Express Lines * Carrier QuoteID: *102 *Shipment Detail*: Handling UnitsTotal WeightConditionDeclared ValueFull Truckload70 lbsUsed$1000 *Shipment Information* Test4321 *Custom Order Details* [X] Driver required for loading & unloading [X] Regulated items that require further inspection [ ] Prohibited or restricted items [ ] Dangerous or hazardous goods [ ] Requires refrigeration *Regulatory Details.* Test4321 AutoCom90001 address line1, address line 2, LOS ANGELES, CA, 90001 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 AutoCom10011 address line 1, address line 2, NEW YORK, NY, 10011 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 Test4321 Please contact the carrier to complete the booking, and update the waybill and tracking information in the order details. Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					}else if(i==3) {
						 expectedMsg="Test Automation has submitted a booked the following custom order: *Order Details:* * OrderID:* {orderID} * Customer Name: *Test Automation * Carrier Name: *FC Test Carrier * Carrier QuoteID: *222 *Shipment Detail*: Handling UnitsTotal WeightConditionDeclared ValueBags70 lbsUsed$1000 *Shipment Information* Test4321 *Custom Order Details* [ ] Driver required for loading & unloading [ ] Regulated items that require further inspection [ ] Prohibited or restricted items [ ] Dangerous or hazardous goods [ ] Requires refrigeration *Regulatory Details.* Test4321 AutoCom90001 address line1, address line 2, LOS ANGELES, CA, 90001 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 AutoCom10011 address line 1, address line 2, NEW YORK, NY, 10011 9:00 AM - 4:00 PM first name last name a@gmail.com 0123456789 Test4321 Please contact the carrier to complete the booking, and update the waybill and tracking information in the order details. Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					}
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				} else if(notificationType.equalsIgnoreCase("Custom Order Cannot Be Fulfilled")) {
					String expectedMsg="Unfortunately, we were unable to find a carrier who was able to fulfill your custom order request. *Order Details:* * OrderID:*{orderID} * Customer Name:*Test Automation * Purchase Order:*DIR_C03 Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test1234 If you have questions or would like to chat with a representative to discuss alternate options please contact our support team. Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				} else if(notificationType.equalsIgnoreCase("Sent To Carrier")) {
					String expectedMsg="Hi, Thank you for submitting the dispute details. We have submitted it to the carrier for an update. Please allow 7-14 business days for a response. We will provide an update when a carrier response is received. Thanks, Freight Club Claims";
					expectedMsg = expectedMsg.replace("{orderID}", orderid);
					this.verifyEmailBody(expectedMsg);
				} 
			
				SeleniumFunction.selectParentframe(driver);
				SeleniumFunction.click(mailinator.deleteEmail());
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			
		}catch(Exception ex) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
		}catch(AssertionError ae) {
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
		}
	}
}
