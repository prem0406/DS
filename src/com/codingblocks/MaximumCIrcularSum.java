package com.codingblocks;

import java.util.Scanner;

public class MaximumCIrcularSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-- >0) {
			int n = s.nextInt();
			
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}

			
			int max = Integer.MIN_VALUE;
			
			
			for (int i = 0; i < n; i++) {
				int tempMax = getMaxSum(arr);
				
				max = Math.max(max, tempMax);
				
				shift(arr, n);
			}
			
			System.out.println(max);
			
		}
		
		

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
	
	public static void shift(int[] arr, int n) {
		int last = arr[n-1];
		
		for (int i = n-2 ; i >= 0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = last;
	}
}
