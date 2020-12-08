package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
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
	public void testApplyCouponCode() {
		
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
		ScreenShot.takeScreenShot(driver, "Product detail page");

		// More Detail Screenshot
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		jse.executeScript("arguments[0].value='2';", quantityDropdown);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		WaitTool.sleep(5);

		// Apply shipping
		CartPage cartPage = new CartPage(driver);
		ScreenShot.takeScreenShot(driver, "CartPage");
		SeleniumFunction.click(cartPage.haveACouponCode());
		SeleniumFunction.sendKeys(cartPage.couponCode(), "CYMJBTEST");
		SeleniumFunction.click(cartPage.applyCouponCode());
		WaitTool.sleep(2);
		System.out.println(SeleniumFunction.getText(cartPage.couponResponse()));
		UseAssert.assertEquals(SeleniumFunction.getText(cartPage.couponResponse()), "Your coupon has been applied.");	
	}
}
