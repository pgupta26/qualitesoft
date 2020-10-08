package com.qualitesoft.freightclub_enhancement.qa518.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub_enhancement.qa518.testPages.CarrierMarkupsPage;

public class TestCarrierMarkups extends InitializeTest{
	
	/*@Test
	public void clearMarkups() {
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		int[] num = {1,2,3,4,5,13,14};
		int[] num1 = {7,8,9,10,11};
		for(int i=0; i<num.length; i++) {
			SeleniumFunction.executeJS(driver,"arguments[0].value = '';", markups.groundMarkups(String.valueOf(num[i])));
		}
		
		WaitTool.sleep(1);

		for(int i=0; i<num1.length; i++) {
			SeleniumFunction.executeJS(driver,"arguments[0].value = '';", markups.nextDayAirEarlyAM(String.valueOf(num1[i])));
		}
		
		WaitTool.sleep(1);

		SeleniumFunction.executeJS(driver,"arguments[0].value = '';", markups.standard("12"));
		markups.standard("12").sendKeys(Keys.TAB);
	}*/
	
	@Test
	public void setMarkups(){
		int i=Integer.parseInt(Row);
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
		WaitTool.sleep(3);
		SeleniumFunction.clickJS(driver, markups.clickCarrierMarkups());
		SeleniumFunction.scrollDownByPixel(driver, "100");
		WaitTool.sleep(5);
		
		SeleniumFunction.selectByvalue(markups.selectShipMethod(xpathRow), xr.getCellData("Markups", "Dollar/PercentageValue", i).trim());
		SeleniumFunction.selectByvalue(markups.selectIncDec(xpathRow),  xr.getCellData("Markups", "Inc/DecValue", i).trim());
		ScreenShot.takeScreenShot(driver, "Markup Selected");
	}
	
	@Test
	public void setGroundMarkups(){
		int i=Integer.parseInt(Row);
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
		System.out.println("Data Row: " +Row);
		
		SeleniumFunction.sendKeys(markups.groundMarkups(xpathRow), xr.getCellData("Markups", "Markups", i).trim());
		markups.groundMarkups(xpathRow).sendKeys(Keys.TAB);
		ScreenShot.takeScreenShot(driver, "Set Group Markup");
	}
	
	@Test
	public void setNextDayAirEarlyAMMarkups(){
		int i=Integer.parseInt(Row);
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
		System.out.println("Data Row: " +Row);
		
		SeleniumFunction.sendKeys(markups.nextDayAirEarlyAM(xpathRow), xr.getCellData("Markups", "Markups", i).trim());
		markups.nextDayAirEarlyAM(xpathRow).sendKeys(Keys.TAB);
		ScreenShot.takeScreenShot(driver, "Set Next Day Air Markup");
	}
	
	@Test
	public void setStandardMarkups(){
		int i=Integer.parseInt(Row);
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
		System.out.println("Data Row: " +Row);
		
		SeleniumFunction.sendKeys(markups.standard(xpathRow), xr.getCellData("Markups", "Markups", i).trim());
		markups.standard(xpathRow).sendKeys(Keys.TAB);
		ScreenShot.takeScreenShot(driver, "Set Standard Markup");
	}
	
	@Test
	public void logout(){
		CarrierMarkupsPage markups=new CarrierMarkupsPage(driver);
		HomePage homepage=new HomePage(driver);
		//SeleniumFunction.scrollUp(driver);
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.clickJS(driver, markups.clkUpdateBtn());
		WebElement element = WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//div[@class='toast-message']") , 30);
		if(element.isDisplayed()) {
			Assert.assertEquals(element.getText(), "All markups applied successfully.");
			ScreenShot.takeScreenShot(driver, "Success Message");
		}
		SeleniumFunction.clickJS(driver, homepage.logoff());
		WaitTool.sleep(2);
	}
}
