package com.qualitesoft.freightclub_enhancement.qa517.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEnterShipmentInformation extends InitializeTest {

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
	String quantity;
	JavascriptExecutor jse;
	QuickQuote quickQuote;
	
	@Test
	public void selectPalletizedPackageType() {
		try {
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			i=Integer.parseInt(Row);
			Log.info("Reading data from row: "+Row);

			packageType = xr.getCellData("Input", "packageType", i).trim();
			DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			Cartons=xr.getCellData("Input","Cartons", i).trim();

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.click(quickQuote.backBtn());
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.PackageType());			
			quickQuote.PackageTypeOptions(packageType);
			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
			quickQuote.quantity2("1");
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Palletized Package Type Selected");
			SeleniumFunction.click(quickQuote.SaveButton());
			
		}catch(Exception | AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}
	
	@Test
	public void selectAddedProductPackageType() {
		try {
			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.click(quickQuote.backBtn());
			jse = (JavascriptExecutor) driver;

			WaitTool.sleep(2);
			
			String productName= "Test_ProductName";
			SeleniumFunction.click(quickQuote.addadditionalItem());
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.cssSelector(".btn-remove:nth-child(1)"), 10));
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			driver.findElement(By.cssSelector("input[placeholder='Select or Search...']")).sendKeys(productName);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
			
			if(!Row.equals("7")) {
				quickQuote.quantity2("11");	
			}
		
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Added product package type selected");
			SeleniumFunction.click(quickQuote.SaveButton());	
		}catch(Exception | AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		}
	}
	
	@Test
	public void looseCartoonPopup() {
		
		try {
			QuickQuote quickQuote = new QuickQuote(driver);
			
			//Verify loose cartoon present when quantity = 11
			this.looseCartoonPopupPresent();
			ScreenShot.takeScreenShot(driver, "Loose cartoon popup when quantity = 11");
			SeleniumFunction.click(quickQuote.closeLooseCartonPopup());
			WaitTool.sleep(1);
			quickQuote.quantity2("1");
			
			//Verify loose cartoon present when quantity = 11 with multiple package type
			WaitTool.sleep(2);
			for(int itemInformationCount =2; itemInformationCount <= 11; itemInformationCount++)
				quickQuote.copyItemInformation();
			SeleniumFunction.executeJS(driver,"window.scrollBy(0,3000)");
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.SaveButton());
			this.looseCartoonPopupPresent();
			ScreenShot.takeScreenShot(driver, "Loose cartoon popup multiple package type");
			SeleniumFunction.click(quickQuote.closeLooseCartonPopup());
			WaitTool.sleep(1);
			SeleniumFunction.executeJS(driver,"window.scrollBy(0,-1700)");
			for(int itemInformationCount =2; itemInformationCount <= 11; itemInformationCount++)
				SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("(//div[@class='row margin-left-0'])[1]/descendant::li[2]/button"), 20));
			WaitTool.sleep(2);
			SeleniumFunction.executeJS(driver,"window.scrollBy(0,500)");
			SeleniumFunction.click(quickQuote.SaveButton());
			
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test
	public void testEnterShipmentInformation() {
		try{
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			i=Integer.parseInt(Row);
			Log.info("Reading data from row: "+Row);

			shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
			pickUpType=xr.getCellData("Input","pickUpType", i).trim();
			dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
			dropOffType=xr.getCellData("Input","dropOffType", i).trim();
			quantity = xr.getCellData("Input", "Quantity", i).trim();
			packageType = xr.getCellData("Input", "packageType", i).trim();
			Weight=xr.getCellData("Input","Weight", i).trim();
			DimensionL=xr.getCellData("Input","DimensionL", i).trim();
			DimensionW=xr.getCellData("Input","DimensionW", i).trim();
			DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			category1=xr.getCellData("Input","category", i).trim();			
			DeclaredValue=xr.getCellData("Input","DeclaredValue", i).trim();
			Cartons=xr.getCellData("Input","Cartons", i).trim();
			jse = (JavascriptExecutor) driver;

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());	
			jse.executeScript("window.scrollBy(0,-500)", "");

			//To accept popup if present
			WaitTool.sleep(10);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			if (shipmentType.equalsIgnoreCase("LTL"))
				SeleniumFunction.click(quickQuote.LTLShipment());
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.OrderDate());
			WaitTool.sleep(5);
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
			/*System.out.println("pickUpType-"+pickUpType);
			if (pickUpType.equalsIgnoreCase("Commercial")){
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
			//surepost doesn't support insurance
			System.out.println("Suite Name: "+suiteName);
			if(!suiteName.equals("Sure Post Suite")) {
				if(Row.equalsIgnoreCase("") ) {
					SeleniumFunction.click(quickQuote.insurance());
				}
			}

			this.insertItemInformation();
			
			WaitTool.sleep(3);
			ScreenShot.takeFullScreenShot("Shipmentinfo " +" "+ Row +shipmentType+" "+packageType);
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.click(quickQuote.SaveButton());
			
		}catch(Exception | AssertionError ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void insertItemInformation() {
		QuickQuote quickQuote = new QuickQuote(driver);
		if(category1.equalsIgnoreCase("Other")) {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			//Add popup on other category
			SeleniumFunction.click(quickQuote.popupCateogory());
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
		} else {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
		}

		jse.executeScript("window.scrollBy(0,350)", "");
		quickQuote.quantity2(quantity);
		if (shipmentType.equalsIgnoreCase("LTL"))
		{
			SeleniumFunction.click(quickQuote.PackageType());			
		}
		else{
			SeleniumFunction.click(quickQuote.PackageTypeParcel());
		}
		WaitTool.sleep(5);

		//LTL Select 1 Package Type
		quickQuote.PackageTypeOptions(packageType);
		SeleniumFunction.click(quickQuote.Weight());
		SeleniumFunction.sendKeys(quickQuote.Weight(), Weight);
		SeleniumFunction.sendKeys(quickQuote.DimensionL(), DimensionL);

		SeleniumFunction.sendKeys(quickQuote.DimensionW(), DimensionW);

		SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
		SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), DeclaredValue);
		if (shipmentType.equals("Parcel")) {

		} else if(packageType.equals("Non-Palletized")) {

		}else 
		{
			SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
		}
	}

	public void looseCartoonPopupPresent() {
		QuickQuote quickQuote = new QuickQuote(driver);
		Assert.assertEquals(quickQuote.looseCartonPopupHeader(), "Loose Carton Warning");
		Assert.assertEquals(quickQuote.looseCartonPopupBody(), "LTL Shipments that exceed 10 loose cartons will be manually reviewed after booking and may be cancelled/refunded at the carrier's discretion. To avoid this, please consider palletizing your shipment or contacting Freight Club support at 866-740-9830 for a manual quote.");
		Assert.assertTrue(quickQuote.looseCartonChangeOrder());
		Assert.assertTrue(quickQuote.looseCartonGetQuote());
	}
	public void looseCartoonPoppNotPresent() {
		QuickQuote quickQuote = new QuickQuote(driver);
		Assert.assertFalse(quickQuote.looseCartonChangeOrder());
		Assert.assertFalse(quickQuote.looseCartonGetQuote());
	}
	
	public void selectShipmentType(String shipmentType) {
		QuickQuote quickQuote = new QuickQuote(driver);

		if (shipmentType.equalsIgnoreCase("Parcial")) {
			SeleniumFunction.click(quickQuote.ParcelShipment());
		} else if(shipmentType.equalsIgnoreCase("LTL")) {
			SeleniumFunction.click(quickQuote.LTLShipment());
		}else if(shipmentType.equalsIgnoreCase("Custom")) {
			SeleniumFunction.click(quickQuote.CustomShipment());
		}
	}
}
