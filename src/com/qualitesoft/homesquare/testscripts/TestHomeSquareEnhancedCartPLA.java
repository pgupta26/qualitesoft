package com.qualitesoft.homesquare.testscripts;

import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareAddToCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;



public class TestHomeSquareEnhancedCartPLA extends InitializeTest{
	
 
	@Test
	public void testEnhancedCartPLA(){
	
         WebDriver driver = getDriver(); 
         //CartPage cartPage1 = new CartPage(driver);
         HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
         WaitTool.sleep(5);
         WebElement continueShoppingButton= cartPage.continueShoppingButton();
         SeleniumFunction.clickJS(driver, continueShoppingButton);;
         WaitTool.sleep(5);
         ScreenShot.takeScreenShot(driver, "Product page");
         
         String oldURL=SeleniumFunction.getCurrentUrl(driver);
         URI uri= JavaFunction.appendUri(oldURL, plaquery);
        SeleniumFunction.get(driver, uri.toString());
        driver.get(uri.toString());
         WaitTool.sleep(1);
         ScreenShot.takeScreenShot(driver, "PLA-Productpage");
         WaitTool.sleep(5);
         HomeSquareAddToCartPage addToCartPage= new HomeSquareAddToCartPage(driver);
         SeleniumFunction.clickJS(driver, addToCartPage.plaaddToCartButton());
 		 SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
 		 ScreenShot.takeScreenShot(driver, "AddToCartPage"); 
         
         SeleniumFunction.click(cartPage.deleteProductLink());
         ScreenShot.takeScreenShot(driver, "ProductRemoved"); 
         WaitTool.sleep(5);
         SeleniumFunction.sendKeys(cartPage.addProductQuantity(), "2");
         SeleniumFunction.clickAction(driver, cartPage.updateProductQuantity());
         ScreenShot.takeScreenShot(driver, "QuantityUpdated"); 
         SeleniumFunction.click(cartPage.checkoutButton());
         
		}
 
}
