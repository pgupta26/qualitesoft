package com.qualitesoft.freightclub;

import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;

public class StringTest {

	public static void main(String[] args) {
		
		boolean flag=true;
		String newInvoiceAmount = null;
		int lastDigit;
		
		while(flag) {
			 newInvoiceAmount = String.valueOf(JavaFunction.getRandomNumber(1, 999))+"."+String.valueOf(JavaFunction.getRandomNumber(1, 99));
			 lastDigit = Integer.parseInt(String.valueOf(newInvoiceAmount.charAt(newInvoiceAmount.length()-1)));
			 if(lastDigit > 0) {
				flag = false; 
			 }
		}
		Log.info("New Invoice Amount Generated:  "+newInvoiceAmount);
	}

}
