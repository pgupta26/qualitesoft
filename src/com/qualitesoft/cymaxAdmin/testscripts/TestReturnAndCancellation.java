package com.qualitesoft.cymaxAdmin.testscripts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.ReturnAndCancellation;

public class TestReturnAndCancellation extends InitializeTest{

	@Test
	public void aTestStatus() throws ParseException{
		ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);

		SeleniumFunction.click(returnPage.clickReturnAndCancellationTab());
		WaitTool.sleep(5);
		SeleniumFunction.scrollIntoView(driver, returnPage.clickReturnDetailsSubtab());
		ScreenShot.takeScreenShot(driver, "Return and Cancellation tab");

		String currentDate =  JavaFunction.currentDateFormat("M/d/yyyy");
		this.changeStatusAndSetDate("RMA Sent to Cust.", "Accidental purchase", currentDate);

		//Add 7 days in current date
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(currentDate));
		c.add(Calendar.DATE, 7);  
		currentDate = sdf.format(c.getTime());

		this.changeStatusAndSetDate("Return - In Transit", "Accidental purchase", currentDate);
	}

	@Test
	public void bTestUploadedFilesCount(){
		ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
		SeleniumFunction.click(returnPage.clickReturnDetailsSubtab());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Return and Cancellation tab");
		
		String fileName = System.getProperty("user.dir") + "\\binaries\\AdminFiles\\enterprise.jpg" ;
		SeleniumFunction.uploadImage(returnPage.setChooseFile(), fileName);
		SeleniumFunction.click(returnPage.clickUploadBtn());
		ScreenShot.takeScreenShot(driver, "File Uploaded");
		
		//verify uploaded file
		WaitTool.sleep(15);
		Assert.assertTrue(returnPage.verifyUploadedFile());
		ScreenShot.takeScreenShot(driver, "Uploaded file verifed");
	}

	@Test
	public void cTestCreateFedExLabel(){
		ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
		SeleniumFunction.click(returnPage.clickReturnAndCancellationTab());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Return and Cancellation tab");

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

		ScreenShot.takeScreenShot(driver, "Fedex detail inserted");
		SeleniumFunction.click(returnPage.clickSubmitBtn());
		if(returnPage.checkAcceptWarning().size()> 0){
			SeleniumFunction.click(	returnPage.acceptWarning());
		}	
	}

	public void changeStatusAndSetDate(String ex_status, String ex_subReason, String ex_date){
		ReturnAndCancellation returnPage = new ReturnAndCancellation(driver);
		SeleniumFunction.selectByvalue(returnPage.selectStatus(), ex_status);
		SeleniumFunction.selectByVisibleText(returnPage.selectSubReason(), ex_subReason);
		SeleniumFunction.sendKeys(returnPage.setFollowUpDate(), ex_date);
		SeleniumFunction.sendKeys(returnPage.setCustEmailDate(), ex_date);
		SeleniumFunction.sendKeys(returnPage.setDepostionDate(), ex_date);

		ScreenShot.takeScreenShot(driver, "Status and date selected");
		SeleniumFunction.click(returnPage.clickUpdateBtn());
		WaitTool.sleep(25);
		SeleniumFunction.acceptAlert(driver, 1);
		driver.navigate().refresh();

		WaitTool.sleep(10);
		String selectedStatus = SeleniumFunction.getText(returnPage.getSelectedStatus());
		UseAssert.assertEquals(selectedStatus, ex_status);

		String followUpDate = SeleniumFunction.getAttribute(returnPage.setFollowUpDate(), "value");
		String custEmailDate = SeleniumFunction.getAttribute(returnPage.setCustEmailDate(), "value");
		String depostionDate = SeleniumFunction.getAttribute(returnPage.setDepostionDate(), "value");

		UseAssert.assertEquals(followUpDate, ex_date);
		UseAssert.assertEquals(custEmailDate, ex_date + " 12:00:00 AM");
		UseAssert.assertEquals(depostionDate, ex_date);
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Status and date verified");

	}
}
