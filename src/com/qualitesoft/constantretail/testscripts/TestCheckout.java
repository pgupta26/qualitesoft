package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.CheckoutPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestCheckout extends InitializeTest  {

	public static String adminPortalWindow;
	public static String websiteWindow;
	@Test
	public void testCheckout() {
		
     driver = getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    WaitTool.sleep(10);
   
    adminPortalWindow =driver.getWindowHandle();      
    SeleniumFunction.click(checkoutPage.visitStore());
    SeleniumFunction.getCurrentWindow(driver);
    websiteWindow =driver.getWindowHandle();
    System.out.println("Title of original Page:" + driver.getTitle());
    
    checkoutPage.furnitureLink();
    WaitTool.sleep(15);
   
  /*  if(driver.findElements(By.xpath("//*[@id=form-newsletter-modal]/div/div/div[1]/h4"))!= null){
    	System.out.println("Element is Present");
    	}else{
    	System.out.println("Element is Absent");
    	}*/
    WebDriverWait wait = new WebDriverWait(driver, 2);
    try{      
		//wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Element is Present");
    }
    catch (Exception e){
    	System.out.println("Element is Absent");
    }
/*    if (isAlertPresents()) {
    	driver.switchTo().alert().accept();
    	driver.switchTo().defaultContent();
    	}

    	public boolean isAlertPresents() {
    	try {
    	driver.switchTo().alert();
    	return true;
    	}// try
    	catch (Exception e) {
    	return false;
    	}// catch
    	}*/
    
    
    //SeleniumFunction.click(driver.findElement(By.xpath("//*[@id='form-newsletter-modal']/div/div/div[1]/button")));
   //SeleniumFunction.hoverAction(driver, checkoutPage.furnitureLink());
    WaitTool.sleep(10);
    //SeleniumFunction.click(checkoutPage.furnitureLink1());
    SeleniumFunction.click(checkoutPage.furnitureLink());
    WaitTool.sleep(10);
    checkoutPage.product1();
    WaitTool.sleep(10);
    SeleniumFunction.click(checkoutPage.product1());
    checkoutPage.addToCart();
    WaitTool.sleep(5);
    SeleniumFunction.click(checkoutPage.addToCart());
	checkoutPage.checkoutButton();
	WaitTool.sleep(5);
	SeleniumFunction.click(checkoutPage.checkoutButton());
	WaitTool.sleep(5);
	checkoutPage.continueButton();
	SeleniumFunction.sendKeys(checkoutPage.guestUserName(), "test@g.com");
	SeleniumFunction.click(checkoutPage.continueButton());
	WaitTool.sleep(5);
	System.out.println(" start 90001");
	SeleniumFunction.sendKeys(checkoutPage.firstName(), "test");
	SeleniumFunction.sendKeys(checkoutPage.lastName(), "one");
	SeleniumFunction.sendKeys(checkoutPage.companyName(), "one");
	SeleniumFunction.sendKeys(checkoutPage.address1(), "Selenium_Address");
	SeleniumFunction.sendKeys(checkoutPage.address2(), "Selenium_Address");
	SeleniumFunction.sendKeys(checkoutPage.zipcode(), "83341");
	System.out.println(" zip code  90001");
	SeleniumFunction.sendKeys(checkoutPage.city(), "Selenium_city");
	SeleniumFunction.select(checkoutPage.country(), "USA");
	WaitTool.sleep(5);
	SeleniumFunction.select(checkoutPage.state(), "Alabama");
	
	SeleniumFunction.sendKeys(checkoutPage.phone(), "4444444444");
	WaitTool.sleep(5);
	SeleniumFunction.click(checkoutPage.reviewButton());
	WaitTool.sleep(10);
	SeleniumFunction.click(checkoutPage.continuePayment());
	WaitTool.sleep(10);
	SeleniumFunction.sendKeys(checkoutPage.creditCardNo(), "4111111111111111");
	SeleniumFunction.sendKeys(checkoutPage.cardName(), "Selenium test");
	SeleniumFunction.select(checkoutPage.expMonth(), "10 (Oct)");
	SeleniumFunction.select(checkoutPage.expYear(), "2018");
	SeleniumFunction.sendKeys(checkoutPage.securityCode(), "123");
	SeleniumFunction.click(checkoutPage.placeOrder());
	WaitTool.sleep(10);
    checkoutPage.orderPage();
    WaitTool.sleep(10);
    //order id
    WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'order-number')]/strong"), 60);
    crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("//*[contains(@class,'order-number')]/strong")));
    System.out.println("Orderid :" + crorderId);
	ScreenShot.takeScreenShot(driver, "orderId");
	driver.close();
	driver.switchTo().window(adminPortalWindow);
	
    
	}
	
	

}
		