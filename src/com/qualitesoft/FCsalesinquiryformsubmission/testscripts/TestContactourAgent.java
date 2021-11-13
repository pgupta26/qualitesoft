package com.qualitesoft.FCsalesinquiryformsubmission.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.FCsalesinquiryformsubmission.pageobjects.ContactUsLink;

public class TestContactourAgent extends InitializeTest{
	


	@Test
	public void testContactourAgent(){

		WebDriver driver = getDriver();
		ContactUsLink contact = new ContactUsLink(driver);
		WaitTool.sleep(7);
		String Text= SeleniumFunction.getText(contact.contactourAgent());
		if(Text.equalsIgnoreCase("Contact Our Agents")) {
			ScreenShot.takeScreenShot(driver, "Contact Our Agent displayed succesfully");	
			Log.warn("Contact Our Agent displayed succesfully");
		}else {
			ScreenShot.takeScreenShot(driver, "Contact Our Agent not displayed succesfully");
			Log.warn("Contact Our Agent not displayed succesfully");
		}		
	}

}
