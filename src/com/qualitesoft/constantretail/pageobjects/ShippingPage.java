package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ShippingPage {

		

		WebDriver driver;
		public ShippingPage(WebDriver driver) {
			this.driver = driver;
		
}
		public WebElement shippingLink() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/settings/shipping']"), 10);
		}
		
       public WebElement setByPrice(){
    	   
    	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//input[@value='price']"), 10);
       }	
       
      public WebElement addShippingRates(){
    	   
    	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@href='#addRatesPrice']"), 20);
       }
      public WebElement addRateWeight(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@href='#addRatesWeight']"), 10);
      }
      
     
      public WebElement priceFromField(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='price-from' and @data-bind='value: Bound1']"), 10);
         }
        
      
      public WebElement priceToField(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='price-to' and @data-bind='value: Bound2']"), 10);
      }
     
      public WebElement priceShippingCost(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='price-shipping-cost']"), 10);
         }
    //button[@type='button' and @data-bind='click: $root.Add']
    
      public WebElement addRateButton(){
     	   
     	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='addRatesPrice']/div[3]/div/div/div[2]/button"), 10);
        }
      
      public WebElement setByWeight(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//input[@value='weight']"), 10);
      }	
    
      public WebElement weightFrom(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//input[@id='weight-from']"), 10);
         }	
      
      public WebElement weighTo(){
     	   
     	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//input[@id='weight-to']"), 10);
        }	
    
      public WebElement shippingRateWeight(){
    	   
    	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesWeight']/div[2]/div/div/div[1]/div/input"), 10);
       }	 
    
      public WebElement saveWeight(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesWeight']/div[2]/div/div/div[2]/button"), 10);
      }	
            
      public WebElement setByDistance(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='location']"), 10);
         }	
      
      public WebElement addRateLocation(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@href='#addRatesLocation']"), 10);
         }
    
      public WebElement locationTo(){
     	   
     	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesLocation']/div[1]/div/div/div[1]/div/input"), 10);
        } 
      
      public WebElement locationFrom(){
    	   
    	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesLocation']/div[1]/div/div/div[2]/div/input"), 10);
       } 
    
      public WebElement locationShipppingRate(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesLocation']/div[2]/div/div[1]/div[1]/div/input"), 10);
      }  
    
      public WebElement saveRatesLocation(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesLocation']/div[2]/div/div[2]/div/button"), 10);
         } 
      
      public WebElement setByZip(){
     	   
     	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='zip']"), 10);
        }	 
      
      public WebElement addRateZip(){
     	   
     	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@href='#addRatesZip']"), 10);
        } 
    
      public WebElement shippingRate(){
    	   
    	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesZip']/div/div[1]/div/input"), 10);
       } 
    
      public WebElement shippingZone(){
   	   
   	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='addRatesZip']/div/div[2]/input"), 10);
      } 
    
      public WebElement uploadZip(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='pickfiles']"), 10);
      } 
      
  	public void uploadzipChrome() {

		try {
			SeleniumFunction.click(uploadZip());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\FCfiles\\zips.xls" };
			SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}
       
      public WebElement saveZip(){
      	   
      	   return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='add-rate-zip']"), 10);
      } 

}



