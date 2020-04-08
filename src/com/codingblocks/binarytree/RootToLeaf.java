package com.codingblocks.binarytree;

import java.util.*;

public class RootToLeaf {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		RootToLeaf m = new RootToLeaf();
		BinaryTree bt1 = m.new BinaryTree();
		int sum = scn.nextInt();
		ArrayList<Integer> path = new ArrayList<>();
		bt1.rootToLeaf(bt1.root, path, sum, 0);
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
		public void rootToLeaf (Node node, ArrayList<Integer> path, int sum, int currSum ) {
			if (node == null) {
				return;
			}
			currSum = currSum + node.data;
			path.add(node.data);
			
			if (node.left == null && node.right == null && sum == currSum) {
				printPath(path);
			} else {
				rootToLeaf(node.left, path, sum, currSum);
				rootToLeaf(node.right, path, sum, currSum);
			}
		}
		
		public void printPath(ArrayList<Integer> path) {
			for (int i : path) {
				System.out.print(i + " ");
			}
		}
	}
}