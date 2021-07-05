package com.qualitesoft.homesquare.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.AddToCartPage;
import com.qualitesoft.homesquare.pageobjects.CartPage;
import com.qualitesoft.homesquare.pageobjects.MyAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareProductsPage;

public class TestHomeSquareAddItemsToCart extends InitializeTest {

	@Test
	public void testAddItemsToCart() throws ParseException {

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement diningChairsLink = myAccountPage.kitchenAndDiningLink();
		SeleniumFunction.hoverAction(driver, diningChairsLink);
		WaitTool.sleep(2);
		SeleniumFunction.click(myAccountPage.HomeSqdiningChairsLink());

		HomeSquareProductsPage productsPage = new HomeSquareProductsPage(driver);
		WebElement diningChair = productsPage.diningChair();
		ScreenShot.takeScreenShot(driver, "Product list Page");
		SeleniumFunction.click(diningChair);
		NumberFormat f = NumberFormat.getInstance(); 
		productPrice = f.parse(productsPage.productPrice().replace("$", "")).doubleValue(); 
		Log.info("**************************************************Product Price : "+productPrice);
		

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdownHome();
		ScreenShot.takeScreenShot(driver, "Product page1");
		SeleniumFunction.select(quantityDropdown, "Quantity: 2");
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());

		CartPage cartPage = new CartPage(driver);
		ScreenShot.takeScreenShot(driver, "CartPage");
		Assert.assertEquals(f.parse(cartPage.getProductPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		Assert.assertEquals(cartPage.getShipping(), shipping);
		Assert.assertEquals(cartPage.getTax(), tax1);
		if(Row.equals("yes"))
			SeleniumFunction.click(cartPage.checkoutButton());
	}
}