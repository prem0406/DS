package com.codingblocks;

import java.util.*;
public class BalanceParenthesis {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		BalanceParenthesis mainobj = new BalanceParenthesis();
		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
		if (isBalanced(str, stack)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean isBalanced(String str, StacksUsingArrays stack) throws Exception {
		
		if (str.length()%2 != 0){
			return false;
		}
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(1);
			} else if (str.charAt(i) == '{') {
				stack.push(2);
			} else if (str.charAt(i) == '[') {
				stack.push(3);
			}
			
			
			else if (str.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.top() == 1) {
					stack.pop();
				}
			}
			else if (str.charAt(i) == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.top() == 2) {
					stack.pop();
				}
			}
			else if (str.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.top() == 3) {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
		
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

