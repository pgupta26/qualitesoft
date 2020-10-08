package com.qualitesoft.freightclub_enhancement.qa537.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	String category;			
	String DeclaredValue;
	String Cartons;
	JavascriptExecutor jse;
	QuickQuote quickQuote;

	
	@Test
	public void testLTLShipmentInformation() {
		try{
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			i=Integer.parseInt(Row);
			Log.info("Reading data from row1: "+Row);

			shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
			pickUpType=xr.getCellData("Input","pickUpType", i).trim();
			dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
			dropOffType=xr.getCellData("Input","dropOffType", i).trim();			
			packageType = xr.getCellData("Input", "packageType", i).trim();
			Weight=xr.getCellData("Input","Weight", i).trim();
			DimensionL=xr.getCellData("Input","DimensionL", i).trim();
			DimensionW=xr.getCellData("Input","DimensionW", i).trim();
			DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			category=xr.getCellData("Input","category", i).trim();			
			DeclaredValue=xr.getCellData("Input","DeclaredValue", i).trim();
			Cartons=xr.getCellData("Input","Cartons", i).trim();
			jse = (JavascriptExecutor) driver;

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());	
			jse.executeScript("window.scrollBy(0,-500)", "");

			//To accept popup if present
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			jse.executeScript("window.scrollBy(0,-1500)", "");
			if (shipmentType.equalsIgnoreCase("LTL"))
				SeleniumFunction.click(quickQuote.LTLShipment());
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.OrderDate());
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.OrderDate1());
			//SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='datepicker-days']//td[@class='today day']"), 30));

			SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), orderReferenceID);
			SeleniumFunction.clickAction(driver, quickQuote.ServiceLevel());
			WaitTool.sleep(5);
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
			jse.executeScript("window.scrollBy(0,250)", "");

			SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
			SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);

			/*if (pickUpType.equalsIgnoreCase("Commercial")){
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeCom());
			} else {
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeRes());
			}
			System.out.println("dropOffType-"+dropOffType);
			if (dropOffType.equalsIgnoreCase("Commercial")) {
				SeleniumFunction.click(quickQuote.DropOffZipLocationTypeCom());
			} else {
				SeleniumFunction.click(quickQuote.DropOffZipLocationTypeRes());

			}*/
			
			this.insertItemInformation();
			
			if(i == 5) {
				i = 3;
				packageType = xr.getCellData("Input", "packageType", i).trim();
				DimensionH=xr.getCellData("Input","DimensionH", i).trim();
				Cartons=xr.getCellData("Input","Cartons", i).trim();
				
				// Add standard pallet type
				quickQuote.copyItemInformation();
				jse.executeScript("window.scrollBy(0,2500)", "");
				SeleniumFunction.click(quickQuote.PackageType2());
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='selectize-dropdown single form-input']//div/div[@data-value='850'])[2]"), 30));
				SeleniumFunction.sendKeys(quickQuote.DimensionH2(), "");
				SeleniumFunction.sendKeys(quickQuote.DimensionH2(), DimensionH);
				SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@id='CartonHeaviest']/input)[2]"), 30), Cartons);
				
				// Add new product type
				SeleniumFunction.click(quickQuote.addadditionalItem());
				jse.executeScript("window.scrollBy(0,2500)", "");
				
				String productName= "Auto_ProductName";
				WaitTool.sleep(2);
				Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
				keyboard.pressKey(Keys.BACK_SPACE);
				WaitTool.sleep(2);
				driver.findElement(By.xpath("(//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/div[1]/div[1]/div/div[1]/input)[3]")).sendKeys(productName);
				WaitTool.sleep(5);
				SeleniumFunction.KeyBoradEnter(driver);
				WaitTool.sleep(2);
			}
			
			jse.executeScript("window.scrollBy(0,2500)", "");
			SeleniumFunction.click(quickQuote.SaveButton());
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}	
	}

	public void insertItemInformation() {
		QuickQuote quickQuote = new QuickQuote(driver);
		if(category.equalsIgnoreCase("Other")) {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			SeleniumFunction.click(quickQuote.popupCateogory());
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
		} else {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "1183");
		}

		jse.executeScript("window.scrollBy(0,350)", "");
		if (shipmentType.equalsIgnoreCase("LTL"))
		{
			SeleniumFunction.click(quickQuote.PackageType());			
		}
		else{
			SeleniumFunction.click(quickQuote.PackageTypeParcel());
		}
		WaitTool.sleep(2);

		//LTL Select 1 Package Type
		if(i == 4) {
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			System.out.println("Product Name: "+com.qualitesoft.freightclub_enhancement.qa537.testscripts.TestManageProducts.Productname);
			driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/div[1]/div[1]/div/div[1]/input")).sendKeys(TestManageProducts.Productname);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
		} else {
			quickQuote.PackageTypeOptions(packageType);
			SeleniumFunction.click(quickQuote.Weight());
			SeleniumFunction.sendKeys(quickQuote.Weight(), Weight);
			
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), "");
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), DimensionL);

			SeleniumFunction.sendKeys(quickQuote.DimensionW(), "");
			SeleniumFunction.sendKeys(quickQuote.DimensionW(), DimensionW);

			SeleniumFunction.sendKeys(quickQuote.DimensionH(), "");
			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), DeclaredValue);
			
			if(i==3){
				SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
			}

			WaitTool.sleep(2);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
		}
	}
	
	@Test
	public void customOrderPopupPresent() {
		try {
			QuickQuote quickQuote = new QuickQuote(driver);
			SoftAssert as = new SoftAssert();
			as.assertEquals(quickQuote.customOrderHeader(), "Requires a Custom Quote");
			as.assertEquals(quickQuote.customOrderPopupBody(), "LTL Shipments are limited to 4 pallets per shipment.   Freight Club can provide you for a quote through our custom quote process, in which we use the information you've already provided.");
			as.assertTrue(quickQuote.customOrderReviseLTSDetailButton());
			as.assertTrue(quickQuote.customOrderCustomQuoteButton());
			ScreenShot.takeScreenShot(driver,"Custom Order Popup");
		}catch(AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}
	
	@Test
	public void customOrderPopupNotPresent() {
		QuickQuote quickQuote = new QuickQuote(driver);
		Assert.assertFalse(quickQuote.customOrderReviseLTSDetailButton());
		Assert.assertFalse(quickQuote.customOrderCustomQuoteButton());
	}
	
	@Test
	public void testVerifyRatesPage() {
		WaitTool.sleep(20);
		try {
			Assert.assertTrue(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[text()='Choose Your Rate']")));
			ScreenShot.takeScreenShot(driver, "Custom Order Popup not Present");
		} catch(AssertionError a) {
			a.printStackTrace();
			throw a;
		}
		
		//Back to Previous Page
		quickQuote = new QuickQuote(driver);
		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		jse.executeScript("window.scrollBy(0,5000)", "");
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/article/div/div[3]/div/div[5]/div/button"), 30));
		WaitTool.sleep(2);
	}
	
	@Test
	public void verifyCustomOrderPopupWithWeight251() {
		try {
			quickQuote = new QuickQuote(driver);
			i=Integer.parseInt(Row);
			if(i == 4) {
				this.customOrderPopupPresent();
				
				SeleniumFunction.click(quickQuote.getCustomQuoteButton());
				SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
				ScreenShot.takeScreenShot(driver, "Custom Order Present Verified.");
			} else {
				SeleniumFunction.sendKeys(quickQuote.Weight(), "251");
				SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
				SeleniumFunction.click(quickQuote.SaveButton());
				this.customOrderPopupPresent();
				
				SeleniumFunction.click(quickQuote.getCustomQuoteButton());
				SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
				ScreenShot.takeScreenShot(driver, "Custom Order Present Verified.");
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void verifyCustomOrderPopupWithMultilePackageType() {
		try {
			i=Integer.parseInt(Row);
			quickQuote = new QuickQuote(driver);
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,-2500)");
			SeleniumFunction.click(quickQuote.LTLShipment());

			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			for(int itemInformationCount =0; itemInformationCount <= 3; itemInformationCount++) {
				if(i == 4) {
					SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/ul/li/button[1]"), 30));
				} else {
					quickQuote.copyItemInformation();
				}
			}
			WaitTool.sleep(2);
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			SeleniumFunction.click(quickQuote.SaveButton());
			this.customOrderPopupPresent();
			
			SeleniumFunction.click(quickQuote.getCustomQuoteButton());
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			ScreenShot.takeScreenShot(driver, "Custom Order Present Verified.");
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test
	public void submitCustomOrderQuoteLTL() {
		try {
			QuickQuote quickQuote = new QuickQuote(driver);

			SeleniumFunction.click(quickQuote.getCustomQuoteButton());
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			i=Integer.parseInt(Row);
			
			String deliveryFrequency=xr.getCellData("Input","DeliveryFrequency", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String orderDetails=xr.getCellData("Input","OrderDetails", i).trim();

			SeleniumFunction.sendKeys(quickQuote.deliveryFrequency(), deliveryFrequency);
			SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));
			SeleniumFunction.sendKeys(quickQuote.regulatoryDetails(), regulatoryDetails);
			ScreenShot.takeScreenShot(driver, "Shipment Details");
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,600)");
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
