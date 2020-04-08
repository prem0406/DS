package com.codingblocks.hashtable;

public class HashTable<K, V> {
	public class HTPair {
		K key;
		V value;
		
		HTPair(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}
		
		public String toString() {
			return "{" + this.key + "-" + this.value + "}";
		}
	}
	
	LinkedList<HTPair>[] buckertArr;
	int size;
	public static final int DEFAULT_CAPACITY = 10;
	
	HashTable(){
		this(DEFAULT_CAPACITY);
	}
	HashTable(int capacity){
		this.buckertArr = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}
	
	public void put(K key, V value) throws Exception {
		HTPair pair = new HTPair(key, value);
		int bi = hashFunction(key);
		
		LinkedList<HTPair>[] ba = this.buckertArr;
		if (ba[bi] == null) {
			ba[bi] = new LinkedList<HTPair>();
		}
		LinkedList<HTPair> list = ba[bi];
		
		int index = list.find(pair);
		if (index != -1) {
			HTPair p = list.getAt(index);
			p.value = value;
		} else {
			list.addLast(pair);
			this.size++;
		}
		double lamda = (this.size* 1.0)/this.buckertArr.length;
		if (lamda > 2) {
			this.rehash();
		}
	}
	
	private void rehash() {
//		LinkedList<HTPair>[] buckertArr;
//		this.buckertArr = (LinkedList<HTPair>[]) new LinkedList[capacity];
	}
	public int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc%buckertArr.length; //---------------------------------------
		return bi;
	}
	
	public void display() {
		for (LinkedList<HTPair> bucket : this.buckertArr) {
			if (bucket == null || bucket.isEmpty()) {
				System.out.print("NULL");
			} else	{
				bucket.display();
			}
			System.out.println();
			System.out.println("*******************************************");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	public V get(K key) throws Exception {
		HTPair pair = new HTPair(key, null);
		int bi = hashFunction(key);
		
		LinkedList<HTPair>[] ba = this.buckertArr;
		if (ba[bi] == null) {
			return null;
		}
		LinkedList<HTPair> list = ba[bi];
		
		int index = list.find(pair);
		if (index != -1) {
			HTPair p = list.getAt(index);
			return p.value;
		} else {
			return null;
		}
	}
	
	public HTPair remove (K key) throws Exception {
		HTPair pair = new HTPair(key, null);
		int bi = hashFunction(key);
		
		LinkedList<HTPair>[] ba = this.buckertArr;
		if (ba[bi] == null) {
			return null;
		}
		LinkedList<HTPair> list = ba[bi];
		
		int index = list.find(pair);
		if (index != -1) {
			HTPair p = list.getAt(index);
			list.removeAt(index);
			this.size--;
			return p;
		} else {
			return null;
		}
	}
}
