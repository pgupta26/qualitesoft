package com.qualitesoft.freightclub_enhancement.qa537.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement manageOrdersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/Order/Index')]"), 30);
	}
	public WebElement OrderHistoryLink() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='site-menu-icon fa fa-archive']//span"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Manage Invoices')]"), 30);
		 //return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Order History')]"), 30);
	}
	public WebElement OrderHistoryLastpage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Last'])[2]"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='k-link k-pager-nav k-state-disabled k-pager-last']"), 30);
	}
	public WebElement manageGreenLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Profile/Greenlist']"), 30);
	}
	public WebElement downloadGreenlistLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='link-important']"), 30);
	}	
	public WebElement createproduct() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-sm']"), 30);
	}
	public WebElement SKU() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='SKU']"), 30);
	}
	public WebElement productName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Name']"), 30);
	}
	public WebElement declaredValue() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='DeclaredValue']"), 30);
	}
	public WebElement weight() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[2]/div[1]/input"), 30);
	}
	public WebElement length() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[3]/div[1]/input"), 30);
	}
	public WebElement width() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[3]/div[2]/input"), 30);
	}
	public WebElement height() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[3]/div[3]/input"), 30);
	}
	public WebElement cateogory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-cartons-table\"]/tbody/tr/td[4]/select"), 30);
	}	
	public WebElement cateogoryoption() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-cartons-table\"]/tbody/tr/td[4]/select/option[2]"), 30);
	}	
	public WebElement freightclass() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[5]/select"), 30);
	}	
	public WebElement freightclassoption() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[5]/select/option[1]"), 30);
	}
	public WebElement closemodal() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"createProductModal\"]/div/div/div[2]/div/form/div[2]/div/table/tbody/tr/td[5]/div/div/div/div[1]/button"), 30);
	}
	public WebElement saveproduct() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='createProductModal']/div/div/div[3]/div/div[2]/button"), 30);
	}	
	public WebElement manageProductLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[contains(@href,'/Product/UploadProducts')]"), 30);
	}
	public WebElement MenuScroll() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='site-menubar-body asScrollable scrollable-inverse is-enabled asScrollable-vertical']"), 30);
	}
	public WebElement selectFilesFullOrder() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='files']//ancestor::div[1]"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='k-button k-upload-button']"), 30);
	}

	public void uploadFileProductChrome() {

		try {
			SeleniumFunction.clickAction(driver, selectFilesFullOrder());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\FCfiles\\" + InitializeTest.manageproductfile };
			SeleniumFunction.runAutoItScript("manageproductuploadchrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}

	public void uploadFileFullOrderChrome() {

		try {
			SeleniumFunction.clickAction(driver, selectFilesFullOrder());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\FCfiles\\" + InitializeTest.managefullorderfile };
			SeleniumFunction.runAutoItScript("manageproductuploadchrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}
	public void uploadFileChrome(String file) {

		try {
			SeleniumFunction.clickAction(driver, selectFilesFullOrder());
			WaitTool.sleep(10);
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\FCfiles\\" + file};
			WaitTool.sleep(10);
			SeleniumFunction.runAutoItScript("manageproductuploadchrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}
	public WebElement OKButton() {
		//Object Modified on 15/10/2019
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//h3[text()='Upload Product Results']/following::button[1] | //h3[text()='Upload Greenlist Results']/following::button[1]"), 30);
		//return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//button[@class='btn btn-primary']"), 30);
	}

	public WebElement uploadButton() {

		//return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//button[contains(.,'Upload files')]"),30);
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//button[@class='k-button k-upload-selected']"), 30);
	}

	public WebElement failureMsg() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'text-danger')]"), 30);
	}

	public WebElement successMsg() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'text-success')]"), 30);
	}

	public void sucessMsgManageProducts() {

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'text-success')]"))) {
			String sucessMsg = SeleniumFunction.getText(successMsg());
			String imports = sucessMsg.substring(0, 1);
			Log.info("Imports: " + imports);
			if (Integer.parseInt(imports) > 0) {
				Log.info(SeleniumFunction.getText(successMsg()));
			} else {
				Log.error(SeleniumFunction.getText(successMsg()));
				Assert.fail();
			}
		}
	}

	public WebElement quickOrderButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(.,'Open Quotes')]"), 30);
	}

	public WebElement selectFilesQuickOrders() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='quickFiles']//ancestor::div[1]"),
				30);
	}

	public void uploadFileQuickOrderChrome() {

		try {
			SeleniumFunction.clickAction(driver, selectFilesQuickOrders());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\FCfiles\\" + InitializeTest.managequickorderfile };
			SeleniumFunction.runAutoItScript("manageproductuploadchrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}

	public WebElement bookQuickOrdersButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath(".//*[@id='quickGrid']//button[2]"), 30);
	}
	
	public WebElement bookFullOrdersButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(.//*[@id='allGrid']//button[contains(@class,'book-button')])[1]"), 30);
	}

	public WebElement quickQuotesNextButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@class,'btn btn-success pull-right')]"), 30);
	}
	
	public WebElement costOfShipmentTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='TotalCost']"), 30);
	}
	
	public WebElement pickUpLocationDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='PickupLocationID']"), 30);
	}
	
	public WebElement dropOffZipCode() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@id,'DeliverZip')]"), 30);
	}
	
	public WebElement quickQuoteServiceLevelDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ServiceLevel']"), 30);
	}
	
	public WebElement quickQuoteAcceptAndContinueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(.,'Accept and Continue')]"), 30);
	}
	
	public WebElement quickQuoteFirstNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupFirstName']"), 30);
	}
	
	public WebElement quickQuoteLastNameTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupLastName']"), 30);
	}
	
	public WebElement quickQuoteStreetAddressTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupAddress']"), 30);
	}
	
	public WebElement quickQuotePhonenoTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupPhoneNumber']"), 30);
	}
	
	public WebElement quickQuoteemailTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupEmailAddress']"), 30);
	}
	
	public WebElement quickQuoteFirstNameDropTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='FirstName']"), 30);
	}
	
	public WebElement quickQuoteLastNameDropTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='LastName']"), 30);
	}
	
	public WebElement quickQuoteaddressDropTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='StreetAddress']"), 30);
	}
	
	public WebElement quickQuotePhonenoDropTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PhoneNumber']"), 30);
	}
	
	public WebElement quickQuoteemailDropTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='EmailAddress']"), 30);
	}
	
	public WebElement quickQuoteAddPalletButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnAddPallet']"), 30);
	}
	
	public WebElement quickQuotePalletQuantityTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Quantity' and preceding-sibling::input[@id='PackagingType']]"), 30);
	}
	
	public WebElement quickQuotePalletWeightTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Weight' and not (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuotePalletLengthTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Length' and not (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuotePalletWidthTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Width' and not (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuotePalletHeightTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Height' and not (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteAddNewSKUButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnAddPalletItem']"), 30);
	}
	
	public WebElement quickQuoteQuantitySKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Quantity' and not (preceding-sibling::input[@id='PackagingType']) and not (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteCostSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ProductCost']"), 30);
	}
	
	public WebElement quickQuoteQuantityCartonSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Quantity' and not (preceding-sibling::input[@id='PackagingType']) and (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteWeightCartonSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Weight' and not (preceding-sibling::input[@id='PackagingType']) and (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteLengthCartonSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Length' and (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteWidthCartonSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Width' and (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteHeightCartonSKUTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Height' and (ancestor::*[@class='tblCartonsTbody'])]"), 30);
	}
	
	public WebElement quickQuoteAddPalleteNextButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@id,'btnNext')]"), 30);
	}
	
	public WebElement quickQuoteBookOrderButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(.,'Book Order')]"), 30);
	}
	
	public WebElement quickQuoteBookOrderError() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='pull-right text-danger']/strong"), 30);
	}
	
	public void quickQuoteBookOrderValidation() {

		quickQuoteBookOrderError();
		if (quickQuoteBookOrderError() != null) {
			if (driver.findElement(By.xpath(".//*[@class='pull-right text-danger']/strong"))
					.getText() != "duplicate") {
				Log.error(driver.findElement(By.xpath(".//*[@class='pull-right text-danger']/strong")).getText());
				//Assert.fail();
			}
		}
	}	
	
	public WebElement newQuickOrderButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(.,'New Quick Order')]"), 30);
	}
	
	public WebElement quickQuoteRefIdTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='OrderReferenceID']"), 30);
	}
	
	public WebElement quickQuoteZipcodeTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PickupZip']"), 30);
	}
	
	public WebElement fullOrderRefno() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='allGrid']/table/tbody/tr[1]/td[4]"), 30);
	}
	
	public WebElement billofLadingButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='btn btn-info btn-xs bol-button']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/BillOfLading/Index']"), 30);
	}
	public WebElement ActionButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(.,'Export to PDF')]"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-xs dropdown-toggle']"), 30);
	}
	public WebElement DownloadPDFButton() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"), 30);
	}
	public WebElement opendownloaded() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=title-area]"), 30);
	}
	public WebElement newDownloadZPLButton() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a"), 30);
	}
	public WebElement exportToPDFButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(.,'Export to PDF')]"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-primary btn-xs display-block']"), 30);
	}
	public WebElement DownloadZPLButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='bolGrid']/table/tbody/tr/td[5]/a[2]"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-primary btn-xs display-block margin-top-5']"), 30);
	}

	
	public WebElement veiwDetailButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[contains(@class,'btn btn-info btn-view-detail')])[1]"), 30);
	}
	
	public WebElement updateTrackingStatusButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-success bottom-spacer']"), 30);
		 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Update Order Information')]"), 30);
	}
	public WebElement admintabButton() {

		 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Admin')]"), 30);
	}
	public WebElement editButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-xs btn-primary']"), 30);
	}
	public WebElement trackingNoLink() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[contains(.,'FCT')])[1]"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='ag-body-viewport-wrapper']//div[@class='ag-body-viewport']//div[@class='ag-body-container']//div[@class='ag-row ag-row-animation ag-row-level-0 ag-row-even ag-row-focus']/div[5]/a[@target='_blank']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@colid='TrackingNos']//div//div//div//a[@target='_blank']"), 30);
	}
	
	public WebElement fullOrderOKButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-success']"), 30);
	}
	
	public WebElement exportOrdersinCSVFormatButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Order/DownloadCSV']"), 30);
	}
	
	public WebElement logOffButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='logOff']"), 30);
	}
	public WebElement IDTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@ref='eColumnFloatingFilter']"), 30);
	}	
	public WebElement ViewDetail() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-xs']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	public WebElement Okbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='modal-footer']//button[@class='btn btn-success']"), 30);
	}
	public WebElement Okbutton1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"orderHistoryDetail\"]/div/div/div[3]/button"), 30);
	}
	public WebElement updatehistory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"orderDetailsTabs\"]/li[2]/a"), 30);
	}
	public WebElement OrderIDTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-text-field='OrderId']"), 30);
	}	
	public WebElement logoff() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='navbar-collapse collapse']//ul[2]//li[3]"), 30);
		 return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'Log off')]"), 30);
	}
	public WebElement ExpandMenupage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='Click to retract or expand the page menu']"), 30);
	}	
	public WebElement ActionDropDown() {
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[11]/div/button"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary btn-xs dropdown-toggle'])[1]"), 30);
	}
	public WebElement CloneDropDown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Clone"), 30);

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-xs dropdown-toggle']/ul/li[3]/a[contains(text(),'Clone')"), 30);
	}
	public WebElement customerPOnumber() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='poNumber']"), 30);
	}
	public WebElement cloneNowButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary']"), 30);
	}	
}
