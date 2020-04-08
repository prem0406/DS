package com.codingblocks;

import java.util.Scanner;

public class BookAllocationProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			
			System.out.println(fun(arr, n , m));
		}
		s.close();
	}
	
	public static int fun(int[] arr, int n, int m) {
//		if (n < m) {
//			return -1;
//		}
		
		int sum = 0;
		
		int start = 0;
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		
		int end = sum;
		
		while (start <= end) {
			
			int mid = (start + end)/2;
//			System.out.println(start + " " + end);
			if (isValid(arr, n, m, mid)) {
				res = mid;
				end = mid - 1;
			} else {
//				System.out.print(isValid(arr, n, m, mid));
				start = mid + 1;
			}
		}
		return res;
	}
	
	public static boolean isValid(int[] arr, int n, int m, int mid) {
		int student = 1;
		int numPages = 0;
		
		
		for (int i = 0; i < n; i++) {
			
			if(mid < arr[i]) {
				return false;
			}
			
			
			if((arr[i] + numPages) > mid) {
				numPages = arr[i];
				student++;
				
				if(student > m) {
					return false;
				}
				
			} else {
				numPages += arr[i];
			}
		}
		return true;
	}
}
