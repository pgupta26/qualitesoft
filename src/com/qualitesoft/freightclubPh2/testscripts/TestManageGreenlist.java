package com.qualitesoft.freightclubPh2.testscripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestManageGreenlist extends InitializeTest {

	@Test
	public void testManagegreenlist() {

		LandingPage landingPage = new LandingPage(driver);
		try {
			for(int i=1;i<=17;i++){
			    Robot r = new Robot();
			    r.keyPress(KeyEvent.VK_TAB);
			    r.keyRelease(KeyEvent.VK_TAB);
			    //System.out.println("Tabbed "+i+" time.");
			}
	
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		WaitTool.sleep(5);
		SeleniumFunction.click(landingPage.manageGreenLink());		
		ScreenShot.takeScreenShot(driver, "Green List");
		//download
		SeleniumFunction.click(landingPage.downloadGreenlistLink());
		WaitTool.sleep(2);
		Robot r;
		//String text = JavaFunction.randomText("Greenlist",5);
		SimpleDateFormat sdfmth = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String text = "Greenlist"+sdfmth.format(cal.getTime()).replaceAll("\\s", "_");
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);

			r.keyPress(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitTool.sleep(2);
		ScreenShot.takeFullScreenShot("Green List" );
		//open excel and take screenshot
		   
	    try {
	    	//Runtime.getRuntime().exec("cmd /c start \"\" \"E:\\qs_automation\\binaries\\FCfiles\\Greenlist_Template.xlsx\"");
	    	Runtime.getRuntime().exec("cmd /c start \"\" \"binaries\\FCfiles\\Greenlist_Template_Ph2.xlsx\"");
	    	WaitTool.sleep(40);
			ScreenShot.takeScreenShotSystemExcel("Green List downloaded");
			WaitTool.sleep(15);
			Runtime.getRuntime().exec(
			        "cmd /c taskkill /f /im excel.exe");
	    	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//upload greenlist
	    WaitTool.sleep(20);
		landingPage.uploadFileChrome("Greenlist_Template_Ph2.xlsx");		
		WaitTool.sleep(5);
		SeleniumFunction.clickAction(driver, landingPage.uploadButton());
		ScreenShot.takeScreenShot(driver, "Green List selected");
		WaitTool.sleep(5);
		
		SeleniumFunction.clickAction(driver, landingPage.OKButton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Green List uploaded");
		
	}


}
