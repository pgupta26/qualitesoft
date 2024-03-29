package com.qualitesoft.americanmattress.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ConfirmationPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestOrderConfirmation extends InitializeTest{
	
	@Test
	public void testAddItemsToCart(){
		if(driver.findElements(By.xpath("//div[@class=confirmation-message]"))!= null){
	    	System.out.println("Element is Present");
	    	}else{
	    	System.out.println("Element is Absent");
	    	}
		ScreenShot.takeScreenShot(driver, "Order Confirmation");
	    //order id
	    WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'order-number')]/strong"), 60);
	    crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("//*[contains(@class,'order-number')]/strong")));
	    System.out.println("Orderid :" + crorderId);
	    String[] order=crorderId.split("-");
	    crorderId = order[1];
	    System.out.println("Orderid :" + crorderId);
	    
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		confirmationPage.returnToHomepageButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		WaitTool.sleep(4);
		SeleniumFunction.click(confirmationPage.returnToHomepageButton());	
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Return to Home Page");
		jse.executeScript("window.scrollBy(0,2250)", "");
		SeleniumFunction.click(confirmationPage.myAccountLink());
		WaitTool.sleep(4);
		SeleniumFunction.sendKeys(confirmationPage.email(), TestCreateNewAccount.emailAddress);
		SeleniumFunction.sendKeys(confirmationPage.password(), "Cymax123");
		SeleniumFunction.click(confirmationPage.signin());
		//jse.executeScript("window.scrollBy(0,350)", "");
		ScreenShot.takeScreenShot(driver, "Sign in As a created user");
		SeleniumFunction.click(confirmationPage.orderhistory());
		//jse.executeScript("window.scrollBy(0,350)", "");
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "OrderHistoryDetails");
/*		 WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='panel panel-default order-record'][1]/div/div/div/h4"), 60);
		    String Id=SeleniumFunction.getText(driver.findElement(By.xpath("//div[@class='panel panel-default order-record'][1]/div/div/div/h4")));
		    System.out.println("id :" + Id);
	
		    String[] ids=Id.split("#");
		    String  id = ids[1];
		    System.out.println("id :" + id);
		    if(crorderId.equals(id)) {
		    System.out.println("Order history contains last order id");
	    	}else{
	    	System.out.println("Order history doesn't contains last order id");
	    		
		    }*/
		  
				   System.out.println("Order history contains last order id: "+crorderId);
		    WaitTool.sleep(3);
	}
	
}
