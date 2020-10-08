package com.qualitesoft.genericcatalog.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.HomePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.genericcatalog.pageobjects.CatalogPage;

public class TestCatalogPage extends InitializeTest {

	@Test
	public void testCatalogPage() {

		HomePage homePage = new HomePage(driver);

		if (homePage.closeModalButton() != null) {
			ScreenShot.takeScreenShot(driver, "HomePage");
			SeleniumFunction.click(homePage.closeModalButton());
		}

		CatalogPage catalogPage = new CatalogPage(driver);
		List<WebElement> links = catalogPage.navigationlinkList();
		ScreenShot.takeScreenShot(driver, "HomePage");

		for (int i = 1; i <= links.size(); i++) {

			WaitTool.sleep(4);
			if (URL.contains("swanns")) {
				SeleniumFunction.hoverAction(driver, catalogPage.navigationLink(i));
			} else {
				SeleniumFunction.clickJS(driver, catalogPage.navigationLink(i));
			}

			WaitTool.sleep(4);
			ScreenShot.takeScreenShot(driver, "CatalogLinkClicked[" + i + "]");
			List<WebElement> subLinks = catalogPage.navigationsublinkList(i);

			int initialize;
			if (URL.contains("paradise") || URL.contains("swanns")) {
				initialize = 2;
			} else {
				initialize = 1;
			}

			int k = 0;
			if (subLinks != null) {
				for (k = initialize; k <= subLinks.size(); k++) {

					SeleniumFunction.clickJS(driver, catalogPage.navigationsubLink(i, k));
					ScreenShot.takeScreenShot(driver, "CatalogPage[" + i + "][" + k + "]");
					WaitTool.sleep(2);

					if (URL.contains("swanns")) {
						SeleniumFunction.hoverAction(driver, catalogPage.navigationLink(i));
					} else {
						SeleniumFunction.clickJS(driver, catalogPage.navigationLink(i));
					}
					WaitTool.sleep(4);
				}
			} else {
				Log.error("The sublink[" + i + "][" + k + "] have returned a null value");
			}
		}
	}
}
