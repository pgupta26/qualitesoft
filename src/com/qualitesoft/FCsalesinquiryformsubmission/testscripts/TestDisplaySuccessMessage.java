package com.qualitesoft.FCsalesinquiryformsubmission.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.FCsalesinquiryformsubmission.pageobjects.ContactUsLink;

public class TestDisplaySuccessMessage extends InitializeTest{
	


	@Test
	public void testContactourAgent(){

		WebDriver driver = getDriver();
		ContactUsLink contact = new ContactUsLink(driver);
		String Text= SeleniumFunction.getText(contact.successMessage());
		WaitTool.sleep(10);
		if(Text.equalsIgnoreCase("Your message was sent successfully. Thanks.")) {
			ScreenShot.takeScreenShot(driver, "Your message was sent successfully.");
			Log.info("Your message was sent successfully");
		}else {
			ScreenShot.takeScreenShot(driver, "Your message was not sent successfully");
			Log.warn("Your message was not sent successfully");
		}		
	}

}
