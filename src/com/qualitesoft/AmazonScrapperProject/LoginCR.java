package com.qualitesoft.AmazonScrapperProject;



import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.AmazonScrapperProject.pageobjects.LoginPage;



public class LoginCR extends InitializeTest  {

	@Test
	public void testLoginCR()  {

	
		LoginPage loginPage = new LoginPage(driver);
		 WaitTool.sleep(5);
         driver = getDriver();
 		 //Read data from excel		
  		Xls_Reader xr=new Xls_Reader("binaries/AmazonScrapper.xlsx");		
  		String username=xr.getCellData("Sheet2","Username", 2).trim();
  		String password=xr.getCellData("Sheet2","Password", 2).trim();
  		System.out.println("username:" + username);
		
		SeleniumFunction.sendKeys(loginPage.emailField(),username);
		SeleniumFunction.sendKeys(loginPage.passwordfield(),password);
		ScreenShot.takeScreenShot(driver, "Login ");
	    SeleniumFunction.click(loginPage.signinbutton());
	    WaitTool.sleep(3);
	    ScreenShot.takeScreenShot(driver, "Home Page ");
	}
}

