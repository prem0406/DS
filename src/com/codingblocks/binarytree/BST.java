package com.codingblocks.binarytree;

import org.w3c.dom.Node;

public class BST {
	public static void main(String[] args) {
		BinaryST bst = new BinaryST();
		bst.add(50);
		bst.add(25);
		bst.add(12);
		bst.add(32);
		bst.add(75);
		bst.add(62);
		bst.add(87);
		
		bst.display();
		
//		System.out.println("Max: " + bst.max());
//		
//		System.out.println("Min: "+ bst.min());
		
		//bst.isBST();
//		System.out.println(bst.isBST());
		bst.remove(50);	
		System.out.println("After Removal");
		bst.display();
	}
	
}

class BinaryST {
	public class Node {
		int data;
		Node left;
		Node right;
		
		Node (int data, Node left, Node right) {
			this.data =data;
			this.left = this.left;
			this.right = this.right;
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
		if (node.left != null) {
			System.out.print(node.left.data + "=>" );
		} else {
			System.out.print( "END=>" );
		}
		
		System.out.print(node.data);
		
		if (node.right != null) {
			System.out.println("<=" + node.right.data);
		} else {
			System.out.println("<=END");
		}
		
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}
	
	public int max() {
		return this.max(this.root);
	}
	private int max(Node node) {
		if (node == null) {
			return -1;
		} else if (node.right == null) {
			return node.data;
		} else {
			return this.max(node.right);
		}
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
		this.remove(this.root, null, data, false);
	}
	public void remove(Node node, Node prev, int data, boolean isLeft) {
		if(node == null) {
			return;
		}
		if (node.data > data) {
			if (node.left != null) {
				remove(node.left, node, data, true);
			}
		} else if (node.data < data) {
			if (node.right != null) {
				remove(node.right, node, data, false);
			}
		} else {
			if (node.left == null && node.right == null) {
				if (isLeft) {
					prev.left = null;
				} else {
					prev.right = null;
				}
			} else if (node.right == null) {
				if (isLeft) {
					prev.left = node.left;
				} else {
					prev.right = node.left;
				}
			} else if (node.left == null) {
				if (isLeft) {
					prev.left = node.right;
				} else {
					prev.right = node.right;
				}
			} else {
				int temp = this.min(node.right);
				node.data = temp;
				remove(node.right, null, node.data, false);
				this.size--;
			}
		}
	}
	
//	public void remove(int data) {
//		this.root = this.remove(this.root, data);
//	}
//	public Node remove(Node node, int data) {
//		if(node == null) {
//			return null;
//		}
//		if (node.data > data) {
//			if (node.left != null) {
//				node.left = remove(node.left, data);
//			}
//				
//		} else if (node.data < data) {
//			if (node.right != null) {
//				node.right = remove(node.right, data);
//			}
//				
//		} else {
//			if (node.left == null && node.right == null) {
//					return null;
//				
//			} else if (node.right == null) {
//					return node.left;
//				
//			} else if (node.left == null) {
//					return node.right;
//				
//			} else {
//				int temp = this.min(node.right);
//				node.data = temp;
//				node.right = remove(node.right, temp);
//				this.size--;
//			}
//		}
//		return node;
//	}
	
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
}
