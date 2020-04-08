package com.codingblocks.Recursion;

public class Rectangle {

	public static void main(String[] args) {
//		int[] arr = { 2, 3, 5 };
//		int[] arr = { 1, 2, 3, 4, 5 };
//		int area = 20;
//
//		System.out.println(rect(arr, area));

		int[][] arr2 = { { 1, 1 }, { 1, 1 } };
		System.out.println(sumSubmatrices(arr2));
		System.out.println(approach2(arr2));
	}

	public static int rect(int[] arr, int area) {
		int count = 0;
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			if (arr[left] * arr[right] < area) {
				count = count + 2 * (right - left) + 1;
				System.out.println(left + " " + right + " count = " + count);
				left++;
			} else {
				right--;
			}
		}

		return count;
	}

	public static int sumSubmatrices(int[][] arr) {
		int sum = 0;
		for (int tli = 0; tli < arr.length; tli++) {
			for (int tlj = 0; tlj < arr.length; tlj++) {
				for (int bri = tli; bri < arr.length; bri++) {
					for (int brj = tlj; brj < arr.length; brj++) {
						for (int i = tli; i <= bri; i++) {
							for (int j = tlj; j <= brj; j++) {
								sum = sum + arr[i][j];
							}
						}
					}
				}
			}
		}

		return sum;
	}
	
	public static int approach2(int[][] arr){
	       int m=arr.length;
	       int n=arr[0].length;
	       int sum=0;
	       for(int i=0; i<m; i++){
	           for(int j=0; j<n; j++){
	                int tl=(i+1)*(j+1);
	                int br=(m-i)*(n-j);
	                sum=sum+(tl*br)*arr[i][j];
	           }
	       }
	        return sum;
	    }

}