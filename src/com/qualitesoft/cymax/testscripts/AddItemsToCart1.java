package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;


public class AddItemsToCart1 extends InitializeTest {
	
	@Test
	public void testAddItemsToCart() throws ParseException {
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			WebElement furnitureLink = myAccountPage.furniturelink();
			WaitTool.sleep(1);
			SeleniumFunction.hoverAction(driver,furnitureLink);
			myAccountPage.bedLink();
			myAccountPage.murphyBeds();
			ScreenShot.takeScreenShot(driver, "Beds category page");

			ProductsPage productPage = new ProductsPage(driver);
			productPage.murphyBed();
			NumberFormat f = NumberFormat.getInstance(); 
			productPrice = f.parse(productPage.productPrice().replace("$", "")).doubleValue(); 
			Log.info("**************************************************Product Price : "+productPrice);
			ScreenShot.takeScreenShot(driver,"Product detail page");	         
			
			AddToCartPage addToCartPage = new AddToCartPage(driver);
			WebElement quantityDropdown = addToCartPage.quantityDropdown();
			jse.executeScript("arguments[0].value='2';", quantityDropdown);
			SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
			WaitTool.sleep(5);
						
			//Apply shipping
			CartPage cartPage = new CartPage(driver);
			this.paidShipping();
			ScreenShot.takeScreenShot(driver,"CartPage");
			UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			UseAssert.assertEquals(cartPage.shipping(), shipping);
			UseAssert.assertEquals(cartPage.tax(), tax1);			
			SeleniumFunction.click(cartPage.checkoutButton());	
	}
	
	public void paidShipping(){
		try{
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='radio' and @value='2']"), 30));
			WaitTool.sleep(15);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
