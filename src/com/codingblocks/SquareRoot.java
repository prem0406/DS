package com.codingblocks;

import java.util.ArrayList;
import java.util.Scanner;

public class SquareRoot {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			double num = sc.nextDouble();
			list.add(num);
		}
		for (int i = 0; i < testCase; i++) {
			double result = Math.sqrt(list.get(i));
			System.out.printf("%.4f", Math.floor(result * 1e4)/1e4);
		}		
		sc.close();
	}
}
