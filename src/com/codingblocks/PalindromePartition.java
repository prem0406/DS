package com.codingblocks;

import java.util.Scanner;

public class PalindromePartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0) {
			String s = sc.next();
			System.out.println(findP(s));
		}

	}
	
	public static int findP (String str) {
		int size = str.length();
		
		int[] c = new int[size];
		boolean[][] dp = new boolean[size][size];
		
		for (int i = 0; i < size; i++) {
			dp[i][i] = true;
		}
		
		for (int k = 2; k <= size; k++) {
			for (int i = 0; i < size - k + 1; i++) {
				int j = i + k - 1;
				
				if(k == 2) {
					dp[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					dp[i][j] = (str.charAt(i) == str.charAt(j)) && dp[i + 1][j - 1];
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (dp[0][i] == true) {
				c[i] = 0;
			} else {
				c[i] = Integer.MAX_VALUE;
				
				for(int j = 0; j < i; j++) {
					if (dp[j + 1][i] == true && 1 + c[j] < c[i]) {
						c[i] = c[j]+1;
					}
				}
			}
			
		}
		return c[size-1];
	}

}
