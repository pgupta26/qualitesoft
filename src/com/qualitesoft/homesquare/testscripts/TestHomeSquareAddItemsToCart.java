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
import com.qualitesoft.homesquare.pageobjects.HomeSquareAddToCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareProductsPage;

public class TestHomeSquareAddItemsToCart extends InitializeTest {

	@Test
	public void testAddItemsToCart() throws ParseException {

		HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
		HomeSquareHomePage homepage = new HomeSquareHomePage(driver);

		if(homepage.closePopupWrapperStatus() == true){
			SeleniumFunction.clickJS(driver, homepage.closePopupWrapper());
			WaitTool.sleep(2);
		}	
		
		WebElement diningChairsLink = myAccountPage.kitchenAndDiningLink();
		SeleniumFunction.hoverAction(driver, diningChairsLink);
		WaitTool.sleep(2);
		SeleniumFunction.click(myAccountPage.HomeSqdiningChairsLink());

		if(driver.getTitle().contains("The wait operation timed out")){
			driver.navigate().refresh();
			driver.navigate().refresh();
		}
		
		HomeSquareProductsPage productsPage = new HomeSquareProductsPage(driver);
		WebElement diningChair = productsPage.diningChair();
		ScreenShot.takeScreenShot(driver, "Product list Page");
		SeleniumFunction.clickJS(driver, diningChair);
		NumberFormat f = NumberFormat.getInstance(); 
		productPrice = f.parse(productsPage.productPrice().replace("$", "")).doubleValue(); 
		Log.info("**************************************************Product Price : "+productPrice);


		HomeSquareAddToCartPage addToCartPage = new HomeSquareAddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdownHome();
		ScreenShot.takeScreenShot(driver, "Product page1");
		SeleniumFunction.select(quantityDropdown, "Quantity: 2");
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());

		HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
		ScreenShot.takeScreenShot(driver, "CartPage");
		Assert.assertEquals(f.parse(cartPage.getProductPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		Assert.assertEquals(cartPage.getShipping(), shipping);
		Assert.assertEquals(cartPage.getTax(), tax1);
		if(Row.equals("yes"))
			SeleniumFunction.click(cartPage.checkoutButton());
		WaitTool.sleep(5);
	}
}