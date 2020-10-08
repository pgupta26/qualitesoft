package com.qualitesoft.freightclub.testscripts;
import com.qualitesoft.core.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestGetQuote extends InitializeTest{

	@Test
	public void testGetQuote() {

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int rcnt=xr.getRowCount("Input");

		//clear existing data
		for(int i=2; i<=rcnt; i++){
			xr.setCellData("Input","OrderId", i,"");
		}

		for(int i=2;i<=rcnt;i++)
		{
			System.out.println("Current Row : "+i);
			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String serviceLevel=xr.getCellData("Input","serviceLevel", i).trim();
			String orderReferenceID=xr.getCellData("Input","orderReferenceID", i).trim();
			String pickUpZip=xr.getCellData("Input","pickUpZip", i).trim();
			String pickUpType=xr.getCellData("Input","pickUpType", i).trim();
			String dropOffZip=xr.getCellData("Input","dropOffZip", i).trim();
			String dropOffType=xr.getCellData("Input","dropOffType", i).trim();			
			String packageType = xr.getCellData("Input", "packageType", i).trim();
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

			if(category1.equalsIgnoreCase("Other"))
			{
				SeleniumFunction.selectByvalue(quickQuote.Category(), "347");
			}
			else
			{
				SeleniumFunction.selectByvalue(quickQuote.Category(), "346");
			}
			WaitTool.sleep(2);
			//Add popup on cateory 
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			SeleniumFunction.click(quickQuote.popupCateogory());
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");

			if (shipmentType.equalsIgnoreCase("LTL"))
			{
				SeleniumFunction.click(quickQuote.PackageType());			
			}
			else{
				SeleniumFunction.click(quickQuote.PackageTypeParcel());

			}
			WaitTool.sleep(5);
			quickQuote.PackageTypeOptions(packageType);
			SeleniumFunction.click(quickQuote.Weight());
			System.out.println("Weight" + Weight);
			SeleniumFunction.sendKeys(quickQuote.Weight(), Weight);
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), DimensionL);

			SeleniumFunction.sendKeys(quickQuote.DimensionW(), DimensionW);

			SeleniumFunction.sendKeys(quickQuote.DimensionH(), DimensionH);
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), DeclaredValue);

			if (!shipmentType.equals("Parcel") && !packageType.equals("Boxed"))
				SeleniumFunction.sendKeys(quickQuote.Cartons(), Cartons);

			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Shipmentinfo "+shipmentType+" "+packageType);
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.click(quickQuote.SaveButton());
			WaitTool.sleep(20);
			jse.executeScript("window.scrollBy(0,-250)", "");


			//select carrier
			SeleniumFunction.scrollUp(driver);
			jse.executeScript("window.scrollBy(0,250)", "");
			quickQuote.waitForQuotesToAppear();

			jse.executeScript("return document.readyState").toString().equals("complete");
			//SeleniumFunction.click(quickQuote.SelectCarrierCheckBox());
			ScreenShot.takeScreenShot(driver, "Rates wih Carriers "+shipmentType+" "+packageType);
			WaitTool.sleep(5);
			SeleniumFunction.click(quickQuote.NextButton());
			WaitTool.sleep(10);

			jse.executeScript("window.scrollBy(0,-350)", "");
			WaitTool.sleep(3);
			//SeleniumFunction.sendKeys(quickQuote.PalletDesc(), "TestPalletDesc");
			SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
			jse.executeScript("window.scrollBy(0,500)", "");
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
			if(i!=5) {
				SeleniumFunction.sendKeys(quickQuote.Email(), "Pick@a.com");
			}	
			jse.executeScript("window.scrollBy(0,350)", "");

			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "DropAddress1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress2(), "DropAddress2");
			SeleniumFunction.sendKeys(quickQuote.DropFirstName(), "DropUserFirstName");
			SeleniumFunction.sendKeys(quickQuote.DropLastName(), "DropUserLastName");
			SeleniumFunction.sendKeys(quickQuote.DropPhone1(), "1234567890");
			SeleniumFunction.sendKeys(quickQuote.DropEmail(), "Drop@a.com");*/
			
			ScreenShot.takeScreenShot(driver, "Filled Shipment info "+shipmentType+" "+packageType);
			SeleniumFunction.click(quickQuote.ReviewOrder());
			WaitTool.sleep(10);
			SeleniumFunction.scrollDownUptoFooter(driver);
			SeleniumFunction.click(quickQuote.Book());
			WaitTool.sleep(15);
			quickQuote.Okbutton();
			ScreenShot.takeScreenShot(driver, "Order Confirmation "+shipmentType+" "+packageType);
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60);
			WaitTool.sleep(10);
			crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']")));
			System.out.println("crorderId:" + crorderId.trim());
			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);
		}			

	}
}