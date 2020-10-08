package com.qualitesoft.americanmattress.testscripts;


import org.testng.annotations.Test;
import com.qualitesoft.americanmattress.pageobjects.HomePage;
import com.qualitesoft.americanmattress.pageobjects.MattressesPage;
import com.qualitesoft.americanmattress.pageobjects.NavigationPage;
import com.qualitesoft.americanmattress.pageobjects.ProductPage;
import com.qualitesoft.americanmattress.pageobjects.ShoppingCartPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestAddItemsToCart extends InitializeTest{
	
	@Test
	public void testAddItemsToCart(){
		
		HomePage homePage = new HomePage(driver);
		/*SeleniumFunction.sendKeys(homePage.emailTextfield(),TestCreateNewAccount.emailAddress);
		SeleniumFunction.sendKeys(homePage.passwordTextfield(),"Cymax123");
		SeleniumFunction.click(homePage.loginButton());*/
		
	/*	ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		SeleniumFunction.click(shoppingCartPage.Dining());
		ScreenShot.takeScreenShot(driver, "Product page");
		SeleniumFunction.click(shoppingCartPage.Diningchair());
		ScreenShot.takeScreenShot(driver, "Product selected");
		SeleniumFunction.click(shoppingCartPage.AddChair());
		ScreenShot.takeScreenShot(driver, "Add product");
		WaitTool.sleep(4);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ProductPage productPage = new ProductPage(driver);
		SeleniumFunction.click(productPage.addToCartButton());
		ScreenShot.takeScreenShot(driver, "Product Added");*/
		
	homePage.pageTitle();
		WaitTool.sleep(4);
		NavigationPage navigationPage = new NavigationPage(driver);
		SeleniumFunction.clickJS(driver, navigationPage.mattressLink());		
		
		MattressesPage mattressesPage = new MattressesPage(driver);
		SeleniumFunction.click(mattressesPage.firstItemLink());
		ScreenShot.takeScreenShot(driver, "MattressPage");
		
		ProductPage productPage = new ProductPage(driver);
		//productPage.sizeDropDown();
		ScreenShot.takeScreenShot(driver, "ProductPage");
		//SeleniumFunction.selectByIndex(productPage.sizeDropDown(), 0);
		SeleniumFunction.click(productPage.addToCartButton());
		
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.keepShoppingLink();
		ScreenShot.takeScreenShot(driver, "ShoppingCartPage");		
	}

}
