package com.codingblocks;

import java.util.Scanner;

public class Unlock {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int SwapIndex= 0;
		int ei = arr.length - 1;
		for (int i = 0; i < k; i++) {
			
			while(SwapIndex < ei) {
				
				int maxIndex = findMax(arr,SwapIndex, ei);
				
				if(maxIndex != SwapIndex) {
					swap(arr,maxIndex,SwapIndex);
					break;
				}
				SwapIndex++;
			}
			SwapIndex++;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		s.close();
	}
	
	public static void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int findMax(int[] arr, int s, int e) {
		int index = -1;
		
		int max = 0;
		for(int i = s; i <= e; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
}
