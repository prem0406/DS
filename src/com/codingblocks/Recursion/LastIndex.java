package com.codingblocks.Recursion;

public class LastIndex {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 3, 5, 6, 5};
		
		//System.out.println(lastIndex(arr,0,7));
		System.out.println(getLastIndex(arr,0,5));
	}
	public static int lastIndex(int[] arr,int i,int data) {
		if(i==arr.length) {
			return -1;
		}
		int index=lastIndex(arr, i+1, data);
		if(index!=-1) {
			return index;
		}else {
			if(arr[i]==data) {
				return i;
			}else {
				return -1;
			}
		}
	}
	private static int getLastIndex(int[] arr, int i, int data) {
		if(i > arr.length-1) {
			return 0;
		}
		if (arr[i] == data) {
			if(getLastIndex(arr, i+1, data) == 0) {
				return i;
			}
		}
		return getLastIndex(arr, i+1, data);
	}

}
