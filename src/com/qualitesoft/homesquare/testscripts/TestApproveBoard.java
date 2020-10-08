package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.BoardApprovalPage;

public class TestApproveBoard extends InitializeTest{
	
	@Test
	public void testApproveBoard(){
		
		BoardApprovalPage boardApprovalPage = new BoardApprovalPage(driver);
		SeleniumFunction.select(boardApprovalPage.selectDropdown(), "Only Published");
		ScreenShot.takeScreenShot(driver, "BoardApprovalPageDropdown");
		WaitTool.sleep(2);
		SeleniumFunction.click(boardApprovalPage.muzeboardCheckbox());
		ScreenShot.takeScreenShot(driver, "CheckboxClicked");
		SeleniumFunction.click(boardApprovalPage.approvalButton());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "BoardApproved");
	}

}
