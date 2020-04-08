package com.codingblocks;

import java.util.*;

public class ChessBoardProblem2 {

	public static void main(String[] args) {
		int n = 3;
		String flag = "first";
		boolean[] prime2 = sieveOfEratosthenes(n*n);
		int[][] board = new int[n][n];
		Map<Integer, Integer> primeMap = new HashMap<>();
		
		for (int i = 2; i < n*n ; i++) {
			
			if (prime2[i]) {
				if (flag.equals("first")) {
					primeMap.put(i, 1);
					flag = "second";
				} else {
					primeMap.put(i, 2);
					flag = "first";
				}
			}
		}
		
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				int  pos = n * row + col + 1;
				if (primeMap.containsKey(pos)) {
					board[row][col] = primeMap.get(pos);
				}
			}
			
		}

		int ans = countWays(board, n, 0, 0, "{0-0}");
		System.out.println();
		System.out.println(ans);
	}
	private static int countWays(int[][] board,int n, int row, int col, String path) {
		if(row >= n || col >= n) {
			return 0;
		}
		
		if (row == n-1 && col == n-1) {		
				System.out.println(path + " ");
				return 1;	
		}
		int myCount = 0;
		if (board[row][col] == 2) {
			//board[row][col] = 0;
			System.out.println(path + "P" + "{" + String.valueOf(n-1) + "-" + String.valueOf(n-1) + "}" );
			myCount = myCount + 1;
			
		}
		if (board[row][col] == 1) {
			return 0;
		}
		
		
		myCount = myCount + countWays(board, n, row + 2, col + 1, path + "K" +"{" + String.valueOf(row+2) + "-" + String.valueOf(col+1) +"}");
		myCount = myCount + countWays(board, n, row + 1, col + 2, path + "K" + "{" + String.valueOf(row+1) + "-" + String.valueOf(col+2) +"}");
		
		if (row == n-1 || row == 0 || col == 0 || col == n-1) {		
			for (int i = col + 1; i < n; i++) {
				//System.out.println("For Loop" + row + "-"+i);
				int tempCount = countWays(board, n, row, i, path + "R" + "{" + row + "-" + String.valueOf(i) +"}");
				myCount = myCount + tempCount;
//				if (tempCount == 1 && col != n-1 && row != n-1) {
//					myCount = myCount + countWays(board, n, row, i, path + "R" + "{" + row + "-" + String.valueOf(i) +"}");
//				}
			}
			//System.out.println("Loop col" + row + "-"+col);
		}
		
		if(col == n-1 || col == 0 || row == 0 || row == n-1) {
			//System.out.println("Loop Row" + col);
			for (int i = row + 1; i < n; i++) {
				int tempCount = countWays(board, n, i, col, path + "R" + "{" + String.valueOf(i) + "-" + col +"}");
				myCount = myCount + tempCount;
//				if (tempCount == 1 && col != n-1 && row != n-1) {
//					myCount = myCount + countWays(board, n, i, col, path + "R" + "{" + String.valueOf(i) + "-" + col +"}");
//				}
			}
		
		}
		
		if(col == row) {
			for (int i = row + 1; i < n; i++) {
				myCount = myCount + countWays(board, n, i, i, path + "B" + "{" + String.valueOf(i) + "-" + String.valueOf(i) +"}");
			}
		} else	if (col + row == n-1) {
				myCount = myCount + countWays(board, n, row+1, col+1, path + "B" + "{" + String.valueOf(row+1) + "-" + String.valueOf(col+1) +"}");
		}
		return myCount;
	}

//	public static boolean[] soe(int n) {
//		boolean[] primes=new boolean[n+1];
//		for(int i=0;i<primes.length;i++) {
//			primes[i]=true;
//		}
//		int test=2;
//		while(test*test<=n) {
//			if(primes[test]) {
//				for(int multiplier=2;multiplier*test<=n;multiplier++) {
//					primes[test*multiplier]=false;
//				}
//			}
//			test++;
//		}
//		return primes;
//	}
	 public static boolean[] sieveOfEratosthenes(int n) 
	    {  
	        boolean prime[] = new boolean[n+1]; 
	        for(int i=0;i<n;i++) 
	            prime[i] = true; 
	          
	        for(int p = 2; p*p <=n; p++) 
	        { 
	            if(prime[p] == true) 
	            { 
	                for(int i = p*p; i <= n; i += p) 
	                    prime[i] = false; 
	            } 
	        } 
	        return prime;
	    } 
}
