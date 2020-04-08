package com.codingblocks;

import java.util.*;

public class OptimalGameStrategy1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(optimalSolution(arr, arr.length));
		s.close();
	}

	private static int optimalSolution(int[] arr, int n) {
		 int table[][] = new int[n][n]; 
	        int gap, i, j, x, y, z; 
	  
	        
	        for (gap = 0; gap < n; ++gap) { 
	            for (i = 0, j = gap; j < n; ++i, ++j) { 
	 
	                x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
	                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
	                z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
	  
	                table[i][j] = Math.max(arr[i] + Math.min(x, y),  
	                                       arr[j] + Math.min(y, z)); 
	            } 
	        } 
	  
	        return table[0][n - 1]; 
	}

}
