package com.qualitesoft.core;

import static org.testng.Assert.assertThrows;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFunction {

	public static void click(WebElement element) {

		try {
			element.click();
			Log.info("WebElement clicked.");
		} catch (Exception e) {
			Log.warn("Not able to click the webelement: " + element + e.getMessage());
			throw e;
		}
	}

	public static void clickAction(WebDriver driver, WebElement element) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			Log.info("WebElement clicked.");
		} catch (Exception e) {
			Log.warn("Not able to click the webelement: " + element + e.getMessage());
			throw e;
		}
	}

	public static void hoverAction(WebDriver driver, WebElement element) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			Log.warn("Not able to hover the webelement: " + element + e.getMessage());
			throw e;
		}
	}

	public static void clickJS(WebDriver driver,WebElement element) {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			Log.info("WebElement clicked.");
		} catch (Exception e) {
			Log.warn("Not able to click the webelement: " + element + e.getMessage());
			throw e;
		}
	}

	public static void sendKeysJS(WebDriver driver, WebElement element, String text) {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + text + "'", element);
			Log.info("WebElement clicked.");
		} catch (Exception e) {
			Log.warn("Not able to send text to the webelement: " + element + e.getMessage());
			throw e;
		}
	}

	public static void sendKeysAction(WebDriver driver, WebElement element, CharSequence keysToSend) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).sendKeys(element, keysToSend).build().perform();
		} catch (Exception e) {
			Log.warn("Not able to send keys" + e.getMessage());
			throw e;
		}
	}

	public static void sendKeys(WebElement element, String text) {

		try {
			element.clear();
			if(!element.getAttribute("value").equals("")){
				element.clear();
			}
			element.sendKeys(text);
			Log.info("Text send.");
		} catch (Exception e) {
			Log.warn("Not able to send text: " + element + e.getMessage());
			throw e;
		}
	}


	public static String getText(WebElement element) {

		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			Log.warn("Not able to get text from the: " + element + e.getMessage());
			throw e;
		}
	}

	public static void select(WebElement element, String text) {

		try {
			Select option = new Select(element);
			option.selectByVisibleText(text);
			Log.info("Value from the dropdown selected: " + text);
		} catch (Exception e) {
			Log.warn("Not able to select value from dropdown: " + element);
			throw e;
		}
	}

	public static void selectByIndex(WebElement element, int index) {

		try {
			Select option = new Select(element);
			option.selectByIndex(index);
			Log.info("Index from the dropdown selected: " + index);
		} catch (Exception e) {
			Log.warn("Not able to select index from dropdown: " + index);
			throw e;
		}
	}

	public static void selectByvalue(WebElement element, String value) {

		try {
			Select option = new Select(element);
			option.selectByValue(value);
			
			WaitTool.sleep(1);
			if(!option.getFirstSelectedOption().getText().equals(value)) {
				System.out.println("value from the dropdown not selected in 1st attempt.");
				option.selectByValue(value);
			} 
			Log.info("value from the dropdown selected: " + value);
		} catch (Exception e) {
			Log.warn("Not able to select value from dropdown: " + value);
			throw e;
		}
	}

	public static void selectByVisibleText(WebElement element, String value) {

		try {
			Select option = new Select(element);
			option.selectByVisibleText(value);
			Log.info("value from the dropdown selected: " + value);
		} catch (Exception e) {
			Log.warn("Not able to select value from dropdown: " + value);
			throw e;
		}
	}

	public static void executeJS(WebDriver driver, String script) {
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script);
		}catch(Exception e) {
			Log.warn("Not able to execute java script");
			throw e;
		}
	}

	public static void executeJS(WebDriver driver, String script, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script, element);
		}catch(Exception ex) {
			Log.warn("Not able to execute java script");
			throw ex;
		}
	}

	public static void selectFrame(WebDriver driver, String frameID) {
		try {
			driver.switchTo().frame(frameID);
		}catch(Exception ex) {
			Log.warn("Not able to switch to frame");
			throw ex;
		}
	}

	public static void selectParentframe(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		}catch(Exception ex) {
			Log.warn("Not able to switch to frame");
			throw ex;
		}
	}

	public static void closeWindow(WebDriver driver) {
		try {
			driver.close();
		}catch(Exception ex) {
			Log.warn("Not able to close current window");
			throw ex;
		}
	}
	public static void runAutoItScript(String scriptname, String cmd) {

		try {
			String path = System.getProperty("user.dir") + "/binaries/autoit/" + scriptname;
			Runtime.getRuntime().exec(path + " " + cmd);
		} catch (Exception e) {
			Log.error("Not able to run AutoIt script" + e.getMessage());
		}
	}

	public static void getCurrentWindow(WebDriver driver) {

		WaitTool.sleep(2);
		try {
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				driver.switchTo().window(window);
			}
		} catch (Exception e) {
			Log.error("Not able to get current window: " + e.getMessage());
			throw e;
		}
	}

	public static void moveToElement(WebDriver driver, WebElement element) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			Log.error("Not able to move to element: " + e.getMessage());
		}
	}

	public static String getCurrentUrl(WebDriver driver){

		try{
			String url=driver.getCurrentUrl();
			Log.info("Current URL: "+ url);
			return url;
		}catch(Exception e){
			Log.error("Unable to Load Current URL: "+ e.getMessage());
			throw e;
		}
	}

	public static void get(WebDriver driver, String url){

		try{
			driver.get(url);
			Log.info("URL opened: "+ url);
		}catch(Exception e){
			Log.error("Unable to load new URL: "+ e.getMessage());
			throw e;
		}
	}
	public static void KeyBoradEnter(WebDriver driver){

		try{
			Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
			keyboard.pressKey(Keys.ENTER);
			Log.info("Enter has pressed ");
		}catch(Exception e){
			Log.error("Unable to press enter key");
			throw e;
		}
	}
	public static void scrollUp(WebDriver driver){
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
			Log.info("Scroll top of the page");
		}catch(Exception ex) {
			Log.error("Unable to scroll top of the page");
			throw ex;
		}
	}

	//*******************************************************Scroll Up/Down Shubham***********************************************

	public static void scrollDownByPixel(WebDriver driver, String pixel){
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+ pixel +")");
	}

	//to perform Scroll on application using  Selenium
	public static void scrollDownUptoFooter(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	//to perform Scroll on application using  Selenium
	public static void 	scrollUPUptoHeader(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
	}

	public static void scrollUpByPixel(WebDriver driver, String pixel){
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-" + pixel +")");
	}

	public static void scrollIntoView(WebDriver driver) throws InterruptedException{
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void horizontalScroll(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(250,0)", "");
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void open(WebDriver driver, String url) {
		try {
			driver.get(url);
		}catch(Exception ex) {
			Log.error("Unable to launch url.");
			throw ex;
		}
	}
}
