package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.PaymentPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestPayment  extends InitializeTest{
	
	@Test
	public void testPayment() {
		
		WebDriver driver = getDriver();
		
		PaymentPage paymentpage = new PaymentPage(driver);
		((JavascriptExecutor) driver).executeScript(
	        "scroll(" + paymentpage.paymentLink().getLocation().getX() + "," + paymentpage.paymentLink().getLocation().getY() + ")");
	    
		//BrainTree
	    SeleniumFunction.click(paymentpage.paymentLink());
	    WaitTool.sleep(20);
	    SeleniumFunction.click(paymentpage.checkboxBrainTree());
	    WaitTool.sleep(10);
	   
	    ((JavascriptExecutor) driver).executeScript(
		        "scroll(" + paymentpage.settingsBraintree().getLocation().getX() + "," + paymentpage.settingsBraintree().getLocation().getY() + ")");
	   
	    String BrainTreevalue=paymentpage.settingsBraintree().getAttribute("aria-expanded");
	    if(BrainTreevalue.equals("false"))
	    {
	    	SeleniumFunction.clickJS(driver,paymentpage.settingsBraintree());
	    }
	    else
	    {
	    System.out.println(BrainTreevalue);	
	    }
	    SeleniumFunction.sendKeys(paymentpage.braintreeMerchantID(), "n649z4jcwcqw4sn6");
	  //  SeleniumFunction.sendKeys(paymentpage.braintreeMerchantAccountID(), "1234");
	    SeleniumFunction.sendKeys(paymentpage.braintreePublicKey(), "xz4g9mpcg6hw7hmz");
	    SeleniumFunction.sendKeys(paymentpage.braintrePrivateKey(), "f679b843612f8f8398fd16461084e114");
	    ScreenShot.takeScreenShot(driver, "BrainTree");
	    SeleniumFunction.click(paymentpage.braintreSave());
	    WaitTool.sleep(6);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-150)", "");
	//Authorize Payment
	    SeleniumFunction.click(paymentpage.authrizeNet());
	    WaitTool.sleep(5);
	    ((JavascriptExecutor) driver).executeScript(
		        "scroll(" + paymentpage.settingsAuthrizeNet().getLocation().getX() + "," + paymentpage.settingsAuthrizeNet().getLocation().getY() + ")");
	   
	    String AuthrizenetValue=paymentpage.settingsAuthrizeNet().getAttribute("aria-expanded");
	    if(AuthrizenetValue.equals("false"))
	    {
	    	  	SeleniumFunction.clickJS(driver,paymentpage.settingsAuthrizeNet());
	    }
	    else
	    {
	    System.out.println(AuthrizenetValue);	
	    }
        
	    SeleniumFunction.sendKeys(paymentpage.authrizeLoginID(), "38yMk5CPy5U ");
        SeleniumFunction.sendKeys(paymentpage.authrizeTransactionKey(), "77py2xq8HGk35Qgd");
        ScreenShot.takeScreenShot(driver, "Authorize");
        SeleniumFunction.click(paymentpage.authrizeSave());
        WaitTool.sleep(5);
        jse.executeScript("window.scrollBy(0,-1650)", "");
        WaitTool.sleep(5);
       //Paypal
       /* SeleniumFunction.click(paymentpage.checkPaypal());
        WaitTool.sleep(10);
        
        String PaypalValue=paymentpage.settingsPaypal().getAttribute("aria-expanded");
        if(PaypalValue.equals("false"))
	    {
	    	  	SeleniumFunction.clickJS(driver,paymentpage.settingsPaypal());
	    }
	    else
	    {
	    System.out.println(PaypalValue);	
	    }
        
        SeleniumFunction.sendKeys(paymentpage.paypalClientID(), "AaYo5q-HQH5NC5nVRvVceBStadPGZpz74WWxQulH0N37H1HdzlowZBzXynGsNvqp7dAO9PdJk7xQbcfr");
        SeleniumFunction.sendKeys(paymentpage.paypalClient(), "EBXqDLjJL5C1XURRqXmijDQCo-9dLSf6j-kr6woRrcCOtHPaR5_qMkaL7gwOjxGSl3W5OGS1N8t6j5FC");
        ScreenShot.takeScreenShot(driver, "Paypal");
        SeleniumFunction.click(paymentpage.paypalSave());*/
        
	}
	
}
