package com.codingblocks;

import java.util.Scanner;

public class MinimumJump {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(funDP(arr, n));
	}
	
	public static int res = Integer.MAX_VALUE;
	
	public static void fun(int[] arr, int i, int n, int step) {
		
		if (i == n) {
			res = Math.min(res, step);
			return;
		} else {
			for(int k = i+1; k <= i + arr[i] && k <= n; k++ ) {
				fun(arr, k, n, step + 1);
			}
		}
	
	}
	
	public static int funDP (int[] arr, int n) {
		int[] steps = new int[n];
		
		if (n == 0 ||arr[0] == 0) {
			return -1;
		}
		
		steps[0] = 0;
		
		for (int i = 1; i < n; i++) {
			steps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j] && steps[j] != Integer.MAX_VALUE) {
					steps[i] = Math.min(steps[i], steps[j]+1);
					break;
				}
			}
		}
		return steps[n-1];
	}

}
