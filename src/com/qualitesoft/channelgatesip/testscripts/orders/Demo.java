package com.qualitesoft.channelgatesip.testscripts.orders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo {

	public static void main(String[] args) {
		String daterow = "Showing 1 to 25 of 125302 order(s)";
		String[] paginationArr = daterow.split(" ");
		String titalRows = paginationArr[5];
		System.out.println(titalRows);

	}

}
