package com.codingblocks;

import java.util.*;

public class RecursionCodeOfString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(codesOfString(str, ""));
		sc.close();
		
	}
	public static ArrayList<String> codesOfString(String str, String ans) {
		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add(ans);
			return list;
		}
		ArrayList<String> myResult = new ArrayList<>();
		String ch1 = str.substring(0, 1);
		String ros1 = str.substring(1);
		myResult.addAll(codesOfString(ros1, ans + getChar(ch1)));
		if (str.length() >= 2) {
			String ch2 = str.substring(0, 2);
			String ros2 = str.substring(2);
			if (Integer.valueOf(ch2) <= 26) {
				myResult.addAll(codesOfString(ros2, ans + getChar(ch2)));
			}
		}
		return myResult;
	}
	private static char getChar(String ch2) {
		int a = 96 + Integer.valueOf(ch2);
		char b = (char) a;
		return b;
	}

}
