package com.qualitesoft.freightclub.testscripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.OrderDetailPage;

public class TestOrderDetails extends InitializeTest {
	
	@Test
	public void testBasicThreshold() {
		
		try{
			int i=Integer.parseInt(Row);
			Log.info("Data Row: "+Row);
			
			ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderPage.ViewDetail());
			
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab		
			WaitTool.sleep(3);
			OrderDetailPage orderDetailPage =new OrderDetailPage(driver);
			if(i == 5 || i == 6 || i == 7) {
				Assert.assertTrue(orderDetailPage.verifyBasicThreshold());
				ScreenShot.takeScreenShot(driver, "Basic threshold present at order details page");
			}else if(i == 2 || i == 3 || i == 4) {
				Assert.assertFalse(orderDetailPage.verifyBasicThreshold());
				ScreenShot.takeScreenShot(driver, "Basic threshold not present at order details page");
			} else {
				Log.info("Do nothing");
			}
			
			driver.close();
			driver.switchTo().window(newTab.get(0));
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}

}
