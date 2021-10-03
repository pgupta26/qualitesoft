package com.qualitesoft.freightclub.testscripts.billoflading;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.BillOfLadingPage;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestSearchFunctionality extends InitializeTest{

	@Test(priority = 1)
	public void searchByWayBill(){
		searchingOnBolPage(1, "CEV1002423", 1);
	}
	
	@Test(priority = 2)
	public void searchByCustomerPo(){
		searchingOnBolPage(2, "TestOrder4", 15);
	}
	
	@Test(priority = 3)
	public void searchByOrderId(){
		searchingOnBolPage(3, "51488656", 1);
	}
	
	public static void searchingOnBolPage(int index, String searchData, int rowsCount){
		BillOfLadingPage bolPage = new BillOfLadingPage(driver);
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		
		SeleniumFunction.clickJS(driver, bolPage.billOfLading());
		WaitTool.sleep(5);

		if(manageOrderpage.acceptFeedbackPopupStatus() == true){
			manageOrderpage.acceptFeedbackPopup();
		}
		SeleniumFunction.sendKeys(bolPage.searchTextBox(index), searchData);
		bolPage.searchTextBox(index).sendKeys(Keys.ENTER);
		/*SeleniumFunction.KeyBoradEnter(driver);*/
		WaitTool.sleep(7);
		String orderStatus = SeleniumFunction.getText(bolPage.gridData(1, index));
		UseAssert.assertEquals(orderStatus, searchData);
		UseAssert.assertEquals(bolPage.getNumberOfRows().size(), rowsCount);
	}
}
