package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.Test;


import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestSelectBrand extends InitializeTest{ 
	@Test
	public void testSelectBrand(){
		WaitTool.sleep(5);
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.scorecard());
		SeleniumFunction.click(login.scorecard());
		WaitTool.sleep(2);
	/*	ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
*/		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		//assign key board object
		/*Keyboard keyboard=(Keyboard) ((HasInputDevices) driver).getKeyboard();
		//enter a key
		keyboard.pressKey(Keys.ENTER);*/
		WaitTool.sleep(5);
		/*driver.close();
		driver.switchTo().window(newTab.get(0));*/
		ScreenShot.takeScreenShot(driver, "Brand selected");
		
		
		
	}
}
