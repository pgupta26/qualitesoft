package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestGetQuote1 extends InitializeTest{

	@Test
	public void handleOkPopup(){
		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='link-quick-quote']"), 30).click();
		WaitTool.sleep(5);
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//button[text()='OK']"))) {
			SeleniumFunction.click(driver.findElement(By.xpath("//button[text()='OK']")));
			WaitTool.sleep(2);
		}
	}

	@Test
	public void getRatesWithParcelShipment(){
		try{
			int rowno = Integer.parseInt(Row);
			Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
			QuickQuote quote = new QuickQuote(driver);
			
			this.handleOkPopup();
			SeleniumFunction.clickJS(driver, quote.ParcelShipment());
			WaitTool.sleep(5);
			SeleniumFunction.click(quote.OrderDate());
			SeleniumFunction.clickJS(driver, quote.OrderDate1());
			SeleniumFunction.sendKeys(quote.OrderReferenceID(), xr.getCellData("Markups", "orderReferenceID", rowno));
			SeleniumFunction.click(quote.ServiceLevel());
			SeleniumFunction.click(quote.ServiceLevelGRND());

			SeleniumFunction.sendKeys(quote.PickUpZip(), xr.getCellData("Markups", "pickUpZip", rowno));
			SeleniumFunction.sendKeys(quote.DropOffZip(),xr.getCellData("Markups", "dropOffZip", rowno));
			JavascriptExecutor jse=((JavascriptExecutor)driver);
			jse.executeScript("window.scrollBy(0,250)", "");

			WaitTool.sleep(3);
			SeleniumFunction.selectByVisibleText(quote.PickUpLocationType(), xr.getCellData("Markups", "pickUpType", rowno));
			SeleniumFunction.selectByVisibleText(quote.DropOffLocationType(), xr.getCellData("Markups", "dropOffType", rowno));
			
			/*if(xr.getCellData("Markups", "pickUpType", rowno).contains("Commercial") && xr.getCellData("Markups", "dropOffType", rowno).contains("Commercial")){
				SeleniumFunction.click(quote.PickUpZipLocationTypeCom());
				SeleniumFunction.click(quote.DropOffZipLocationTypeCom());
			}
			else if(xr.getCellData("Markups", "pickUpType", rowno).contains("Residential")&& xr.getCellData("Markups", "dropOffType", rowno).contains("Commercial")){
				SeleniumFunction.click(quote.PickUpZipLocationTypeRes());
				SeleniumFunction.click(quote.DropOffZipLocationTypeCom());
			}
			else if(xr.getCellData("Markups", "pickUpType", rowno).contains("Commercial")&& xr.getCellData("Markups", "dropOffType", rowno).contains("Residential")){
				SeleniumFunction.click(quote.PickUpZipLocationTypeCom());
				SeleniumFunction.click(quote.DropOffZipLocationTypeRes());
			}*/
			SeleniumFunction.scrollDownByPixel(driver, "100");

			SeleniumFunction.click(quote.PackageTypeParcel());
			SeleniumFunction.clickJS(driver, quote.parcelPackageCardBoardBox());
			SeleniumFunction.sendKeys(quote.Weight(), xr.getCellData("Markups", "Weight", rowno));
			if(xr.getCellData("Markups", "Weight", rowno).contains("150")){
				SeleniumFunction.clickJS(driver, quote.understoodBtn());
			}
			SeleniumFunction.sendKeys(quote.DimensionL(), xr.getCellData("Markups", "DimensionL", rowno));
			if(xr.getCellData("Markups", "DimensionL", rowno).contains("97")){
				SeleniumFunction.clickJS(driver, quote.understoodBtn());
			}
			SeleniumFunction.sendKeys(quote.DimensionW(), xr.getCellData("Markups", "DimensionW", rowno));
			SeleniumFunction.sendKeys(quote.DimensionH(), xr.getCellData("Markups", "DimensionH", rowno));
			WaitTool.sleep(3);
			// List<WebElement> understood=driver.findElements(By.xpath("(//button[@type='button']/span[text()='Understood'])[1]"));
			SeleniumFunction.selectByvalue(quote.Category(), xr.getCellData("Markups", "Category", rowno));
			WaitTool.sleep(5);
			if(xr.getCellData("Markups", "Category", rowno).contains("347")){
				WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary'])[3]"), 60).click();
			}
			SeleniumFunction.sendKeys(quote.DeclaredValue(), xr.getCellData("Markups", "DeclaredValue", rowno));
			ScreenShot.takeScreenShot(driver, "Quick Quote Information");
			WaitTool.sleep(3);
			SeleniumFunction.clickJS(driver, quote.SaveButton());
			WaitTool.sleep(15);
		
			//Set Order Id
			String[] currentUrl = driver.getCurrentUrl().split("=");
			System.out.println("Order Id: "+currentUrl[1]);
			xr.setCellData("Markups", "OrderId", rowno, currentUrl[1]);
			ScreenShot.takeScreenShot(driver, "Rates Page");
		}catch(Exception ex){
			Log.warn(ex.getMessage());
			throw ex;
		}
	}
	@Test
	public void international(){
		int rowno = Integer.parseInt(Row);
		Xls_Reader xr=new Xls_Reader(".\\binaries\\FCfiles\\FCMarkups.xlsx");
		QuickQuote quote = new QuickQuote(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.sendKeys(quote.internationalDesc(),"Table"/* xr.getCellData("Marrkups", "Description", rowno)*/);
		SeleniumFunction.sendKeys(quote.HSCode(), "1001");
		SeleniumFunction.clickJS(driver, quote.selectHSCode());
		WaitTool.sleep(3);
		SeleniumFunction.sendKeys(quote.setInternationalDeclaredValue2(), xr.getCellData("Markups", "DeclaredValue", rowno));
		SeleniumFunction.sendKeys(quote.countryOfOrigin(), xr.getCellData("Markups", "CountryOfOrigin", rowno));
		SeleniumFunction.click(quote.selectCountryOfOrigin());
		SeleniumFunction.clickJS(driver, quote.SaveButton());
	}
}
