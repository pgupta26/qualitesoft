package com.qualitesoft.constantretail.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.ProductPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestExportProduct extends InitializeTest{
	
	public static String adminPortalWindow;
	public static String websiteWindow;
	@Test
	public void testEditProduct(){
		WaitTool.sleep(5);
	  ProductPage productsPage = new ProductPage(driver);
	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  jse.executeScript("window.scrollBy(0,100)", "");
	  SeleniumFunction.click(productsPage.exportProduct());
		WaitTool.sleep(2);
		Robot r;
		//String text = JavaFunction.randomText("Greenlist",5);
		SimpleDateFormat sdfmth = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String text = "products"+sdfmth.format(cal.getTime()).replaceAll("\\s", "_");
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		WaitTool.sleep(5);
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
		ScreenShot.takeFullScreenShot("Product downloaded" );
	  
	}
	


}	