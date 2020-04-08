package com.codingblocks;

import java.util.*;

public class RatsInJungle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] rats = new int[n];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int temp = s.nextInt();
			rats[i] = temp;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			
			if(map.containsKey(rats[i])) {
//				System.out.println("Append : "+rats[i]);
				map.put(rats[i], map.get(rats[i]) + 1);
			} else {
//				System.out.println("First : "+rats[i]);
				map.put(rats[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//			System.out.println(e.getKey() +" "+ e.getValue());
			int key = e.getKey();
			int value = e.getValue();
			
			
				int d = value/(key+1);
				int mod = value% (key+1);
				sum = sum + d * (key + 1);
				if (mod > 0) {
					sum = sum + (key+1);
				}
		}
		
		System.out.println(sum);
	}

}
