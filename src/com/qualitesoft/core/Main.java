package com.qualitesoft.core;

import java.util.List;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Main {

	public static void main(String[] args) {
		try {
			//String suiteName = "xml-config-files\\"+args[0]+""+;
			DOMConfigurator.configure("log4j.xml");
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("xml-config-files\\freightclub\\demo2.xml");
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
