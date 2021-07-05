package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
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
		String actualMessage = driver.findElement(By.tagName("body")).getText().replaceAll("[\\t\\n\\r]+"," ");
		Log.info("Actual Message:"+actualMessage);
		Assert.assertEquals(expectedEmailBody, actualMessage);
	}
	
	@Parameters({ "notificationType"})
	@Test
	public void testEmailNotifications(String notificationType) {
		
		String expectedEmailBody=null;

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
		int i=Integer.parseInt(Row);
		Log.info("Data Row: " +Row);
		
		//filter record by order id
		String orderid=xr.getCellData("Input","OrderId", i).trim();
		
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
				String expectedMsg="== == == Test Automation has submitted a custom order quote request == *Order Details:* * OrderID:*{orderID} * Customer Name:*Test Automation Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test1234 FC Team, please review and update the quote. Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
				expectedMsg = expectedMsg.replace("{orderID}", orderid);
				this.verifyEmailBody(expectedMsg);
			} else if(notificationType.equalsIgnoreCase("Order Ready For Booking")) {
				String expectedMsg="The Freight Club team has reviewed your custom order request 51484599 and has provided a quote. Review the order and proceed with the booking through the Manage Orders - Open Quotes page. *Order Details:* * OrderID:*{orderID} * PO Number:*DIR_C02 Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test4321 Thanks again for choosing Freight Club and have a great day! Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com";
				expectedMsg = expectedMsg.replace("{orderID}", orderid);
				this.verifyEmailBody(expectedMsg);	
			} else if(notificationType.equalsIgnoreCase("Order Confirmation Mail - User")) {
				expectedEmailBody = "Thank you for submitting your order, this is a confirmation of your booking.";
				this.verifyEmailBody(expectedEmailBody);
			}else if(notificationType.equalsIgnoreCase("Order Confirmation Mail - Admin")) {
				String expectedMsg="The Freight Club team has reviewed your custom order request 51484599 and has provided a quote. Review the order and proceed with the booking through the Manage Orders - Open Quotes page. *Order Details:* * OrderID:*{orderID} * PO Number:*DIR_C02 Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test4321 Thanks again for choosing Freight Club and have a great day! Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com Freight Club - Copyright 2019 ?© Freight Club 12020 Sunrise Valley Dr. # 100 Reston, Virginia, 20191 You are receiving this email because you are a customer of Freight Club Terms & Conditions <https://www.freightclub.com/terms-and-conditions> | Privacy Policy <https://app.freightclub.com/Home/PrivacyPolicy>";
				expectedMsg = expectedMsg.replace("{orderID}", orderid);
				this.verifyEmailBody(expectedMsg);
			} else if(notificationType.equalsIgnoreCase("Custom Order Cannot Be Fulfilled")) {
				String expectedMsg="Unfortunately, we were unable to find a carrier who was able to fulfill your custom order request. *Order Details:* * OrderID:*{orderID} * Customer Name:*Test Automation * Purchase Order:*DIR_C03 Pick Up Company Address Line1, LOS ANGELES, CA, 90001 Drop Off Company Address Line2, NEW YORK, NY, 10011 Test1234 If you have questions or would like to chat with a representative to discuss alternate options please contact our support team. Kind Regards, Customer Support 1-844-819-2187 info@freightclub.com";
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

		
	}
}
