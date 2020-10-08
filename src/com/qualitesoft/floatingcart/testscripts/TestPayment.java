package com.qualitesoft.floatingcart.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.floatingcart.pageobjects.FloatingQuickQuote;

public class TestPayment extends InitializeTest {
	
	@Test
	public void testPayment(){
		FloatingQuickQuote quickQuote = new FloatingQuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		
		if(loginuser.equals("Mstore2") || loginuser.equals("Mstoreuser")) {
			/*SeleniumFunction.click(quickQuote.existingcardCheckBox());
			ScreenShot.takeScreenShot(driver, "Payment Page");
			jse.executeScript("window.scrollBy(0,450)", "");
			SeleniumFunction.click(quickQuote.BookandPay());
			WaitTool.sleep(5);
			ScreenShot.takeScreenShot(driver, "Payment Confirmation");
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.sleep(5);*/
			SeleniumFunction.click(WaitTool.waitForElementToBeClickable(driver, By.id("btn-continue-to-orders"), 60));

			//Manage Order
			SeleniumFunction.click(quickQuote.manageOrdersLink());
			ScreenShot.takeScreenShot(driver, "Manage Order");
			WaitTool.sleep(5);
			SeleniumFunction.click(quickQuote.ViewDetail());
			WaitTool.sleep(5);
			//Navigate to Update Order Page
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab
			jse.executeScript("window.scrollBy(0,250)", "");
			ScreenShot.takeScreenShot(driver, "Order Info");
			driver.close();
			driver.switchTo().window(newTab.get(0));
			WaitTool.sleep(10);

		} else {
			SeleniumFunction.sendKeys(quickQuote.CreditCardNumber(), "4111111111111111");
			SeleniumFunction.sendKeys(quickQuote.CardName(), "test");
			SeleniumFunction.sendKeys(quickQuote.CVV(), "123");
			SeleniumFunction.select(quickQuote.Month(), "1");
			SeleniumFunction.select(quickQuote.Year(), "2021");
			SeleniumFunction.sendKeys(quickQuote.BillFirstName(), "Testfirst");
			SeleniumFunction.sendKeys(quickQuote.BillLastName(), "Testlast");
			SeleniumFunction.sendKeys(quickQuote.BillCompanytName(), "abc");			
			SeleniumFunction.sendKeys(quickQuote.BillPhone(), "1234567890");
			SeleniumFunction.sendKeys(quickQuote.BillAddress1(), "Add1");
			SeleniumFunction.sendKeys(quickQuote.BillAddress2(), "Add2");
			SeleniumFunction.sendKeys(quickQuote.Billzip(), "90001");
			SeleniumFunction.sendKeys(quickQuote.Billcity(), "TestCity");
			SeleniumFunction.select(quickQuote.Billcountry(), "United States");
			SeleniumFunction.select(quickQuote.Billstate(), "Alabama");
			ScreenShot.takeScreenShot(driver, "Payment Page");
			jse.executeScript("window.scrollBy(0,550)", "");
			SeleniumFunction.click(quickQuote.BookandPay());
			WaitTool.sleep(15);
			ScreenShot.takeScreenShot(driver, "Payment Confirmation");
			WaitTool.sleep(10);
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.sleep(10);
		}
	}
}
