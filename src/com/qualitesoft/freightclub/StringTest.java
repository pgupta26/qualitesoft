package com.qualitesoft.freightclub;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String toastMessage = "Creating Report\r\n"
				+ "As soon as your export is ready we will send it to your login email address: test.automation@mailinator.com\r\n"
				+ "";
		toastMessage = toastMessage.replaceAll("[\\t\\n\\r]+"," ");
		
		System.out.println(toastMessage);
	}

}
