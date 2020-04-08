package com.codingblocks;

import java.util.*;

public class MinimumTimeTraversal {
	public static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			
		
			
			Point S = new Point();
			Point E = new Point();
			
			int n = sc.nextInt();// number of pipelines
			
			ArrayList<Pipe> pipe = new ArrayList<>();
			
			S.x = sc.nextInt();
			S.y = sc.nextInt();
			E.x = sc.nextInt();
			E.y = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				int time = sc.nextInt();
				pipe.add(new Pipe(x1, y1, x2, y2, time));
			}
				
				int[] vst = new int[n];
				ans = abs(E.x - S.x) + abs(E.y - S.y);
				
				minTime(pipe, S.x, S.y , E, 0, vst,n);
			
				
				System.out.println("#" + t + " : " + ans);
			
		}

	}
	
	public static int abs(int x) {
		return Math.abs(x);
	}

	
	public static void minTime (ArrayList<Pipe> pipe, int sx, int sy, Point E, int i, int[] vst, int n) {
		
		 ans = Math.min(ans, i + abs(sx - E.x) + abs (sy - E.y));
		
		for (int j = 0; j < n; j++) {
			
			if (vst[j] > 0) {
				continue;
			}
			
	          
	          int dis = abs(pipe.get(j).x1 - sx) + abs(pipe.get(j).y1 - sy) + pipe.get(j).time;
	          vst[j]++;
	          minTime(pipe, pipe.get(j).x2, pipe.get(j).y2, E, i + dis,vst,n);
	         
	          dis = abs(pipe.get(j).x2 - sx) + abs(pipe.get(j).y2 - sy) + pipe.get(j).time;
	          minTime(pipe, pipe.get(j).x1, pipe.get(j).y1, E, i + dis,vst,n);
	          vst[j]--;
			
		}
		
		
	}

}

class Pipe {
	
	int x1;
	int y1;
	
	int x2;
	int y2;
	int time;
	
	public Pipe(int x1, int y1, int x2, int y2, int time) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.time = time;
	}
	
}

class Point {
	int x;
	int y;
}
