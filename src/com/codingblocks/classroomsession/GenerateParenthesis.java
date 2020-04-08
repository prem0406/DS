package com.codingblocks.classroomsession;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		int n = 3;
		List<String> list = new ArrayList<>();
		list = generateParenthesis(n);
		System.out.println(list);

	}

	private static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		if(n == 0) {
			list.add("");
			return list;
		}
		
		List<String> currResult = generateParenthesis(n-1);
		List<String> myResult = new ArrayList<>();
		for (int i = 0; i < currResult.size(); i++) {
			
			myResult.add("(" + currResult.get(i) + ")");
			if (!myResult.contains("()" + currResult.get(i))) {
				myResult.add("()" + currResult.get(i));
			}
			
			if (!myResult.contains(currResult.get(i) + "()")) {
				myResult.add(currResult.get(i) + "()");
			}
		}
		return myResult;
	}

}
