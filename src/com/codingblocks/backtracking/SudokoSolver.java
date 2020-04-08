package com.codingblocks.backtracking;

public class SudokoSolver {

	public static void main(String[] args) {
		int[][] arr = {
				{5,	3,	0,	0,	7,	0,	0,	0,	0},
				{6,	0,	0,	1,	9,	5,	0,	0,	0},
				{0,	9,	8,	0,	0,	0,	0,	6,	0},
				{8,	0,	0,	0,	6,	0,	0,	0,	3},
				{4,	0,	0,	8,	0,	3,	0,	0,	1},
				{7,	0,	0,	0,	2,	0,	0,	0,	6},
				{0,	6,	0,	0,	0,	0,	2,	8,	0},
				{0,	0,	0,	4,	1,	9,	0,	0,	5},
				{0,	0,	0,	0,	8,	0,	0,	2,	9}
		};
		boolean[][] fixedCells =  new boolean[9][9];
		setFixedCells(arr,fixedCells);
		boolean solve = sudokoSolver(arr, fixedCells, 0, 0);
		if (solve) {
			printBoard(arr);
		} else {
			System.out.println("This Sudoko has No solution");
		}
		

	}

	private static boolean sudokoSolver(int[][] arr, boolean[][] fixedCells, int r, int c) {
		
		if (r == arr.length-1 && c == arr.length) {
			return true;
		}
		if (c == arr.length) {
			r= r+1; 
			c=0;
		}
		if (fixedCells[r][c]) {
			return sudokoSolver(arr, fixedCells, r, c + 1);
		}
		boolean ans = false;
		
				for (int p = 1; p <= 9; p++) {
					if ( canPlace(arr,r,c,p) ) {
						System.out.println(p);
						arr[r][c] = p;
						ans = sudokoSolver(arr, fixedCells, r, c + 1);
						if (ans == true) {
							return true;
						}
						arr[r][c] = 0;
					}
			
		}

		return true;
	}

	private static boolean canPlace(int[][] arr, int r, int c, int p) {
		for (int i = 0; i < arr.length; i++) {
			if((arr[r][i] == p) || (arr[i][c] == p)) {
				return false;
			}
		}
		int row = 0;
		int col = 0;
		
		if (r < 3) {
			row = 0;
		}else if (r < 6) {
			row = 3;
		} else {
			row = 6;
		}
		
		if (c < 3) {
			col = 0;
		}else if (c < 6) {
			col = 3;
		} else {
			col = 6;
		}
		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col + 3; j++) {
				if(arr[i][j] == p) {
					return false;
				}
			}
		}
		return true;
	}

	private static void printBoard(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		
	}

	private static void setFixedCells(int[][] arr, boolean[][] fixedCells) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if(arr[row][col] != 0) {
					fixedCells[row][col] = true;
				}
			}
		}
		
	}
	

}
