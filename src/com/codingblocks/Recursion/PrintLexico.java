package com.codingblocks.Recursion;

public class PrintLexico {

	public static void main(String[] args) {
		printLexico(10,1000);

	}
	public static void printLexico(int curr, int end) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				printLexico(end, curr * 10 + i);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				printLexico(end, curr * 10 + i);
			}
		}

	}
}
