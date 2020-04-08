package com.codingblocks;

import java.util.*;

public class BST {
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 0; tc < t; tc++) {
			BinaryST bst = new BinaryST();
			int n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				int addElement = sc.nextInt();
				bst.add(addElement);
			}
			
			int r = sc.nextInt();
			
			for (int j = 0; j < r; j++) {
				int rElement = sc.nextInt();
				bst.remove(rElement);
			}
			
			bst.display();
			System.out.println();
			
		}
		sc.close();
	}
}

class BinaryST {
	public class Node {
		int data;
		Node left;
		Node right;
		
		Node (int data, Node left, Node right) {
			this.data =data;
			this.left = left;
			this.right = right;
		}
	}
	
	Node root;
	int size;
	
	public void add (int data) {
		if (this.root == null) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.add(this.root, data);
		}
	}
	
	private void add(Node node, int data) {
		if (node.data > data) {
			if (node.left != null) {
				this.add(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}
		} else if (node.data < data) {
			if (node.right != null) {
				this.add(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}
		} else {
			
		}
	}
	public void display() {
		display(this.root);
	}
	private void display(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		
		
			this.display(node.left);
		
		
			this.display(node.right);
	}
	
	public int min() {
		return this.min(this.root);
	}
	private int min(Node node) {
		if (node == null) {
			return -1;
		} else if (node.left == null) {
			return node.data;
		} else {
			return this.min(node.left);
		}
	}
	
	public void remove(int data) {
		this.root = this.remove(this.root, data);
	}
	public Node remove(Node node, int data) {
		if(node == null) {
			return node;
		}
		if (node.data > data) {
				node.left = remove(node.left, data);
				return node;
	
		} else if (node.data < data) {
				node.right = remove(node.right, data);
				return node;
				
		} else {
			
			if (node.left == null && node.right == null) {
					this.size--;
					return null;
				
			}
			if (node.right == null) {
					this.size--;
					return node.left;
				
			}
			if (node.left == null) {
					this.size--;
					return node.right;
				
			}
			
			int temp = this.min(node.right);
			node.data = temp;
			node.right = remove(node.right, temp);
			this.size--;
			
			return node;
			
		}
	}
}