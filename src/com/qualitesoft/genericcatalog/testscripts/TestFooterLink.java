package com.qualitesoft.genericcatalog.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.genericcatalog.pageobjects.CatalogPage;

public class TestFooterLink extends InitializeTest {

	@Test
	public void testFooterLink() {
		
		CatalogPage catalogPage = new CatalogPage(driver);
		SeleniumFunction.moveToElement(driver, catalogPage.footerCatalogLink(catalogPage.footerCatalogLink().size()));
		ScreenShot.takeScreenShot(driver, "FooterLinks");

		for (int i = 1; i <= catalogPage.footerCatalogLink().size(); i++) {
			SeleniumFunction.clickJS(driver, catalogPage.footerCatalogLink(i));
			ScreenShot.takeScreenShot(driver, "FooterCatalog[" + i + "]");
		}

	}

}
