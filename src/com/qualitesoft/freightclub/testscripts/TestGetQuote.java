package com.qualitesoft.freightclub.testscripts;
import com.qualitesoft.core.Xls_Reader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.testscripts.TestManageProducts;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestGetQuote extends InitializeTest{
	
	public void searchPackageTypeProduct(String productName) {
		QuickQuote quickQuote = new QuickQuote(driver);

		WaitTool.sleep(2);
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.BACK_SPACE);
		WaitTool.sleep(2);
		SeleniumFunction.sendKeys(quickQuote.productvalue(), productName);
		WaitTool.sleep(5);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(2);
	}

	public void addSearchProduct() {
		QuickQuote quickQuote = new QuickQuote(driver);

		SeleniumFunction.scrollUpByPixel(driver, "1000");
		SeleniumFunction.click(quickQuote.Addproduct());
		SeleniumFunction.click(quickQuote.searchproduct());				
		this.searchPackageTypeProduct("prodTBQW");
		ScreenShot.takeScreenShot(driver, "product added at shipment information page") ;
	}

	public void enterShipmentInformation(Xls_Reader xr) {
		QuickQuote quickQuote = new QuickQuote(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int i=Integer.parseInt(Row);

		String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
		String packageType = xr.getCellData("Input", "packageType", i).trim();
		String packageType2 = xr.getCellData("Input", "packageType2", i).trim();

		String palletDescription = xr.getCellData("ShipmentInformation", "PalletDescription", 2);

		SeleniumFunction.scrollUpByPixel(driver, "300");
		if(packageType.equals("Standard Pallet 2") || packageType.equals("Custom Pallet (enter dimensions)") || packageType2.equals("Standard Pallet 2")) {
			SeleniumFunction.click(quickQuote.genericPallet());
			SeleniumFunction.sendKeys(quickQuote.palletDescription(), palletDescription);
		}
		
		/*
		 * if(Row.equalsIgnoreCase("5") || Row.equalsIgnoreCase("8") ||
		 * Row.equalsIgnoreCase("9")) { this.addSearchProduct(); }
		 */
		
		jse.executeScript("window.scrollBy(0,-350)", "");
		WaitTool.sleep(3);
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "Test Special Handling Instructions");
		jse.executeScript("window.scrollBy(0,400)", "");
		WaitTool.sleep(15);
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com90001']"), 10));	
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com10011']"), 10));	
		jse.executeScript("window.scrollBy(0,350)", "");
		ScreenShot.takeScreenShot(driver, "Filled Shipment info "+shipmentType+" "+packageType);
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(10);
	}

	@Test
	public void testGetQuote() {

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int i=Integer.parseInt(Row);

		//clear existing data
		xr.setCellData("Input","OrderId", i,"");

		//Read data from sheet for selected row
		String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
		String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
		String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
		String pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
		String pickUpType=xr.getCellData("Input","pickUpType", i).trim();
		String dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
		String dropOffType=xr.getCellData("Input","dropOffType", i).trim();			
		String packageType = xr.getCellData("Input", "packageType", i).trim();
		String packageType2 = xr.getCellData("Input", "packageType2", i).trim();
		String Weight=xr.getCellData("Input","Weight", i).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		String category1=xr.getCellData("Input","category", i).trim();			
		String DeclaredValue=xr.getCellData("Input","DeclaredValue", i).trim();
		String Cartons=xr.getCellData("Input","Cartons", i).trim();

		QuickQuote quickQuote = new QuickQuote(driver);
		SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());

		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		if (shipmentType.equalsIgnoreCase("LTL")) {
			SeleniumFunction.click(quickQuote.LTLShipment());
		} else {
			SeleniumFunction.click(quickQuote.ParcelShipment());
		}

		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(5);
		SeleniumFunction.scrollUpByPixel(driver, "1500");
		SeleniumFunction.click(quickQuote.OrderDate());
		WaitTool.sleep(5);
		SeleniumFunction.click(quickQuote.OrderDate1());

		SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), orderReferenceID);

		SeleniumFunction.clickAction(driver, quickQuote.ServiceLevel());
		if(!shipmentType.equals("Parcel"))
		{					
			if (serviceLevel.contains("White Glove - Light Assembly")) {
				SeleniumFunction.click(quickQuote.ServiceLevelWG());
			} else if (serviceLevel.contains("Back Of Truck")) {
				SeleniumFunction.click(quickQuote.ServiceLevelBOT());
			} else if (serviceLevel.contains("Curbside")) {
				SeleniumFunction.click(quickQuote.ServiceLevelCUR());
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

		SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip.trim());
		SeleniumFunction.sendKeys(quickQuote.DropOffZip(),dropOffZip.trim());
		jse.executeScript("window.scrollBy(0,250)", "");

		SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
		SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);

		if(category1.equalsIgnoreCase("Other")){
			SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			SeleniumFunction.click(quickQuote.popupCateogory());
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,500)", "");
		}
		else {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
		}

		SeleniumFunction.scrollDownByPixel(driver, "1000");
		if (shipmentType.equalsIgnoreCase("LTL")){
			SeleniumFunction.click(quickQuote.PackageType());			
		}
		else{
			SeleniumFunction.click(quickQuote.PackageTypeParcel());
		}

		if(Row.equalsIgnoreCase("2") || Row.equalsIgnoreCase("7") || Row.equalsIgnoreCase("12")) {
			this.searchPackageTypeProduct(TestManageProducts.Productname);
		} else {
			WaitTool.sleep(5);
			quickQuote.PackageTypeOptions(packageType);
			SeleniumFunction.click(quickQuote.Weight());
			SeleniumFunction.sendKeys(quickQuote.Weight(), Weight);
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), DimensionL);

			SeleniumFunction.sendKeys(quickQuote.DimensionW(), DimensionW);

			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), DeclaredValue);
			if (shipmentType.equals("Parcel")) {}
			else if(packageType.equals("Non-Palletized")) {}
			else {
				SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
			}
		}

		// LTL select 2 package type
		if (packageType2.equalsIgnoreCase("Standard Pallet 2")) {
			SeleniumFunction.click(quickQuote.addadditionalItem());
			WaitTool.sleep(2);
			SeleniumFunction.scrollDownUptoFooter(driver);
			SeleniumFunction.click(quickQuote.PackageType2());
			System.out.println("package selected: " + packageType2);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath("(//div[@class='selectize-dropdown single form-input']//div/div[@data-value='850'])[2]"),
					30));
			System.out.println("package selected" + packageType2);
			SeleniumFunction.click(quickQuote.Weight2());
			System.out.println("Weight" + Weight);
			SeleniumFunction.sendKeys(quickQuote.Weight2(), Weight);

			SeleniumFunction.sendKeys(quickQuote.DimensionH2(), DimensionH);

			// Change by shubham
			WaitTool.sleep(1);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath("//span[text()='Select categories']"), 30));
			WaitTool.sleep(1);
			SeleniumFunction.click(
					WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@value='347'])[2]"), 30));

			// Add popup on cateory Other
			SeleniumFunction.click(quickQuote.popupCateogory2());

			SeleniumFunction.sendKeys(quickQuote.DeclaredValue2(), DeclaredValue);
			SeleniumFunction.sendKeys(quickQuote.Cartons2(), Cartons);
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
		}

		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Shipmentinfo "+shipmentType+" "+packageType);
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(quickQuote.SaveButton());
		WaitTool.sleep(20);
		jse.executeScript("window.scrollBy(0,-250)", "");


		//Select Carrier Tab
		SeleniumFunction.scrollUp(driver);
		jse.executeScript("window.scrollBy(0,250)", "");
		quickQuote.waitForQuotesToAppear();
		ScreenShot.takeScreenShot(driver, "Rates wih Carriers "+shipmentType+" "+packageType);
		WaitTool.sleep(5);
		List<WebElement> oklist=driver.findElements(By.xpath("//button[@data-role='end']"));
		if(oklist.size() >0) {
			driver.findElement(By.xpath("//button[@data-role='end']")).click();
		}
		jse.executeScript("return document.readyState").toString().equals("complete");

		if(Row.equalsIgnoreCase("11") || Row.equalsIgnoreCase("12")) {
			SeleniumFunction.click(quickQuote.UPSSureButton());
		}else {
			if(serviceLevel.equalsIgnoreCase("Ground")) {
				SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//table[@id='table-quotes']//tbody//tr[1]//td[6]//button"), 60));
			}else {
				SeleniumFunction.clickJS(driver, quickQuote.NextButton());
			}
		}			
		WaitTool.sleep(10);

		/*
		 * if(Row.equalsIgnoreCase("3")) { jse.executeScript("window.scrollBy(0,-1000)",
		 * ""); SeleniumFunction.click(quickQuote.Addproduct());
		 * SeleniumFunction.click(quickQuote.searchproduct()); WaitTool.sleep(2);
		 * Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		 * keyboard.pressKey(Keys.BACK_SPACE); WaitTool.sleep(2);
		 * SeleniumFunction.sendKeys(quickQuote.productvalue(),
		 * TestManageProducts.Productname); WaitTool.sleep(2);
		 * SeleniumFunction.KeyBoradEnter(driver); ScreenShot.takeScreenShot(driver,
		 * "product added ") ; }
		 */

		//Shipment information tab 
		if(i != 9) {
			this.enterShipmentInformation(xr);
		}

		//Review and Book Tab
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.clickJS(driver, quickQuote.Book());
		WaitTool.sleep(30);
		ScreenShot.takeScreenShot(driver, "Order Confirmation "+shipmentType+" "+packageType);
		SeleniumFunction.click(quickQuote.Okbutton1());
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60);
		WaitTool.sleep(10);
		crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']")));

		//set order id in excel
		xr.setCellData("Input","OrderId", i,crorderId.trim());
		WaitTool.sleep(5);
	}			
}