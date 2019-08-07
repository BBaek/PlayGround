package com.bbaek;

public class UnicodeTest {
	public static void main(String[] args) {
		String string = "GST";  
		byte[] bytes = string.getBytes();  
		for (byte b : bytes) {  
		    System.out.print(String.format("0x%02X ", b));
		}
		System.out.println();  
	}
}
