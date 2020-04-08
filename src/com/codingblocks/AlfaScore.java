package com.codingblocks;

import java.util.*;
public class AlfaScore {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
		long[] stairs = new long[length];
        for (int i = 0; i < length; i++){
            stairs[i]= sc.nextInt();
        }
		long jCount = 0;
		for (int i = 1; i < length; i++) {
			long aCount = 0;
			for (int j = 0; j < i; j++) {
				if (stairs[i] > stairs[j]) {
					aCount += stairs[j];
				}
			}
			jCount += aCount;
		}
		System.out.println(jCount%1000000007);
		sc.close();
	}

}
