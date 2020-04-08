package com.codingblocks.classroomsession;

import java.util.ArrayList;

public class MazePath {
	static int arr[][] = new int[4][4];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> pathList  = getMazePath(0,0,2,2,"");
//		int pathCount  = getMazePathCount(0,0,3,3);
//		System.out.println(pathCount);
		System.out.println(pathList);
//		System.out.println(mazeCountIterativeTD(0, 0, 3, 3));
		
	}

	private static int getMazePathCount(int v, int h, int fv, int fh) {
		if (v>fv || h>fh) {
			return 0;
		}
		if(v == fv && h == fh) {
			return 1;
		}
		
		return getMazePathCount(v+1, h, fv, fh) + getMazePathCount(v, h+1, fv, fh);
	}
	private static int mazeCountIterativeTD(int v, int h, int fv, int fh) {
		for (int row = fv; row >=0 ; row--) {
			for (int col = fh; col >= 0; col--) {
				if(col == fh || row == fv) {
					arr[row][col] = 1;
				} else {
					arr[row][col] = arr[row][col + 1] + arr[row + 1][col];
				}
			}
		}
		return arr[0][0];
	}
//	private static int getMazePathCount(int v, int h, int fv, int fh) {
//		if (v>fv || h>fh) {
//			return 0;
//		}
//		if(v == fv && h == fh) {
//			return 1;
//		}
//		if (arr[v][h] != 0) {
//			return arr[v][h];
//		}
//		
//		int count = getMazePathCount(v+1, h, fv, fh) + getMazePathCount(v, h+1, fv, fh);
//		arr[v][h] = count;
//		return count;
//	}
	public static ArrayList<String> getMazePath(int v, int h, int fv, int fh, String path) {
		if (v>fv || h>fh) {
			return null;
		}
		if(v == fv && h == fh) {
			ArrayList<String> currList = new ArrayList<>();
			currList.add(path);
			return currList;
		}
		
		ArrayList<String> resList = new ArrayList<>();
		if (getMazePath(v+1, h, fv, fh, path + "V") != null) {
			resList.addAll(getMazePath(v+1, h, fv, fh, path + "V"));
			
		}
		if (getMazePath(v, h+1, fv, fh, path + "H") != null) {
			resList.addAll(getMazePath(v, h+1, fv, fh, path + "H"));
		}
		
		return resList;
	}

}
