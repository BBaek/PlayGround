package com.bbaek;

public class Test {
	public static void main(String[] args) {
		System.out.println(ConstType.AESKEY_LOGIN.key);
	}
}

enum ConstType {
	DES("DES", "des"),
	AESKEY("AESKEY", "aeskey"),
	AESKEY_LOGIN("AESKEY", "login"),
	AESKEY_USER("AESKEY", "user");
	
	public final String key;
	public final String value;
	
	ConstType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 *  
	 * @param
	 * @return
	 * @throws
	 */
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}