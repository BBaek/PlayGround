package com.bbaek;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Encoding {
	public static void main(String[] args) {
		String originalStr = "복사wefwe본 123.txt"; // 테스트
		String[] charSet = { "utf-8", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949" };

		for (int i = 0; i < charSet.length; i++) {
			for (int j = 0; j < charSet.length; j++) {
				try {
					System.out.println("[" + charSet[i] + "," + charSet[j] + "] = "	+ new String(originalStr.getBytes(charSet[i]), charSet[j])
//							+ "[" + stringToHexString(new String(originalStr.getBytes(charSet[i]), charSet[j])) + "]");
							+ "[" + stringToHexString(originalStr) + "]");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		
		String urii = "물류 관리";
		String uri = "%EF%BF%BD%EF%BF%BD%EF%BF%BD%EF%BF%BD%20%EF%BF%BD%EF%BF%BD";
		try {
			String utf = URLEncoder.encode(urii, "UTF-8");
			String euc = URLEncoder.encode(urii, "EUC-KR");
			System.out.println(URLDecoder.decode(uri, "UTF-8"));
			System.out.println(URLDecoder.decode(uri, "EUC-KR"));
			System.out.println(URLDecoder.decode(uri, "iso-8859-1"));
			System.out.println(utf);
			System.out.println(utf + " UTF-8> " + URLDecoder.decode(utf, "UTF-8"));
			System.out.println(utf + " EUC-KR> " + URLDecoder.decode(utf, "EUC-KR"));
			System.out.println(utf + " ISO-8859-1> " + URLDecoder.decode(utf, "iso-8859-1"));
			System.out.println(euc);
			System.out.println(URLDecoder.decode(euc, "UTF-8"));
			System.out.println(URLDecoder.decode(euc, "EUC-KR"));
			System.out.println(URLDecoder.decode(euc, "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String stringToHexString(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += String.format("%02X ", (int)str.charAt(i));
		}
		return result;
	}
}
