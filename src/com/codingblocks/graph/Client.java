package com.codingblocks.graph;

public class Client {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 8);
		graph.addEdge("E", "G", 3);
		graph.addEdge("F", "G", 3);
		
		graph.display();
//		System.out.println(graph.hashPath("A", "G"));
//		System.out.println(graph.hashPathIT("A", "G"));
		graph.removeEdge("E", "D");
		System.out.println(graph.isConnected());
//		graph.connectedComponents();
		
//		graph.removeVertex("A");
//		graph.removeEdge("A", "D");
		
		graph.display();

	}

}
