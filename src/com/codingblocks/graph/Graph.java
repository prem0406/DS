package com.codingblocks.graph;

import java.util.*;

public class Graph {
	class Vertex {
		String name;
		HashMap<Vertex, Integer> nbrs;
		
		Vertex(String name) {
			this.name = name;
			nbrs = new HashMap<>();
		}
		
		public boolean equals (Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}
		
		public void display() {
			String s = this.name;
			s = s + "=>";
			
			Collection<Vertex> vtcs = this.nbrs.keySet();
			for (Vertex vtx : vtcs) {
				s = s + vtx.name + "(" + this.nbrs.get(vtx) + ")";
			}
			s = s +"---END";
			
			System.out.println(s);
		}
	}
	
	HashMap<String, Vertex> vtx;
	
	public Graph() {
		vtx = new HashMap<>();
	}
	
	public void addVertex(String name) {
		Vertex vt = new Vertex(name);
		this.vtx.put(name, vt);
	}
	
	public void removeVertex(String name) {
		Vertex v = this.vtx.get(name);
		
		Collection<Vertex> nbrs = v.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			nbr.nbrs.remove(v);
		}
		
		this.vtx.remove(name);
	}
	
	public int numVertex() {
		return vtx.size();
	}
	public void addEdge(String v1, String v2, int cost) {
		Vertex vtx1 = vtx.get(v1);
		Vertex vtx2 = vtx.get(v2);
		
		if ( vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vtx2)) {
			return;
		}
		
		vtx1.nbrs.put(vtx2, cost);
		vtx2.nbrs.put(vtx1, cost);
	}
	
	public void removeEdge(String name1, String name2) {
		Vertex v1 = this.vtx.get(name1);
		Vertex v2 = this.vtx.get(name2);
		
		v1.nbrs.remove(v2);
		v2.nbrs.remove(v1);
	}
	public void display() {
		Collection<Vertex> vtcs = this.vtx.values();
		
		for (Vertex vtx : vtcs) {
			vtx.display();
		}
		System.out.println("*********************************************");
	}
	
	public boolean hashPath(String s1, String s2) {
		
		Vertex vtx1 = this.vtx.get(s1);
		Vertex vtx2 = this.vtx.get(s2);
		
		if ( vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> map = new HashMap<>();
		return hashPath(vtx1, vtx2, map);
		
	}
	private boolean hashPath(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> map) {
		
		 if (map.containsKey(vtx1)) {
			 return false;
		 } else {
			 map.put(vtx1, true);
		 }
		 	
		if (vtx1.nbrs.containsKey(vtx2)) {
			return true;
		}
		
		Set<Vertex> nbrs = vtx1.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			
			if (this.hashPath(nbr, vtx2, map)) {
				return true;
			}
		
		}
		
		return false;	
	}
	
	public boolean hashPathIT(String s1, String s2) {
		Vertex vtx1 = this.vtx.get(s1);
		Vertex vtx2 = this.vtx.get(s2);
		
		if ( vtx1 == null || vtx2 == null) {
			return false;
		}
		
		return hashPathIT(vtx1, vtx2);
		
	}
	private boolean hashPathIT(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Boolean> map = new HashMap<>();
		Queue<Vertex> q = new LinkedList<Graph.Vertex>();
		
		
		q.add(vtx1);
		
		if (vtx1.nbrs.containsKey(vtx2)) {
			return true;
		}
		while (!q.isEmpty()) {
			Vertex rv = q.remove();
			
			map.put(rv, true);
			
			if (rv.nbrs.containsKey(vtx2)) {
				return true;
			} else {
				Set<Vertex> nbrs = rv.nbrs.keySet();
				
				for (Vertex nbr : nbrs) {
					if (nbr.nbrs.containsKey(vtx2)) {
						return true;
					} else	if (!map.containsKey(nbr)) {
						q.add(nbr);
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isConnected() {
		HashMap<Vertex, Boolean> map = new HashMap<>();
		Queue<Vertex> q = new LinkedList<Graph.Vertex>();
//		Vertex vtx1 = this.vtx.get("A");
		Collection<Vertex> coll = this.vtx.values();
		Iterator<Vertex> itr = coll.iterator();
		
		Vertex vtx1 = null;
		if (itr.hasNext()) {
			vtx1 = itr.next();
		}
//		vtx2 = coll.
		
		q.add(vtx1);
		map.put(vtx1, true);
		int countVertex = 0;
		while (!q.isEmpty()) {
			Vertex rv = q.remove();
			
			
			countVertex++;
//			System.out.print(rv.name + " ");
			Set<Vertex> nbrs = rv.nbrs.keySet();
			
			for (Vertex nbr : nbrs) {
				
				if (!map.containsKey(nbr)) {
					
					
					q.add(nbr);
					map.put(nbr, true);
				}
			}
			
		}
//		System.out.println(countVertex + " " + numVertex());
		return countVertex == this.numVertex();
	}
	
	public void connectedComponents() {
		ArrayList<String> list = new ArrayList<>();
		HashMap<Vertex, Boolean> map = new HashMap<>();
		Queue<Vertex> q = new LinkedList<Graph.Vertex>();
		
		for (Vertex vtx1 : this.vtx.values()) {
			
			if (!map.containsKey(vtx1)) {
				String s = "";
				q.add(vtx1);
				while (!q.isEmpty()) {
					Vertex rv = q.remove();
					s = s + rv.name;
					map.put(rv, true);
					
					Set<Vertex> nbrs = rv.nbrs.keySet();
					
					for (Vertex nbr : nbrs) {
						
						if (!map.containsKey(nbr)) {
							
							q.add(nbr);
							map.put(nbr, true);
						}
					}
					
				}
				list.add(s);
			}	
		}
		
		for (String s : list) {
			System.out.println(s);
		}
		
	}
}
