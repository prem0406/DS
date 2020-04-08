package com.codingblocks;

import java.util.Scanner;

public class SortingString {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int length = sc.nextInt();
	        String[] words = new String[length];
	        for (int i = 0; i < length; i++) {
	        	words[i] = sc.next();
	        }
	        for(int i = 0; i < words.length-1; ++i) {
	            for (int j = i + 1; j < words.length; ++j) {
	                if (words[i].compareTo(words[j]) > 0) {
	                    String temp = words[i];
	                    words[i] = words[j];
	                    words[j] = temp;
	      	          }
	                if (words[j].contains(words[i])) {
	      	        	String temp2 = words[i];
	      	            words[i] = words[j];
	      	            words[j] = temp2;
	                }
	            }
	        }

			for (String str : words) {
				System.out.println(str);
			}
	        sc.close();
	}

}
