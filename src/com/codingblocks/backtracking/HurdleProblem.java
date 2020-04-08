package com.codingblocks.backtracking;

public class HurdleProblem {

	public static void main(String[] args) {
			int[][] board = {
					{0, 0, 9, 0},
					{0, 0, 9, 0},
					{9, 0, 0, 0},
					{0, 9, 0, 0}
			};
			findPath(board, board.length-1, board[0].length-1, 0, 0);
	}

	public static void findPath(int[][] board, int er, int ec, int cr, int cc) {
		if (cr > er || cc > ec) {
			return;
		}
		if (board[cr][cc] == 9) {
			return;
		}
		
		if (cr == er && cc == ec) {
			board[cr][cc]=1;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("********************");
			return;
		}
		if (board[cr][cc]==0) {
			board[cr][cc]=1;
			findPath(board, er, ec, cr, cc+1);
			findPath(board, er, ec, cr+1, cc);
			board[cr][cc]=0;
			return;
		}
		
	}

}
