package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.grid.web.servlet.handler.SeleniumBasedRequestFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub_enhancement.qa517.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub_enhancement.qa538.testPages.ShipmentReviewOrderPage;
import com.thoughtworks.selenium.Selenium;

public class TestManageOrders extends InitializeTest {

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
	public void testRequestCancellationAndCloneOrReQuoteButton() {
		try{

			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
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

			if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']"))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true);
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}
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
}
