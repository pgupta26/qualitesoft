package com.qualitesoft.freightclub.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;


public class TestManageGreenlist extends InitializeTest {

	@Test
	public void testManagegreenlist() {

		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.click(landingPage.manageGreenLink());
		
		QuickQuote quickQuote = new QuickQuote(driver);
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		
		SeleniumFunction.click(landingPage.downloadGreenlistLink());
		WaitTool.sleep(10);

		//open excel and take screenshot  
	    try {
	    	Runtime.getRuntime().exec("cmd /c start \"\" \"binaries\\FCfiles\\Greenlist_Template.xlsx\"");
	    	WaitTool.sleep(20);
			ScreenShot.takeScreenShotSystemExcel("Green List downloaded");
			WaitTool.sleep(15);
			Runtime.getRuntime().exec(
			        "cmd /c taskkill /f /im excel.exe");
	    	
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//upload greenlist
	    WaitTool.sleep(10);
		landingPage.uploadFileChrome("Greenlist_Template.xlsx");		
		WaitTool.sleep(5);
		SeleniumFunction.clickAction(driver, landingPage.uploadButton());
		ScreenShot.takeScreenShot(driver, "Green List selected");
		WaitTool.sleep(5);
		SeleniumFunction.clickAction(driver, landingPage.OKButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Green List uploaded");
	}
}
