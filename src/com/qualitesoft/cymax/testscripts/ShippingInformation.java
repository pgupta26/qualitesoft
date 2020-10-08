package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.ShippingInformationPage;

public class ShippingInformation extends InitializeTest {

	@Test
	public void testShippingInformation() {
		try{
			CartPage cartPage = new CartPage(driver);
			NumberFormat f = NumberFormat.getInstance(); 

			WaitTool.sleep(5);
			ShippingInformationPage shippingInfo = new ShippingInformationPage(driver);
			if(testname.contains("Existing User")) {
				shippingInfo.enterNewAddress();	
			}
			
			if(suiteName.contains("Homesquare")) {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
				Assert.assertEquals(cartPage.tax(), tax1);
			} else {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
				Assert.assertEquals(cartPage.tax(), tax);
			}
			Assert.assertEquals(cartPage.shipping(), shipping);
			
			SeleniumFunction.sendKeys(cartPage.firstName(), "test");
			SeleniumFunction.sendKeys(cartPage.lastName(), "one");
			SeleniumFunction.sendKeys(cartPage.address1(), "Selenium_Address");
			SeleniumFunction.sendKeys(cartPage.address2(), "Selenium_Address");
			SeleniumFunction.sendKeys(cartPage.zipcode(), "83341");
			System.out.println(" zip code  83341");
			SeleniumFunction.sendKeys(cartPage.city(), "Selenium_city");
			SeleniumFunction.select(cartPage.country(), "United States");
			WaitTool.sleep(5);
			SeleniumFunction.select(cartPage.state(), "Alabama");

			SeleniumFunction.sendKeys(cartPage.phone(), "4444444444");

	
			shippingInfo.businessCommercial();
			shippingInfo.companyName("company name");
			shippingInfo.industry("Education");
			SeleniumFunction.sendKeys(cartPage.SpecialDelivery(), "test");
			WaitTool.sleep(5);
			ScreenShot.takeScreenShot(driver, "shipping info");
			SeleniumFunction.click(cartPage.reviewButton());
			WaitTool.sleep(5);
			ScreenShot.takeFullScreenShot("Review Order page");
			if(suiteName.contains("Homesquare")) {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			} else {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			}
			Assert.assertEquals(cartPage.shipping(), shipping);
			Assert.assertEquals(cartPage.tax(), tax);
			SeleniumFunction.clickJS(driver,cartPage.reviewButton()); //continue payment		

		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("dfjd");
		}

	}


}
