package com.qualitesoft.freightclub.appcommon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManageClaims;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.ManageProducts;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;
import com.qualitesoft.freightclub.pageobjects.Admin.ManageOrderNotQuotedTab;

public class CommonOps extends InitializeTest {

	public void shipmentInformation(Xls_Reader xr, int rowIndex) {

		//Read data from sheet for selected row
		String shipmentType=xr.getCellData("Input","shipmentType", rowIndex).trim();
		String serviceLevel=xr.getCellData("Input","serviceLevel", rowIndex).trim();
		String orderReferenceID=xr.getCellData("Input","orderReferenceID", rowIndex).trim();
		String pickUpZip=xr.getCellData("Input","pickUpZip", rowIndex).trim();
		String pickUpType=xr.getCellData("Input","pickUpType", rowIndex).trim();
		String dropOffZip=xr.getCellData("Input","dropOffZip", rowIndex).trim();
		String dropOffType=xr.getCellData("Input","dropOffType", rowIndex).trim();			

		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		if(loginuser ==  null ||  !loginuser.equals("new")) {
			SeleniumFunction.clickJS(driver, quickQuote.quickQuoteLink());
		}
		quickQuote.acceptPopup();
		SeleniumFunction.scrollDownByPixel(driver, "500");
		WaitTool.sleep(5);
		
		if(!quickQuote.shipmentType(shipmentType).getAttribute("class").contains("active"))
				SeleniumFunction.clickJS(driver, quickQuote.shipmentType(shipmentType));
		quickQuote.acceptPopup();
		SeleniumFunction.scrollUpByPixel(driver, "1500");
		SeleniumFunction.click(quickQuote.OrderDate());
		SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), orderReferenceID);
		SeleniumFunction.click(quickQuote.serviceLevel(serviceLevel));

		SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip.trim());
		SeleniumFunction.sendKeys(quickQuote.DropOffZip(),dropOffZip.trim());
		SeleniumFunction.scrollUpByPixel(driver, "250");
		SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
		SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);
	}

	public void itemInformation(Xls_Reader xr, int rowIndex, int itemIndex) {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);

		//Read data from sheet for selected row
		String quantity=xr.getCellData("Input","Quantity", rowIndex).trim();
		String Weight=xr.getCellData("Input","Weight", rowIndex).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", rowIndex).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", rowIndex).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", rowIndex).trim();
		String category=xr.getCellData("Input","category", rowIndex).trim();			
		String DeclaredValue=xr.getCellData("Input","DeclaredValue", rowIndex).trim();
		String Cartons=xr.getCellData("Input","Cartons", rowIndex).trim();
		String packageType = xr.getCellData("Input", "packageType", rowIndex).trim();	

		SeleniumFunction.scrollDownByPixel(driver, "1000");
		if(packageType.equals("SearchaddedProduct")) {
			WaitTool.sleep(2);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.BACK_SPACE);
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(quickQuote.productvalue(itemIndex), Productname);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);

		}else {
			if(category.equalsIgnoreCase("Other")){
				SeleniumFunction.selectByvalue(quickQuote.Category(itemIndex), "347");
				SeleniumFunction.click(quickQuote.popupCateogory(itemIndex));
				WaitTool.sleep(2);
			}
			else {
				SeleniumFunction.selectByvalue(quickQuote.Category(itemIndex), "346");
			}

			WebElement quan = quickQuote.quantity(itemIndex);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value=''", quan);
			SeleniumFunction.sendKeys(quan, quantity);
			SeleniumFunction.clickJS(driver, quickQuote.PackageType(packageType, itemIndex));
			SeleniumFunction.sendKeys(quickQuote.Weight(itemIndex), Weight);
			SeleniumFunction.sendKeys(quickQuote.DimensionL(itemIndex), DimensionL);
			SeleniumFunction.sendKeys(quickQuote.DimensionW(itemIndex), DimensionW);
			SeleniumFunction.sendKeys(quickQuote.DimensionH(itemIndex), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(itemIndex), DeclaredValue);
			if (packageType.equalsIgnoreCase("Standard Pallet 1") || packageType.equalsIgnoreCase("Custom Pallet (enter dimensions)")) {
				SeleniumFunction.sendKeys(quickQuote.Cartons(itemIndex), Cartons);
			}
		}
	}

	public void selectCarrier() {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		WaitTool.sleep(2);
		SeleniumFunction.scrollUpByPixel(driver, "250");
		SeleniumFunction.click(quickQuote.SaveButton());
		WaitTool.sleep(20);
		quickQuote.waitForQuotesToAppear();
		WaitTool.sleep(5);
		quickQuote.acceptPopup();
	}

	public void addPalletContents(Xls_Reader xr, int rowIndex, int itemIndex) {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);

		String palletType = xr.getCellData("Input", "PalletType", rowIndex).trim();		
		String palletDescription = xr.getCellData("ShipmentInformation", "PalletDescription", rowIndex);
		String quantity=xr.getCellData("Input","Quantity", rowIndex).trim();
		String Weight=xr.getCellData("Input","Weight", rowIndex).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", rowIndex).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", rowIndex).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", rowIndex).trim();
		String category=xr.getCellData("Input","category", rowIndex).trim();			
		String DeclaredValue=xr.getCellData("Input","DeclaredValue", rowIndex).trim();
		String numberOfCartoons = xr.getCellData("Input", "NumberOfCartoons", rowIndex).trim();			

		if(palletType.equalsIgnoreCase("Generic Pallet")) {
			SeleniumFunction.scrollUpByPixel(driver, "300");
			SeleniumFunction.click(quickQuote.genericPallet());
			SeleniumFunction.sendKeys(quickQuote.palletDescription(), palletDescription);
			SeleniumFunction.sendKeys(quickQuote.numberOfCartoons(), numberOfCartoons);
		} else if(palletType.equalsIgnoreCase("Non-Palletized")) {
			if(category.equalsIgnoreCase("Other")){
				SeleniumFunction.selectByvalue(quickQuote.Category(itemIndex), "347");
				SeleniumFunction.click(quickQuote.popupCateogory(itemIndex));
				WaitTool.sleep(2);
			}
			else {
				SeleniumFunction.selectByvalue(quickQuote.Category(itemIndex), "346");
			}

			SeleniumFunction.sendKeys(quickQuote.quantity(itemIndex), quantity);
			SeleniumFunction.clickJS(driver, quickQuote.PackageType(palletType, itemIndex));
			SeleniumFunction.sendKeys(quickQuote.Weight(itemIndex), Weight);
			SeleniumFunction.sendKeys(quickQuote.DimensionL(itemIndex), DimensionL);
			SeleniumFunction.sendKeys(quickQuote.DimensionW(itemIndex), DimensionW);
			SeleniumFunction.sendKeys(quickQuote.DimensionH(itemIndex), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(itemIndex), DeclaredValue);

		} else if(palletType.equals("New Product")) {
			ManageProducts manageProducts = new ManageProducts(driver);
			String Productname=JavaFunction.randomText("prod", 4);
			Log.info("Product Name: "+Productname);

			SeleniumFunction.click(quickQuote.productvalue(itemIndex));
			SeleniumFunction.click(quickQuote.addProduct(itemIndex+1));
			SeleniumFunction.sendKeys(manageProducts.SKU(),Productname);
			SeleniumFunction.sendKeys(manageProducts.productName(),Productname);
			SeleniumFunction.sendKeys(manageProducts.declaredValue(),DeclaredValue);

			xr=new Xls_Reader("binaries/FCfiles/ManageProducts.xlsx");
			this.addProductCarton(xr, 5, 1);

			SeleniumFunction.click(manageProducts.saveproduct());

		} else  {
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(quickQuote.productvalue(itemIndex), Productname);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(2);
		}
	}

	public void shipmentCompletion(Xls_Reader xr, int rowIndex) {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);

		String shipmentType=xr.getCellData("Input","shipmentType", rowIndex).trim();
		String packageType = xr.getCellData("Input", "packageType", rowIndex).trim();

		SeleniumFunction.scrollDownByPixel(driver, "350");
		WaitTool.sleep(3);
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "Test Special Handling Instructions");
		SeleniumFunction.scrollUpByPixel(driver, "400");
		WaitTool.sleep(15);
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com90001']"), 10));	
		quickQuote.LocationName().sendKeys(Keys.chord("Auto"));
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Com10011']"), 10));	
		SeleniumFunction.scrollUpByPixel(driver, "400");
		ScreenShot.takeScreenShot(driver, "Filled Shipment info "+shipmentType+" "+packageType);
	}

	public void verifyPalletizedDetail(Xls_Reader xr, int rowIndex, String panelIndex) {
		int i=rowIndex;
		
		String expectedPackageType;
		expectedPackageType = xr.getCellData("Input", "packageType", i).trim();
		
		if(expectedPackageType.equalsIgnoreCase("SearchaddedProduct")) {
			expectedPackageType="Standard Pallet 1";
		}

		String expectedWeight=xr.getCellData("Input","Weight", i).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		String expectedCategory=xr.getCellData("Input","category", i).trim();			
		String expectedDeclareValue=xr.getCellData("Input","DeclaredValue", i).trim();
		String expectedNumberOfCartoons=xr.getCellData("Input","NumberOfCartoons", i);

		expectedPackageType = "1 x "+expectedPackageType.split("Standard ")[1].toUpperCase();
		expectedWeight = expectedWeight+"lbs";
		String expectedDimension = "L"+DimensionL+" x W"+DimensionW+" x H"+DimensionH+" inches";
		expectedDeclareValue = "$"+expectedDeclareValue+".00";

		ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);

		String actualPackageType = notQuotedTab.packageTypeHeading(panelIndex).getText();
		String actualWeight = notQuotedTab.getCellValueFromPackage(panelIndex, "1").getText();
		String actualDimentions = notQuotedTab.getCellValueFromPackage(panelIndex, "2").getText();
		String actualDeclaredValue = notQuotedTab.getCellValueFromPackage(panelIndex, "3").getText();
		String actualCategory = notQuotedTab.getCellValueFromPackage(panelIndex, "6").getText();
		String actualCartoon = notQuotedTab.getCellValueFromPackage(panelIndex, "5").getText();


		Assert.assertEquals(actualPackageType, expectedPackageType);
		Assert.assertEquals(actualWeight, expectedWeight);
		Assert.assertEquals(actualDimentions, expectedDimension);
		Assert.assertEquals(actualDeclaredValue, expectedDeclareValue);
		Assert.assertEquals(actualCartoon, expectedNumberOfCartoons);
		if(testname.equals("Test user is able to create palletized sku")) {
			Assert.assertEquals(actualCategory, "Other, Other, Other");
		}else {
			Assert.assertEquals(actualCategory, expectedCategory);
		}
		
	}

	public void bookOrder(Xls_Reader xr, int rowIndex) {
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		ManageOverages manageOverage = new ManageOverages(driver);

		SeleniumFunction.clickJS(driver, quickQuote.Book());
		SeleniumFunction.click(quickQuote.Okbutton1());			
		crorderId=SeleniumFunction.getText(manageOverage.gridData(1, 1));
		Log.info("Order Id Generated: "+crorderId);
		String orderDate= SeleniumFunction.getText(manageOverage.gridData(1, 3));
		orderDate = orderDate.replace("/","-");
		Log.info("Pick up date: "+orderDate);
		String amount= SeleniumFunction.getText(manageOverage.gridData(1, 10));
		Log.info("Amount: "+orderDate);

		//set order id in excel
		xr.setCellData("Input","OrderId", rowIndex,crorderId.trim());
		xr.setCellData("Input","pickUpDate", rowIndex,orderDate.trim());
		xr.setCellData("Input","Amount", rowIndex,amount);
		WaitTool.sleep(5);
	}

	public void addProductDetail(Xls_Reader xr, int rowIndex) {
		ManageProducts manageProducts = new ManageProducts(driver);

		Productname=JavaFunction.randomText("prod", 4);
		Log.info("Product Name: "+Productname);

		String sku=xr.getCellData("Input","Sku", rowIndex).trim();
		String declaredValue=xr.getCellData("Input","DeclaredProductValue", rowIndex).trim();
		String palletType=xr.getCellData("Input","PalletType", rowIndex).trim();
		String weight=xr.getCellData("Input","PalletWeight", rowIndex).trim();
		String length=xr.getCellData("Input","PalletLength", rowIndex).trim();
		String width=xr.getCellData("Input","PalletWidth", rowIndex).trim();
		String height=xr.getCellData("Input","PalletHeight", rowIndex).trim();

		SeleniumFunction.click(manageProducts.createproduct());	
		ScreenShot.takeScreenShot(driver, "Create Product");

		SeleniumFunction.clickJS(driver, manageProducts.palletType(palletType));
		SeleniumFunction.sendKeys(manageProducts.SKU(),sku);
		SeleniumFunction.sendKeys(manageProducts.productName(),Productname);
		SeleniumFunction.sendKeys(manageProducts.declaredValue(),declaredValue);

		if(!palletType.equalsIgnoreCase("No Pallet Required")) {
			SeleniumFunction.sendKeys(manageProducts.weight(),weight);
			SeleniumFunction.sendKeys(manageProducts.length(),length);
			SeleniumFunction.sendKeys(manageProducts.width(),width);
			SeleniumFunction.sendKeys(manageProducts.height(),height);
		}
	}

	public void addProductCarton(Xls_Reader xr, int rowIndex, int itemIndex) {
		ManageProducts manageProduct = new ManageProducts(driver);

		String cartonWeight=xr.getCellData("Input","CartonWeight", rowIndex).trim();
		String cartonLength=xr.getCellData("Input","CartonLength", rowIndex).trim();
		String cartonWidth=xr.getCellData("Input","CartonWidth", rowIndex).trim();
		String cartonHeight=xr.getCellData("Input","CartonHeight", rowIndex).trim();
		String category=xr.getCellData("Input","Category", rowIndex).trim();

		if(category.equalsIgnoreCase("Other")){
			SeleniumFunction.selectByvalue(manageProduct.category(itemIndex), "347");
			SeleniumFunction.click(manageProduct.popupCateogory(itemIndex));
			WaitTool.sleep(2);
		}
		else {
			SeleniumFunction.selectByvalue(manageProduct.category(itemIndex), "346");
		}

		SeleniumFunction.sendKeys(manageProduct.cartoonweight(itemIndex), cartonWeight);
		SeleniumFunction.sendKeys(manageProduct.cartoonlength(itemIndex), cartonLength);
		SeleniumFunction.sendKeys(manageProduct.cartoonwidth(itemIndex), cartonWidth);
		SeleniumFunction.sendKeys(manageProduct.cartoonheight(itemIndex), cartonHeight);

	}
	
	/*-------------------------------Manage Orders Page --------------------------------------*/
	
	public void openManageOrdersPageAndSearchOrder(String orderId){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		SeleniumFunction.clickJS(driver, manageOrderpage.manageOrdersLink());
		ScreenShot.takeScreenShot(driver, "Manage Order Page");

		if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
			SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		}
		
		if(manageOrderpage.acceptFeedbackPopupStatus() == true){
			manageOrderpage.acceptFeedbackPopup();
		}

		manageOrderpage.searchFields("1", orderId);
		manageOrderpage.orderIdFilter().sendKeys(Keys.ENTER);
		WaitTool.sleep(10);
	}
	
	public void openManageClaimsPageAndSearchOrder(String orderId){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		ManageClaims manageClaims = new ManageClaims(driver);

		if(manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
			SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		}
		
		SeleniumFunction.click(manageClaims.manageClaimsLink());
		ScreenShot.takeScreenShot(driver, "Manage Claims Page");

		if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
			SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		}

		WaitTool.sleep(5);
		manageOrderpage.orderIDFilter(orderId);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(10);
	}
}


