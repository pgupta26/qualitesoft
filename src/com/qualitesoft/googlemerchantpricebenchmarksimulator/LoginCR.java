package com.qualitesoft.googlemerchantpricebenchmarksimulator;



import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.googlemerchantpricebenchmarksimulator.pageobjects.LoginPage;



public class LoginCR extends InitializeTest  {

	@Test
	public void testLoginCR() {

		LoginPage loginPage = new LoginPage(driver);
		 WaitTool.sleep(5);
         driver = getDriver();
 		 //Read data from excel		
  		Xls_Reader xr=new Xls_Reader("binaries/Inputfile.xlsx");		
  		String username=xr.getCellData("Sheet2","Username", 2).trim();
  		String password=xr.getCellData("Sheet2","Password", 2).trim();
  		System.out.println("username:" + username);
		
		SeleniumFunction.sendKeys(loginPage.emailField(),username);
		 SeleniumFunction.click(loginPage.nextbutton());
		SeleniumFunction.sendKeys(loginPage.passwordfield(),password);
		ScreenShot.takeScreenShot(driver, "Login ");
	    SeleniumFunction.click(loginPage.nextpwdbutton());
	    WaitTool.sleep(20);
	    ScreenShot.takeScreenShot(driver, "Home Page ");
	     		
	   // WaitTool.isElementPresentAndDisplay(driver, By.xpath("/html/body/nav/div[1]/div"));

  
 
    
  
	}

	
}

