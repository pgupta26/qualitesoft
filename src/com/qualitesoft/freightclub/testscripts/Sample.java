package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SoftAssertion;

public class Sample {

	@Test
	public void assertionTest() {
		
		String amount = String.valueOf(JavaFunction.getRandomNumber(1, 999))+"."+String.valueOf(JavaFunction.getRandomNumber(1, 99));
		System.out.println(amount);
		
	}

}
