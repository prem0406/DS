package com.codingblocks.binarytree;

import java.util.*;
public class LCA {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public LCA() {
        this.root = null;
        this.size = 0;
    }

    public void add(int data) {
        if (this.isEmpty()) {
            this.root = new Node(data, null, null);
            this.size++;
        } else {
            this.add(this.root, data);
        }
    }

    private void add(Node node, int data) {
        if (data > node.data) {
            if (node.right != null) {
                this.add(node.right, data);
            } else {
                this.size++;
                node.right = new Node(data, null, null);
            }
        } else if (data < node.data) {
            if (node.left != null) {
                this.add(node.left, data);
            } else {
                this.size++;
                node.left = new Node(data, null, null);
            }
        } else {
            // nothing to do
        }
    }

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = this.remove(node.right, data);
            return node;
        } else if (data < node.data) {
            node.left = this.remove(node.left, data);
            return node;
        } else {
            // found the element
            if (node.left == null && node.right == null) {
                this.size--;
                return null;
            } else if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                // both children
                int lmax = this.max(node.left);
                node.data = lmax;
                node.left = this.remove(node.left, lmax);

                return node;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void display() {
        System.out.println(this);
    }

    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        int rv = node.data;

        if (node.right != null) {
            rv = this.max(node.right);
        }

        return rv;
    }

    @Override
    public String toString() {
        return this.toString(this.root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }

        String retVal = "";

        if (node.left != null) {
            retVal += node.left.data + " => ";
        } else {
            retVal += "END" + " => ";
        }

        retVal += node.data;

        if (node.right != null) {
            retVal += " <= " + node.right.data;
        } else {
            retVal += " <= " + "END";
        }

        retVal += "\n";

        retVal += this.toString(node.left);
        retVal += this.toString(node.right);

        return retVal;
    }
    public int lca(Node node, int d1, int d2) {
    	if (node == null) {
    		return 0;
    	}
    	if (d1 < node.data && d2 < node.data) {
    		return lca(node.left, d1, d2);
    	}
    	if (d1 > node.data && d2 > node.data) {
    		return lca(node.right, d1, d2);
    	}
        return node.data;
    }
    
 public static void main(String[] args) {
        LCA b1= new LCA();
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        while(n!=0){
        	int m=scn.nextInt();
        	b1.add(m);
        	--n;
        }
        int d1= scn.nextInt();
        int d2= scn.nextInt();
        System.out.println(b1.lca(b1.root, d1, d2));
 }
}