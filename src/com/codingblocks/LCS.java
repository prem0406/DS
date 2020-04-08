package com.codingblocks;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int m = str1.length();
		int n = str2.length();
		int[][] matrix = new int[m+1][n+1];
		
		for (int row = 0; row <= m; row++ ) {
			matrix[row][0] = 0;
		}
		for (int col = 0; col <= n; col++ ) {
			matrix[0][col] = 0;
		}
		
		for (int row = 1; row <= m; row++) {
			for (int col = 1; col <= n; col++) {
				if (str1.charAt(row-1) == str2.charAt(col-1)) {
					matrix[row][col] = matrix[row-1][col-1] + 1;
				}
				else {
					matrix[row][col] = Math.max(matrix[row][col-1], matrix[row-1][col]);
				}
			}
		}
		
		int index = matrix[m][n];
		char[] lcs = new char[index+1];
		lcs[index] = ' ';
		int row = m;
		int col = n;
		while(row > 0 && col > 0) {
			if (str1.charAt(row-1) == str2.charAt(col-1)) {
				lcs[index-1] = str1.charAt(row-1);
				row--;
				col--;
				index--;
			} else if (matrix[row][col-1] < matrix[row-1][col]) {
				row--;
			}
			else {
				col--;
			}
		}
		System.out.println(String.valueOf(lcs));
		sc.close();
	}

	
}
