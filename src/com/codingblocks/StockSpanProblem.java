package com.codingblocks;

import java.util.Scanner;

public class StockSpanProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] resArr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < n; i++) {
				int currC = 0;
				//int count = 0;
				for (int j = 0; j <= i; j++) {
					if (arr[j] <= arr[i]) {
						currC++;
					} else {
						currC = 0;
					}
					resArr[i] = currC;
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(resArr[i] + " ");
			}
		}
		sc.close();
	}

}
