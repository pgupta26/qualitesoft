package com.qualitesoft.freightclub_enhancement.qa538.testscripts;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.freightclub_enhancement.qa518.testScripts.TestQuickQuoteRates;

public class Sample {
	
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*String value = "33.37";
		String value1 ="5";
		BigDecimal bigDecima = new BigDecimal(value);
		BigDecimal bigDecimal = new BigDecimal(value1);
		
		//String markups = "5";
		BigDecimal big =  bigDecima.subtract(bigDecimal);
		
		System.out.println("In Double: "+big.doubleValue());
		System.out.println(String.valueOf(big));
		
		String str = "28.37";
		System.out.println(Double.parseDouble(str));*/
		
    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		String formatDate = sdf.format(c.getTime());  
		
		Log.info("Current Date Created: "+formatDate);
	}
}
