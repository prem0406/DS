package com.codingblocks.classroomsession;
import java.util.*;

class MaximumCircles {
	
	static class Circle implements Comparable<Circle> {
		long leftPoint;
		long rightPoint;
		
		Circle(long x, long y) {
			this.rightPoint = x;
			this.leftPoint = y;
		}

		@Override
		public int compareTo(Circle arg0) {
			
			if(this.rightPoint > arg0.rightPoint) {
				return 1;
			} else {
				return -1;
			}
		}
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Circle arr[] = new Circle[n];
		for(int i=0;i<n;i++) {
			long x = scn.nextLong();
			long r = scn.nextLong();
			arr[i] = new Circle(x+r,x-r);
		}
		Arrays.sort(arr);
		int ans = 1, chosen = 0;
		for(int i=1;i<n;i++) {
			if(arr[i].leftPoint>=arr[chosen].rightPoint) {
				ans++;
				chosen = i;
			}
		}
		System.out.println(n-ans);
	}
	
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class MaximumCircles {
//	
//	public static void main(String[] args) {
//		ArrayList<Circle> circleList = new ArrayList<>();
//		int maxCircle = 0;
//		Scanner sc = new Scanner(System.in);
//		int numOfCircle = sc.nextInt();
//		for (int i = 0; i < numOfCircle; i++) {
//			int radius = sc.nextInt();
//			int x1 = i - radius;
//			int x2 = 1 + radius;
//			circleList.add(new Circle(x1,x2));
//		}
//		circleList = getIntersect(circleList);
//		isSafe(circleList);
//	}
//
//	private static boolean isSafe(ArrayList<Circle> circleList) {
//		for (int i = 0; i < circleList.size(); i++) {
//			for (int j = 0; j < circleList.size(); j++) {
//				if (i != j) {
//					int x1 = circleList.get(i).x1;
//					int x2 = circleList.get(i).x2;
//					int x3 = circleList.get(j).x1;
//					int x4 = circleList.get(j).x2;
//					if (x1 <  x3 && x2 <= x4) {
//						return false;
//					} else if (x1 >  x3 && x2 >= x4) {
//						return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
//
//	private static ArrayList<Circle> getIntersect(ArrayList<Circle> circleList) {
//		for (int i = 0; i < circleList.size(); i++) {
//			int count = 0;
//			for (int j = 0; j < circleList.size(); j++) {
//				if (i != j) {
//					int x1 = circleList.get(i).x1;
//					int x2 = circleList.get(i).x2;
//					int x3 = circleList.get(j).x1;
//					int x4 = circleList.get(j).x2;
//					if (x1 <  x3 && x2 <= x4) {
//						count++;
//					} else if (x1 >  x3 && x2 >= x4) {
//						count++;
//					}
//				}
//			}
//			circleList.get(i).setIntersect(count);
//		}
//		return circleList;
//	}
//
//}
//class Circle {
//	 int x1;
//	int x2 ;
//	int intersect;
//	public Circle(int x1, int x2) {
//		this.x1 = x1;
//		this.x2 = x2;
//	}
//	public void setIntersect(int intersect) {
//		this.intersect = intersect;
//	}
//}
