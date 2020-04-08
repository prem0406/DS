package com.codingblocks;

import java.util.Scanner;

public class PairSumBST {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		int sum = s.nextInt();
		pairSum(arr, sum);
	}
	
	public static void pairSum(int[] arr, int sum) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			if ( sum == arr[start]+ arr[end]) {
				System.out.println(arr[start] + " " + arr[end]);
				start++;
				end--;
			}
			System.out.println("hello");
			if (sum > arr[start]+ arr[end]) {
				start++;
			}
			
			if(sum < arr[start]+ arr[end]) {
				end--;
			}
			
		}
		
	}

}
