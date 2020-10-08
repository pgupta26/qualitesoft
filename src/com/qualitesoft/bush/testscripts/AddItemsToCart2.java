package com.qualitesoft.bush.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;

public class AddItemsToCart2 extends InitializeTest {
	@Test
	public void testAddItemsToCart() throws ParseException {
		try{
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");		
		WebElement furnitureLink = myAccountPage.homeOfficelink();
		WaitTool.sleep(1);
		SeleniumFunction.hoverAction(driver,furnitureLink);
		WaitTool.sleep(1);
		SeleniumFunction.clickJS(driver, myAccountPage.diningChairsLink());
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
		Assert.assertEquals(cartPage.getTax(), tax);
		System.out.println("Row value: "+Row);
		//if(Row.equals("yes"))
			//Assert.assertEquals(cartPage.getShipping(), shipping);
			//SeleniumFunction.click(cartPage.checkoutButton());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void paidShipping(){
		try{
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='408' and @class='shipping-radio']"), 60));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='408' and @class='shipping-radio']")));
			WaitTool.sleep(5);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
