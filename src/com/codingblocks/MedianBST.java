package com.codingblocks;

import java.util.Scanner;

public class MedianBST {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		int index = 0;
		int median;
		if (n % 2 == 0) {
			index = n/2;
			median = (arr[index] + arr[index - 1])/2;
			
		} else {
			index = (n-1)/2 ;
			median = arr[index];
		}
		System.out.println(median);
	}

}
