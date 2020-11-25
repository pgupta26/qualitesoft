package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

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
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;

public class AddItemsToCart2 extends InitializeTest{

	@Test
	public void  addItemToCart() throws ParseException{
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			HomePage homepage = new HomePage(driver);
			if(homepage.cymaxPopup()!=null) {
				SeleniumFunction.click(homepage.cymaxPopup());
			}
			ProductsPage productsPage = new ProductsPage(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			WebElement furnitureLink = myAccountPage.furniturelink();
			WaitTool.sleep(1);
			SeleniumFunction.hoverAction(driver,furnitureLink);
			myAccountPage.bedLink();
			WaitTool.sleep(20);
			myAccountPage.murphyBeds();
			WaitTool.sleep(10);
			ScreenShot.takeScreenShot(driver, "Beds category page");

			ProductsPage productPage = new ProductsPage(driver);
			SeleniumFunction.sendKeys(homepage.HomeSqsearchTextField(), "1652636");
			SeleniumFunction.click(homepage.searchButton());
			SeleniumFunction.click(productsPage.firstProductInListing());	
			WaitTool.sleep(10);
			NumberFormat f = NumberFormat.getInstance(); 
			productPrice = f.parse(productPage.productPrice().replace("$", "")).doubleValue(); 
			Log.info("**************************************************Product Price : "+productPrice);
			ScreenShot.takeScreenShot(driver,"Product detail page");	         

			AddToCartPage addToCartPage = new AddToCartPage(driver);
			WebElement quantityDropdown = addToCartPage.quantityDropdown();
			jse.executeScript("arguments[0].value='2';", quantityDropdown);
			SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());

			CartPage cartPage = new CartPage(driver);
			ScreenShot.takeScreenShot(driver,"CartPage");
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			Assert.assertEquals(cartPage.tax(), tax);
	}
	
	@Test
	public void paidShipping(){
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='2' and @class='shipping-radio']"), 60));
			WaitTool.sleep(10);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
	}
	
	@Test
	public void testAmazonOnCartPage(){
			LoginPage loginPage =new LoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 60));
			Log.info("login successfully.");
			SeleniumFunction.click(loginPage.continueButton());
	}
}
