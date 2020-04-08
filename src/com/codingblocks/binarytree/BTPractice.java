package com.codingblocks.binarytree;
import java.util.*;

import com.codingblocks.binarytree.BinaryST.Node;

public class BTPractice {
	static int maxD = 0;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
//50 true 25 true 12 false false true 54 false false true 75 true 62 false false true 87 false false
		BTPractice btp = new BTPractice();
		BinaryTree b = btp.new BinaryTree();
		b.display();
		System.out.println(b.sizeOfLargeBST());
//		System.out.println(b.getSize());
//		System.out.println(b.isBST());
//		System.out.println("Height: "+ b.findHeight());
//		System.out.println(b.findNode(25));
//		System.out.println(b.findMax());
//		System.out.println(b.findDiameter());
//		b.inOrderI();
//		b.postOrderI();
//		System.out.println(b.Diameter());
//		System.out.println(b.diameterBetter());
	}
	private class BinaryTree {
		
		Node root;
		int size;
		private class Node {
			int data;
			Node left;
			Node right;
		}
		
		private class Pair {
			Node node;
			boolean selfDone;
			boolean leftDone;
			boolean rightDone;
			
			public Pair (Node node) {
				this.node = node;
			}
		}
		class DiaPair {
			int height;
			int diameter;
			
			DiaPair(int height, int diameter) {
				this.height = height;
				this.diameter = diameter;
			}

			public DiaPair() {
				
			}
		}
		BinaryTree(){
			this.root = this.takeInput(null, false);
		}
		
		
		private Node takeInput(Node parent, boolean choice) {
			if (parent == null) {
				System.out.println("Enter data for root Node: ");
			} else if (choice) {
				System.out.println("Enter data for left Node: ");
			} else if (!choice) {
				System.out.println("Enter data for right Node: ");
			}
			int data = sc.nextInt();
			Node child = new Node();
			child.data = data;
			this.size++;
			
			System.out.println("Have Left element ? ");
			boolean lchoice = sc.nextBoolean();
			if (lchoice) {
				child.left = this.takeInput(child, true);
			}
			
			System.out.println("have right element? ");
			boolean rchoice = sc.nextBoolean();
			if (rchoice) {
				child.right = this.takeInput(child, false);
			}
			
			return child;
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
		public int findHeight() {
			return findHeight(this.root);
		}
		private int findHeight(Node node) {
			if (node == null) {
				return -1;
			}
			return 1 + Math.max(findHeight(node.left), findHeight(node.right));
		}
		
		public boolean findNode(int fdata) {
			return findNode(this.root, fdata);
		}
		private boolean findNode(Node node, int fdata) {
			if (node == null) {
				return false;
			}
			if (node.data == fdata) {
				return true;
			}
			
				return findNode(node.left, fdata) ||
				findNode(node.right, fdata);
			
		}
		
		public int findMax() {
			return findMax(this.root);
		}
		
		private int findMax(Node node) {
			if (node == null) {
				return Integer.MIN_VALUE;
			}
			
			return (Math.max(node.data, Math.max(findMax(node.left), findMax(node.right))));
		}
		
//		public int findDiameter() {
//			return findDiameter(this.root, 0);
//		}
//		
//		private int findDiameter(Node node, int pathSum) {
//			if (node == null) {
//				return 0;
//			}
//			if (node.left == null && node.right == null) {
//				return pathSum;
//			}
//			//pathSum =+ 1;
//			
//			
//				int pathL = pathL + findDiameter(node.left, pathSum + 1);
//			
//			
//			
//				int pathR = pathR- findDiameter(node.right, pathSum + 1);
//			
//			
//			return size;
//			
//		}
		public int Diameter() {
			return Diameter(this.root);
		}
		private int Diameter (Node node) {
			if (node == null) {
				return 0;
			}
			int myd = this.findHeight(node.left) + this.findHeight(node.right) + 2;
			int ld = this.Diameter(node.left);
			int rd = this.Diameter(node.right);
			
			int myans = Math.max(myd, Math.max(ld, rd));
			return myans;
		}
		
		
		
		public void inOrderI() {
			inOrderI(this.root);
		}
		
		private void inOrderI(Node node) {
			Stack<Pair> stack = new Stack<>();
			stack.push(new Pair(node));
			while ( !stack.isEmpty()) {
				Pair pair = stack.peek();
				if (pair.leftDone == false) {
					pair.leftDone = true;
					if (pair.node.left != null) {
						stack.push(new Pair(pair.node.left));
					}
				} else if (pair.selfDone == false) {
					System.out.println(pair.node.data + " ");
					pair.selfDone = true;
				} else if (pair.rightDone == false) {
					pair.rightDone = true;
					if (pair.node.right != null) {
						stack.push(new Pair(pair.node.right));
					}
				} else {
					stack.pop();
				}
			}
		}
		
		public int diameterBetter() {
			return diameterBetter(this.root).diameter;
		}
		private DiaPair diameterBetter(Node node) {
			if (node == null) {
				DiaPair d = new DiaPair(-1, 0);
				return d;
			}
			DiaPair pL = diameterBetter(node.left);
			DiaPair pR = diameterBetter(node.right);
			
			
			int mydia = pL.height + pR.height + 2;
			DiaPair pAns = new DiaPair();
			pAns.height = Math.max(pL.height, pR.height) + 1;
			pAns.diameter = Math.max(mydia, Math.max(pL.diameter, pR.diameter));
			
			
			return pAns;
		}
		public void postOrderI() {
			postOrderI(this.root);
		}
		public void postOrderI(Node node) {
			Stack<Pair> stack = new Stack<>();
			stack.push(new Pair(node));
			while ( !stack.isEmpty()) {
				Pair pair = stack.peek();
				if (pair.leftDone == false) {
					pair.leftDone = true;
					if (pair.node.left != null) {
						stack.push(new Pair(pair.node.left));
					}
				} else if (pair.rightDone == false) {
					pair.rightDone = true;
					if (pair.node.right != null) {
						stack.push(new Pair(pair.node.right));
					}
				} else if (pair.selfDone == false) {
					System.out.println(pair.node.data + " ");
					pair.selfDone = true;
				} else {
					stack.pop();
				}
			}
		}
		
		
	}
}
