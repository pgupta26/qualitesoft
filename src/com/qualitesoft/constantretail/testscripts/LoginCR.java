package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


import com.qualitesoft.constantretail.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;



public class LoginCR extends InitializeTest  {


	@Test
	public void testLoginCR() {
		
         driver = getDriver();
		LoginPage loginPage = new LoginPage(driver);		
		SeleniumFunction.sendKeys(loginPage.emailField(),crusername);
		SeleniumFunction.sendKeys(loginPage.passwordfield(),crpassword);
		ScreenShot.takeScreenShot(driver, "dataprovided");
		//SeleniumFunction.sendKeysAction(driver, loginPage.passwordfield(), Keys.ENTER);
	    SeleniumFunction.click(loginPage.signInbutton());    
	    WaitTool.isElementPresentAndDisplay(driver, By.xpath("/html/body/nav/div[1]/div")); 
	}
	
}
