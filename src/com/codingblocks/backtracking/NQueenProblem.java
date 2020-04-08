package com.codingblocks.backtracking;

public class NQueenProblem {

	public static void main(String[] args) {
		boolean[][] board = new boolean[8][8];
		System.out.println(countNQueen(board, 0));
	}
	
	public static int countNQueen(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++ ) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNQueen(board, row+1);
				board[row][col] = false;
			}
		}
		return count;
	}

	private static boolean isItSafe(boolean[][] board, int row, int col) {
		int leftCol = col;
		int rightCol = col;
		while (row > 0) {
			if(leftCol>0) {
				if (board[row-1][leftCol-1]) {
					return false;
				}
				leftCol--;
			}
			if(rightCol<board[row].length-1) {
				if (board[row-1][rightCol+1]) {
					return false;
				}
				rightCol++;
			}
			if (board[row-1][col]) {
				return false;
			}
			row--;
		}
		return true;
	}
}
