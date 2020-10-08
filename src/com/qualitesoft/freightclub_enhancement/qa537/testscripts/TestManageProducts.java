package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

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
			WaitTool.sleep(2);	
			SeleniumFunction.click(landingPage.createproduct());	
			ScreenShot.takeScreenShot(driver, "Create Product");
			SeleniumFunction.sendKeys(landingPage.SKU(),JavaFunction.randomText("ProdSKU", 6));
			SeleniumFunction.sendKeys(landingPage.productName(),Productname);
			SeleniumFunction.sendKeys(landingPage.declaredValue(),"100");
			SeleniumFunction.sendKeys(landingPage.weight(),weight);
			SeleniumFunction.sendKeys(landingPage.length(),"65");
			SeleniumFunction.sendKeys(landingPage.width(),"40");
			SeleniumFunction.sendKeys(landingPage.height(),"40");
			SeleniumFunction.click(landingPage.cateogory());
			SeleniumFunction.click(landingPage.safeCategory());
			//SeleniumFunction.click(landingPage.freightclass());
			WaitTool.sleep(2);
			SeleniumFunction.click(landingPage.saveproduct());
			WaitTool.sleep(3);	
			ScreenShot.takeScreenShot(driver, "Product Added");
		}catch(Exception ex) {
			ex.printStackTrace();throw ex;
		}
	}

}
