package com.qualitesoft.core;

import java.util.List;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Main {

	public static void main(String[] args) {

		try {
			DOMConfigurator.configure("log4j.xml");
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");// path to xml..
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
