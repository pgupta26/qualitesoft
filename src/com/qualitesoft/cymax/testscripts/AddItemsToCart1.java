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
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;

public class AddItemsToCart1 extends InitializeTest {
	
	@Test
	public void testVerifyBrandListing() {
		
		try {
			HomePage homePage = new HomePage(driver);
			if (homePage.cymaxPopup() != null) {
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
			ScreenShot.takeScreenShot(driver, "Product detail page");

			// More Detail Screenshot
			AddToCartPage addToCartPage = new AddToCartPage(driver);
			SeleniumFunction.scrollDownByPixel(driver, "1000");
			SeleniumFunction.click(addToCartPage.aboutTheBrand());
			SeleniumFunction.click(addToCartPage.brandLogo());
			ScreenShot.takeScreenShot(driver, "Brand Listing Page");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testAddItemsToCart() throws ParseException {
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

		// More Detail Screenshot
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		SeleniumFunction.click(addToCartPage.moreDetails());
		ScreenShot.takeScreenShot(driver, "Shipping Details Popup");
		SeleniumFunction.click(addToCartPage.closeShippingDetails());
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		jse.executeScript("arguments[0].value='2';", quantityDropdown);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		WaitTool.sleep(5);

		// Apply shipping
		CartPage cartPage = new CartPage(driver);
		if(testname.equals("Checkout via Credit Card - New User")){
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
		}
		WaitTool.sleep(5);
		this.paidShipping();
		ScreenShot.takeScreenShot(driver, "CartPage");
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.tax(), tax1);
		
		//Total Price Calculation
		double totalPrice = (productPrice * 2) + f.parse(cartPage.shipping().replace("$", "")).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);
		SeleniumFunction.click(cartPage.checkoutButton());
	}

	public void paidShipping() {
		try {
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath("//input[@type='radio' and @value='2']"), 30));
			WaitTool.sleep(15);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
