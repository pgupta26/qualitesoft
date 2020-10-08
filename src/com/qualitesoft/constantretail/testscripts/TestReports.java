package com.qualitesoft.constantretail.testscripts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.ReportPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestReports extends InitializeTest{

	
	@Test
	public void testReports() {
		
	WebDriver driver = getDriver();
	ReportPage reportPage = new ReportPage(driver);
	driver.navigate().refresh();
	WaitTool.sleep(10);
	SeleniumFunction.click(reportPage.reportsLink());
	WaitTool.sleep(5);
	SeleniumFunction.selectByVisibleText(reportPage.categories(), "Orders");
	WaitTool.sleep(5);
	SeleniumFunction.selectByVisibleText(reportPage.reports(), "Sales");
	SeleniumFunction.sendKeys(reportPage.dateFrom(), currentDate());
	SeleniumFunction.sendKeys(reportPage.dateTo(), futureDate()+Keys.TAB);
	
	WaitTool.sleep(5);
	ScreenShot.takeScreenShot(driver, "Date1");
	SeleniumFunction.click(reportPage.runReport());
	WaitTool.sleep(10);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
	ScreenShot.takeScreenShot(driver, "Reports");

	
	}
	private static String currentDate(){
		
		Date myDate=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		String currentDate=dateFormat.format(myDate);
		return currentDate;
	}
    
	private static String futureDate(){
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DATE, 1);
	String futureDate=dateFormat.format(c.getTime());
	return futureDate;
}
	
}	
		
		