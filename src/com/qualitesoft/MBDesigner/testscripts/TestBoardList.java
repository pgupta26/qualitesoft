package com.qualitesoft.MBDesigner.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.BoardList;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestBoardList extends InitializeTest{
	@Test
	public void testViewBoard(){
		WebDriver driver = getDriver();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab	
		WaitTool.sleep(5);
		BoardList list = new BoardList(driver);
		SeleniumFunction.hoverAction(driver,list.BoardIcon());
		SeleniumFunction.click(list.previewButton());
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "Preview");
		SeleniumFunction.click(list.shopthislookButton());
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "Shop This Look");
	}
}
