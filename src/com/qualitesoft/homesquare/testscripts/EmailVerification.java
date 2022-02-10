package com.qualitesoft.homesquare.testscripts;

import java.text.ParseException;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;


public class EmailVerification extends InitializeTest {
	
	@Test
	public void testEmailVerification() throws ParseException {
			/*NumberFormat f = NumberFormat.getInstance();
			SeleniumFunction.executeJS(driver, "window.open('');");
			SeleniumFunction.getCurrentWindow(driver);
		    	SeleniumFunction.open(driver, "http://www.yopmail.com/en/");
		    	YopMailPage yopMailPage = new YopMailPage(driver);
		    	yopMailPage.emailAddress(emailAddress);
		    	yopMailPage.checkInbox();
		    	SeleniumFunction.selectFrame(driver, "ifinbox");
		    		yopMailPage.selectCymaxStore();
		    	SeleniumFunction.selectParentframe(driver);
		    	SeleniumFunction.selectFrame(driver, "ifmail");
		    		WaitTool.sleep(2);
		    		String[] priceData= yopMailPage.getPrice();
		    		UseAssert.assertEquals("$0.00", priceData[1]);
		    		UseAssert.assertEquals("$0.00", priceData[3]);
		    		if(testname.contains("HQS")) {
		    			UseAssert.assertEquals(f.parse(priceData[4].replace("$", "")).doubleValue(), (productPrice));
		    		}else {
		    			UseAssert.assertEquals(f.parse(priceData[4].replace("$", "")).doubleValue(), (productPrice * 2));
		    		}
				SeleniumFunction.selectParentframe(driver);
		    	SeleniumFunction.closeWindow(driver);
		    SeleniumFunction.getCurrentWindow(driver);*/    
	}

}
