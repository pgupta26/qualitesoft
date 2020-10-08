package com.qualitesoft.MBDesigner.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.BoardList;
import com.qualitesoft.MBDesigner.pageobjects.ViewBoard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestViewBoard extends InitializeTest{
	@Test
	public void testViewBoard(){
		WebDriver driver = getDriver();
		WaitTool.sleep(5);
		ViewBoard view = new ViewBoard(driver);
		SeleniumFunction.click(view.viewBoradButton());
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		BoardList list = new BoardList(driver);
		WaitTool.sleep(12);
		ScreenShot.takeScreenShot(driver, "BoardList Page");
	}

}
