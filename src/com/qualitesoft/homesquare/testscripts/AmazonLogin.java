package com.qualitesoft.homesquare.testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareLoginPage;


public class AmazonLogin extends InitializeTest {
	@Test
	public void testAmazonLoginAsGuest(){
		try{
			HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			WaitTool.sleep(5);
			SeleniumFunction.click(cartPage.checkoutButton());	
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 60));

			SeleniumFunction.getCurrentWindow(driver);
			Log.info("Switch to Window Title: "+driver.getTitle());

			if(loginPage.amazonEmailStatus() == true){
				amazonLogin();
				WaitTool.sleep(5);
				SeleniumFunction.click(loginPage.amazonLoginBtn());
				Log.info("login successfully.");
			}
			
			WaitTool.sleep(10);
			SeleniumFunction.click(loginPage.continueButton());

			SeleniumFunction.getCurrentWindow(driver);
			Log.info("Switch to Window Title: "+ driver.getTitle());

		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	@Test
	public void testAmazonOnCartPage(){
		try{
			HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
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
			HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
			HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.id("AmazonPayButton"), 30));
			WaitTool.sleep(10);

			SeleniumFunction.getCurrentWindow(driver);
			Log.info("Switch to Window Title: "+driver.getTitle());
			WaitTool.sleep(5);
			if(loginPage.amazonEmailStatus() == true){
				amazonLogin();
				WaitTool.sleep(5);
				SeleniumFunction.click(loginPage.amazonLoginBtn());
				Log.info("login successfully.");
			}
			
			SeleniumFunction.click(loginPage.continueButton());

			SeleniumFunction.getCurrentWindow(driver);
			Log.info("Switch to Window Title: "+driver.getTitle());

			/*amazonLogin();
			SeleniumFunction.click(loginPage.amazonLoginBtn());
			Log.info("login successfully.");*/

			/*			SeleniumFunction.click(loginPage.continueButton());
			 */
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testAmazonLoginOnMyAccountPage(){
		HomeSquareHomePage homepage = new HomeSquareHomePage(driver);
		HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
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
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='submit']"), 20));
				//amazonLogin();
				//SeleniumFunction.click(loginPage.amazonSignInBtn());
				Log.info("login successfully.");
				driver.switchTo().window(parentWindow); 
				WaitTool.sleep(15);//control to parent window
			}
		}
	}
	public static void amazonLogin(){
		HomeSquareLoginPage loginPage =new HomeSquareLoginPage(driver);
		SeleniumFunction.sendKeys(loginPage.amazonEmail(), "Raj.r@cymax.com");
		SeleniumFunction.sendKeys(loginPage.amazonPassword(), "Welcome@2");
		ScreenShot.takeScreenShot(driver, "Amazon login information entered");
	}
}
