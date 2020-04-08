package com.codingblocks.binarytree;

import java.util.*;
public class IsBalancedBT {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		IsBalancedBT m = new IsBalancedBT();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			BalancedPair bp = this.new BalancedPair();
			if (node == null) {
				bp.isBalanced = true;
				bp.height = 0;
				return bp;
			} 
			
			BalancedPair hLeft = isBalanced(node.left); 
			BalancedPair hRight = isBalanced(node.right);
			if (Math.abs(hLeft.height - hRight.height) > 1 || hLeft.isBalanced == false 
														&& hRight.isBalanced == false) {
				bp.isBalanced = false;
			} else {
				bp.isBalanced = true;
				bp.height = 1 + Math.max(hLeft.height, hRight.height);
			}
			return bp;
			
		}

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}

	}
}
