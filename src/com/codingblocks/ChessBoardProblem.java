package com.codingblocks;

import java.util.*;

public class ChessBoardProblem {
	public static ArrayList<String> br = new ArrayList<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int ans = countWays(n, 0, 0, "{0-0}");
		System.out.println();
		System.out.println(ans);
		

	}

	private static int countWays(int n, int row, int col, String path) {
		if(row >= n || col >= n) {
			return 0;
		}
		
		if (row == n-1 && col == n-1) {		
				System.out.print(path + " ");
				return 1;	
		}
		
		int myCount = 0;
		
		myCount = myCount + countWays(n, row + 2, col + 1, path + "K" +"{" + String.valueOf(row+2) + "-" + String.valueOf(col+1) +"}");
		myCount = myCount + countWays(n, row + 1, col + 2, path + "K" + "{" + String.valueOf(row+1) + "-" + String.valueOf(col+2) +"}");
		
		if (row == n-1 || row == 0 || col == 0 || col == n-1) {		
			for (int i = col + 1; i < n; i++) {
				myCount = myCount + countWays(n, row, i, path + "R" + "{" + row + "-" + String.valueOf(i) +"}");
			}	
		}
		
		if(col == n-1 || col == 0 || row == 0 || row == n-1) {
			for (int i = row + 1; i < n; i++) {
				myCount = myCount + countWays(n, i, col, path + "R" + "{" + String.valueOf(i) + "-" + col +"}");
			}
		
		}
		
		if(col == row) {
			for (int i = row + 1; i < n; i++) {
				myCount = myCount + countWays(n, i, i, path + "B" + "{" + String.valueOf(i) + "-" + String.valueOf(i) +"}");
			}
		} else	if (col + row == n-1) {
				myCount = myCount + countWays(n, row+1, col+1, path + "B" + "{" + String.valueOf(row+1) + "-" + String.valueOf(col+1) +"}");
		}
		return myCount;
	}

}
