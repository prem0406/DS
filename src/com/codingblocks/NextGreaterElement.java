package com.codingblocks;

import java.util.*;

public class NextGreaterElement {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tCase = s.nextInt();
		while (tCase>0) {
			tCase--;
			
			int n = s.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			
			if (arr.length > 100) {
				fun(arr);
			} else {
				fun2(arr);
			}
			
		}
		s.close();
	}
	
	public static void fun2(int[] arr) {
		int n = arr.length;
		
		int nextG = -1;
		int i = 0;
		int j;
		
		for (; i < n; i++) {
			nextG = -1;
			
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					nextG = arr[j];
					break;
				}
			}
			
			System.out.println(arr[i] + "," + nextG);
		}
	}
	
	public static void fun (int[] arr) {
		java.util.Queue<Integer> q = new java.util.LinkedList<Integer>();
		
		q.add(arr[0]);
		
		if (arr.length > 1) {
			for (int i = 1; i < arr.length; i++) {
				
				while (!q.isEmpty() && q.peek() < arr[i]) {
					System.out.println(q.peek() + "," + arr[i]);
					q.remove();
				}
				q.add(arr[i]);
			}
		}
		
		while (!q.isEmpty()) {
			int x = q.peek();
			q.remove();
			
			System.out.println(x + "," + -1);
		}
	}
}