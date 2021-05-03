package com.qualitesoft.freightclub.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.Mailinator;


public class EmailVerification extends InitializeTest {

	@Test
	public void testVerifyReadyForBookingMail() {
		try {
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			//filter record by order id
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			System.out.println("Order1 Id: "+orderid);
			
			String expectedMsg = "The Freight Club team has reviewed your custom order request orderid and has provided a quote.";
			expectedMsg = expectedMsg.replaceAll("orderid", orderid);
			
			SeleniumFunction.executeJS(driver, "window.open('');");
			SeleniumFunction.getCurrentWindow(driver);
			SeleniumFunction.open(driver, "https://www.mailinator.com/");

			Mailinator mailinator = new Mailinator(driver);

			SeleniumFunction.sendKeys(mailinator.searchBox(), fcusername);
			WaitTool.sleep(2);
			SeleniumFunction.click(mailinator.goButton());
			WaitTool.sleep(20);
			SeleniumFunction.click(mailinator.firstMail());
				SeleniumFunction.selectFrame(driver, "msg_body");
				Assert.assertEquals(mailinator.reviewedOrderMsg().getText(), expectedMsg);
				ScreenShot.takeFullScreenShot("Review Order Mail");
				SeleniumFunction.selectParentframe(driver);
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);    
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}catch(AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}
	
	@Test
	public void testOrderBooking() {
		try {
		
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			//filter record by order id
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			System.out.println("Order1 Id: "+orderid);
			
			String expectedMsg = "Thank you for submitting your order, this is a confirmation of your booking.";
			
			SeleniumFunction.executeJS(driver, "window.open('');");
			SeleniumFunction.getCurrentWindow(driver);
			SeleniumFunction.open(driver, "https://www.mailinator.com/");

			Mailinator mailinator = new Mailinator(driver);

			SeleniumFunction.sendKeys(mailinator.searchBox(), fcusername);
			WaitTool.sleep(2);
			SeleniumFunction.click(mailinator.goButton());
			WaitTool.sleep(20);
			SeleniumFunction.click(mailinator.firstMail1());
				SeleniumFunction.selectFrame(driver, "msg_body");
				System.out.println("Actual Message: "+mailinator.orderConfirmationMsg().getText());
				Assert.assertTrue(mailinator.orderConfirmationMsg().getText().contains(expectedMsg));
				ScreenShot.takeFullScreenShot("Order Confirmation Mail");
				SeleniumFunction.selectParentframe(driver);
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);    
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}catch(AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}

}
