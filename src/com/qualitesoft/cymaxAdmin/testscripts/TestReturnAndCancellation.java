package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.ReturnAndCancellation;

public class TestReturnAndCancellation extends InitializeTest{

	@Test
	public void testStatus(){
		try{
			ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
			
			SeleniumFunction.click(returnPage.clickReturnAndCancellationTab());
			WaitTool.sleep(5);
			SeleniumFunction.scrollIntoView(driver, returnPage.clickReturnDetailsSubtab());
			
			this.changeStatusAndSetDate("Return - In Transit", JavaFunction.currentDate());
			this.changeStatusAndSetDate("Completed - Returned to Orbit", "12/31/2022");
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testUploadedFilesCount(){
		try{
			ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
			
			SeleniumFunction.click(returnPage.clickReturnDetailsSubtab());
			WaitTool.sleep(10);
			
			String fileName = System.getProperty("user.dir") + "\\binaries\\AdminFiles\\enterprise.jpg" ;
			SeleniumFunction.uploadImage(returnPage.setChooseFile(), fileName);
			
			int beforeUplodingFileCount = returnPage.getUploadedPhotosText().size();
			SeleniumFunction.click(returnPage.clickUploadBtn());
			
			int afterUplodingFileCount = returnPage.getUploadedPhotosText().size();
			UseAssert.assertEquals(afterUplodingFileCount, beforeUplodingFileCount + 1); 
		}catch(Exception e){
			Assert.fail();
		}		
	}
	
	@Test
	public void testCreateFedExLabel(){
		try{
			ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
			SeleniumFunction.click(returnPage.clickReturnAndCancellationTab());
			WaitTool.sleep(5);
			SeleniumFunction.click(returnPage.clickFedExLabel());
			WaitTool.sleep(10);
			
			SeleniumFunction.sendKeys(returnPage.setRma(), "123456");
			SeleniumFunction.sendKeys(returnPage.setFirstName(), "FedEx Fname");
			SeleniumFunction.sendKeys(returnPage.setCompanyName(), "Test Company");
			SeleniumFunction.sendKeys(returnPage.setAddress(), "Selenium Address");
			SeleniumFunction.sendKeys(returnPage.setCity(), "Selenium City");
			SeleniumFunction.sendKeys(returnPage.setPostalCode(), "78965");
			SeleniumFunction.sendKeys(returnPage.setPhoneNum(), "1236547898");
			SeleniumFunction.sendKeys(returnPage.setDate(), JavaFunction.currentDateFormat("yyyy-MM-dd"));
			SeleniumFunction.click(returnPage.clickSubmitBtn());
			
			if(returnPage.checkAcceptWarning().size()> 0){
				SeleniumFunction.click(	returnPage.acceptWarning());
			}
		}catch(Exception e){
			Assert.fail();
		}		
	}
	
	public void changeStatusAndSetDate(String ex_status, String ex_date){
		ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
		SeleniumFunction.selectByvalue(returnPage.selectStatus(), ex_status);
		SeleniumFunction.sendKeys(returnPage.setFollowUpDate(), ex_date);
		SeleniumFunction.sendKeys(returnPage.setCustEmailDate(), ex_date);
		SeleniumFunction.sendKeys(returnPage.setDepostionDate(), ex_date);
		
		SeleniumFunction.click(returnPage.clickUpdateBtn());
		WaitTool.sleep(25);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		
		String selectedStatus = SeleniumFunction.getText(returnPage.getSelectedStatus());
		UseAssert.assertEquals(selectedStatus, ex_status);
		
		String followUpDate = SeleniumFunction.getAttribute(returnPage.setFollowUpDate(), "value");
		String custEmailDate = SeleniumFunction.getAttribute(returnPage.setCustEmailDate(), "value");
		String depostionDate = SeleniumFunction.getAttribute(returnPage.setDepostionDate(), "value");
		
		UseAssert.assertEquals(followUpDate, ex_date);
		UseAssert.assertEquals(custEmailDate, ex_date + " 12:00:00 AM");
		UseAssert.assertEquals(depostionDate, ex_date);
		WaitTool.sleep(5);
	}
}
