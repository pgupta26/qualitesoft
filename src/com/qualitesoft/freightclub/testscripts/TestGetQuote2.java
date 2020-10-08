package com.qualitesoft.freightclub.testscripts;
import com.qualitesoft.core.Xls_Reader;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.SignInPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestGetQuote2 {
	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qa.freightclub.com/");
		
		HomePage homePage = new HomePage(driver);
		SeleniumFunction.clickJS(driver, homePage.signInLink());
		SignInPage signInPage = new SignInPage(driver);
		
		SeleniumFunction.sendKeys(signInPage.usernameTextField(), "qatest@cymax.com");
		SeleniumFunction.sendKeys(signInPage.passowrdTextField(), "Welcome@2");
		SeleniumFunction.clickJS(driver, signInPage.loginButton());
		
		//Get Excel Data
		
		//Xls_Reader xr=new Xls_Reader("E:\\WorkspaceNew\\qs_automation\\binaries\\FCfiles\\FCFile.xlsx");
		Xls_Reader xr=new Xls_Reader("binaries/FCFile.xlsx");
		int rcnt=xr.getRowCount("Input");
		for(int i=2;i<=rcnt;i++)
		{
//			for(int j=1; j<=ccnt;j++){
//				String cellDataNew=xr.getCellData("Input",j, i).trim();
//				System.out.print(cellDataNew+"\n");
			
			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String orderDate=xr.getCellData("Input","orderDate", i).trim();
			String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			String pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
			String pickUpType=xr.getCellData("Input","pickUpType", i).trim();
			String dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
			String dropOffType=xr.getCellData("Input","dropOffType", i).trim();			
			String packageType=xr.getCellData("Input","packageType", i).trim();
			String Weight=xr.getCellData("Input","Weight", i).trim();
			String DimensionL=xr.getCellData("Input","DimensionL", i).trim();
			String DimensionW=xr.getCellData("Input","DimensionW", i).trim();
			String DimensionH=xr.getCellData("Input","DimensionH", i).trim();
			String category1=xr.getCellData("Input","category", i).trim();			
			String DeclaredValue=xr.getCellData("Input","DeclaredValue", i).trim();
			String Cartons=xr.getCellData("Input","Cartons", i).trim();
				
			QuickQuote quickQuote = new QuickQuote(driver);
			SeleniumFunction.clickJS(driver, quickQuote.manageOrdersLink());
			
			if (shipmentType.equalsIgnoreCase("LTL"))
			{
			SeleniumFunction.click(quickQuote.LTLShipment());
			}
			else{
			SeleniumFunction.click(quickQuote.ParcelShipment());
			}
			
			SeleniumFunction.click(quickQuote.OrderDate());
			SeleniumFunction.click(quickQuote.ClickDate(orderDate));
			
			SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), orderReferenceID);
			SeleniumFunction.clickAction(driver,quickQuote.ServiceLevel());
			if(serviceLevel.contains("White Glove - Light Assembly"))
			{
			SeleniumFunction.click(quickQuote.ServiceLevelOptions());
			}
			
	      //SeleniumFunction.select(quickQuote.ServiceLevelOptions(), "Back Of Truck (No Liftgate) - One man delivery - Customer to remove shipment from truck");
	        		
			
			SeleniumFunction.sendKeys(quickQuote.PickUpZip(), pickUpZip);
			SeleniumFunction.sendKeys(quickQuote.DropOffZip(), dropOffZip);
			
			SeleniumFunction.selectByVisibleText(quickQuote.PickUpLocationType(), pickUpType);
			SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), dropOffType);
			
			/*if(pickUpType=="Commercial")
			{
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeRes());
			}
			else
			{
				SeleniumFunction.click(quickQuote.PickUpZipLocationTypeCom());
			}
			
			if(dropOffType=="Commercial")
			{
				SeleniumFunction.click(quickQuote.DropOffZipLocationTypeCom());
			}
			else
			{SeleniumFunction.click(quickQuote.DropOffZipLocationTypeRes());
			
			}*/
			
			if(category1.equalsIgnoreCase("Other"))
			{
			SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			}
			else
			{
				SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
			}
		
			SeleniumFunction.click(quickQuote.PackageType());
			
			
			quickQuote.PackageTypeOptions("Custom Pallet (enter dimensions)");
			
			SeleniumFunction.sendKeys(quickQuote.Weight(), Weight);
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), DimensionL);
		
			SeleniumFunction.sendKeys(quickQuote.DimensionW(),DimensionW);
			
			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), DeclaredValue);
			SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);
			WaitTool.sleep(5);
			ScreenShot.takeScreenShot(driver, "Data-Provided");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			SeleniumFunction.click(quickQuote.SaveButton());
			WaitTool.sleep(20);
			ScreenShot.takeScreenShot(driver, "Carriers");
			quickQuote.ValidateCarriers("9");
			
			
			}			
		
	}	
}