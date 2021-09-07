package com.qualitesoft.freightclub.testscripts;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.testscripts.TestManageProducts;

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
	
	public void validateRequiredFields() {
		ArrayList<String> expectedRequiredFields = new ArrayList<String>();
		Collections.addAll(expectedRequiredFields, "Pickup date is required", "Customer PO Number is required"
				, "Please select a Service Level", "Pick Up location is required","Company name is required" 
				, "Address is required", "Drop Off location is required", "Address is required","You must select a handling unit", "Value is required"
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
			QuickQuote quickQuote = new QuickQuote(driver);
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
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
	}

	@Test
	public void selectPalletizedPackageType() {
		
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			i=Integer.parseInt(Row);
			Log.info("Reading data from row: "+Row);

			packageType = xr.getCellData("Input", "packageType", i).trim();
			DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			Cartons=xr.getCellData("Input","Cartons", i).trim();

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.click(quickQuote.backBtn());
			WaitTool.sleep(2);
			SeleniumFunction.scrollDownByPixel(driver, "2000");
			WaitTool.sleep(1);
			SeleniumFunction.click(quickQuote.PackageType());			
			quickQuote.PackageTypeOptions(packageType);
			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
			quickQuote.quantity2("1");
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Palletized Package Type Selected");
			SeleniumFunction.click(quickQuote.SaveButton());
	}

	@Test
	public void selectAddedProductPackageType() {

			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.click(quickQuote.backBtn());
			jse = (JavascriptExecutor) driver;

			WaitTool.sleep(2);
			SeleniumFunction.scrollDownByPixel(driver, "2000");
			WaitTool.sleep(2);
			String productName= "prodDNnz";
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
	}

	@Test
	public void looseCartoonPopup() {

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
				quickQuote.copyItemInformation(0);
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
	}

	@Test
	public void testEnterShipmentInformation() {
		
		Xls_Reader xr;
		String testDatasheet= "binaries/FCfiles/"+testData;
		xr=new Xls_Reader(testDatasheet);
		
		i=Integer.parseInt(Row);
		Log.info("Reading data from row: "+Row);

		shipmentType=xr.getCellData("Input","shipmentType", i).trim();
		serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
		orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
		pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
		pickUpType=xr.getCellData("Input","pickUpType", i).trim();
		dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
		dropOffType=xr.getCellData("Input","dropOffType", i).trim();
		packageType = xr.getCellData("Input", "packageType", i).trim();
		Weight=xr.getCellData("Input","Weight", i).trim();
		quantity=xr.getCellData("Input","Quantity", i).trim();
		DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		category1=xr.getCellData("Input","category", i).trim();			
		DeclaredValue=xr.getCellData("Input","DeclaredValue", i).trim();
		Cartons=xr.getCellData("Input","Cartons", i).trim();
		String  handlingUnits = xr.getCellData("Input","HandlingUnits", i).trim();
		String  totalWeight = xr.getCellData("Input","TotalWeight", i).trim();
		String declareValue=xr.getCellData("Input","DeclaredValue", i).trim();
		String deliveryFrequency=xr.getCellData("Input","DeliveryFrequency", i).trim();
		String shipmentInformation=xr.getCellData("Input","shipmentInformation", i).trim();
		String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
		String orderDetails = xr.getCellData("Input","OrderDetails", i).trim();
		String requiredTemp = xr.getCellData("Input","RequiredTemp", i).trim();
		
		
		jse = (JavascriptExecutor) driver;

		QuickQuote quickQuote = new QuickQuote(driver);
		if(!loginuser.equals("new")) {
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());	
		}
		
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		
		SeleniumFunction.scrollUpByPixel(driver, "2500");
		WaitTool.sleep(2);
		if (shipmentType.equalsIgnoreCase("LTL")) {
			SeleniumFunction.click(quickQuote.LTLShipment());
		} else if(shipmentType.equalsIgnoreCase("Custom")) {
			SeleniumFunction.click(quickQuote.CustomShipment());
		}
		
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		SeleniumFunction.scrollUpByPixel(driver, "2500");
		WaitTool.sleep(2);

		SeleniumFunction.click(quickQuote.OrderDate());
		WaitTool.sleep(5);
		SeleniumFunction.click(quickQuote.OrderDate1());

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

		if(loginuser.equals("new")) {
			String emailAddress = JavaFunction.randomText("Selenium", 4) + "@email.com";
			System.out.println("Email Address: "+emailAddress);
			SeleniumFunction.sendKeys(quickQuote.QuickEmail(),emailAddress);
			SeleniumFunction.selectByvalue(quickQuote.AccountType(), "11");
		}
		
		SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip.trim());
		SeleniumFunction.sendKeys(quickQuote.DropOffZip(),dropOffZip.trim());
		jse.executeScript("window.scrollBy(0,250)", "");


		SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
		SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);

		if(testname.contains("QA-538")) {
			
			SeleniumFunction.sendKeys(quickQuote.PickUpCompanyName(), "Pick Up Company");
			SeleniumFunction.sendKeys(quickQuote.dropOffCompanyName(), "Drop Off Company");
			SeleniumFunction.sendKeys(quickQuote.PickUpAddress1(), "Address Line1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "Address Line2");
			
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
				WaitTool.sleep(3);
				try {
					SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));	
				}catch(Exception ex) {
					Log.info("retry.............");
					WaitTool.sleep(2);
					SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));	
				}
			}
			SeleniumFunction.sendKeys(quickQuote.regulatoryDetails(), regulatoryDetails);
			
		}else {
			this.insertItemInformation();
		}
		
		if(testname.equals("Test Submit Custom Order - LTL")) {
			i = 3;
			packageType = xr.getCellData("Input", "packageType", i).trim();
			DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			Cartons=xr.getCellData("Input","Cartons", i).trim();
			
			// Add standard pallet type
			quickQuote.copyItemInformation(0);
			jse.executeScript("window.scrollBy(0,2500)", "");
			SeleniumFunction.click(quickQuote.PackageType2());
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='selectize-dropdown single form-input']//div/div[@data-value='850'])[2]"), 30));
			SeleniumFunction.sendKeys(quickQuote.DimensionH2(), "");
			SeleniumFunction.sendKeys(quickQuote.DimensionH2(), DimensionH);
			SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@id='CartonHeaviest']/input)[2]"), 30), Cartons);
			
			// Add new product type
			SeleniumFunction.click(quickQuote.addadditionalItem());
			jse.executeScript("window.scrollBy(0,2500)", "");
			
			String productName= "prodDNnz";
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			driver.findElement(By.xpath("(//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/div[1]/div[1]/div/div[1]/input)[3]")).sendKeys(productName);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
		}

		WaitTool.sleep(3);
		ScreenShot.takeFullScreenShot("Shipmentinfo " +" "+ Row +shipmentType+" "+packageType);
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(quickQuote.SaveButton());
		
		if(testname.contains("QA-538")) {
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(1);
			quickQuote.acceptPopup();
			WaitTool.sleep(1);
			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[2])[3]"), 30);
			crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[2])[3]")));
			System.out.println("crorderId:" + crorderId.trim());
			
			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);
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
			if(testname.contains("Custom Order")) {
				SeleniumFunction.selectByvalue(quickQuote.Category(), "1183");
			} else {
				SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
			}
		}

		jse.executeScript("window.scrollBy(0,350)", "");
		
		if(!testname.contains("Custom Order")) {
			quickQuote.quantity2(quantity);
		}
		
		if (shipmentType.equalsIgnoreCase("LTL"))
		{
			SeleniumFunction.click(quickQuote.PackageType());			
		}
		else{
			SeleniumFunction.click(quickQuote.PackageTypeParcel());
		}
		WaitTool.sleep(5);

		//LTL Select 1 Package Type
		if(i == 4) {
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/div[1]/div[1]/div/div[1]/input")).sendKeys(TestManageProducts.Productname);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
		} else {
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

	//***********************************QA - 537**************************************************

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
	}

	@Test
	public void verifyCustomOrderPopupWithMultilePackageType() {
			i=Integer.parseInt(Row);
			quickQuote = new QuickQuote(driver);
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,-2500)");
			SeleniumFunction.click(quickQuote.LTLShipment());
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,500)");
			for(int itemInformationCount =0; itemInformationCount <= 3; itemInformationCount++) {
				if(i == 4) {
					SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section[2]/div/div[5]/div[1]/div[2]/div/div/table/tr/td[2]/div/ul/li/button[1]"), 30));
				} else {
					quickQuote.copyItemInformation(itemInformationCount);
					SeleniumFunction.scrollDownUptoFooter(driver);
					WaitTool.sleep(1);
				}
			}
			WaitTool.sleep(2);

			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			SeleniumFunction.click(quickQuote.SaveButton());
			this.customOrderPopupPresent();

			SeleniumFunction.click(quickQuote.getCustomQuoteButton());
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
			ScreenShot.takeScreenShot(driver, "Custom Order Present Verified.");
	}

	@Test
	public void submitCustomOrderQuoteLTL() {
			QuickQuote quickQuote = new QuickQuote(driver);

			SeleniumFunction.click(quickQuote.getCustomQuoteButton());
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
			i=Integer.parseInt(Row);
			
			String deliveryFrequency=xr.getCellData("Input","DeliveryFrequency", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String orderDetails=xr.getCellData("Input","OrderDetails", i).trim();
			
			SeleniumFunction.scrollUpByPixel(driver, "800");
			
			SeleniumFunction.sendKeys(quickQuote.PickUpCompanyName(), "Pick Up Company");
			SeleniumFunction.sendKeys(quickQuote.dropOffCompanyName(), "Drop Off Company");
			SeleniumFunction.sendKeys(quickQuote.PickUpAddress1(), "Address Line1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "Address Line2");
			
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,400)");
			
			SeleniumFunction.sendKeys(quickQuote.deliveryFrequency(), deliveryFrequency);
			SeleniumFunction.click(quickQuote.customOrderDetails(orderDetails));
			SeleniumFunction.sendKeys(quickQuote.regulatoryDetails(), regulatoryDetails);
			ScreenShot.takeScreenShot(driver, "Shipment Details");
			SeleniumFunction.executeJS(driver, "window.scrollBy(0,600)");
			SeleniumFunction.click(quickQuote.submitForQuote());

			WaitTool.sleep(30);
			quickQuote.acceptPopup();

			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[2])[3]"), 20);
			crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[2])[3]")));
			System.out.println("crorderId:" + crorderId.trim());

			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);
	}
}
