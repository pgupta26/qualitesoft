package com.qualitesoft.core;

public class UseAssert {

	public static void assertEquals(String actual, String expected) {

		try {
			org.testng.Assert.assertEquals(actual, expected);
			Log.info("[" + actual + "] matched with [" + expected + "]");
		} catch (AssertionError e) {
			Log.warn(e.getMessage());
			throw e;
		}
	}
}
