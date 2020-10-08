package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import java.util.ArrayList;
import java.util.Collections;
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

public class ShipmentInformation extends InitializeTest {

	int i;

	String shipmentType;
	String serviceLevel;
	String orderReferenceID;
	String pickUpZip;
	String pickUpType;
	String dropOffZip;
	String dropOffType;			
	String packageType ;
	String Weight;
	String DimensionL;
	String DimensionW;
	String DimensionH;
	String category1;			
	String DeclaredValue;
	String Cartons;

	public void validateRequiredFields() {
		ArrayList<String> expectedRequiredFields = new ArrayList<String>();
		Collections.addAll(expectedRequiredFields, "Pickup date is required", "Customer PO Number is required"
				, "Please select a Service Level", "Pick Up location is required", "Drop Off location is required"
				, "You must select a handling unit", "Value is required"
				, "Value is required", "Supply the details of the shipment.");
		ArrayList<String> actualRequiredFields  = new ArrayList<String>();
		List<WebElement> validationFields = driver.findElements(By.xpath("//span[@class='form-group-message']"));
		for(WebElement validationField :validationFields) {
			System.out.println(validationField.getCssValue("display"));
			if(validationField.getCssValue("display").equals("block")){
				actualRequiredFields.add(validationField.getText());
			}
		}
		
		Log.info("Actual Required Fields:"+actualRequiredFields);
		Assert.assertEquals(actualRequiredFields, expectedRequiredFields);
	}
	
	@Test
	public void validateCustomerOrderRequiredFields() {
		try {
			QuickQuote quickQuote = new QuickQuote(driver);
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			i=Integer.parseInt(Row);
			
			shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());
			WaitTool.sleep(10);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,-1500)");
			if(shipmentType.equals("Custom")) {
				SeleniumFunction.click(quickQuote.CustomShipment());
			}
			
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(5);
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,500)");
			SeleniumFunction.click(quickQuote.submitForQuote());
			this.validateRequiredFields();
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Required Fields Custom Order");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void testEnterShipmentInformation() {
		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_538.xlsx");
			i=Integer.parseInt(Row);
			
			shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
			pickUpType=xr.getCellData("Input","pickUpType", i).trim();
			dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
			dropOffType=xr.getCellData("Input","dropOffType", i).trim();			
			String  handlingUnits = xr.getCellData("Input","HandlingUnits", i).trim();
			String  totalWeight = xr.getCellData("Input","TotalWeight", i).trim();
			String declareValue=xr.getCellData("Input","DeclaredValue", i).trim();
			String deliveryFrequency=xr.getCellData("Input","DeliveryFrequency", i).trim();
			String shipmentInformation=xr.getCellData("Input","shipmentInformation", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String orderDetails = xr.getCellData("Input","OrderDetails", i).trim();
			String requiredTemp = xr.getCellData("Input","RequiredTemp", i).trim();
			
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());
			WaitTool.sleep(10);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,-1500)");
			if(shipmentType.equals("Custom")) {
				SeleniumFunction.click(quickQuote.CustomShipment());
			}
			WaitTool.sleep(2);
			quickQuote.acceptPopup();
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,-500)");
			SeleniumFunction.click(quickQuote.OrderDate());
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.OrderDate1());

			SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), orderReferenceID);
			SeleniumFunction.clickAction(driver, quickQuote.ServiceLevel());
			WaitTool.sleep(2);
			
			if(!shipmentType.equals("Parcel"))
			{
				if (serviceLevel.contains("White Glove - Light Assembly")) {
					SeleniumFunction.click(quickQuote.ServiceLevelWG());
				} else if (serviceLevel.contains("Back Of Truck")) {
					SeleniumFunction.click(quickQuote.ServiceLevelBOT());
				} else if (serviceLevel.contains("Curbside")) {
					//SeleniumFunction.click(quickQuote.ServiceLevelCUR());
					SeleniumFunction.clickJS(driver, quickQuote.ServiceLevelCUR());
				} else if (serviceLevel.contains("Threshold")) {
					SeleniumFunction.click(quickQuote.ServiceLevelTHR());
				} else if (serviceLevel.contains("Room of Choice")) {
					SeleniumFunction.click(quickQuote.ServiceLevelROC());
				} else if (serviceLevel.contains("White Glove - Packaging Removal")) {
					SeleniumFunction.click(quickQuote.ServiceLevelWGPR());
				}

			}else {
				SeleniumFunction.click(quickQuote.ServiceLevelGRND());
			}

			SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip.substring(0, pickUpZip.length() - 2));
			SeleniumFunction.sendKeys(quickQuote.DropOffZip(),
					dropOffZip.substring(0, dropOffZip.length() - 2));
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,250)");
		
			SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
			SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);
			/*//Pick Up Type
			if (pickUpType.equalsIgnoreCase("Commercial")){
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeCom());
			} else {
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeRes());
			}
			
			//Drop Off Type
			if (dropOffType.equalsIgnoreCase("Commercial")) {
				SeleniumFunction.click(quickQuote.DropOffZipLocationTypeCom());
			} else {
				SeleniumFunction.click(quickQuote.DropOffZipLocationTypeRes());

			}*/
			
			SeleniumFunction.select(quickQuote.handlingUnits(), handlingUnits);
			SeleniumFunction.sendKeys(quickQuote.totalWeights(), totalWeight);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), declareValue);
			
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,400)");
			
			if(i == 2) {
				SeleniumFunction.sendKeys(quickQuote.deliveryFrequency(), "tes");
				SeleniumFunction.click(quickQuote.submitForQuote());
				Assert.assertTrue(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[text()='Minimum width must be bigger than 4 characters']")));
			}
			
			if(i == 3) {
				Select sc = new Select(quickQuote.deliveryFrequencySelect());
				sc.selectByVisibleText(deliveryFrequency);
			}
			
			SeleniumFunction.sendKeys(quickQuote.deliveryFrequency(), shipmentInformation);
			if(orderDetails.equals("Requires refrigeration")) {
				SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));
				SeleniumFunction.sendKeys(quickQuote.requiredTemp(), requiredTemp);
			}else {
				SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));	
			}
			SeleniumFunction.sendKeys(quickQuote.regulatoryDetails(), regulatoryDetails);
			ScreenShot.takeScreenShot(driver, "Shipment Details");
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,1000)");
			SeleniumFunction.click(quickQuote.submitForQuote());
			
			WaitTool.sleep(30);
			quickQuote.acceptPopup();
			
			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[1])[3]"), 20);
			crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[1])[3]")));
			System.out.println("crorderId:" + crorderId.trim());
			
			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
