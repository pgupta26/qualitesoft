package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub_enhancement.qa517.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub_enhancement.qa538.testPages.Admin.ManageOrderNotQuotedTab;


public class TestSubmitCustomQuote extends InitializeTest {
	
	public void testValidateRequiredFields() {
		try{
			ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);
		    SeleniumFunction.scrollDownUptoFooter(driver);
		    SeleniumFunction.click(notQuotedTab.submitQuote());

			ArrayList<String> expectedRequiredFields = new ArrayList<String>();
			Collections.addAll(expectedRequiredFields, "Value is required"
					, "Value is required", "Value is required");
			ArrayList<String> actualRequiredFields  = new ArrayList<String>();
			List<WebElement> validationFields = driver.findElements(By.xpath("//span[@class='form-group-message']"));
			for(WebElement validationField :validationFields) {
				if(validationField.getCssValue("display").equals("block")){
					actualRequiredFields.add(validationField.getText());
				}
			}
			
			Log.info("Actual Required Fields:"+actualRequiredFields);
			Assert.assertEquals(actualRequiredFields, expectedRequiredFields);
			
		}catch(Exception | AssertionError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testSubmitCustomQuote() {
		
		try{
		
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			
			QuickQuote quickQuote = new QuickQuote(driver);
			WaitTool.sleep(20);
			quickQuote.acceptPopup();
			WaitTool.sleep(5);
			
			ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);
			SeleniumFunction.click(notQuotedTab.notQuoted());
			WaitTool.sleep(5);
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			String orderDetails=xr.getCellData("Input","OrderDetails", i).trim();
			String updatedOrderDetails=xr.getCellData("Input","updatedOrderDetails", i).trim();	
			String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			String handlingUnits = xr.getCellData("Input","HandlingUnits", i).trim();
			String totalWeight = xr.getCellData("Input","TotalWeight", i).trim();
			String declareValue=xr.getCellData("Input","DeclaredValue", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String quoteId = xr.getCellData("Input","QuoteID", i).trim();
			String COGS = xr.getCellData("Input","COGS", i).trim();
			String updatedShipmentInformation = xr.getCellData("Input","updatedShipmentInformation", i).trim();
			String updatedRegulatoryDetails = xr.getCellData("Input","updatedRegulatoryDetails", i).trim();
			String deliveryFrequency=xr.getCellData("Input","DeliveryFrequency", i).trim();
			String requiredTemp=xr.getCellData("Input","RequiredTemp", i).trim();
			String updatedRequiredTemp=xr.getCellData("Input","UpdatedRequiredTmp", i).trim();

			
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			System.out.println("Order Id: "+orderid);
			SeleniumFunction.sendKeys(notQuotedTab.orderIDFilter(), orderid);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(5);
		    
		    SeleniumFunction.click(notQuotedTab.complete());
		    WaitTool.sleep(5);
		    
		    if(i == 2) {
		    	this.testValidateRequiredFields();
		    }
		    		    
		    //Verify Details
		    Assert.assertTrue(quickQuote.customOrderDetails(orderDetails).isSelected());
		    if(orderDetails.equals("Requires refrigeration")) { 
		    	System.out.println("Attribute Value: "+quickQuote.requiredTemp().getAttribute("value"));
		    	Assert.assertEquals(quickQuote.requiredTemp().getAttribute("value"), requiredTemp);
				SeleniumFunction.sendKeys(quickQuote.requiredTemp(), updatedRequiredTemp);
		    }
			Assert.assertEquals(notQuotedTab.serviceLevel().getText(), serviceLevel);	
		    
			Select deliveryFrequencyDropDown = new Select(driver.findElement(By.xpath("//*[@id='shipment-review']/div[1]/div[3]/div/div[5]/div[1]/select")));
			if(i == 2) {
			    Assert.assertEquals("One Time Shipment", deliveryFrequencyDropDown.getFirstSelectedOption().getText().trim());
			} else if(i == 3){
			    Assert.assertEquals(deliveryFrequencyDropDown.getFirstSelectedOption().getText().trim(),deliveryFrequency);
			}
		    
			Assert.assertTrue(SeleniumFunction.getText(notQuotedTab.totalWeight()).contains(totalWeight.substring(0, 1)));
		    Assert.assertTrue(SeleniumFunction.getText(notQuotedTab.declaredValue()).contains(declareValue.substring(0, 1)));
		    Assert.assertTrue(SeleniumFunction.getText(notQuotedTab.handlingUnits()).contains(handlingUnits));   		   		    
		    Assert.assertEquals(notQuotedTab.regulatoryDetails().getAttribute("value"), regulatoryDetails);
		    ScreenShot.takeScreenShot(driver, "Verify details at submit quote page");
		    
		    //Enter new Details
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,-3000)");
		    SeleniumFunction.click(notQuotedTab.fulfillmentCarrier());
		    SeleniumFunction.click(driver.findElement(By.xpath("//div[@data-value='222']")));
		
		    SeleniumFunction.sendKeys(notQuotedTab.carrierQuoteID(), quoteId.substring(0, quoteId.indexOf(".")));
		    SeleniumFunction.sendKeys(notQuotedTab.COGS(), COGS.substring(0, quoteId.indexOf(".")));
		    
		    if(i == 3 || i==4) {
		    	String formatDate;
		    	SeleniumFunction.executeJS(driver, "window.scrollBy(0,-400)");
		    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				Date date = new Date();
				if(i==4) {
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.DAY_OF_MONTH, 1);
					formatDate = sdf.format(c.getTime()); 
				} else {
					formatDate = sdf.format(date);
				}
				Log.info("Current Date Created: "+formatDate);
				xr.setCellData("Input","RecurringExpiry", i,formatDate);
				SeleniumFunction.executeJS(driver, "arguments[0].removeAttribute('readonly', 'readonly')", notQuotedTab.recurringExpiry());
		    	notQuotedTab.recurringExpiry().clear();
				SeleniumFunction.sendKeys(notQuotedTab.recurringExpiry(), formatDate);
		    }
		   
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,800)");
		    notQuotedTab.shipmentInformation().clear();
		    notQuotedTab.regulatoryDetails().clear();
		    SeleniumFunction.sendKeys(notQuotedTab.shipmentInformation(), updatedShipmentInformation);
			SeleniumFunction.click(quickQuote.customOrderDetails(updatedOrderDetails));
		    SeleniumFunction.sendKeys(notQuotedTab.regulatoryDetails(), updatedRegulatoryDetails);
		    
		    WaitTool.sleep(5);
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,-800)");
		    WebElement markupPercentage = notQuotedTab.markupPercentage();
		    markupPercentage.clear();
		    SeleniumFunction.sendKeys(markupPercentage, "6");
		    WaitTool.sleep(5);
		    
		    //Submit Information
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,1000)");
		    ScreenShot.takeScreenShot(driver, "Submit quote details");
		    SeleniumFunction.click(notQuotedTab.submitQuote());
			WaitTool.sleep(10);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}catch(AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}
}
