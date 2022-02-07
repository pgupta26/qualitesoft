package com.qualitesoft.vignettes.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ProductPage;
import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCartPages extends InitializeTest{
	
	@Test
	public void testCartPages(){
		
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		SeleniumFunction.click(shoppingCartPage.keepShoppingLink());
		SeleniumFunction.click(shoppingCartPage.Addotheritem_vig());
		ScreenShot.takeScreenShot(driver, "Add product");
		WaitTool.sleep(4);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ProductPage productPage = new ProductPage(driver);
		SeleniumFunction.click(productPage.addToCartButton());
		ScreenShot.takeScreenShot(driver, "Another Product Added");
				
		shoppingCartPage.removeLink();
		ScreenShot.takeScreenShot(driver, "CartPage");
		SeleniumFunction.click(shoppingCartPage.removeLink());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "CartPageItemRemoved");
		
	SeleniumFunction.sendKeys(shoppingCartPage.quantityTextfield(), "3");
		WaitTool.sleep(1);
		SeleniumFunction.click(shoppingCartPage.updateLink());
		WaitTool.sleep(8);
		ScreenShot.takeScreenShot(driver, "QuantityUpdated");
	}

}
