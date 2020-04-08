package com.codingblocks;

import java.util.*;

public class LargerstBSTinBT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}
		
		BinaryTree bt = new BinaryTree();
		bt.buildTree(pre, in);
		System.out.println(bt.sizeOfLargeBST());

	}

}

class BinaryTree {
	Node root;
	int size;
	
	private class Node {
		int data;
		Node left;
		Node right;
		
		Node (int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	
	
	public void buildTree(int[] pre, int[] in) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < pre.length; i++) {
			map.put(in[i], i);
		}
		Index indexOb = new Index();
		indexOb.index = 0;
		this.root = this.buildTree(pre, 0, pre.length - 1,indexOb, map);
	}
	
	class Index {
		int index;
	}
	
	private Node buildTree(int[] pre, int start, int end, Index preIndex, 
												Map<Integer, Integer> map) {
		
	
		if (start > end) {
			return null;
		}
		
		int curr = pre[preIndex.index];
		preIndex.index += 1;
	
		Node node = new Node(curr, null, null);
		
		if (start == end) {
			return node;
		}
		
		int inIndex = map.get(curr);
		
		node.left = buildTree(pre, start, inIndex - 1, preIndex, map);
		node.right = buildTree(pre, inIndex + 1, end, preIndex, map);
		
		
		
		return node;
		
	}
	
	public boolean isBST() {
		return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		
		if(node.data < min || node.data > max) {
			return false;
		} else if (! this.isBST(node.left, min, node.data)) {
			return false;
		} else if (! this.isBST(node.right, node.data, max)) {
			return false;
		} else {
			return true;
		}
		//return false;
		
	}
	public int getSize() {
		return getSize(this.root);
	}
	private int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + getSize(node.left) + getSize(node.right);	
	}
	
	public int sizeOfLargeBST() {
		return sizeOfLargeBST(this.root);
	}
	private int sizeOfLargeBST(Node node) {
		if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return this.getSize(node);
		} 
		int lmax =0;
		int rmax =0;
		if(node.left != null) {
			lmax = sizeOfLargeBST(node.left);
		}
		if(node.right != null) {
			rmax = sizeOfLargeBST(node.right);
		}
		
		return Math.max(lmax, rmax);
	}
}
