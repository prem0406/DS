package com.codingblocks;

import java.util.*;

public class TreeRightView {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] str = s.nextLine().split(" ");


		
		BT bt = new BT(str);
//		bt.inOrder();
		
		bt.fun2();
		s.close();
	}

}

class BT {
	class Node {
		String data;
		Node left;
		Node right;
		
		Node (String data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	int size;
	Node root;
	//static int max = 0;
	
	class Max{
		int max;
	}
	
	BT(String[] a){
//		this.root = this.BinaryTreeFromArray(a, 0);
		this.takeInput(a);
	}
	
	public void fun2() {
		Max max = new Max();
		this.fun2(this.root, 1, max);
	}
	
	private void fun2(Node node, int l, Max max) {
		if (node == null) {
			return;
		}
		if (max.max < l) {
			
			if(!node.data.equals("-1")) {
				System.out.print(node.data + " ");
				max.max = l;
			}
			
		}
		
		fun2(node.right, l+1, max);
		fun2(node.left, l+1, max);
	}
	
	Node BinaryTreeFromArray(String a[],int i)
	{
		if(i>a.length-1 )
			return null;
		
		Node tnode=new Node(a[i]);
	
		if(2*i+1 > a.length-1 && 2*i+2 > a.length-1)
			return tnode;
		
		tnode.left=BinaryTreeFromArray(a,2*i+1);
		tnode.right=BinaryTreeFromArray(a,2*i+2);
		
		return tnode;
	}
	
	public void inOrder() {
		this.inOrder(this.root);
	}
	
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
	
		inOrder(node.left);
		inOrder(node.right);
	}
	
	public void takeInput(String[] str) {
		this.root = this.takeInput(this.root, str);
	}
	
	 public Node takeInput(Node node, String[] str) {
         String rootData = str[0];



         if (rootData.equals("-1")) {
             return null;
         }



         Node rootNode = new Node(rootData);
         



         java.util.Queue<Node> pn = new java.util.LinkedList();
         pn.add(rootNode);


         int i = 1;
         while (i < str.length) {
             Node fn = pn.remove();
             String lc = str[i++];// left child of that node
             if (!lc.equals("-1")) {
                 Node leftChild = new Node(lc);
                
                 fn.left = leftChild;
                 pn.add(leftChild);
             }
             String rc = str[i++];



             if (!rc.equals("-1")) {
                 Node rightChild = new Node(rc);
                 fn.right = rightChild;
                 pn.add(rightChild);
             }
         }



         return rootNode;
     }
}
