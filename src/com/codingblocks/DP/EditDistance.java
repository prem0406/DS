package com.codingblocks.DP;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "abbg";
		String s2 = "abgg";
		System.out.println(editDistance(s1,s2));
		System.out.println(editDistanceDP(s1,s2));

	}

	private static int editDistance(String s1, String s2) {
		
		if (s1.length() == 0) {
			return s2.length();
		} else if (s2.length() == 0) {
			return s1.length();
		}
		
		int ans = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		System.out.println(ros1);
		System.out.println(ros2);
		if (s1.charAt(0) == s2.charAt(0)) {
			
			ans = editDistance(ros1, ros2);
			
		} else {
			int f1 = editDistance(ros1, ros2) + 1;
			int f2 = editDistance(ros1, s2) + 1;
			int f3 = editDistance(s1, ros2)+1;
			int min1 = Math.min(f1, f2);
			ans = Math.min(min1, f3);
		}
		return ans;
	}
	
	private static int editDistanceDP(String s1, String s2) {
		int[][] mat = new int[s1.length()+1][s2.length()+1];
		for (int row = mat.length-1, i = 0 ; row >= 0; row--, i++) {
			mat[row][i] = i ;
		}
		for (int col = mat[0].length-1, i = 0; col >= 0; col--, i++) {
			mat[mat.length-1][col] = i;
		}
		for (int row = mat.length-1; row >= 0; row--) {
			
			for (int col = mat[0].length-1; col >= 0; col--) {
//				if (row == mat.length-1) {
//					mat[row][col]= col;
//				}
					
				if (s1.charAt(col) == s2.charAt(row)) {
					mat[row][col] = mat[row+1][col+1];
				}
				else {
					int min1 = Math.min(mat[row+1][col], mat[row+1][col+1]);
					int min2 = Math.min(min1, mat[row][col+1]);
					mat[row][col] = min2+1;
				}
			}
		}
		return mat[0][0];
	}

}
