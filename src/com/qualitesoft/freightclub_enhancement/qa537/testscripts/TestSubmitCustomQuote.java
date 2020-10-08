package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

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
import com.qualitesoft.freightclub_enhancement.qa537.testPages.Admin.ManageOrderNotQuotedTab;


public class TestSubmitCustomQuote extends InitializeTest {
	
	public void verifyNonPalletizedDetail(String panelIndex) {
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
		int i=Integer.parseInt(Row);
		
		String expectedPackageType = xr.getCellData("Input", "packageType", i).trim();
		String expectedWeight=xr.getCellData("Input","Weight", i).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		String expectedCategory=xr.getCellData("Input","category", i).trim();			
		String expectedDeclareValue=xr.getCellData("Input","DeclaredValue", i).trim();
		
		expectedPackageType = "1 x "+expectedPackageType+" 1";
		expectedWeight = expectedWeight.substring(0, expectedWeight.indexOf("."))+"lbs";
		String expectedDimension = "L"+DimensionL.substring(0, DimensionL.indexOf("."))+" x W"+DimensionW.substring(0, DimensionW.indexOf("."))+" x H"+DimensionH.substring(0, DimensionH.indexOf("."))+" inches";
		expectedDeclareValue = "$"+expectedDeclareValue.substring(0,expectedDeclareValue.indexOf("."))+".00";
		
		
		ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);
		
		String actualPackageType = notQuotedTab.packageTypeHeading(panelIndex).getText();
		String actualWeight = notQuotedTab.getCellValueFromPackage(panelIndex, "1").getText();
		String actualDimentions = notQuotedTab.getCellValueFromPackage(panelIndex, "2").getText();
		String actualDeclaredValue = notQuotedTab.getCellValueFromPackage(panelIndex, "3").getText();
		String actualCategory = notQuotedTab.getCellValueFromPackage(panelIndex, "4").getText();
		
		Assert.assertEquals(actualPackageType, expectedPackageType);
		Assert.assertEquals(actualWeight, expectedWeight);
		Assert.assertEquals(actualDimentions, expectedDimension);
		Assert.assertEquals(actualDeclaredValue, expectedDeclareValue);
		Assert.assertEquals(actualCategory, expectedCategory);
	}
	
	public void verifyPalletizedDetail(String panelIndex) {
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
		int i=6;
		
		String expectedPackageType = xr.getCellData("Input", "packageType", i).trim();
		String expectedWeight=xr.getCellData("Input","Weight", i).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		String expectedCategory=xr.getCellData("Input","category", i).trim();			
		String expectedDeclareValue=xr.getCellData("Input","DeclaredValue", i).trim();
		String expectedCartoon=xr.getCellData("Input","Cartons", i);

		
		expectedPackageType = "1 x "+expectedPackageType.split("Standard ")[1].toUpperCase();
		expectedWeight = expectedWeight.substring(0,expectedWeight.indexOf("."))+"lbs";
		String expectedDimension = "L"+DimensionL.substring(0,DimensionL.indexOf("."))+" x W"+DimensionW.substring(0,DimensionW.indexOf("."))+" x H"+DimensionH.substring(0,DimensionH.indexOf("."))+" inches";
		expectedDeclareValue = "$"+expectedDeclareValue.substring(0, expectedDeclareValue.indexOf("."))+".00";
		expectedCartoon = expectedCartoon.substring(0, expectedCartoon.indexOf("."));
		
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
		Assert.assertEquals(actualCartoon, expectedCartoon);
		Assert.assertEquals(actualCategory, expectedCategory);
	}
	
	public void verifyAddedProductDetail(String panelIndex) {
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
		int i=Integer.parseInt(Row);
		
		String expectedWeight=xr.getCellData("Input","Weight", i).trim();
		String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
		String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
		String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
		String expectedCategory=xr.getCellData("Input","category", i).trim();			
		String expectedCartoon=xr.getCellData("Input","Cartons", i).trim();

		
		expectedWeight = expectedWeight.substring(0,expectedWeight.indexOf("."))+" lbs";
		String expectedDimension = DimensionL.substring(0,DimensionL.indexOf("."))+" x "+DimensionW.substring(0,DimensionW.indexOf("."))+" x "+DimensionH.substring(0,DimensionH.indexOf("."))+" in";
		expectedCartoon = expectedCartoon.substring(0, expectedCartoon.indexOf("."));
		
		ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);
		
		String actualPackageType = notQuotedTab.packageTypeHeading(panelIndex).getText();
		String actualWeight = notQuotedTab.getCellValueFromPackage(panelIndex, "2").getText();
		String actualDimentions = notQuotedTab.getCellValueFromPackage(panelIndex, "3").getText();
		String actualCategory = notQuotedTab.getCellValueFromPackage(panelIndex, "4").getText();
		String actualCartoon = notQuotedTab.getCellValueFromPackage(panelIndex, "1").getText();

		Assert.assertEquals(actualPackageType, "1 x Auto_ProductName");
		Assert.assertEquals(actualWeight, expectedWeight);
		Assert.assertEquals(actualDimentions, expectedDimension);
		Assert.assertEquals(actualCategory, expectedCategory);
		Assert.assertEquals(actualCartoon, expectedCartoon);
	}
	
	
	
	@Test
	public void testSubmitCustomQuote() {
		
		try{
		
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			
			QuickQuote quickQuote = new QuickQuote(driver);
			WaitTool.sleep(10);
			quickQuote.acceptPopup();
			WaitTool.sleep(5);
			
			ManageOrderNotQuotedTab notQuotedTab = new ManageOrderNotQuotedTab(driver);
			SeleniumFunction.click(notQuotedTab.notQuoted());
			WaitTool.sleep(5);
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_537.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			String regulatoryDetails = xr.getCellData("Input","RegulatoryDetails", i).trim();
			String quoteId = xr.getCellData("Input","QuoteID", i).trim();
			String COGS = xr.getCellData("Input","COGS", i).trim();
			String deliveryFrequency1=xr.getCellData("Input","DeliveryFrequency1", i).trim();
			String deliveryFrequency2=xr.getCellData("Input","DeliveryFrequency", i).trim();

			
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			System.out.println("Order Id: "+orderid);
			SeleniumFunction.sendKeys(notQuotedTab.orderIDFilter(), orderid);
			WaitTool.sleep(5);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(5);
		    
		    SeleniumFunction.click(notQuotedTab.complete());
		    WaitTool.sleep(5);
		    
		    //Verify Details
			Assert.assertEquals(serviceLevel, notQuotedTab.serviceLevel().getText());	
			Select deliveryFrequency = new Select(driver.findElement(By.xpath("//*[@id='shipment-review']/div[1]/div[3]/div/div[5]/div[1]/select")));
			if(i == 5) {
			    Assert.assertEquals(deliveryFrequency.getFirstSelectedOption().getText().trim(), deliveryFrequency1);
			} else if(i == 3){
			    Assert.assertEquals(deliveryFrequency.getFirstSelectedOption().getText().trim(),deliveryFrequency1);
			}
		    Assert.assertEquals(notQuotedTab.regulatoryDetails().getAttribute("value"), regulatoryDetails);
		    Assert.assertEquals(notQuotedTab.shipmentInformation().getAttribute("value"), deliveryFrequency2);
		    
		    // Verify all package type details
		    this.verifyNonPalletizedDetail("5");
		    this.verifyPalletizedDetail("4");
		    this.verifyAddedProductDetail("6");
		    ScreenShot.takeScreenShot(driver, "Verify details at submit quote page");
		    
		    //Enter new Details.
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,-800)");
		    SeleniumFunction.click(notQuotedTab.fulfillmentCarrier());
		    SeleniumFunction.click(driver.findElement(By.xpath("//div[@data-value='222']")));
		
		    SeleniumFunction.sendKeys(notQuotedTab.carrierQuoteID(), quoteId.substring(0, quoteId.indexOf(".")));
		    SeleniumFunction.sendKeys(notQuotedTab.COGS(), COGS.substring(0, quoteId.indexOf(".")));
		    
		    
		    WaitTool.sleep(5);
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,400)");
		    WebElement markupPercentage = notQuotedTab.markupPercentage();
		    markupPercentage.clear();
		    SeleniumFunction.sendKeys(markupPercentage, "6");
		    WaitTool.sleep(5);
		    
		    //Submit Information
		    SeleniumFunction.executeJS(driver, "window.scrollBy(0,2500)");
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
