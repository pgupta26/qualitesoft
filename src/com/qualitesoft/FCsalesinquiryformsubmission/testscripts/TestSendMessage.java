package com.qualitesoft.FCsalesinquiryformsubmission.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.FCsalesinquiryformsubmission.pageobjects.ContactUsLink;

public class TestSendMessage extends InitializeTest{
	


	@Test
	public void testSendMessage(){
		WebDriver driver = getDriver();
		ContactUsLink contact = new ContactUsLink(driver);

		SeleniumFunction.sendKeys(contact.name(), "TestAutomation");
		SeleniumFunction.sendKeys(contact.email(), "test@a.com");
		SeleniumFunction.sendKeys(contact.subject(), "testSubject");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		WaitTool.sleep(2);
		SeleniumFunction.sendKeys(contact.message(), "Testmessage");
		ScreenShot.takeScreenShot(driver, "User Info entered successfully");
		
		SeleniumFunction.click(contact.sendmessage());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Message sent Successfully");

		
		
	}

}
