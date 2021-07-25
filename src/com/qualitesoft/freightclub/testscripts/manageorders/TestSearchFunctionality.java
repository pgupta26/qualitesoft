package com.qualitesoft.freightclub.testscripts.manageorders;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestSearchFunctionality extends InitializeTest{

	public static void searchOnManageOrders(String searchIndex, String index2, String searchData){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			WaitTool.sleep(7);
			
			manageOrderpage.ActionButton();
			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}
			manageOrderpage.searchFields(searchIndex, searchData);
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(10);

			int rows = manageOrderpage.getRowsCount();
			UseAssert.assertEquals(rows, 1);
			UseAssert.assertEquals(manageOrderpage.getColumnData(index2), searchData);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(priority = 1)
	public void searchByOrderId(){
		searchOnManageOrders("1", "2", "51487543");
	}

	@Test(priority = 2)
	public void searchByWaybill(){
		searchOnManageOrders("3", "9", "FCABF1006300");
	}

	@Test(priority = 3)
	public void searchByTrackingNumber(){
		searchOnManageOrders("4", "10", "66488638");
	}

	@Test(priority = 4)
	public void verifyFilterHeaderText(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
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
