package com.bbaek;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * It support for unicode BMP
 * @author wsbaek
 *
 */
public class UnicodeTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String input = "";
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Enter text(exit=/x): ");
		        input = scan.nextLine();
		        if(input.equals("/x")) {
		        	System.out.println("Exit");
		        	break;
		        }
	        	System.out.println("Input: " + input);
	        	stringToUnicode(input);
	        	stringToUnicodeBytes(input, ByteOrder.LITTLE_ENDIAN);
	        	stringToUnicodeBytes(input, ByteOrder.BIG_ENDIAN);
	        	unicodeHexStringToString(input, ByteOrder.LITTLE_ENDIAN);
	        	unicodeHexStringToString(input, ByteOrder.BIG_ENDIAN);
	        } catch (Exception e) {
	        	e.printStackTrace();
			}
		}
	}
	
	static String unicodeHexStringToString(String hexStr, ByteOrder order) {
		String[] arrStr = hexStr.split(" ");
		String text = "";
		String title = "[TEXT(LITTLE)]";
		for(int i = 0; i < arrStr.length;){
			text += "\\u";
			if(order.equals(ByteOrder.LITTLE_ENDIAN)) {
				text += arrStr[++i] + arrStr[i - 1];
				i++;
			} else {
				title = "[TEXT(BIG)]";
				text += arrStr[i++] + arrStr[i++];
			}
		}
		text = StringEscapeUtils.unescapeJava(text);
		System.out.println(title);
        System.out.println(text);
		return text;
	}
	
	static String stringToUnicode(String str) throws Exception {
		String unicode = "";
        for (int i = 0; i < str.length(); i++) {
            unicode += String.format("U+%04X ", str.codePointAt(i));
        }
        System.out.println("[UNICODE]");
        System.out.println(unicode);
        return unicode;
    }
	
	static byte[] stringToUnicodeBytes(String str, ByteOrder order) throws Exception {
		String title = "[UNICODE BYTE(LITTLE)]";
		byte[] bytes = new byte[0];
		for (int i = 0; i < str.length(); i++) {
			byte[] temp = intTobyte(str.codePointAt(i), order);
			if(order.equals(ByteOrder.LITTLE_ENDIAN)) {
				temp = ArrayUtils.remove(temp, 2);
				temp = ArrayUtils.remove(temp, 2);
			} else {
				title = "[UNICODE BYTE(BIG)]";
				temp = ArrayUtils.remove(temp, 0);
				temp = ArrayUtils.remove(temp, 0);
			}
			bytes = ArrayUtils.addAll(bytes, temp);
		}
		System.out.println(title);
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(String.format("%02X ", bytes[i]));
		}
		System.out.println();
		return bytes;
	}
	
	public static byte[] intTobyte(int integer, ByteOrder order) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		buff.order(order);
		buff.putInt(integer);
		return buff.array();
	}
	
	public static int byteToInt(byte[] bytes, ByteOrder order) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		buff.order(order);
		// buff사이즈는 4인 상태임
		// bytes를 put하면 position과 limit는 같은 위치가 됨.
		buff.put(bytes);
		// flip()가 실행 되면 position은 0에 위치 하게 됨.
		buff.flip();
		return buff.getInt(); // position위치(0)에서 부터 4바이트를 int로 변경하여 반환
	}
}
