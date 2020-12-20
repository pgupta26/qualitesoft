package com.qualitesoft.cymax.testscripts;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.CheckoutPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.OrderConfirmationPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;
import com.qualitesoft.cymax.pageobjects.ShippingInformationPage;

public class TestApplyCouponCode extends InitializeTest {

	@Test
	public void testApplyCouponCode() throws ParseException {

		HomePage homePage = new HomePage(driver);
		if (homePage.cymaxPopup() != null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebElement furnitureLink = myAccountPage.furniturelink();
		WaitTool.sleep(1);
		SeleniumFunction.hoverAction(driver, furnitureLink);
		myAccountPage.bedLink();
		myAccountPage.murphyBeds();
		ScreenShot.takeScreenShot(driver, "Beds category page");

		ProductsPage productPage = new ProductsPage(driver);
		productPage.murphyBed();
		NumberFormat f = NumberFormat.getInstance();
		productPrice = f.parse(productPage.productPrice().replace("$", "")).doubleValue();
		Log.info("**************************************************Product Price : " + productPrice);
		ScreenShot.takeScreenShot(driver, "Product detail page");

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		WebElement quantityDropdown = addToCartPage.quantityDropdown();
		jse.executeScript("arguments[0].value='2';", quantityDropdown);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		WaitTool.sleep(5);

		// Remove multiple products
		CartPage cartPage = new CartPage(driver);
		int cartItemCount = cartPage.cartItemCount();
		Log.info("Cart Item Count: " + cartItemCount);
		int i = 0;
		if (cartItemCount > 1) {
			while (i < (cartItemCount - 1)) {
				SeleniumFunction.click(cartPage.deleteProductLink());
				WaitTool.sleep(1);
				i++;
			}
		}

		ScreenShot.takeScreenShot(driver, "CartPage");
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.tax(), tax);

		// Verify coupon code applied successfully
		SeleniumFunction.click(cartPage.haveACouponCode());
		SeleniumFunction.sendKeys(cartPage.couponCode(), "CYMJBTEST");
		SeleniumFunction.click(cartPage.applyCouponCode());
		WaitTool.sleep(2);
		UseAssert.assertEquals(SeleniumFunction.getText(cartPage.couponResponse()), "Your coupon has been applied.");
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);

		// Total Price Calculation
		double totalPrice = (productPrice * 2)
				- f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);
		SeleniumFunction.click(cartPage.checkoutButton());
	}

	@Test
	public void testSignIn() {
		LoginPage loginPage = new LoginPage(driver);
		if (loginPage.alreadyHaveAccountPresent()) {
			loginPage.alreadyHaveAccount();
			loginPage.userName(emailAddress);
			loginPage.password("CymaxQa1234");
			ScreenShot.takeScreenShot(driver, "login information entered");
			loginPage.signInButton();
			Log.info("login successfully.");
		}
	}

	@Test
	public void testShippingInformation() throws ParseException {

		Xls_Reader xr = new Xls_Reader("binaries/CymaxTestData.xlsx");
		String firstName = xr.getCellData("ShippingAddress", "FirstName", Integer.parseInt(Row)).trim();
		String lastName = xr.getCellData("ShippingAddress", "LastName", Integer.parseInt(Row)).trim();
		String address1 = xr.getCellData("ShippingAddress", "Address1", Integer.parseInt(Row)).trim();
		String address2 = xr.getCellData("ShippingAddress", "Address2", Integer.parseInt(Row)).trim();
		String city = xr.getCellData("ShippingAddress", "City", Integer.parseInt(Row)).trim();
		String state = xr.getCellData("ShippingAddress", "State", Integer.parseInt(Row)).trim();
		String country = xr.getCellData("ShippingAddress", "Country", Integer.parseInt(Row)).trim();
		String zipCode = xr.getCellData("ShippingAddress", "PinCode", Integer.parseInt(Row)).trim();
		String phone = xr.getCellData("ShippingAddress", "Phone", Integer.parseInt(Row));

		double totalPrice;
		CartPage cartPage = new CartPage(driver);
		NumberFormat f = NumberFormat.getInstance();

		WaitTool.sleep(5);
		ShippingInformationPage shippingInfo = new ShippingInformationPage(driver);

		// Verify Price
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);
		UseAssert.assertEquals(cartPage.tax(), tax);
		totalPrice = (productPrice * 2)
				- f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);

		SeleniumFunction.sendKeys(cartPage.firstName(), firstName);
		SeleniumFunction.sendKeys(cartPage.lastName(), lastName);
		SeleniumFunction.sendKeys(cartPage.address1(), address1);
		SeleniumFunction.sendKeys(cartPage.address2(), address2);
		SeleniumFunction.sendKeys(cartPage.zipcode(), zipCode);
		SeleniumFunction.sendKeys(cartPage.city(), city);
		SeleniumFunction.select(cartPage.country(), country);
		WaitTool.sleep(5);
		SeleniumFunction.select(cartPage.state(), state);
		SeleniumFunction.sendKeys(cartPage.phone(), phone);
		shippingInfo.businessCommercial();
		shippingInfo.companyName("company name");
		shippingInfo.industry("Education");
		SeleniumFunction.sendKeys(cartPage.SpecialDelivery(), "test");
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "shipping info");
		SeleniumFunction.click(cartPage.reviewButton());
		WaitTool.sleep(5);
		ScreenShot.takeFullScreenShot("Review Order page");

		// Verify Prices
		productPrice = productPrice * 2;
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), productPrice);
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);

		double couponValue1 = f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		DecimalFormat df = new DecimalFormat("#####.##");
		double tax1 = ((productPrice - couponValue1) * f.parse(taxRate).doubleValue() / 100);
		tax = df.format(tax1);
		UseAssert.assertEquals(cartPage.tax().replace("$", ""), tax);
		totalPrice = productPrice - couponValue1 + f.parse(df.format(tax1)).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);
		SeleniumFunction.clickJS(driver, cartPage.reviewButton()); // continue
																	// payment
	}

	@Test
	public void testCartPages() throws ParseException {
		double totalPrice;
		CartPage cartPage = new CartPage(driver);
		NumberFormat f = NumberFormat.getInstance();
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), productPrice);
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);

		double couponValue1 = f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		DecimalFormat df = new DecimalFormat("#####.##");
		double tax1 = ((productPrice - couponValue1) * f.parse(taxRate).doubleValue() / 100);
		tax = df.format(tax1);
		UseAssert.assertEquals(cartPage.tax().replace("$", ""), tax);

		totalPrice = productPrice - couponValue1 + f.parse(df.format(tax1)).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		SeleniumFunction.sendKeys(checkoutPage.creditCardNumberTextbox(), "4111111111111111");
		SeleniumFunction.select(checkoutPage.expiryMonthDropdown(), "01 (Jan)");
		SeleniumFunction.select(checkoutPage.expiryYearDropdown(), "2021");
		SeleniumFunction.sendKeys(checkoutPage.securityCodeTextbox(), "123");
		SeleniumFunction.sendKeys(checkoutPage.cardHolderNameTextbox(), "Selenium Cymax");
		ScreenShot.takeScreenShot(driver, "Payment info");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(cartPage.reviewButton());// place my order
	}

	@Test
	public void testOrderConfirmation() throws ParseException {
		double totalPrice;
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		orderConfirmationPage.close();
		WaitTool.sleep(2);
		ScreenShot.takeFullScreenShot("OrderConfirmationPage");

		CartPage cartPage = new CartPage(driver);
		NumberFormat f = NumberFormat.getInstance();
		UseAssert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), productPrice);
		UseAssert.assertEquals(cartPage.shipping(), shipping);
		UseAssert.assertEquals(cartPage.couponCodeValue(), couponValue);

		double couponValue1 = f.parse(couponValue.replace("$", "").replace("(", "").replace(")", "")).doubleValue();
		DecimalFormat df = new DecimalFormat("#####.##");
		double tax1 = ((productPrice - couponValue1) * f.parse(taxRate).doubleValue() / 100);
		tax = df.format(tax1);
		UseAssert.assertEquals(cartPage.tax().replace("$", ""), tax);

		totalPrice = productPrice - couponValue1 + f.parse(df.format(tax1)).doubleValue();
		UseAssert.assertEquals(f.parse(cartPage.totalPrice().replace("$", "")).doubleValue(), totalPrice);
		WaitTool.sleep(15);

		orderConfirmationPage.successMsg();
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);

		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());
		HomePage homePage = new HomePage(driver);
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(homePage.myAccountLink());
		WaitTool.sleep(5);

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement orderId = myAccountPage.orderId();
		ScreenShot.takeScreenShot(driver, "OrderOnMyAccount");
		String orderIdString = SeleniumFunction.getText(orderId);
		System.out.println("Orderid account :" + orderIdString);
		Log.info("Order Id on My Account page: " + orderIdString);

		if (orderNumberString.equalsIgnoreCase(orderIdString)) {
			Log.info("Order Id matched on Order confirmation and My Account page");
		} else {
			Log.error("Order Id did not matched on Order confirmation and My Account page");
			Assert.fail();
		}
	}
}
