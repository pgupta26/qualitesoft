package com.qualitesoft.freightclub.testscripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.ShipmentReviewOrderPage;

public class TestManageOrders extends InitializeTest {
	
	@Test
	public void testRequestCancellationAndCloneOrReQuoteButton() {
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
						
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			String orderid=xr.getCellData("Input","OrderId", i).trim();

			manageOrderpage.orderIDFilter(orderid);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(5);

			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}
			SeleniumFunction.clickJS(driver,manageOrderpage.ActionButton());

			if(i==5) {
				Assert.assertFalse(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']")));
			}

			if(i == 3) {
				Long d = getDuration();
				if (d == 0) {
					System.out.println("Both Start time and End Time are equal");
				} else if (d > 0) {
					System.out.println("Start time is less than end time");
					if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Re-Quote']"))) {
						Assert.assertTrue(true);
					} else {
						Assert.assertFalse(true);
					} 
					ScreenShot.takeScreenShot(driver, "Request Cancellation and Re-Quote button presence");
				} else {
					System.out.println("Start time is greater than end time");
					if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Clone']"))) {
						Assert.assertTrue(true);
					} else {
						Assert.assertFalse(true);
					} 
					ScreenShot.takeScreenShot(driver, "Request Cancellation and Clone button presence");
				}
			}

			ScreenShot.takeScreenShot(driver, "Request Cancellation button presence.");		
	}
	
	
	@Test
	public void testVerifyAppointmentFlagUnderBOLPdf() {
		
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			
			manageOrderpage.orderIDFilter(orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(5);
		    
		    if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
		    	 SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		    }
		    SeleniumFunction.clickJS(driver,manageOrderpage.ActionButton());
		    manageOrderpage.billOfLoadingPdf();
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Bill of Lading PDF for order id "+orderid);	
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Long getDuration() {

		String startTimeStr = "12:30:00";

		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date dateobj = new Date();
		String endTimeStr = df.format(dateobj);

		LocalDate today = LocalDate.now();
		String startTimeStrT = today + " " + startTimeStr;
		String endTimeStrT = today + " " + endTimeStr;

		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime startTime = LocalDateTime.parse(startTimeStrT,
				formatter);
		LocalDateTime endTime = LocalDateTime.parse(endTimeStrT, formatter);

		Duration d = Duration.between(startTime, endTime);
		Long l = d.getSeconds();

		if (d.getSeconds() == 0)
			System.out.println("Both Start time and End Time are equal");
		else if (d.getSeconds() > 0)
			System.out.println("Start time is less than end time");
		else
			System.out.println("Start time is greater than end time");

		return l;
	}


	@Test
	public void verifyCloneOrReQuoteFunctionFunctionality() {
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);

			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();

			Long d = getDuration();
			
			if (d == 0) {
				System.out.println("Both Start time and End Time are equal");
			} else if (d > 0) {
				System.out.println("verify re-quote functionality");
				SeleniumFunction.click(manageOrderpage.reQuote());
				ScreenShot.takeScreenShot(driver, "Re Quote success message");
				
				SeleniumFunction.click(manageOrderpage.notQuoted());
				Assert.assertEquals(manageOrderpage.customerPO_NotQuoted().getText(), orderReferenceID);
				
			} else {
				orderReferenceID = "Clone_" + orderReferenceID;
				System.out.println("Cloned Customer PO number: "+orderReferenceID);
				System.out.println("Start time is greater than end time");
				SeleniumFunction.click(manageOrderpage.clone());
				SeleniumFunction.sendKeys(manageOrderpage.customerPONumber(), orderReferenceID);
				SeleniumFunction.click(manageOrderpage.cloneNow());


				SeleniumFunction.executeJS(driver, "window.scrollBy(0, 2000)");
				ShipmentReviewOrderPage reviewOrder = new ShipmentReviewOrderPage(driver);
				SeleniumFunction.click(reviewOrder.book1());
				WaitTool.sleep(30);

				QuickQuote quickQuote = new QuickQuote(driver);
				quickQuote.Okbutton();
				SeleniumFunction.click(quickQuote.Okbutton());
				WaitTool.sleep(20);
				
				Assert.assertEquals(manageOrderpage.customerPO().getText(), orderReferenceID);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*---------------------------------QA - 538--------------------------------------*/
	@Test
	public void testRequestCancellationAndCloneOrReQuoteButton1() {
		try{

			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			String orderid=xr.getCellData("Input","OrderId", i).trim();

			manageOrderpage.orderIDFilter(orderid);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(5);

			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}
			SeleniumFunction.clickJS(driver,manageOrderpage.ActionButton());
			
			Assert.assertFalse(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']")));

			//Assert.assertTrue(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']")));
			
			/*if(i == 3) {
				Long d = getDuration();
				if (d == 0) {
					System.out.println("Both Start time and End Time are equal");
				} else if (d > 0) {
					System.out.println("Start time is less than end time");
					if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Re-Quote']"))) {
						Assert.assertTrue(true);
					} else {
						Assert.assertFalse(true);
					} 
					ScreenShot.takeScreenShot(driver, "Request Cancellation and Re-Quote button presence");
				} else {
					System.out.println("Start time is greater than end time");
					if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Clone']"))) {
						Assert.assertTrue(true);
					} else {
						Assert.assertFalse(true);
					} 
					ScreenShot.takeScreenShot(driver, "Request Cancellation and Clone button presence");
				}
			}*/

			//ScreenShot.takeScreenShot(driver, "Request Cancellation button presence.");		
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void verifyCloneButtonFunctionality() {
		try{
			Assert.assertTrue(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Clone']")));
			ScreenShot.takeScreenShot(driver, "Clone button presence");

			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();

			orderReferenceID = "Clone_" + orderReferenceID;
			System.out.println("Cloned Customer PO number: "+orderReferenceID);
			SeleniumFunction.click(manageOrderpage.clone());
			SeleniumFunction.sendKeys(manageOrderpage.customerPONumber(), orderReferenceID);
			SeleniumFunction.click(manageOrderpage.cloneNow());


			SeleniumFunction.executeJS(driver, "window.scrollBy(0, 2000)");
			ShipmentReviewOrderPage reviewOrder = new ShipmentReviewOrderPage(driver);
			WaitTool.sleep(2);
			SeleniumFunction.click(reviewOrder.book1());
			WaitTool.sleep(30);

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.click(quickQuote.Okbutton1());
			WaitTool.sleep(20);

			Assert.assertEquals(manageOrderpage.customerPO().getText(), orderReferenceID);

		}catch(Exception | AssertionError e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void verifyReQuoteFunctionFunctionality() {
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);

			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();

			System.out.println("verify re-quote functionality");
			SeleniumFunction.click(manageOrderpage.reQuote());
			ScreenShot.takeScreenShot(driver, "Re Quote success message");

			WaitTool.sleep(10);
			SeleniumFunction.click(manageOrderpage.notQuoted());
			Assert.assertEquals(manageOrderpage.customerPO_NotQuoted().getText(), orderReferenceID);

		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
}
