package com.codingblocks.linkedlistdata;


import java.time.format.ResolverStyle;
import java.util.*;

import javax.sound.sampled.ReverbType;
public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	class HeapMover {
		Node node;
		
		HeapMover(Node node) {
			this.node = node;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(1)
	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.tail.data;
	}

	// O(N)
	public int getAt(int idx) throws Exception {
		Node temp = this.getNodeAt(idx);
		return temp.data;
	}

	// O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		Node retVal = this.head;
		for (int i = 0; i < idx; i++) {
			retVal = retVal.next;
		}

		return retVal;
	}

	// O(1)
	public void addFirst(int data) {
		Node node = new Node(data, this.head);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	// O(1)
	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int idx, int data) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.head.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n)
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

		//System.out.println("END");
	}
public void reverse_PR(LinkedList list, int i) throws Exception {
		if (list.getNodeAt(i).next == null) {
			int temp = list.tail.data;
			list.tail.data = list.head.data;
			list.head.data = temp;
			return;
		}
		
		reverse_PR(list,i+1);
		if (i < list.size/2) {
		
		} else {
			int dataF = list.getAt(i);
			int dataL = list.getAt(list.size - i -1);
			list.getNodeAt(i).data = dataL;
			list.getNodeAt(list.size - i -1).data = dataF;
		}
	}
	
	public void reverseData (HeapMover left, Node right, int count) {
		if(right == null) {
			return;
		}
		
		reverseData(left, right.next,count+1);
		if (count >= this.size/2) {
			int temp = right.data;
			right.data = left.node.data;
			left.node.data = temp;
			left.node = left.node.next;
		}
	}

	public void reversePointer(Node node) {
		if (node == this.tail) {
			return;
		}
		reversePointer(node.next);
		node.next.next = node;
	}
	public void reverse() {
		HeapMover left = new HeapMover(this.head);
		reverseData(left, this.head, 0);
		
//		this.reversePointer(this.head);
//		Node tempNode = this.tail;
//		this.tail = this.head;
//		this.head = tempNode;
//		this.tail.next = null;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		//int M = scn.nextInt();

		
		LinkedList list = new LinkedList();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}
		
		list.reverse();	
		list.display();
		
		scn.close();
	}
}


