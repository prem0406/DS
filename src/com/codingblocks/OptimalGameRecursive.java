package com.codingblocks;

import java.util.Scanner;

public class OptimalGameRecursive {
	//static int count = 0;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(getScore(arr, 0,arr.length-1,0));
		s.close();
	}

	private static int getScore(int[] arr, int i, int j, int turn) {
		//int c = count++;
		if (i > j) {
			return 0;
		}
		int score1 = 0;
		int score2 = 0;
		if (turn == 0) {
			score1 = Math.max(arr[i] +getScore(arr, i+1, j, 1), arr[j] + getScore(arr, i, j-1, 1));
			//System.out.println("Fun: " +c +" Score1 : "+ score1 + " Score2 : "+score2 + " Turn: " + turn);
			return score1;
		} 
		if (turn == 1) {
			score2 = Math.min(getScore(arr, i+1, j, 0), getScore(arr, i, j-1, 0));
			//System.out.println("Fun: " +c +" Score1 : "+ score1 + " Score2 : "+score2 + " Turn: " + turn);
			return score2;
			
		}
		//System.out.println("Score1 : "+ score1 + " Score2 : "+score2 + " Turn" + turn);
		
		return 0;
	}

}
