package com.qualitesoft.homesquare.testscripts;

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
import com.qualitesoft.homesquare.pageobjects.HomeSquareAddToCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareProductsPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;


public class AddToCart extends InitializeTest{
	@Test
	public void  addToCart(){
		try {
			HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
			HomeSquareHomePage homepage = new HomeSquareHomePage(driver);
			HomeSquareProductsPage productsPage = new HomeSquareProductsPage(driver);
			
			if(homepage.closePopupWrapperStatus() == true){
				SeleniumFunction.clickJS(driver, homepage.closePopupWrapper());
				WaitTool.sleep(2);
			}	
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			WebElement diningChairsLink = myAccountPage.kitchenAndDiningLink();
			SeleniumFunction.hoverAction(driver, diningChairsLink);
			WaitTool.sleep(2);
			
			if(driver.getTitle().contains("The wait operation timed out")){
				driver.navigate().refresh();
				driver.navigate().refresh();
			}
			
			SeleniumFunction.click(myAccountPage.HomeSqdiningChairsLink());
			ScreenShot.takeScreenShot(driver, "Beds category page");
			
			SeleniumFunction.sendKeys(homepage.searchField(), "1652636");
			WaitTool.sleep(5);		
			SeleniumFunction.click(homepage.searchButton1());
			WaitTool.sleep(15);		
			SeleniumFunction.click(productsPage.firstProductInListing());	
			WaitTool.sleep(10);
			NumberFormat f = NumberFormat.getInstance(); 
			productPrice = f.parse(productsPage.productPrice().replace("$", "")).doubleValue(); 
			Log.info("**************************************************Product Price : "+productPrice);
			ScreenShot.takeScreenShot(driver,"Product detail page");	
			
			HomeSquareAddToCartPage addToCartPage = new HomeSquareAddToCartPage(driver);
			WebElement quantityDropdown = addToCartPage.quantityDropdown();
			jse.executeScript("arguments[0].value='2';", quantityDropdown);
			SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
			WaitTool.sleep(10);	
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			ScreenShot.takeScreenShot(driver,"CartPage");
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			Assert.assertEquals(cartPage.tax(), tax);

		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	@Test
	public void paidShipping(){
		HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='2' and @class='shipping-radio']"), 60));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='6' and @class='shipping-radio']")));
		WaitTool.sleep(5);
		Assert.assertEquals(cartPage.shipping(), fastShipping);
	}
}
