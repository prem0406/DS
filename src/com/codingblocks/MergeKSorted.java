package com.codingblocks;

import java.util.Scanner;

class MinHeapNode 
{ 
	int element;
	
	int i; 
	
	int j; 

	public MinHeapNode(int element, int i, int j) 
	{ 
		this.element = element; 
		this.i = i; 
		this.j = j; 
	} 
} 


public class MergeKSorted 
{ 
	MinHeapNode[] harr;  
	int heap_size;  

	public MergeKSorted(MinHeapNode a[], int size) 
	{ 
		heap_size = size; 
		harr = a; 
		int i = (heap_size - 1)/2; 
		while (i >= 0) 
		{ 
			MinHeapify(i); 
			i--; 
		} 
	} 

	void MinHeapify(int i) 
	{ 
		int l = left(i); 
		int r = right(i); 
		int smallest = i; 
		if (l < heap_size && harr[l].element < harr[i].element) 
			smallest = l; 
		if (r < heap_size && harr[r].element < harr[smallest].element) 
			smallest = r; 
		if (smallest != i) 
		{ 
			swap(harr, i, smallest); 
			MinHeapify(smallest); 
		} 
	} 

	int left(int i) { return (2*i + 1); } 

	int right(int i) { return (2*i + 2); } 

	
	MinHeapNode getMin() 
	{ 
		if(heap_size <= 0) 
		{ 
			System.out.println("Heap underflow"); 
			return null; 
		} 
		return harr[0]; 
	} 
	
	void replaceMin(MinHeapNode root) { 
		harr[0] = root; 
		MinHeapify(0); 
	} 

	// A utility function to swap two min heap nodes 
	void swap(MinHeapNode[] arr, int i, int j) { 
		MinHeapNode temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 

	static void printArray(int[] arr) { 
		for(int i : arr) 
			System.out.print(i + " "); 
		System.out.println(); 
	} 


	static void mergeKSortedArrays(int[][] arr, int k) 
	{ 
		MinHeapNode[] hArr = new MinHeapNode[k]; 
		int resultSize = 0; 
		for(int i = 0; i < arr.length; i++) 
		{ 
			MinHeapNode node = new MinHeapNode(arr[i][0],i,1); 
			hArr[i] = node; 
			resultSize += arr[i].length; 
		} 

		MergeKSorted mh = new MergeKSorted(hArr, k); 

		int[] result = new int[resultSize];

		for(int i = 0; i < resultSize; i++) 
		{ 

			MinHeapNode root = mh.getMin(); 
			result[i] = root.element; 
			
			if(root.j < arr[root.i].length) 
				root.element = arr[root.i][root.j++]; 
			else
				root.element = Integer.MAX_VALUE; 

			mh.replaceMin(root); 
		} 

		printArray(result); 

	} 


	public static void main(String args[]){ 
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] arr = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j=0; j < n ; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		mergeKSortedArrays(arr,arr.length); 
	} 
}
