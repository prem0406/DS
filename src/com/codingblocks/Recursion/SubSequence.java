package com.codingblocks.Recursion;

import java.util.ArrayList;

public class SubSequence {

	public static void main(String[] args) {
		ArrayList<String> strSS = getSS("abc");
		System.out.println(strSS);
	}
	private static ArrayList<String> getSS(String str) {
		
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> oldList = getSS(str.substring(1));
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < oldList.size(); i++) {
			list.add(oldList.get(i));
			list.add(str.charAt(0) + oldList.get(i));
		}
				
		return list;
	}

}
