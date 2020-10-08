package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qualitesoft.core.Log;

public class StringTest {

	public static void main(String[] args) throws ParseException {
		DOMConfigurator.configure("log4j.xml");
		Log.info("dfsdfsdf");
		Log.info("fsdfsfsfsdfsdfsdfsfsfdsfsfsf");
		Log.info("fsdfsdfsdf");
		Log.debug("fjsdfsd");
	}
}
