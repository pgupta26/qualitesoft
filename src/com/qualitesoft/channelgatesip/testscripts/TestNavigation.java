package com.qualitesoft.channelgatesip.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;


import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestNavigation extends InitializeTest{ 
	@Test
	public void testSelectBrand(){
		WaitTool.sleep(5);
		LoginPage login = new LoginPage(driver);
		SeleniumFunction.click(login.bestsellers());
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		ScreenShot.takeScreenShot(driver, "bestsellers selected");		
		SeleniumFunction.click(login.geoanalysis());
	
		WaitTool.sleep(7);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		ScreenShot.takeScreenShot(driver, "geoanalysis selected");
		
		SeleniumFunction.click(login.gapanalysis());
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		ScreenShot.takeScreenShot(driver, "gapanalysis selected");
		WaitTool.sleep(5);
		SeleniumFunction.click(login.marketing());	
		WaitTool.sleep(8);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		ScreenShot.takeScreenShot(driver, "marketing selected");	
		WaitTool.sleep(5);
		//SeleniumFunction.click(login.GeneralSettingsClose());
		WebElement element =
				driver.findElement(By.xpath("//a[@href='/app/sip/marketing']"));
				((JavascriptExecutor)
				driver).executeScript("arguments[0].scrollIntoView();", element);
		SeleniumFunction.click(login.keywordanalysis());
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(login.searchbrand(),"Abbyson Living");
		ScreenShot.takeScreenShot(driver, "keywordanalysis selected");
		WaitTool.sleep(10);
		
		
		
	}
}
