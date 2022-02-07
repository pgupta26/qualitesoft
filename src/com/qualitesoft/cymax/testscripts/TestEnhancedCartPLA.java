package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;


public class TestEnhancedCartPLA extends InitializeTest {

	@Test
	public void testEnhancedCartPLA() throws ParseException {
		CartPage cartPage = new CartPage(driver);
		WaitTool.sleep(5);
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		SeleniumFunction.clickJS(driver, addToCartPage.keepshoppingButton());

		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		ScreenShot.takeScreenShot(driver, "AddToCartPage");
		WaitTool.sleep(5);
		SeleniumFunction.clickAction(driver, cartPage.deleteProductLink());
		ScreenShot.takeScreenShot(driver, "ProductRemoved");
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(cartPage.addProductQuantity(), "2");
		WaitTool.sleep(5);
		SeleniumFunction.clickAction(driver, cartPage.updateProductQuantity());
		ScreenShot.takeScreenShot(driver, "QuantityUpdated");
		
		NumberFormat f = NumberFormat.getInstance(); 
		System.out.println("Product Total: "+SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'cart-product md-font-size')]/div/div[2]"), 20)));
		productPrice = f.parse(SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'cart-product md-font-size')]/div/div[2]"), 20)).replace("$", "")).doubleValue(); 
		Log.info("**************************************************Product Price : "+productPrice);
		ScreenShot.takeScreenShot(driver,"Product detail page");	         
		
		SeleniumFunction.click(cartPage.checkoutButton());
	}
}
