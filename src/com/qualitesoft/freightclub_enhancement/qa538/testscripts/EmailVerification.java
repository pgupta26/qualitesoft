package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.cymax.pageobjects.YopMailPage;
import com.qualitesoft.freightclub_enhancement.qa538.testPages.Mailinator;


public class EmailVerification extends InitializeTest {

	@Test
	public void testVerifyReadyForBookingMail() {
		try {
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
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
			WaitTool.sleep(30);
			SeleniumFunction.click(mailinator.firstMail());
				SeleniumFunction.selectFrame(driver, "msg_body");
				Assert.assertEquals(mailinator.reviewedOrderMsg().getText(), expectedMsg);
				ScreenShot.takeFullScreenShot("Order ready for booking");
				SeleniumFunction.selectParentframe(driver);
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);    
		}catch(Exception |AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testOrderBooking() {
		try {
		
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
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
			WaitTool.sleep(30);
			SeleniumFunction.click(mailinator.firstMail1());
				SeleniumFunction.selectFrame(driver, "msg_body");
				Assert.assertTrue(mailinator.orderConfirmationMsg().getText().contains(expectedMsg));
				ScreenShot.takeFullScreenShot("Order Confirmation Mail");
				SeleniumFunction.selectParentframe(driver);
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);    
			
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
