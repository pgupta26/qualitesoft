package com.qualitesoft.freightclub.testscripts.manageorders;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestSearchFunctionality extends InitializeTest{

	public void searchOnManageOrders(String searchIndex, String index2, String searchData){
		ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
		manageOrderpage.searchFields(searchIndex, searchData);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(10);

		int rows = manageOrderpage.getRowsCount();
		Assert.assertEquals(rows, 1);
		Assert.assertEquals(manageOrderpage.getColumnData(index2), searchData);
	}
	
	@Test(priority = 1)
	public void searchByOrderId(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());

			manageOrderpage.ActionButton();
			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}
			
			this.searchOnManageOrders("1", "2", "51487543");
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(priority = 2)
	public void searchByWaybill(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			driver.navigate().refresh();
			manageOrderpage.ActionButton();
			WaitTool.sleep(7);
			this.searchOnManageOrders("3", "9", "FCABF1006300");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(priority = 3)
	public void searchByTrackingNumber(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			driver.navigate().refresh();
			manageOrderpage.ActionButton();
			WaitTool.sleep(7);
			this.searchOnManageOrders("4", "10", "66488638");
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(priority = 4)
	public void verifyFilterHeaderText(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			driver.navigate().refresh();
			manageOrderpage.ActionButton();
			WaitTool.sleep(5);
			ArrayList<String> headers = new ArrayList<String>();
			ArrayList<String> ex_header = new ArrayList<String>(Arrays.asList("ID", "Customer PO #", "Order Date"
					,"Ready for Pick Up", "Status", "Cancel Requested","Type", "Way Bill #","Tracking #", "Quoted Price"));

			for(int i=0; i<10; i++){
				headers.add(i, manageOrderpage.getFilterHeader(i + 1));
			}
			System.out.println("Actual Array is " + headers + "\n expected is " + ex_header);
			Assert.assertEquals(headers, ex_header);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}

