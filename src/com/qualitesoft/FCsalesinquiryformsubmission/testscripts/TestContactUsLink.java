package com.qualitesoft.FCsalesinquiryformsubmission.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.FCsalesinquiryformsubmission.pageobjects.ContactUsLink;

public class TestContactUsLink extends InitializeTest{
	


	@Test
	public void testContactUsLink(){	WebDriver driver = getDriver();
	ContactUsLink contact = new ContactUsLink(driver);
	SeleniumFunction.clickJS(driver, contact.contactusLink());
	WaitTool.sleep(5);
	ScreenShot.takeScreenShot(driver, "Navigate to Contact Us Page");
	}

}
