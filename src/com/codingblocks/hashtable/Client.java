package com.codingblocks.hashtable;

public class Client {

	public static void main(String[] args) throws Exception {
		HashTable<String, Integer> map = new HashTable<>(5);
		map.put("India", 350);
		map.put("Russia", 300);
		map.put("China", 400);
		map.put("Isreal", 75);
		map.put("Pak", 50);
		map.put("USA", 100);
		
		map.display();
		
		System.out.println(map.get("USA"));
		System.out.println(map.remove("Pak"));
		map.display();
	}

}
