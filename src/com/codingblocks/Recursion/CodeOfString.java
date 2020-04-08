package com.codingblocks.Recursion;

public class CodeOfString {

	public static void main(String[] args) {
		String str = "1234";
//		System.out.println(str.substring(0,1));
		codesOfString(str, "");
		
	}
	public static void codesOfString(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		String ch1 = str.substring(0, 1);
		String ros1 = str.substring(1);
		codesOfString(ros1, ans + getChar(ch1));
		if (str.length() >= 2) {
			String ch2 = str.substring(0, 2);
			String ros2 = str.substring(2);
			if (Integer.valueOf(ch2) <= 26) {
				codesOfString(ros2, ans + getChar(ch2));
			}
		}

	}
	private static char getChar(String ch2) {
		int a = 96 + Integer.valueOf(ch2);
		char b = (char) a;
		return b;
	}

}
