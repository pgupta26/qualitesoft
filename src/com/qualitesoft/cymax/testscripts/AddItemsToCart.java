package com.qualitesoft.cymax.testscripts;

import java.net.URI;

import org.openqa.selenium.JavascriptExecutor;
//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;

public class AddItemsToCart extends InitializeTest {

	@Test
	public void testAddItemsToCart() {

		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		
		//SeleniumFunction.click(homePage.noThanks());
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,-250)", "");
		WebElement furnitureLink = myAccountPage.furniturelink();
		SeleniumFunction.hoverAction(driver,furnitureLink);
		 WaitTool.sleep(1);
		/*WebElement kitchenAndDiningLink = myAccountPage.kitchenAndDiningLink();
		SeleniumFunction.click(kitchenAndDiningLink);
		WaitTool.sleep(1);*/
		SeleniumFunction.click(myAccountPage.diningChairsLink());
		
		ProductsPage productsPage = new ProductsPage(driver);
		WebElement diningChair = productsPage.diningChair();
		ScreenShot.takeScreenShot(driver, "Product List Page");
		SeleniumFunction.click(diningChair);
	
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		ScreenShot.takeScreenShot(driver, "Product detail Page");
		SeleniumFunction.sendKeys(quantityDropdown, "Quantity: 2");
		//SeleniumFunction.select(quantityDropdown, "Quantity: 2");
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		
		CartPage cartPage = new CartPage(driver);
		//WebElement checkoutButton = cartPage.checkoutButton();
		//SeleniumFunction.click(cartPage.checkoutButton());
		ScreenShot.takeScreenShot(driver, "CartPage");
		//now go to Enhancedcartpage
		
		
	}
}
