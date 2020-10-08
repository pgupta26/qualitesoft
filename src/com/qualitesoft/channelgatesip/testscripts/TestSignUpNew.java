package com.qualitesoft.channelgatesip.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestSignUpNew extends InitializeTest{ 
	@Test
	public void testInstance(){
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Sign Up New User");
		
		LoginPage login = new LoginPage(driver);
	
		//Use robot class to press Ctrl+t keys    		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                       
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		/*Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
		//enter a key
		keyboard.pressKey(Keys.CONTROL);
		keyboard.sendKeys("T");*/
	
		WaitTool.sleep(2);
		//Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		WaitTool.sleep(2);
		driver.switchTo().window(tabs.get(1));
		WaitTool.sleep(2);
		driver.get("http://www.mailinator.com/v3/index.jsp?zone=public&query="+emailcreated+"#/#inboxpane");
		//driver.get("http://www.mailinator.com/v3/index.jsp?zone=public&query=selenium_2019_03_26_18_34_17#/#inboxpane");
		WaitTool.sleep(5);
		//WaitTool.sleep(5);
		//SeleniumFunction.click(login.emailmailinator());
		//SeleniumFunction.sendKeys(login.searchemail(),"Selenium_2019-03-23_12-51-06@mailinator.com");
		//SeleniumFunction.click(login.gobtn());
		SeleniumFunction.click(login.checkbox());
		driver.switchTo().frame("msg_body");
		SeleniumFunction.click(login.activate());		
		WaitTool.sleep(2);
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(2));
		SeleniumFunction.sendKeys(login.passwordinbox(),"123456");
		SeleniumFunction.sendKeys(login.confirmpasswordinbox(),"123456");
		Keyboard keyboard=(Keyboard) ((HasInputDevices) driver).getKeyboard();
		//enter a key
		keyboard.pressKey(Keys.TAB);
		SeleniumFunction.click(login.terms());
		SeleniumFunction.click(login.register());
		WaitTool.sleep(4);
	/*	//SeleniumFunction.sendKeys(login.email(),"Selenium_2019-03-23_12-33-10@mailinator.com");
		SeleniumFunction.sendKeys(login.email(),emailcreated);
		SeleniumFunction.sendKeys(login.passwordemail(),"test");
		ScreenShot.takeScreenShot(driver, "email filled details");
		SeleniumFunction.click(login.loginbtn());
		WaitTool.sleep(5);*/
		ScreenShot.takeScreenShot(driver, "After logged in ");
		SeleniumFunction.click(login.scorecard());
		WaitTool.sleep(8);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		WaitTool.sleep(3);
		ScreenShot.takeScreenShot(driver, "bestsellers selected");		
		
		
	}
	
	
}
