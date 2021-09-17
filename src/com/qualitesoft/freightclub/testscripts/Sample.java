package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.SoftAssertion;

public class Sample {

	public static void main(String[] args) {
		String locationName = "AutoCom90001";
		System.out.println(locationName.substring(0, 4));
		System.out.println(locationName.substring(4, locationName.length()));
	}
}
