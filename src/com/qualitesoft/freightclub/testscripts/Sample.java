package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.qualitesoft.core.SoftAssertion;

public class Sample {

	@Test
	public void assertionTest() {
		SoftAssertion.assertEquals("Test", "Test1");
		System.out.println("Operation continue............");
	}

}
