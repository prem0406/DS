package com.codingblocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class DigitalDictionary {

	public static void main(String[] args) {
		Trie t = new Trie();
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i< n; i++) {
			arr[i] = s.next();
		}
		for (int i = 0; i< n; i++) {
			t.addWord(arr[i]);
		}
//		t.display();
		
		int q = s.nextInt();
		String[] query = new String[q];
		for (int i = 0; i< q; i++) {
			query[i] = s.next();
		}
		
		for (int i = 0; i< q; i++) {
			if(t.search(query[i])) {
				
			} else {
				t.addWord(query[i]);
				System.out.println("No Suggestions");
			}
		}

	}

}

class Trie {
	class Node {
		char data;
		TreeMap<Character, Node> children;
		boolean isTerminal;
		
		Node(char data, boolean isTerminal){
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new TreeMap<>();
		}
	}
	
	Node root;
	int numWords;
	
	Trie() {
		this.root = new Node('\0', false);
	}
	
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		
		if (child == null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		
		this.addWord(child, ros);
	}
	
	public void display() {
		this.display(this.root, "");
	}
	public void display(Node node, String res) {
		if (node.isTerminal) {
			System.out.println(res);
		}
		Set<Map.Entry<Character, Node>> entry = node.children.entrySet();
		for (Map.Entry<Character, Node> entries : entry) {
			this.display(entries.getValue(), res + entries.getKey());
		}
	}
	
	public boolean search(String word) {
		return this.search(this.root, word, word);
	}
	private boolean search(Node parent, String word,String str) {
		if (word.length() == 0) {
//			if (parent.isTerminal) {
				
				this.display(parent, str);
				return true;
//			} 
//			else {
//				return false;
//			}
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if (child == null) {
			return false;
		} 
		
		return this.search(child, ros, str);
				
	}
	
	public void remove(String word) {
		this.remove(this.root, word);
	}
	private void remove(Node parent, String word) {
		if(word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				numWords--;
				return;
			}	
		}
		
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if (child == null) {
			return;
		}
		
		this.remove(child, ros);
		if (child.isTerminal == false && child.children.size() == 0) {
			parent.children.remove(cc);
		}
	}
	
	public void display2() {
		this.display2(this.root, "");
	}
	private void display2(Node node, String res) {
		if (node.children.size()==0) {
			//System.out.println(res);
			return;
		}
		Set<Map.Entry<Character, Node>> entry = node.children.entrySet();
		for (Map.Entry<Character, Node> entries : entry) {
			System.out.println("Root: " + entries.getKey());
			this.display2(entries.getValue(), ""+entries.getKey());
		}
	}
}
