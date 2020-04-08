package com.codingblocks.classroomsession;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60};
		//System.out.println(MCM(arr,1,arr.length-1));
		System.out.println(MCMDP(arr));
	}

	private static int MCM(int[] arr, int si, int ei) {
		if ( si == ei ) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int cost1 = MCM(arr,si,i);
			int cost2 = MCM(arr, i+1,ei);
			int cost3 = cost1 + cost2 + arr[si-1]*arr[i]*arr[ei];
			min = Math.min(cost3, min);
		}
		return min;
	}
	private static int MCMDP(int[] arr) {
		int[][] mat = new int[arr.length][arr.length];
		
		//d = 2 means that 2-0 or 3-1 i.e it make 3 elements of array compulsory for 
		//matrix multiplication. e.g 10x20 20x30 , so 10, 20 and 30 are three elements
		for (int d = 2; d < arr.length; d++) {
			int min1 = 0;
			for (int i = 0; i < arr.length - d ; i++) {
				int j= i+d;
				int min = Integer.MAX_VALUE;
				for (int k = i+1; k < j; k++) {
					min1 = mat[i][k] + mat[k][j] + arr[i] * arr[k]* arr[j];
					min = Math.min(min, min1);
					mat[i][j] = min;
				}
				
			}
		}
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat.length; col++) {
				System.out.print(mat[row][col] + " ");
			}
			System.out.println();
		}
		return mat[0][arr.length-1];
	}
	
}
