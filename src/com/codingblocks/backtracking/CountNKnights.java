package com.codingblocks.backtracking;

public class CountNKnights {
	static int count = 0;
	public static void main(String[] args) {
		int n = 3;
		boolean[][] board = new boolean[n][n];
		//	printNKnights(board, 0, 0, 0, "");
		System.out.println(countNKnights(board, 0, 0, 0));
		//System.out.println(counNKnights(board, board.length-1, board[0].length, 0, 0, 0));
	}

//	public static int counNKnights(int[][] board, int er, int ec, int cr, int cc,int knightCount) {
//		if (knightCount == er) {
//			return 1;
//		}
//		if (cc > ec || cr > er) {
//			return 0;
//		}
//		int count = 0;
//		if (isSafe(board, cr, cc)) {
//			board[cr][cc] = 1;
//			count += counNKnights(board, er, ec, cr, cc+1, knightCount + 1);
//			board[cr][cc] = 1;
//			count += counNKnights(board, er, ec, cr+1, 0, knightCount);
//		}
//		return count;
//	}
//	
//	public static boolean isSafe(int[][] board, int row, int col) {
//		for (int i = 0; i < row; i++) {
//			for (int k = 0; k < col; k++) {
//				if (board[i][k] == 1) {
//					if ((Math.abs(i-row)==2 && Math.abs(k-col)==1) || (Math.abs(i-row)==1 && Math.abs(k-col)==2)) {
//						return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
	public static int countNKnights(boolean[][] board, int r, int c, int placed) {
		int currCount = ++count;
		System.out.println("Function No: "+ currCount);
		if (placed == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = c; col < board.length; col++) {
			if (isItSafe(board, r, col)) {
				board[r][col] = true;
				count = count + countNKnights(board, r, col + 1, placed + 1);
				System.out.println("Loop 1 Function No: "+ currCount + " Count : " +count);
				board[r][col] = false;

			}
		}

		for (int row = r + 1 ; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (isItSafe(board, row, col)) {
					board[row][col] = true;
					count = count + countNKnights(board, row, col + 1, placed + 1);
					System.out.println("Loop 2 Function No: "+ currCount+ " Count : " +count);
					board[row][col] = false;

				}
			}
		}
		return count;
	}

	public static void printNKnights(boolean[][] board, int r, int c, int placed, String osf) {
		if (placed == board.length) {
			System.out.print(osf+"  ");
			return;
		}
		for (int col = c; col < board.length; col++) {
			if (isItSafe(board, r, col)) {
				board[r][col] = true;
				printNKnights(board, r, col + 1, placed + 1, osf + "{" + r + "-" + col + "} ");
				board[r][col] = false;

			}
		}

		for (int row = r + 1; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (isItSafe(board, row, col)) {
					board[row][col] = true;
					printNKnights(board, row, col + 1, placed + 1, osf + "{" + row + "-" + col + "} ");
					board[row][col] = false;

				}
			}
		}

	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1]) {
			return false;
		}

		if (row - 2 >= 0 && col + 1 < board[0].length && board[row - 2][col + 1]) {
			return false;
		}
		if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) {
			return false;
		}
		if (row - 1 >= 0 && col + 2 < board[0].length && board[row - 1][col + 2]) {
			return false;
		}

		return true;
	}
}
