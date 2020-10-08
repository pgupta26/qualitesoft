package com.qualitesoft.channelgatesip.testscripts;


import org.testng.annotations.Test;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestAdminPortal extends InitializeTest{ 
	@Test
	public void testAdminPortal(){
		WaitTool.sleep(5);
		LoginPage login = new LoginPage(driver);
		/*Robot r = null ;
		try {
			for(int i=1;i<=4;i++){
				r = new Robot();
			    r.keyPress(KeyEvent.VK_TAB);
			    r.keyRelease(KeyEvent.VK_TAB);
			    //System.out.println("Tabbed "+i+" time.");
			}
	
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);*/
	
	    SeleniumFunction.click(login.adminPortal());
		ScreenShot.takeScreenShot(driver, "Available brand page");
		WaitTool.sleep(7);
		
		
		
	}
}
