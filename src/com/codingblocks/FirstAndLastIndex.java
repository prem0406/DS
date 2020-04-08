package com.codingblocks;

import java.util.*;

public class FirstAndLastIndex {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] arr = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		int op = s.nextInt();
		for (int i = 0; i < op; i++) {
			int num = s.nextInt();
			int first = -1;
			int last = -1;
			for (int j = 0; j < n; j++) {
				if (arr[j] == num) {
					first = j;
					break;
				}
			}
			for (int k = n-1 ; k >= 0; k--) {
				if (arr[k] == num) {
					last = k;
					break;
				}
			}
			System.out.println(first + " " + last);
			
		}
		
	}

}
