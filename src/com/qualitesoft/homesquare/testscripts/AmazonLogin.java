package com.qualitesoft.homesquare.testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;

public class AmazonLogin extends InitializeTest {
	@Test
	public void testAmazonLoginAsGuest(){
		try{

			LoginPage loginPage =new LoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			SeleniumFunction.click(cartPage.checkoutButton());	
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 60));
			amazonLogin();
			SeleniumFunction.click(loginPage.amazonLoginBtn());
			Log.info("login successfully.");
			SeleniumFunction.click(loginPage.continueButton());
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	@Test
	public void testAmazonOnCartPage(){
		try{
			LoginPage loginPage =new LoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 60));
			Log.info("login successfully.");

			SeleniumFunction.click(loginPage.continueButton());

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@Test
	public void testAmazonLoginOnCartPage(){
		try{
			LoginPage loginPage =new LoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 60));
			amazonLogin();
			SeleniumFunction.click(loginPage.amazonLoginBtn());
			Log.info("login successfully.");

			SeleniumFunction.click(loginPage.continueButton());

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testAmazonLoginOnMyAccountPage(){
		try{
			WebDriver driver = getDriver();
			HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
			HomePage homepage = new HomePage(driver);
			LoginPage loginPage =new LoginPage(driver);
			SeleniumFunction.click(homepage.HomeSqmyAccountLink());
			WaitTool.sleep(3);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("OffAmazonPaymentsWidgets0"), 60));
			WaitTool.sleep(5);
			String parentWindow = driver.getWindowHandle();
			Set<String> handles =  driver.getWindowHandles();
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(parentWindow))
				{
					driver.switchTo().window(windowHandle);
					amazonLogin();
					SeleniumFunction.click(loginPage.amazonSignInBtn());
					Log.info("login successfully.");
					driver.switchTo().window(parentWindow); 
					WaitTool.sleep(5);//control to parent window
				}
			}
		}
		catch(Exception e){

		}
	}
	public static void amazonLogin(){
		LoginPage loginPage =new LoginPage(driver);
		SeleniumFunction.sendKeys(loginPage.amazonEmail(), "Raj.r@cymax.com");
		SeleniumFunction.sendKeys(loginPage.amazonPassword(), "Welcome@2");
		ScreenShot.takeScreenShot(driver, "Amazon login information entered");


	}
}
