package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestManageProducts extends InitializeTest {
	
	@Test
	public void testManageProducts() {
			QuickQuote quickQuote = new QuickQuote(driver);
			Productname=JavaFunction.randomText("prod", 4);
			Log.info("Product Name: "+Productname);
			LandingPage landingPage = new LandingPage(driver);
			SeleniumFunction.clickJS(driver, landingPage.manageProductLink());
			WaitTool.sleep(15);
			quickQuote.acceptPopup();
			WaitTool.sleep(5);	
			SeleniumFunction.click(landingPage.createproduct());	
			ScreenShot.takeScreenShot(driver, "Create Product");
			SeleniumFunction.sendKeys(landingPage.SKU(),JavaFunction.randomText("ProdSKU", 6));
			SeleniumFunction.sendKeys(landingPage.productName(),Productname);
			SeleniumFunction.sendKeys(landingPage.declaredValue(),"211");
			SeleniumFunction.sendKeys(landingPage.weight(),"70");
			SeleniumFunction.sendKeys(landingPage.length(),"11");
			SeleniumFunction.sendKeys(landingPage.width(),"12");
			SeleniumFunction.sendKeys(landingPage.height(),"13");
			if(testname.contains("Weight greater than 250 - LTL  Added-Product")) {
				SeleniumFunction.sendKeys(landingPage.cartoonweight(),"251");
			}else {
				SeleniumFunction.sendKeys(landingPage.cartoonweight(),"70");
			}
			
			SeleniumFunction.sendKeys(landingPage.cartoonlength(),"11");
			SeleniumFunction.sendKeys(landingPage.cartoonwidth(),"12");
			SeleniumFunction.sendKeys(landingPage.cartoonheight(),"13");
			SeleniumFunction.click(landingPage.cateogory());
			if(testname.contains("Weight greater than 250 - LTL  Added-Product")) {
				SeleniumFunction.click(landingPage.safeCategory());
			}else {
				SeleniumFunction.click(landingPage.cateogoryoption());
			}
			WaitTool.sleep(5);	
			SeleniumFunction.click(landingPage.saveproduct());
			ScreenShot.takeScreenShot(driver, "Product Added");
	}
}
