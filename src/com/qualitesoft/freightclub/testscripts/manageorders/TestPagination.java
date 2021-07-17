package com.qualitesoft.freightclub.testscripts.manageorders;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestPagination extends InitializeTest{

	public void clickPaginationBtnAndVerifyRows(int btnIndex, String pageInput, String rowsNumbers, int totalRows){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			String rowsCount = manageOrderpage.getPagiationTotalRows();
			String[] num = rowsCount.split(" ");

			if(Integer.parseInt(num[4]) > totalRows){
				manageOrderpage.clickPaginationButton(btnIndex);
				WaitTool.sleep(15);
				//************Verify rows limit on pagination********
				String paginationLimit= manageOrderpage.getPagiationTotalRows();
				Assert.assertEquals(paginationLimit.substring(0, 8), rowsNumbers);
				System.out.println("Pagination Limit is >>>" + paginationLimit);

				//**************Verify Input field count***********
				String inputPageCount = manageOrderpage.getPageNumber();
				Assert.assertEquals(inputPageCount, pageInput);
				System.out.println("Input page number is >>>" + inputPageCount);

				//*************Verify Number of Rows***********
				int rows = manageOrderpage.getRowsCount();
				System.out.println("Total rows are >>>>>>>>>" + rows);			
				Assert.assertEquals(rows, 10);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	@Test(priority = 0)
	public void testPagination(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			manageOrderpage.ActionButton();
			WaitTool.sleep(10);
			if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
				SeleniumFunction.click(manageOrderpage.ExpandMenupage());
			}

			String rowsCount = manageOrderpage.getPagiationTotalRows();
			String[] num = rowsCount.split(" ");

			int rows = manageOrderpage.getRowsCount();
			System.out.println("Total rows are >>>>>>>>>" + rows);

			//******* Verify initially rows are 10*******
			if(Integer.parseInt(num[4]) > 10){
				Assert.assertEquals(rows, 10);
			}
			else{
				Assert.assertEquals(rows, Integer.parseInt(num[4]));
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(priority = 1)
	public void testLastPageRows(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);

			String rowsCount = manageOrderpage.getPagiationTotalRows();
			String[] num = rowsCount.split(" ");
			System.out.println("Pagination Rows count is >>>>>>>>>" + rowsCount);

			int rows = manageOrderpage.getRowsCount();
			System.out.println("Total rows are >>>>>>>>>" + rows);

			if(Integer.parseInt(num[4]) > 10){
				manageOrderpage.clickPaginationButton(4);
				WaitTool.sleep(10);

				char lastNum = rowsCount.charAt(rowsCount.length() - 1);
				int ex_rows = Character.getNumericValue(lastNum);
				int lastPageRows = manageOrderpage.getRowsCount();

				System.out.println("Last num from pagination text >>>>>>>>>" + ex_rows);
				System.out.println("Rows count>>>>>>>>>" + lastPageRows);

				if(lastNum != '0'){
					Assert.assertEquals(lastPageRows, ex_rows);
				}
				else{
					Assert.assertEquals(lastPageRows, 10);
				}

				String pages = manageOrderpage.getTotalPages();
				String totalPages = pages.replaceAll("[^?0-9]+", "");
				System.out.println("Total pages are >>>>>>>>>" + totalPages);

				String inputPages = manageOrderpage.getPageNumber();
				Assert.assertEquals(inputPages, totalPages);
			}
			else{
				Assert.assertEquals(rows, Integer.parseInt(num[4]));
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(priority = 2)
	public void testFirstPageRows(){
		this.clickPaginationBtnAndVerifyRows(1, "1", "1 to 10 ", 10);
	}

	@Test(priority = 3)
	public void testNextPageRows(){
		this.clickPaginationBtnAndVerifyRows(3, "2", "11 to 20", 20);			
	}

	@Test(priority = 4)
	public void testPreviousPageRows(){
		this.clickPaginationBtnAndVerifyRows(2, "1", "1 to 10 ", 10);
	}

	@Test(priority = 5)
	public void verifyRowsLimit(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			String inputPage2 = manageOrderpage.getPageNumber();
			String nextPageRows = manageOrderpage.getPagiationTotalRows();

			manageOrderpage.setPageNumber("2");
			SeleniumFunction.KeyBoradEnter(driver);
			WaitTool.sleep(15);
			Assert.assertEquals(inputPage2, "2");
			Assert.assertEquals(nextPageRows.substring(0, 8), "11 to 20");
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
