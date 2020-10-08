package com.qualitesoft.freightclub_enhancement.qa518.testScripts;

public class Test {

	public static void main(String[] args){
		
		String value = "345.787";
		
		System.out.println(value.indexOf("."));
		if(value.charAt(value.indexOf(".")+3)>=5){
			
			String value1 = value.substring(0,(value.indexOf(".")+3));
			System.out.println(value1);
			
			Double val=0.01;
			Double expected=(Double.parseDouble(value1));
			System.out.println(expected);
			System.out.println(Double.sum(expected, val));
			/*String value2 = expected.toString();
			String alue = value2.substring(0, value.indexOf(".")+3);
			System.out.println(alue);
	*/	}
		
		
	}
}
