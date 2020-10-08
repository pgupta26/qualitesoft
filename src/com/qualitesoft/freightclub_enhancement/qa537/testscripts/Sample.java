package com.qualitesoft.freightclub_enhancement.qa537.testscripts;

import java.math.BigDecimal;

import com.qualitesoft.freightclub_enhancement.qa518.testScripts.TestQuickQuoteRates;

public class Sample {
	
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

	public static void main(String[] args) {
		String str1 = "Standard Pallet 1";
		
		//str1.split("Standard");
		System.out.println(str1.split("Standard ")[1]);
	}
}
