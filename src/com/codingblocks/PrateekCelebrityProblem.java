package com.codingblocks;

import java.util.Scanner;

public class PrateekCelebrityProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		findCelebrity(arr, n);
		s.close();
	}
	
	public static void findCelebrity(int[][] arr, int n) {
		int id = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if(arr[i][j] != 0) {
					flag = false;
				}
			}
			if (flag == true) {
				id = i;
			}
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += arr[i][id]; 
		}
		
		if (count == n-1) {
			System.out.println(id);
		} else {
			System.out.println("No Celebrity");
		}
	}
}
