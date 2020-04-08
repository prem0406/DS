package com.codingblocks;

import java.util.*;

public class CheckBalanceParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//String str = "((a + b) + ((c+d)))";
		str = str.replaceAll("\\s", "");
		System.out.println(checkDuplicates(str));
		sc.close();
	}

	private static boolean checkDuplicates(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				char ch=stack.pop();
			 	int count = 0;
			 	while (ch != '(') {
			 		count++;
			 		ch = stack.pop();
			 	}
			 	if (count < 1) {
			 		return true;
			 	}
			} else {
				stack.push(str.charAt(i));
			}
		}
		return false;
	}
}
