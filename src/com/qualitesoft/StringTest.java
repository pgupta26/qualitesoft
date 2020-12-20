package com.qualitesoft;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.qualitesoft.core.Xls_Reader;

public class StringTest {

	public static void main(String[] args)  {
		Xls_Reader xr = new Xls_Reader("binaries/CymaxTestData.xlsx");
		String phone = xr.getCellData("ShippingAddress", "Phone", Integer.parseInt("2"));
		
		System.out.println(phone);
	}

}
