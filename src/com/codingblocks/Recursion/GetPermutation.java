package com.codingblocks.Recursion;

import java.util.ArrayList;

public class GetPermutation {

	public static void main(String[] args) {
		ArrayList<String> strP = getPermutation("abc");
		System.out.println(strP);

	}
	private static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> oldList = getPermutation(str.substring(1));
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < oldList.size(); i++) {
			int oldListLength = oldList.get(i).length();
			for (int j = 0; j <= oldListLength; j++) {
				String strTemp = ""+oldList.get(i).substring(0,j) + str.charAt(0) + oldList.get(i).substring(j);
				System.out.println(strTemp);
				list.add(strTemp);
			}
		}
				
		return list;
	}
}
