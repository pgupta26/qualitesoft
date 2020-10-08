package com.qualitesoft.bush.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.AddToCartPage;
import com.qualitesoft.bush.pageobjects.CartPage;
import com.qualitesoft.bush.pageobjects.MyAccountPage;
import com.qualitesoft.bush.pageobjects.ProductsPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.LoginPage;


public class AddItemsToCart extends InitializeTest {

	@Test
	public void testAddItemsToCart() throws ParseException {

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebElement furnitureLink = myAccountPage.furniturelink();
		SeleniumFunction.hoverAction(driver,furnitureLink);
		WaitTool.sleep(1);
		SeleniumFunction.click(myAccountPage.diningChairsLink());
		ScreenShot.takeScreenShot(driver, "Office Chairs page");

		ProductsPage productsPage = new ProductsPage(driver);
		WebElement diningChair = productsPage.diningChair();
		SeleniumFunction.click(diningChair);
		NumberFormat f = NumberFormat.getInstance(); 
		productPrice = f.parse(productsPage.productPrice().replace("$", "")).doubleValue(); 
		Log.info("**************************************************Product Price : "+productPrice);
		ScreenShot.takeScreenShot(driver, "Product List Page");

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		jse.executeScript("arguments[0].value='2';", quantityDropdown);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());

		CartPage cartPage = new CartPage(driver);
		ScreenShot.takeScreenShot(driver, "CartPage");
		Assert.assertEquals(f.parse(cartPage.getProductPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		Assert.assertEquals(cartPage.getShipping(), shipping);
		Assert.assertEquals(cartPage.getTax(), tax1);
		System.out.println("Row value: "+Row);
		if(Row.equals("yes"))
			SeleniumFunction.click(cartPage.checkoutButton());
		
		if(suiteName.equals("Bush Suite - Payal")) {
			LoginPage loginPage =new LoginPage(driver);
			if(loginPage.alreadyHaveAccountPresent()) {
				loginPage.alreadyHaveAccount();
				loginPage.userName(crusername);
				loginPage.password(crpassword);
				ScreenShot.takeScreenShot(driver, "login information entered");
				loginPage.signInButton();
				Log.info("login successfully.");
			}	
		}
	}
	
}
