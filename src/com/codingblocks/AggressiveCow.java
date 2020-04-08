package com.codingblocks;

import java.util.*;

public class AggressiveCow {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int cow = s.nextInt();
		
		long[] stalls = new long[n];
		
		for (int i = 0; i < n; i++) {
			stalls[i] = s.nextInt();
		}
		
		Arrays.sort(stalls);
		int res = binarySearch(stalls, 0, stalls.length - 1,cow);
		System.out.println(res);

	}
	
	public static int binarySearch(long[] arr, int start, int end, int cow) {
		int max = 0;
		while (start < end) {
			int mid = (start + end)/2;
			
			if (check(arr,mid,cow) == 1) {
				
				if ( mid > max) {
					max = mid;
				}
				start = mid + 1;
			} else {
				end = mid;
			}
	
		}
		return max;
	}
	public static int check(long[] arr, int mid, int cow) {
		int countC = 1;
		long pos = arr[0];
		for (int i = 1; i < arr.length; i++) {
			
			if (arr[i] - pos >= mid) {
				pos = arr[i];
				countC++;
				if (countC == cow) {
					return 1;
				}
			}
		}
		return 0;
	}
}
