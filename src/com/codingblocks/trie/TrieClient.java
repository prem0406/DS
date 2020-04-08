package com.codingblocks.trie;

public class TrieClient {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.addWord("arts");
		t.addWord("art");
		t.addWord("boy");
		t.addWord("sea");
		t.addWord("see");
		t.addWord("seen");
		
		//t.display();
		//t.remove("see");
		t.display2();
//		System.out.println(t.search("sejje"));

	}

}
