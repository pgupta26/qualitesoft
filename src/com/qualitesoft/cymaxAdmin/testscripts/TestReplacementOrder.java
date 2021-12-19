package com.qualitesoft.cymaxAdmin.testscripts;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.ReplacementPage;

public class TestReplacementOrder extends InitializeTest{

	@Test
	public void verifyStatusAndFollowUpDate(){
		ReplacementPage replacement = new ReplacementPage(driver);
		
		SeleniumFunction.click(replacement.clickReplacementTab());
		WaitTool.sleep(20);
		this.changeStatus("Accepted", JavaFunction.currentDateFormat("M/d/yyyy"));
		this.changeStatus("Completed", "12/31/2022");
	}
	
	@Test
	public void verifyUploadedFile(){
		ReplacementPage replacement = new ReplacementPage(driver);
		WaitTool.sleep(10);
		String fileName = System.getProperty("user.dir") + "\\binaries\\AdminFiles\\enterprise.jpg" ;
		SeleniumFunction.uploadImage(replacement.setChooseFile(), fileName);
		
		int beforeUplodingFileCount = replacement.getUploadedPhotosText().size();
		ScreenShot.takeScreenShot(driver, "Upload Replacement Image Page");
		SeleniumFunction.click(replacement.clickUploadBtn());
		
		WaitTool.sleep(20);
		int afterUplodingFileCount = replacement.getUploadedPhotosText().size();
		UseAssert.assertEquals(afterUplodingFileCount, beforeUplodingFileCount + 1); 
	}
	
	public void changeStatus(String ex_status, String ex_date){
		ReplacementPage replacement = new ReplacementPage(driver);
		SeleniumFunction.selectByvalue(replacement.selectStatus(), ex_status);
		SeleniumFunction.sendKeys(replacement.setFollowUpDate(), ex_date);
		
		ScreenShot.takeScreenShot(driver, "Update Peplacement Page");
		
		SeleniumFunction.click(replacement.clickSaveBtn());
		WaitTool.sleep(20);
		SeleniumFunction.acceptAlert(driver, 1);
		driver.navigate().refresh();
		
		WaitTool.sleep(10);
		String selectedStatus = SeleniumFunction.getText(replacement.getSelectedStatus());
		UseAssert.assertEquals(selectedStatus, ex_status);
		
		String followUpDate = SeleniumFunction.getAttribute(replacement.setFollowUpDate(), "value");
		UseAssert.assertEquals(followUpDate, ex_date + " 12:00:00 AM");
		WaitTool.sleep(5);
	}
}
