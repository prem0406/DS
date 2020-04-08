package com.codingblocks;

import java.util.*;

public class FormBiggestNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-- >0) {
			int n = s.nextInt();
			
			String[] arr = new String[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = s.next();
			}

			Arrays.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					String ab = a +b;
					String ba = b + a;
					
					return ab.compareTo(ba) > 0 ? -1 : 1;
				}
				
			});
			
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i]);
			}
			
			System.out.println();
			
		}
		s.close();
	}

}
