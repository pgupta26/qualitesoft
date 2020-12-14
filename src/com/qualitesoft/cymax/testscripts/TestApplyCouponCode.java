package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;

public class TestApplyCouponCode extends InitializeTest {
	
	@Test
	public void testApplyCouponCode() throws ParseException {
		
		HomePage homePage = new HomePage(driver);
		if(homePage.cymaxPopup()!=null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebElement furnitureLink = myAccountPage.furniturelink();
		WaitTool.sleep(1);
		SeleniumFunction.hoverAction(driver, furnitureLink);
		myAccountPage.bedLink();
		myAccountPage.murphyBeds();
		ScreenShot.takeScreenShot(driver, "Beds category page");

		ProductsPage productPage = new ProductsPage(driver);
		productPage.murphyBed();
		NumberFormat f = NumberFormat.getInstance();
		productPrice = f.parse(productPage.productPrice().replace("$", "")).doubleValue();
		Log.info("**************************************************Product Price : " + productPrice);
		ScreenShot.takeScreenShot(driver, "Product detail page");

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		jse.executeScript("arguments[0].value='2';", quantityDropdown);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		WaitTool.sleep(5);
		
		// Remove multiple products
		CartPage cartPage = new CartPage(driver);
		int cartItemCount=cartPage.cartItemCount();
		Log.info("Cart Item Count: "+cartItemCount);
		int i = 0;
		if(cartItemCount > 1) {
			while(i<(cartItemCount-1)){
				SeleniumFunction.click(cartPage.deleteProductLink());
				WaitTool.sleep(1);
				i++;
			}
		}

		AddItemsToCart1 obj = new AddItemsToCart1();
		obj.paidShipping();
		ScreenShot.takeScreenShot(driver, "CartPage");
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.tax(), tax1);
		
		//Verify coupon code applied successfully
		SeleniumFunction.click(cartPage.haveACouponCode());
		SeleniumFunction.sendKeys(cartPage.couponCode(), "CYMJBTEST");
		SeleniumFunction.click(cartPage.applyCouponCode());
		WaitTool.sleep(2);
		UseAssert.assertEquals(SeleniumFunction.getText(cartPage.couponResponse()), "Your coupon has been applied.");
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);
		
		//Total Price Calculation
		double totalPrice = (productPrice * 2) + f.parse(cartPage.shipping().replace("$", "")).doubleValue()-f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);
	}
}
