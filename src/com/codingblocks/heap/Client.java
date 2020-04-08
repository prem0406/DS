package com.codingblocks.heap;

public class Client {

	public static void main(String[] args) {
//		Heap<Student> hp = new Heap<>(false);
//		hp.add(new Student("I", 9, 100));
//		hp.add(new Student("H", 8, 200));
//		hp.add(new Student("G", 7, 300));
//		hp.add(new Student("F", 6, 400));
//		hp.add(new Student("E", 5, 500));
//		hp.add(new Student("D", 4, 600));
//		hp.add(new Student("C", 3, 700));
//		hp.add(new Student("B", 2, 800));
//		hp.add(new Student("A", 1, 900));
		
		Heap<Integer> hp = new Heap<>();
		hp.add(10);
		hp.add(20);
		hp.add(80);
		hp.add(500);
		hp.add(4);
		hp.add(70);
		hp.add(0);
		
		
		hp.display();

	}
	
}

class Student implements Comparable<Student>{
	String name;
	int rank;
	int marks;
	
	Student(String name, int rank, int marks) {
		name = this.name;
		rank = this.rank;
		marks = this.marks;
	}

	@Override
	public int compareTo(Student o) {
		return this.marks - o.marks;
	}
	
	public String toString() {
		return "{ Name: " + this.name + " Rank: " + this.rank + " Marks: "+ this.marks + "}";
	}
}