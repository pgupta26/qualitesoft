package com.qualitesoft.testcymax.testscripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class test extends InitializeTest{ 
	@Test
	public void test1() {
		//driver = new ChromeDriver();
		Xls_Reader xr=new Xls_Reader("binaries/Testfile.xlsx");
		 System.out.println("xr:" + xr);
		 int rcnt=xr.getRowCount("Input");
		 for(int i=2;i<=rcnt;i++)
			{
				String URL=xr.getCellData("Input","URL", i).trim();	
				String wait=xr.getCellData("Input","WAIT", i).trim();
				String w=wait.replace(".0","");
				int wait1=Integer.parseInt(w);
				 System.out.println("URL:" + URL);
				 System.out.println("WAIT:" + wait1);
				
				 driver.get(URL);
				WaitTool.sleep(wait1);
			}
	}
}
