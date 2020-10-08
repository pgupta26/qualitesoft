package com.qualitesoft.freightclubPh2.testscripts;
import com.qualitesoft.core.Xls_Reader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;


public class TestGetQuote extends InitializeTest{ 
	@Test
	public void testGetQuote() {

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile_Ph2.xlsx");
		int i=Integer.parseInt(Row);
		System.out.println("Data Row: " +Row);

		//clear existing data
		xr.setCellData("Input","OrderId", i,"");

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
		
		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		if (shipmentType.equalsIgnoreCase("LTL"))
			SeleniumFunction.click(quickQuote.LTLShipment());

		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(5);
		SeleniumFunction.scrollUpByPixel(driver, "1500");
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

		SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip.substring(0, pickUpZip.length() - 2));
		SeleniumFunction.sendKeys(quickQuote.DropOffZip(),
				dropOffZip.substring(0, dropOffZip.length() - 2));
		jse.executeScript("window.scrollBy(0,250)", "");

		SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
		SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);

		//surepost doesn't support insurance
		if(!suiteName.equals("Sure Post Suite")) {
			if(Row.equalsIgnoreCase("8") ) {
				SeleniumFunction.click(quickQuote.insurance());
			}
		}

		SeleniumFunction.scrollDownUptoFooter(driver);
		if(category1.equalsIgnoreCase("Other"))
		{
			SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			//Add popup on cateory Other
			SeleniumFunction.click(quickQuote.popupCateogory());
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
		}else {
			SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
		}

		jse.executeScript("window.scrollBy(0,350)", "");
		if (shipmentType.equalsIgnoreCase("LTL"))
		{
			SeleniumFunction.click(quickQuote.PackageType());			
		}
		else{
			SeleniumFunction.click(quickQuote.PackageTypeParcel());
		}
		WaitTool.sleep(5);

		//search by added product
		if(Row.equalsIgnoreCase("2") || Row.equalsIgnoreCase("7") || Row.equalsIgnoreCase("9")) {
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(quickQuote.PackageValue(), TestManageProducts.Productname);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
		}else {

			quickQuote.PackageTypeOptions(packageType);
			System.out.println("package selected"+packageType);
			SeleniumFunction.click(quickQuote.Weight());
			System.out.println("Weight" + Weight);
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

		//LTL select 2 package type
		if(packageType2.equalsIgnoreCase("Standard Pallet 2")) {			
			SeleniumFunction.click(quickQuote.addadditionalItem());
			WaitTool.sleep(2);
			SeleniumFunction.scrollDownUptoFooter(driver);
			SeleniumFunction.click(quickQuote.PackageType2());
			System.out.println("package selected: "+packageType2);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='selectize-dropdown single form-input']//div/div[@data-value='850'])[2]"), 30));
			System.out.println("package selected"+packageType2);
			SeleniumFunction.click(quickQuote.Weight2());
			System.out.println("Weight" + Weight);
			SeleniumFunction.sendKeys(quickQuote.Weight2(), Weight);

			SeleniumFunction.sendKeys(quickQuote.DimensionH2(), DimensionH);

			//Change by shubham
			WaitTool.sleep(1);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Select categories']"), 30));
			WaitTool.sleep(1);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@value='347'])[2]"), 30));

			//Add popup on cateory Other
			SeleniumFunction.click(quickQuote.popupCateogory2());

			SeleniumFunction.sendKeys(quickQuote.DeclaredValue2(), DeclaredValue);	
			SeleniumFunction.sendKeys(quickQuote.Cartons2(), Cartons);
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
		}

		WaitTool.sleep(7);
		ScreenShot.takeScreenShot(driver, "Shipmentinfo " +" "+ Row +shipmentType+" "+packageType);
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(quickQuote.SaveButton());
		WaitTool.sleep(10);
		jse.executeScript("window.scrollBy(0,-250)", "");


		//select carrier
		//SeleniumFunction.scrollUp(driver);
		//jse.executeScript("window.scrollBy(0,200)", "");
		quickQuote.waitForQuotesToAppear();
		ScreenShot.takeScreenShot(driver, "Rates wih Carriers "+shipmentType+" "+packageType);
		WaitTool.sleep(5);
		List<WebElement> oklist=driver.findElements(By.xpath("//button[@data-role='end']"));
		if(oklist.size() >0) {
			driver.findElement(By.xpath("//button[@data-role='end']")).click();
		}
		jse.executeScript("return document.readyState").toString().equals("complete");

		if(Row.equalsIgnoreCase("8") || Row.equalsIgnoreCase("9")) {
			SeleniumFunction.click(quickQuote.UPSSureButton());
		}else {
			SeleniumFunction.clickJS(driver, quickQuote.NextButton());
		}			
		WaitTool.sleep(10);


		//Fill shipment info
		/*if(Row.equalsIgnoreCase("3") || Row.equalsIgnoreCase("4") || Row.equalsIgnoreCase("5") || Row.equalsIgnoreCase("6")|| Row.equalsIgnoreCase("8")) {
			jse.executeScript("window.scrollBy(0,-450)", "");
			SeleniumFunction.sendKeys(quickQuote.PalletDesc(), "TestPalletDesc");
		} */
		if(Row.equalsIgnoreCase("3")) {
			jse.executeScript("window.scrollBy(0,-1000)", "");
			SeleniumFunction.click(quickQuote.Addproduct());
			SeleniumFunction.click(quickQuote.searchproduct());				
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(quickQuote.productvalue(), TestManageProducts.Productname);
			WaitTool.sleep(2);
			SeleniumFunction.KeyBoradEnter(driver);
			ScreenShot.takeScreenShot(driver, "product added ") ;
		}

		jse.executeScript("window.scrollBy(0,-350)", "");
		WaitTool.sleep(3);
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
		jse.executeScript("window.scrollBy(0,400)", "");
		WaitTool.sleep(15);
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com90001']"), 10));	
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com10011']"), 10));	
		jse.executeScript("window.scrollBy(0,350)", "");
		
		/*SeleniumFunction.sendKeys(quickQuote.Address1(), "Address1");
		SeleniumFunction.sendKeys(quickQuote.Address2(), "Address2");
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.sendKeys(quickQuote.FirstName(), "UserFirstName");
		SeleniumFunction.sendKeys(quickQuote.LastName(), "UserLastName");
		SeleniumFunction.sendKeys(quickQuote.Phone1(), "1234567890");
		SeleniumFunction.sendKeys(quickQuote.Email(), "a@a.com");	
		jse.executeScript("window.scrollBy(0,350)", "");
		SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "DropAddress1");
		SeleniumFunction.sendKeys(quickQuote.DropAddress2(), "DropAddress2");
		SeleniumFunction.sendKeys(quickQuote.DropFirstName(), "DropUserFirstName");
		SeleniumFunction.sendKeys(quickQuote.DropLastName(), "DropUserLastName");
		SeleniumFunction.sendKeys(quickQuote.DropPhone1(), "1234567890");
		SeleniumFunction.sendKeys(quickQuote.DropEmail(), "Drop@a.com");*/
		ScreenShot.takeScreenShot(driver, "Filled Shipment info "+" "+ Row +" "+shipmentType+" "+packageType);
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(10);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, quickQuote.Book());
		jse.executeScript("return document.readyState").toString().equals("complete");
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "Order Confirmation  " +" "+ Row +shipmentType+" "+packageType);
		SeleniumFunction.click(quickQuote.Okbutton());

		//Payment type OnAccount use below code
		WaitTool.sleep(10);
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60);
		WaitTool.sleep(5);

		crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']")));
		System.out.println("crorderId:" + crorderId.trim());
		//set order id in excel
		xr.setCellData("Input","OrderId", i,crorderId.trim());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Order Status"+shipmentType+" "+packageType+" "+crorderId);

	}
}