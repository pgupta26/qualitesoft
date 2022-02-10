package com.qualitesoft.channelgatesip.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestInviteUser extends InitializeTest{ 
	@Test
	public void testInstance(){
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Invite User");
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.teams());
		WaitTool.sleep(5);
		SeleniumFunction.click(login.inviteuserBtn());
		emailcreated =emailAddress();
		SeleniumFunction.sendKeys(login.useremail(),emailcreated+"@mailinator.com");
		System.out.println(emailAddress());
		SeleniumFunction.sendKeys(login.firstname(),"test");
		SeleniumFunction.sendKeys(login.lastname(),"lastname");
		SeleniumFunction.sendKeys(login.companyname(),"cymax");
		SeleniumFunction.click(login.usergroup());
		//assign key board object
		Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
		//enter a key
		keyboard.pressKey(Keys.ENTER);
		ScreenShot.takeScreenShot(driver, "inviteuser filled details");
		WaitTool.sleep(2);
		SeleniumFunction.click(login.companyname());
		WaitTool.sleep(2);
		SeleniumFunction.click(login.invitebutton());
		WaitTool.sleep(7);
		ScreenShot.takeScreenShot(driver, "After Inviteuser ");
		
		
	}
	private static String emailAddress() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		String emailAddress = "selenium_" + dateFormat.format(date).replaceAll("\\s", "_");
		return emailAddress;
	}
	
}
