package com.qualitesoft.freightclubPh2.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestCloneOrders extends InitializeTest{

	@Test
	public void testCloneOrders(){

		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile_Ph2.xlsx");
		System.out.println("xr:" + xr);
		int i=Integer.parseInt(Row);
		String orderid=xr.getCellData("Input","OrderId", i).trim();
		String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
		String packageType = xr.getCellData("Input", "packageType", i).trim();

		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(5);
		SeleniumFunction.click(landingPage.ExpandMenupage());	
		WaitTool.sleep(3);
		SeleniumFunction.click(landingPage.ActionDropDown());
		//SeleniumFunction.click(landingPage.ActionDropDown());
		ScreenShot.takeScreenShot(driver, "Order");
		SeleniumFunction.click(landingPage.CloneDropDown());
		String CloneOrder="CloneOrder"+Row;
		ScreenShot.takeScreenShot(driver, CloneOrder);
		SeleniumFunction.sendKeys(landingPage.customerPOnumber(), CloneOrder);
		SeleniumFunction.click(landingPage.cloneNowButton());

		QuickQuote quickQuote = new QuickQuote(driver);
		WaitTool.sleep(20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		/*jse.executeScript("window.scrollBy(0,-500)", "");
		SeleniumFunction.click(quickQuote.OrderDate());
		WaitTool.sleep(5);
		SeleniumFunction.click(quickQuote.OrderDate1());*/

		//jse.executeScript("window.scrollBy(0,950)", "");
		SeleniumFunction.scrollDownUptoFooter(driver);

		SeleniumFunction.click(quickQuote.SaveButton());
		WaitTool.sleep(10);
		jse.executeScript("window.scrollBy(0,-250)", "");

		quickQuote.waitForQuotesToAppear();
		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(5);
		jse.executeScript("return document.readyState").toString().equals("complete");

		if(Row.equalsIgnoreCase("8") || Row.equalsIgnoreCase("9")) {
			SeleniumFunction.click(quickQuote.UPSSureButton());
		}else {
			SeleniumFunction.clickJS(driver, quickQuote.NextButton());
		}			
		
		/*//select carrier
		SeleniumFunction.scrollUp(driver);
		jse.executeScript("window.scrollBy(0,250)", "");
		WaitTool.sleep(30);
		jse.executeScript("return document.readyState").equals("complete");
		jse.executeScript("window.scrollBy(0,250)", "");
		if(Row.equalsIgnoreCase("8") || Row.equalsIgnoreCase("9")) {
			SeleniumFunction.clickJS(driver, quickQuote.UPSSureButton());
		}
		else {
			if(quickQuote.NextButton().isDisplayed()) {
				SeleniumFunction.click(quickQuote.NextButton());
			}
			else {
				jse.executeScript("window.scrollBy(950,0)", "");
				SeleniumFunction.click(quickQuote.NextButton());
			}
		}*/
		WaitTool.sleep(15);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(15);
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.click(quickQuote.Book());
		WaitTool.sleep(15);
		quickQuote.Okbutton();
		if(Row.equalsIgnoreCase("5")) {
			ScreenShot.takeScreenShot(driver, "Clone Order Confirmation with LTL pallet and non pallet");
		}else {
			ScreenShot.takeScreenShot(driver, "Clone Order Confirmation "+" "+shipmentType+" "+packageType);	
		}

		SeleniumFunction.click(quickQuote.Okbutton());

		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='ag-body']//div[3]//div[1]//div[1]//div[1]/div[2]"), 60);
		WaitTool.sleep(5);
		String id=SeleniumFunction.getText(driver.findElement(By.xpath("//div[@class='ag-body']//div[3]//div[1]//div[1]//div[1]/div[2]")));
		System.out.println("crorderId:" + id.trim());
		//set order id in excel
		xr.setCellData("Input","OrderId", i,id.trim());
		WaitTool.sleep(5);
		WaitTool.sleep(5);
		if(Row.equalsIgnoreCase("5")) {
			ScreenShot.takeScreenShot(driver, "Clone Order Status with LTL pallet and non pallet"+"  "+id);
		}else {
			ScreenShot.takeScreenShot(driver, "Clone Order Status"+shipmentType+" "+packageType+" "+id);
		}

		WaitTool.sleep(10);
	}
}
