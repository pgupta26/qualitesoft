package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;;

public class TestPayment extends InitializeTest {

	@Test
	public void testPayment() {
		QuickQuote quickQuote = new QuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		SeleniumFunction.sendKeys(quickQuote.CreditCardNumber(), "4111111145551142");
		SeleniumFunction.sendKeys(quickQuote.CardName(), "test");
		SeleniumFunction.sendKeys(quickQuote.CVV(), "737");
		SeleniumFunction.select(quickQuote.Month(), "3");
		SeleniumFunction.select(quickQuote.Year(), "2030");
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
