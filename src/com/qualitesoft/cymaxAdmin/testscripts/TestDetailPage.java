package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.DetailPage;

public class TestDetailPage extends InitializeTest{

	@Test
	public void aVerifyProductDetailPop(){
		try{
			DetailPage detailPage = new DetailPage(driver);
			WaitTool.sleep(10);
			String manufacturename = SeleniumFunction.getText(detailPage.clickManufactureNameLink());
			SeleniumFunction.click(detailPage.clickSkuNum());
			WaitTool.sleep(15);
			String popupHeader = SeleniumFunction.getText(detailPage.getPopupHeader());
			String manufactureName = SeleniumFunction.getText(detailPage.getManufactureNameOnPopup());

			UseAssert.assertEquals(popupHeader, "Product Info");
			UseAssert.assertEquals(manufactureName, manufacturename);
			ScreenShot.takeScreenShot(driver, "Product Information Page");
			SeleniumFunction.click(detailPage.clickClosePopup());
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void bVerifyMaufactureDetail(){

		DetailPage detailPage = new DetailPage(driver);

		String manufacturename = SeleniumFunction.getText(detailPage.clickManufactureNameLink());
		SeleniumFunction.click(detailPage.clickManufactureNameLink());

		SeleniumFunction.getCurrentWindow(driver);
		try{
			String popupHeader = SeleniumFunction.getText(detailPage.getManufactureListText());
			String manufactureName = SeleniumFunction.getText(detailPage.getManufactureName());

			UseAssert.assertEquals(popupHeader, "Manufacture List");
			UseAssert.assertEquals(manufactureName, manufacturename);
			ScreenShot.takeScreenShot(driver, "Manufacture Detail Page");
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
		}catch(Exception e){
			System.out.println(e.getMessage());
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
			Assert.fail();
		}
	}
}
