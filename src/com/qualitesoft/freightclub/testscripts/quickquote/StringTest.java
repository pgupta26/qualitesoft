package com.qualitesoft.freightclub.testscripts.quickquote;

import com.qualitesoft.core.SeleniumFunction;

public class StringTest {

	public static void main(String[] args) {
		String markupQuote = "$726.63";
		double markupQuoteAmount = Double.parseDouble(markupQuote.substring(1, markupQuote.length()));
		System.out.println(markupQuoteAmount);
	
	}

}
