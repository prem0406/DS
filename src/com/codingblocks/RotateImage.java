package com.codingblocks;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] image = new int[n][n];
		int[][] image2 = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				image[row][col] = row * n + col + 1; 
			}
		}
		
		rotateImage(image,image2, n - 1);
		
		
	}

	private static void rotateImage(int[][] image, int[][] image2, int n) {
		for (int row = 0; row <=n; row++) {
			for (int col = 0; col <=n; col++) {
				//image2[n-col][row] = image[row][col];
				System.out.print(image[col][n-row] + " ");
			}
			System.out.println();
		}
		
//		for (int row = 0; row <=n; row++) {
//			for (int col = 0; col <=n; col++) {
//				System.out.print(image2[row][col] + " ");
//			}
//			System.out.println();
//		}
	}

}
