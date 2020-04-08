package com.codingblocks;
import java.util.*;

public class HistogramProblem {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		long[] arr = new long[n];
		
		for(int i = 0;i < n;i++)
		    arr[i] = s.nextLong();
		    
    		HistogramProblem mainobj = new HistogramProblem();
    		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000000);
    		System.out.println(hist(arr, stack));
    		
		}
	

	public static long hist(long[] arr, StacksUsingArrays stack) throws Exception {
		int n = arr.length;
		long currArea;
		long maxArea = 0;
		int top;
		
		int i = 0;
		while (i < n) {
			
			if (stack.isEmpty() || arr[stack.top()] <= arr[i]) {
				stack.push(i++);
				
				
			} else {
				top = stack.top();
				stack.pop();
				
				if (stack.isEmpty()) {
					currArea = arr[top] *  i;
				} else {
					currArea = arr[top] * (i - stack.top() - 1);
				}
				
				
				if (maxArea < currArea) {
					maxArea = currArea;
				}
			}
		}
		
		while (stack.isEmpty() == false) {
			top = stack.top();
			stack.pop();
			
			if (stack.isEmpty()) {
				currArea = arr[top] *  i;
			} else {
				currArea = arr[top] * (i - stack.top() - 1);
			}
			
			if (maxArea < currArea) {
				maxArea = currArea;
			}
		}
		
		return maxArea;
	    
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(int item) throws Exception {
			if (this.size() == this.data.length) {
				throw new Exception("Stack is Full");
			}
			this.tos++;
			this.data[this.tos] = item;
		}

		public int pop() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			this.data[this.tos] = 0;
			this.tos--;
			return retVal;
		}

		public int top() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			return retVal;
		}

		public void display() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			for (int i = this.tos; i >= 0; i--) {
				System.out.println(this.data[i]);
			}

		}

	}

}