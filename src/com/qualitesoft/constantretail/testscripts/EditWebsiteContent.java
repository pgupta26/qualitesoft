package com.qualitesoft.constantretail.testscripts;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.AboutUsWebsitePage;
import com.qualitesoft.constantretail.pageobjects.NavigationBarPage;
import com.qualitesoft.constantretail.pageobjects.SitePagesPage;
import com.qualitesoft.constantretail.pageobjects.WebsitePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class EditWebsiteContent extends InitializeTest {

	public static String aboutUsText = "Automated Test";
	public static String generalInfoText = "New Element";

	@Test
	public void testEditWebsiteContent() {

		WebDriver driver = getDriver();

		String websiteWindow = driver.getWindowHandle();

		driver.switchTo().window(CreateNewStore.adminPortalWindow);

		NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
		SeleniumFunction.clickJS(driver, navigationBarPage.pagesLink());

		SitePagesPage sitePagesPage = new SitePagesPage(driver);
		WaitTool.sleep(6);
		ScreenShot.takeScreenShot(driver, "SitePagesPage");
		SeleniumFunction.click(sitePagesPage.aboutUsLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "AboutUsPage");
		WaitTool.sleep(1);
		driver.switchTo().frame("contentFrame");
		WaitTool.sleep(1);
		SeleniumFunction.click(sitePagesPage.aboutUsEditButton());
		ScreenShot.takeScreenShot(driver, "AboutUsEditorPopup");
		SeleniumFunction.sendKeys(sitePagesPage.aboutUsTextbox(), aboutUsText);
		SeleniumFunction.click(sitePagesPage.saveButton());
		ScreenShot.takeScreenShot(driver, "AboutUsSavedPopup");
		driver.switchTo().defaultContent();

		driver.switchTo().window(websiteWindow);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		WebsitePage websitePage = new WebsitePage(driver);
		SeleniumFunction.click(websitePage.aboutUs());
		AboutUsWebsitePage aboutUsWebsitePage = new AboutUsWebsitePage(driver);
		if (SeleniumFunction.getText(aboutUsWebsitePage.aboutUsLink()).equalsIgnoreCase(aboutUsText)) {
			Log.info("Text matched on website about us page.");
		} else {
			Log.error("Text not matched on website about us page.");
			Assert.fail();
		}
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "AboutUsPageEdited");

		driver.switchTo().window(CreateNewStore.adminPortalWindow);
		SeleniumFunction.click(sitePagesPage.homeViewLink());
		ScreenShot.takeScreenShot(driver, "SitePagesPageHomeView");
		WaitTool.sleep(2);
		driver.switchTo().frame("contentFrame");
		Actions actions = new Actions(driver);
		actions.moveToElement(sitePagesPage.generalInfoEditButton()).build().perform();
		SeleniumFunction.click(sitePagesPage.generalInfoEditButton());
		WaitTool.sleep(4);
		SeleniumFunction.clickJS(driver, sitePagesPage.addNewLinkButton());
		WaitTool.sleep(2);
		//actions.moveToElement(sitePagesPage.generalInfoEditTextbox()).click().build().perform();
		ScreenShot.takeScreenShot(driver, "NewLinkEditorPopup");
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, sitePagesPage.generalInfoEditTextbox());

		SeleniumFunction.sendKeysJS(driver, sitePagesPage.generalInfoEditTextbox(), generalInfoText);
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, sitePagesPage.generalInfoSaveButton());
		ScreenShot.takeScreenShot(driver, "GeneralInfoSavedPopup");

		if (SeleniumFunction.getText(sitePagesPage.newElement()).equalsIgnoreCase(generalInfoText)) {
			Log.info("New Element text matched on Site page editor popup.");
		} else {
			Log.error("New Element text matched didnot on Site page editor popup.");
		}
		driver.switchTo().window(websiteWindow);
		driver.navigate().refresh();
		ScreenShot.takeScreenShot(driver, "NewElementWebsite");
		
		if (SeleniumFunction.getText(sitePagesPage.newElementWebsite()).equalsIgnoreCase(generalInfoText)) {
			Log.info("New Element text matched on Website.");
		} else {
			Log.error("New Element text didnot matched on Website.");
			Assert.fail();
		}		
	}
}
