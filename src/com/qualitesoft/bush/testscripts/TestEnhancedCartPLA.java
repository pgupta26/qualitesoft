package com.qualitesoft.bush.testscripts;



import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.AddToCartPage;
import com.qualitesoft.bush.pageobjects.CartPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestEnhancedCartPLA extends InitializeTest{
	
 
	@Test
	public void testEnhancedCartPLA(){
	
         WebDriver driver = getDriver(); 
 		//HomePage homePage = new HomePage(driver);
         WaitTool.sleep(5);
 		//SeleniumFunction.click(homePage.noThanks());         
         CartPage cartPage = new CartPage(driver);
        // WebElement continueShoppingButton= cartPage.continueShoppingButton();
         //SeleniumFunction.clickJS(driver, continueShoppingButton);
         WaitTool.sleep(5);
         ScreenShot.takeScreenShot(driver, "Product page");
         
//         String oldURL=SeleniumFunction.getCurrentUrl(driver);
//         URI uri= JavaFunction.appendUri(oldURL, plaquery);
//         SeleniumFunction.get(driver, uri.toString());
//        // driver.get(uri.toString());
//         WaitTool.sleep(5);
//         ScreenShot.takeScreenShot(driver, "PLA-Productpage");
         AddToCartPage addToCartPage= new AddToCartPage(driver);
         SeleniumFunction.clickJS(driver, addToCartPage.keepshoppingButton());
        
 		 SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
 		 ScreenShot.takeScreenShot(driver, "AddToCartPage"); 
 		//SeleniumFunction.clickJS(driver, continueShoppingButton);
 		WaitTool.sleep(5);
         SeleniumFunction.clickAction(driver, cartPage.deleteProductLink());
         ScreenShot.takeScreenShot(driver, "ProductRemoved"); 
         WaitTool.sleep(2);
         SeleniumFunction.sendKeys(cartPage.addProductQuantity(), "2");
         WaitTool.sleep(5);
         SeleniumFunction.clickAction(driver, cartPage.updateProductQuantity());
         ScreenShot.takeScreenShot(driver, "QuantityUpdated"); 
 		 WebElement checkoutButton = cartPage.checkoutButton();
 		 SeleniumFunction.click(cartPage.checkoutButton());
         //now go to payment page
		}
 
}
