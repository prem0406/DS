package com.codingblocks.classroomsession;

public class Mixtures {

	public static void main(String[] args) {
		int[] arr = {40, 60, 20};
//		int[] arr = {18,19};
		System.out.println(minSmoke(arr,0,arr.length-1));

	}
	private static int minSmoke(int[] arr, int si, int ei) {
		if ( si == ei ) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int cost1 = minSmoke(arr,si,i);
			int cost2 = minSmoke(arr, i+1,ei);
			int cost3 = cost1 + cost2 + color(arr,si,i) * color(arr,i+1,ei);
			
			min = Math.min(cost3, min);
		}
		return min;
	}
	private static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum = sum+arr[i];
		}
		return sum%100;
	}
}
