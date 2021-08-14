package com.qualitesoft.freightclub.testscripts.manageprofiles;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;

public class TestSelectPaymentMethod extends InitializeTest {
	
	@Test
	public void testSelectPaymentMethod() {
		try {
			ProfileManagementPage profileManagement = new ProfileManagementPage(driver);

			Xls_Reader xr = new Xls_Reader("binaries/FCfiles/"+testData);
			int rowIndex = Integer.parseInt(Row);
			Log.info("Row Number: "+rowIndex);	
			
			String paymentMethod = xr.getCellData("ContactInfo", "PaymentMethod", rowIndex);
			
			SeleniumFunction.moveToElement(driver, profileManagement.paymentType());
			SeleniumFunction.selectByVisibleText(profileManagement.paymentType(), paymentMethod);
			ScreenShot.takeScreenShot(driver, "OnAccount Payment Selected");		

			//click on save profile
			SeleniumFunction.scrollDownUptoFooter(driver);
			WaitTool.sleep(5);
			SeleniumFunction.clickJS(driver, profileManagement.saveProfileButtonSurePost());
			ScreenShot.takeScreenShot(driver, "profile saved successfully");
			WaitTool.sleep(20);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
