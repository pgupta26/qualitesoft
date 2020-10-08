package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.thoughtworks.selenium.Selenium;

public class AddItemsToCart1 extends InitializeTest {
	
	@Test
	public void testAddItemsToCart() {
		try {
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
			
			CartPage cartPage = new CartPage(driver);
			
			//Apply shipping
			this.paidShipping();
			ScreenShot.takeScreenShot(driver,"CartPage");
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			Assert.assertEquals(cartPage.shipping(), shipping);
			Assert.assertEquals(cartPage.tax(), tax1);			
			SeleniumFunction.click(cartPage.checkoutButton());	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void paidShipping(){
		try{
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='2' and @class='shipping-radio']"), 60));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='6' and @class='shipping-radio']")));
			WaitTool.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
