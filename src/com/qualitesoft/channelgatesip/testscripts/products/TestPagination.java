package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestPagination extends InitializeTest{

	@Test(priority = 1)
	public void verifyFirstPageRowCount(){
		try{
			ProductListing listingPage = new ProductListing(driver);


			WaitTool.sleep(5);
			int rowsCount = listingPage.getCountOfRows().size();
			Log.info("Rows count is " + rowsCount);

			String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
			String[] num = productCounter.split(" ");
			if(Integer.parseInt(num[2]) > 15){
				UseAssert.assertEquals(rowsCount, 15);
			}
			else{
				UseAssert.assertEquals(rowsCount, Integer.parseInt(num[4]));
			}
		}
		catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyPaginationBtnStatusOnFirstPage(){
		try{
			checkBtnStatus("disabled", "disabled", "", "", 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void verifyPaginationBtnStatusOnSecondPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.nextPageBtn());
			checkBtnStatus("", "", "", "", 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void verifyPaginationBtnStatusOnPreviousPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.previousPageBtn());
			checkBtnStatus("disabled", "disabled", "", "", 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}	

	@Test(priority = 5)
	public void verifyRandomPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.pageBtn(4));
			checkBtnStatus("", "", "", "", 60);
			int rowsCount = listingPage.getCountOfRows().size();
			UseAssert.assertEquals(rowsCount, 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void verifyPaginationBtnStatusOnLastPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.lastPageBtn());
			checkBtnStatus("", "", "disabled", "disabled", 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 7)
	public void verifyLastPageRowsCount(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			int rowsCount = listingPage.getCountOfRows().size();

			String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
			String[] num = productCounter.split(" ");
			if(Integer.parseInt(num[2])%15 == 0){
				UseAssert.assertEquals(rowsCount, 15);
			}
			else{
				UseAssert.assertEquals(rowsCount, Integer.parseInt(num[2])%15);
			}
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	public static void checkBtnStatus(String fstatus, String pstatus, String nstatus, String lstatus, int rowsCount){
		ProductListing listingPage = new ProductListing(driver);
		String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
		String[] num = productCounter.split(" ");
		
		WaitTool.sleep(10);
		listingPage.getTableData(1, 1);
		if(Integer.parseInt(num[2]) > rowsCount){
			listingPage.firstPageBtn();
			String f_status = SeleniumFunction.getAttribute(listingPage.firstPageBtnStatus(), "class");
			String p_status = SeleniumFunction.getAttribute(listingPage.previousPageBtnStatus(), "class");
			String n_status = SeleniumFunction.getAttribute(listingPage.nextPageBtnStatus(), "class");
			String l_status = SeleniumFunction.getAttribute(listingPage.lastPageBtnStatus(), "class");

			UseAssert.assertEquals(f_status, fstatus);
			UseAssert.assertEquals(p_status, pstatus);
			UseAssert.assertEquals(n_status, nstatus);
			UseAssert.assertEquals(l_status, lstatus);
		}
		else{
			Log.info("Rows are less than " + rowsCount);
		}
	}
}
