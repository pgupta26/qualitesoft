package com.qualitesoft.cymaxAdmin.testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.ReplacementPage;

public class TestReplacementOrder extends InitializeTest{

	@Test
	public void verifyStatusAndFollowUpDate(){
		try{
			ReplacementPage replacement = new ReplacementPage(driver);
			
			SeleniumFunction.click(replacement.clickReplacementTab());
			WaitTool.sleep(20);
			this.changeStatus("Accepted", JavaFunction.currentDateFormat("M/d/yyyy"));
			this.changeStatus("Completed", "12/31/2022");
			
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void verifyUploadedFile(){
		ReplacementPage replacement = new ReplacementPage(driver);
		WaitTool.sleep(10);
		String fileName = System.getProperty("user.dir") + "\\binaries\\AdminFiles\\enterprise.jpg" ;
		SeleniumFunction.uploadImage(replacement.setChooseFile(), fileName);
		
		int beforeUplodingFileCount = replacement.getUploadedPhotosText().size();
		SeleniumFunction.click(replacement.clickUploadBtn());
		
		WaitTool.sleep(20);
		int afterUplodingFileCount = replacement.getUploadedPhotosText().size();
		UseAssert.assertEquals(afterUplodingFileCount, beforeUplodingFileCount + 1); 
	}
	
	public void changeStatus(String ex_status, String ex_date){
		ReplacementPage replacement = new ReplacementPage(driver);
		SeleniumFunction.selectByvalue(replacement.selectStatus(), ex_status);
		SeleniumFunction.sendKeys(replacement.setFollowUpDate(), ex_date);
		
		SeleniumFunction.click(replacement.clickSaveBtn());
		WaitTool.sleep(20);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		
		WaitTool.sleep(10);
		String selectedStatus = SeleniumFunction.getText(replacement.getSelectedStatus());
		UseAssert.assertEquals(selectedStatus, ex_status);
		
		String followUpDate = SeleniumFunction.getAttribute(replacement.setFollowUpDate(), "value");
		UseAssert.assertEquals(followUpDate, ex_date + " 12:00:00 AM");
		WaitTool.sleep(5);
	}
}
