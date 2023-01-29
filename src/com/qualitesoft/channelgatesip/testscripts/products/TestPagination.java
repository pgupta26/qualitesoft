package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.OrderPage;
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
			driver.navigate().refresh();
			WaitTool.sleep(10);
			listingPage.getTableData(1, 1);

			if(keyword != "") {
				OrderPage orderPage = new OrderPage(driver);				
				SeleniumFunction.click(orderPage.getOrderCountOnBadge(keyword));
			}
			WaitTool.sleep(5);
			int rowsCount = listingPage.getCountOfRows().size();
			Log.info("Rows count is " + rowsCount);

			String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
			String[] num = productCounter.split(" ");
			if(Integer.parseInt(num[5]) > 25){
				UseAssert.assertEquals(rowsCount, 25);
			}
			else{
				UseAssert.assertEquals(rowsCount, Integer.parseInt(num[5]));
			}
		}
		catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyPaginationBtnStatusOnFirstPage(){
		try{
			checkBtnStatus(false, false, true, true, 15);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void verifyPaginationBtnStatusOnSecondPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.nextPageBtn(2));
			checkBtnStatus(true, true, true, true, 25);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void verifyPaginationBtnStatusOnPreviousPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.previousPageBtn(2));
			checkBtnStatus(false, false, true, true, 25);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}	

	@Test(priority = 5)
	public void verifyRandomPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.pageBtn("3"));
			checkBtnStatus(true,true, true, true, 60);
			int rowsCount = listingPage.getCountOfRows().size();
			UseAssert.assertEquals(rowsCount, 25);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void verifyPaginationBtnStatusOnLastPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.lastPageBtn(2));
			checkBtnStatus(true, true, false, false, 25);
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
			if(Integer.parseInt(num[5])%25 == 0){
				UseAssert.assertEquals(rowsCount, 25);
			}
			else{
				UseAssert.assertEquals(rowsCount, Integer.parseInt(num[5])%25);
			}
			
			if(keyword != "") {
				OrderPage orderPage = new OrderPage(driver);			
				UseAssert.assertEquals(SeleniumFunction.getAttribute(orderPage.getSelectedFilter(keyword), "aria-pressed"), "true");
			}
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void checkBtnStatus(boolean fstatus, boolean pstatus, boolean nstatus, boolean lstatus, int rowsCount){
		ProductListing listingPage = new ProductListing(driver);
		String productCounter = SeleniumFunction.getText(listingPage.getTotalProductCount());
		String[] num = productCounter.split(" ");
		
		WaitTool.sleep(10);
		listingPage.getTableData(1, 1);
		if(Integer.parseInt(num[5]) > rowsCount){
			listingPage.firstPageBtn(2);
			
			UseAssert.assertEquals(listingPage.firstPageBtnStatus().isEnabled(), fstatus);
			UseAssert.assertEquals(listingPage.previousPageBtnStatus().isEnabled(), pstatus);
			UseAssert.assertEquals(listingPage.nextPageBtnStatus().isEnabled(), nstatus);
			UseAssert.assertEquals(listingPage.lastPageBtnStatus().isEnabled(), lstatus);			
		}
		else{
			Log.info("Rows are less than " + rowsCount);
		}
	}
}
