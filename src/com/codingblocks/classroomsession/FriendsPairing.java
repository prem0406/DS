package com.codingblocks.classroomsession;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FriendsPairing {

	public static void main(String[] args) {
		int n =  4;
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) {
			arr[i] = i+1;
		}
		IntStream.of(arr).forEachOrdered(m -> System.out.print(m + ","));
		System.out.println();
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.println(arr[i] + "," + arr[j]);
			}
		}
	}

}
