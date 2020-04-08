package com.codingblocks;

import java.util.*;

public class GrandTemple {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] arrX = new int[n];
		int[] arrY = new int[n];
		
		for (int i = 0; i < n; i++) {
				arrX[i] = s.nextInt();
				arrY[i] = s.nextInt();
		}
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		
		int dx = 0;
		int dy = 0;
		
		
		for (int i = 0; i < n-1; i++) {
//			System.out.print(arrX[i] + " " + arrX[i+1] + " ");
			if(arrX[i+1] - arrX[i] > dx) {
				dx = arrX[i+1] - arrX[i];
			}
		}
//		System.out.println();
		for (int i = 0; i < n-1; i++) {
//			System.out.print(arrY[i] + " " + arrY[i+1] + " ");
			if(arrY[i+1] - arrY[i] > dy) {
				dy = arrY[i+1] - arrY[i];
			}
		}
//		System.out.println(dx + " " + dy);
		int area = (dx-1) * (dy-1);
		
		System.out.println(area);
	}
}


