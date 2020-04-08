package com.codingblocks;

import java.util.*;
public class SubSetSumEasy {
    public static void main(String args[]) {
        int[] set;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            set = new int[n];
            for (int j = 0; j < n; j++){
                set[j]= sc.nextInt();
            }
//    		int sum = 0;
//    		int[] set = {1, -2 , -2, 3, 6};
//    		int n = set.length;
            sum = 0;
            if (Arrays.stream(set).anyMatch(m->m==0)) {
            	System.out.println("Yes");
            } else if (isSubSetPresent(set, n-1, sum, n-1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static boolean isSubSetPresent(int[] set, int n, int sum, int flag) {
		if (sum == 0 && flag != set.length - 1) {
			return true;
		}
		if (n==0 ) {
			return false;
		}
		
		return isSubSetPresent(set,n-1,sum, flag) || isSubSetPresent(set, n-1, sum+set[n-1], flag - 1);
	}
}