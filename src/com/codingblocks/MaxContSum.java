package com.codingblocks;

import java.util.*;

public class MaxContSum {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int tc = s.nextInt();
//		for (int t = 0; t < tc; t++) {
//			int n = s.nextInt();
//			int[] arr = new int[n];
//			for (int i = 0; i < n; i++) {
//				arr[i] = s.nextInt();
//			}
//			System.out.println(getMaxSum(arr));
//		}
//		int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
//		System.out.println(getMaxSum(arr));
		

	}
	public static int getMaxSum(int[] nums) {

	    int maxSoFar = 0;
	    int maxEndingHere = 0;



	    for (int i = 0; i < nums.length; i++){

	    	maxEndingHere = maxEndingHere + nums[i];
	    	maxSoFar = Math.max(maxSoFar, maxEndingHere);
//	      	maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
	    
	    	if (maxEndingHere < 0) {
	    	maxEndingHere = 0;
	    	}
	        
	    }

	    return maxSoFar;
	  }

}
