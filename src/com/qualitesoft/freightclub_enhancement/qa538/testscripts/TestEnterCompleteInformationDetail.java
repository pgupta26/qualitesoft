package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEnterCompleteInformationDetail extends InitializeTest {
	
	@Test
	public void testEnterCompleteInformationDetail() {
		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.sendKeys(quickQuote.Address1(), "Address1");
			SeleniumFunction.sendKeys(quickQuote.Address2(), "Address2");
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.sendKeys(quickQuote.FirstName(), "UserFirstName");
			SeleniumFunction.sendKeys(quickQuote.LastName(), "UserLastName");
			SeleniumFunction.sendKeys(quickQuote.Phone1(), "12345678900");
			quickQuote.Email().clear();
			SeleniumFunction.sendKeys(quickQuote.Email(), "a@a.com");	
			jse.executeScript("window.scrollBy(0,350)", "");
			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "DropAddress1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress2(), "DropAddress2");
			SeleniumFunction.sendKeys(quickQuote.DropFirstName(), "DropUserFirstName");
			SeleniumFunction.sendKeys(quickQuote.DropLastName(), "DropUserLastName");
			SeleniumFunction.sendKeys(quickQuote.DropPhone1(), "12345678900");
			quickQuote.DropEmail().clear();
			SeleniumFunction.sendKeys(quickQuote.DropEmail(), "Drop@a.com");
			SeleniumFunction.click(quickQuote.ReviewOrder());
			WaitTool.sleep(15);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

}
