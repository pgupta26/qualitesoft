package com.qualitesoft.freightclubPh2.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
public class TestManageProducts extends InitializeTest {

	public static String Productname;

	@Test
	public void testManageProducts() {
		try {
			QuickQuote quickQuote = new QuickQuote(driver);
			Productname=JavaFunction.randomText("prod", 4);
			System.out.println(Productname);
			LandingPage landingPage = new LandingPage(driver);
			SeleniumFunction.clickJS(driver, landingPage.manageProductLink());
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(5);	
			SeleniumFunction.click(landingPage.createproduct());	
			ScreenShot.takeScreenShot(driver, "Create Product");
			SeleniumFunction.sendKeys(landingPage.SKU(),JavaFunction.randomText("ProdSKU", 6));
			SeleniumFunction.sendKeys(landingPage.productName(),Productname);
			SeleniumFunction.sendKeys(landingPage.declaredValue(),"211");
			SeleniumFunction.click(landingPage.pallerRequired());
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Custom Pallet (enter dimensions)']"), 10));	
			SeleniumFunction.sendKeys(landingPage.weight(),"70");
			SeleniumFunction.sendKeys(landingPage.length(),"11");
			SeleniumFunction.sendKeys(landingPage.width(),"12");
			SeleniumFunction.sendKeys(landingPage.height(),"13");
			SeleniumFunction.sendKeys(landingPage.cartoonweight(),"70");
			SeleniumFunction.sendKeys(landingPage.cartoonlength(),"11");
			SeleniumFunction.sendKeys(landingPage.cartoonwidth(),"12");
			SeleniumFunction.sendKeys(landingPage.cartoonheight(),"13");
			SeleniumFunction.click(landingPage.cateogory());
			SeleniumFunction.click(landingPage.cateogoryoption());
			WaitTool.sleep(5);	
			SeleniumFunction.click(landingPage.saveproduct());
			ScreenShot.takeScreenShot(driver, "Product Added");
		}catch(Exception ex) {
			ex.printStackTrace();throw ex;
		}
	}

}
