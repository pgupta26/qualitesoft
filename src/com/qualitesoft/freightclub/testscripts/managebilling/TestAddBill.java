package com.qualitesoft.freightclub.testscripts.managebilling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.Admin.ManageBillingPage;

public class TestAddBill extends InitializeTest{

	@Test
	public void addBill(){
		try{
			ManageBillingPage billingPage = new ManageBillingPage(driver);
			SeleniumFunction.click(billingPage.manageBillingLink());
			SeleniumFunction.click(billingPage.newBillBtn());
			SeleniumFunction.click(billingPage.addBillBtn());
			String validation = "";
			for(WebElement el : billingPage.createBillPopupValidation() ){
				String text = SeleniumFunction.getText(el);
				validation = validation.concat(text);
			}
			UseAssert.assertEquals(validation, "Date is required.Carrier Code is required.Document Number is required.PO Number is required.Total is required.Freight is required.Type is required.");
			SeleniumFunction.click(billingPage.closeBtn());
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			if(manageOrderpage.acceptFeedbackPopupStatus() == true){
				manageOrderpage.acceptFeedbackPopup();
			}
		}catch(Exception e){
			e.getMessage();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "billData")
	public void addBillForCeva(Map<Object, Object> mapData) throws ParseException{
		try{
			ManageBillingPage billingPage = new ManageBillingPage(driver);
			
			SeleniumFunction.click(billingPage.newBillBtn());
			WaitTool.sleep(5);
			SeleniumFunction.clickAction(driver, billingPage.billDate());
			SeleniumFunction.sendKeysAction(driver, billingPage.billDate(), mapData.get("Date").toString());
			SeleniumFunction.click(billingPage.carrierCode());
			SeleniumFunction.click(billingPage.carrierCodeOptions(mapData.get("CarrierCode").toString()));
			SeleniumFunction.sendKeys(billingPage.documentNumber(), mapData.get("DocumentNumber").toString());
			SeleniumFunction.sendKeys(billingPage.poNumber(), mapData.get("PONumber").toString());
			SeleniumFunction.sendKeys(billingPage.netAmountDue(), mapData.get("Total").toString());
			SeleniumFunction.sendKeys(billingPage.freight(), mapData.get("Freight").toString());
			SeleniumFunction.click(billingPage.type());
			SeleniumFunction.click(billingPage.typeValue(mapData.get("Type").toString()));
			WaitTool.sleep(2);
			SeleniumFunction.click(billingPage.addBillBtn());
			WebElement toastMess = billingPage.toastMessage();
			String message = SeleniumFunction.getText(toastMess);
			UseAssert.assertEquals(message, mapData.get("Toast Message").toString());
			boolean flag = billingPage.closeBtnStatus();
			if(flag == true){
				SeleniumFunction.click(billingPage.closeBtn());
			}
			WebElement document = billingPage.documentNumTextBox();
			SeleniumFunction.sendKeys(document, mapData.get("DocumentNumber").toString());
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(5);
			
			CommonOps commonops = new CommonOps();
			commonops.searchDocumentIdAndVerifyListing(
					mapData.get("CarrierCode").toString(), mapData.get("Type").toString(), 
					mapData.get("File Status").toString(), "", mapData.get("Status").toString(),
					mapData.get("Total").toString(), mapData.get("DocumentNumber").toString());
		}catch(Exception e){
			e.getMessage();
			Assert.fail();
		}
	}
	
	@DataProvider(name = "billData")
	public Object[][] RegistrationPageData() throws IOException{
		File file = new File(".\\binaries\\FCfiles\\ManageBilling.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();
		int lastRowNum = sheet.getLastRowNum() ;
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
			}
			obj[i][0] = datamap;

		}
		return  obj;

	}
}
