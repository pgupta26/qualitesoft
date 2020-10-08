package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestEnterCompleteInformationDetail extends InitializeTest {
	
	@Test
	public void testEnterCompleteInformationDetail() {
		try{
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			int i=Integer.parseInt(Row);
			System.out.println("Data Row: " +Row);

			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String packageType = xr.getCellData("Input", "packageType", i).trim();
			QuickQuote quickQuote = new QuickQuote(driver);
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("return document.readyState").toString().equals("complete");
			WaitTool.sleep(20);
			
			if (shipmentType.equals("Parcel")) {
				SeleniumFunction.sendKeys(quickQuote.PalletDescParcel(), "TestPalletDesc");
			}else {
				SeleniumFunction.sendKeys(quickQuote.PalletDesc(), "TestPalletDesc");
			}
			jse.executeScript("window.scrollBy(0,-350)", "");
			WaitTool.sleep(3);
			//SeleniumFunction.sendKeys(quickQuote.PalletDesc(), "TestPalletDesc");
			SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
			jse.executeScript("window.scrollBy(0,250)", "");
			//SeleniumFunction.sendKeys(quickQuote.LocationName(), "TestUser");
			//SeleniumFunction.sendKeys(quickQuote.LocationName(), JavaFunction.randomText("Username ",5));
			SeleniumFunction.sendKeys(quickQuote.Address1(), "Address1");
			SeleniumFunction.sendKeys(quickQuote.Address2(), "Address2");
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.sendKeys(quickQuote.FirstName(), "UserFirstName");
			SeleniumFunction.sendKeys(quickQuote.LastName(), "UserLastName");
			SeleniumFunction.sendKeys(quickQuote.Phone1(), "12345678900");
			SeleniumFunction.sendKeys(quickQuote.Email(), "a@a.com");	
			jse.executeScript("window.scrollBy(0,350)", "");
			//SeleniumFunction.sendKeys(quickQuote.DropLocationName(), "DropTestUser");
			//SeleniumFunction.sendKeys(quickQuote.DropLocationName(), JavaFunction.randomText("Dropname ",5));
			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "DropAddress1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress2(), "DropAddress2");
			SeleniumFunction.sendKeys(quickQuote.DropFirstName(), "DropUserFirstName");
			SeleniumFunction.sendKeys(quickQuote.DropLastName(), "DropUserLastName");
			SeleniumFunction.sendKeys(quickQuote.DropPhone1(), "12345678900");
			SeleniumFunction.sendKeys(quickQuote.DropEmail(), "Drop@a.com");
			ScreenShot.takeFullScreenShot("Filled Shipment info "+shipmentType+" "+packageType);
			SeleniumFunction.click(quickQuote.ReviewOrder());
			WaitTool.sleep(15);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

}
