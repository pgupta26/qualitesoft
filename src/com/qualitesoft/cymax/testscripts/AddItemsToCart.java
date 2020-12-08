package com.qualitesoft.cymax.testscripts;


import java.text.NumberFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;

public class AddItemsToCart extends InitializeTest {

	@Test
	public void testAddItemsToCart() {
		
		HomePage homepage = new HomePage(driver);
		if(homepage.cymaxPopup()!=null) {
			SeleniumFunction.click(homepage.cymaxPopup());
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
		ScreenShot.takeScreenShot(driver,"Product detail page");	         
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		ScreenShot.takeScreenShot(driver, "Product detail Page");
		SeleniumFunction.sendKeys(quantityDropdown, "Quantity: 2");
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());

	}
}
