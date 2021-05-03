package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;;

public class TestShipmentInfo extends InitializeTest {
	@Test
	public void testShipmentInfo() throws InterruptedException{
		String testDataSheet= "binaries/FCfiles/"+testData;
		Xls_Reader xr=new Xls_Reader(testDataSheet);

		String description=xr.getCellData("ShipmentInformation","Description", 2).trim();
		String specialHandlingInstructions=xr.getCellData("ShipmentInformation","SpecialHandlingInstructions", 2).trim();
		String addressLine1=xr.getCellData("ShipmentInformation","AddressLine1", 2).trim();
		String addressLine2=xr.getCellData("ShipmentInformation","AddressLine2", 2).trim();
		String state=xr.getCellData("ShipmentInformation","State", 2).trim();
		String country=xr.getCellData("ShipmentInformation","Country", 2).trim();
		String city=xr.getCellData("ShipmentInformation","City", 2).trim();
		String zipCode=xr.getCellData("ShipmentInformation","ZipCode", 2).trim();
		String email=xr.getCellData("ShipmentInformation","Email", 2).trim();
		String phoneNumber=xr.getCellData("ShipmentInformation","PhoneNumber", 2).trim();
		String extension=xr.getCellData("ShipmentInformation","Extension", 2).trim();
		String pickUpAddressLine1=xr.getCellData("ShipmentInformation","PickUpAddressLine1", 2).trim();
		String pickUpFirstName=xr.getCellData("ShipmentInformation","PickUpFirstName", 2).trim();
		String pickUpLastName=xr.getCellData("ShipmentInformation","PickUpLastName", 2).trim();
		String pickUpPhone1=xr.getCellData("ShipmentInformation","PickUpPhone1", 2).trim();
		String dropOffAddressLine1=xr.getCellData("ShipmentInformation","DropOffAddressLine1", 2).trim();
		String dropOffFirstName=xr.getCellData("ShipmentInformation","DropOffFirstname", 2).trim();
		String dropOffLastName=xr.getCellData("ShipmentInformation","DropOffLastName", 2).trim();
		String dropOffPhone1=xr.getCellData("ShipmentInformation","DropOffPhone1", 2).trim();

		QuickQuote quickQuote = new QuickQuote(driver);
		
		SeleniumFunction.sendKeys(quickQuote.PalletDesc(), description);
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), specialHandlingInstructions);
		SeleniumFunction.sendKeys(quickQuote.Address1(), addressLine1);
		SeleniumFunction.sendKeys(quickQuote.Address2(), addressLine2);
		SeleniumFunction.sendKeys(quickQuote.City(), city);
		SeleniumFunction.sendKeys(quickQuote.Country(), country);
		SeleniumFunction.sendKeys(quickQuote.State(), state);
		SeleniumFunction.sendKeys(quickQuote.ZipCode(), zipCode);	
		SeleniumFunction.sendKeys(quickQuote.Email(), email);
		SeleniumFunction.scrollDownByPixel(driver, "500");

		SeleniumFunction.sendKeys(quickQuote.LocationName(), "PickUpComm");
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Add location with name')]"), 10));	
		SeleniumFunction.sendKeys(quickQuote.PickUpAddress1(), pickUpAddressLine1);
		SeleniumFunction.sendKeys(quickQuote.PickUpFirstName(), pickUpFirstName);
		SeleniumFunction.sendKeys(quickQuote.PickUpLastName(), pickUpLastName);
		SeleniumFunction.sendKeys(quickQuote.PickUpPhone1(), pickUpPhone1);

		//Drop Off Location Detail
		SeleniumFunction.scrollUpByPixel(driver, "250");
		SeleniumFunction.sendKeys(quickQuote.LocationName(), "DropOffComm");
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='DropOffComm']"), 10));
		SeleniumFunction.sendKeys(quickQuote.DropAddress1(), dropOffAddressLine1);
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='col-xs-12 col-md-6'][2]/descendant::input[@id='Phone1']"), 30), dropOffPhone1);
		SeleniumFunction.sendKeys(quickQuote.DropFirstName(), dropOffFirstName);
		SeleniumFunction.sendKeys(quickQuote.DropLastName(), dropOffLastName);
		SeleniumFunction.sendKeys(quickQuote.DropPhone1(), dropOffPhone1);

		ScreenShot.takeScreenShot(driver, "Filled Shipment info");
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(5);
		SeleniumFunction.click(quickQuote.ReviewOrder());
		
		ScreenShot.takeScreenShot(driver, "Shipment Review");
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(15);
		
		/*ScreenShot.takeScreenShot(driver, "Order Confirmation");
		SeleniumFunction.click(quickQuote.Okbutton());
		WaitTool.sleep(10);
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60);
		WaitTool.sleep(10);
		crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']")));
		
		//set order id in excel
		xr.setCellData("Input","OrderId", 4,crorderId.trim());
		WaitTool.sleep(5);*/
	}
}
