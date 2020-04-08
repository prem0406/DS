package com.codingblocks.Recursion;

import java.util.ArrayList;

public class GetBoardPath {
	static int count = 0;
	public static void main(String[] args) {
		ArrayList<String> strBoardPath = getBoardPath(4,0);
		System.out.println(strBoardPath);

	}
	private static ArrayList<String> getBoardPath(int end, int curr) {
		int mycount = ++count;
		System.out.println("Function No: "+mycount );
		if (end == curr) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		if (end < curr) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		
		ArrayList<String> recList = new ArrayList<>();
		ArrayList<String> resList = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			System.out.println("Loop For Curr: " + curr + " Dice: "+dice);
			 recList = getBoardPath(end, dice + curr);
			 System.out.println("Function No: "+mycount);
			 
			 for (int i = 0; i < recList.size(); i++ ) {
				 resList.add(recList.get(i) + dice);
			 }
			 System.out.println(resList);
		}
		
		return resList;
	}

}
