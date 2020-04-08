package com.codingblocks.Recursion;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,5,8,1,8,7};
		System.out.println(lastIndex(arr, 0, 8));
		
		System.out.println(getSS("abc"));
		System.out.println(getPermutations("abc"));
		System.out.println(getBoardPath(10,0));
		
       
	}
	
	public static int lastIndex(int[] arr,int i,int data) {
		if(i==arr.length) {
			return -1;
		}
		int index=lastIndex(arr, i+1, data);
		if(index!=-1) {
			return index;
		}else {
			if(arr[i]==data) {
				return i;
			}else {
				return -1;
			}
		}
	}
	
	public static ArrayList<String> getSS(String str){
		if(str.length()==0) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		char cc=str.charAt(0);
		String ros=str.substring(1);
		
		ArrayList<String> recresult=getSS(ros);
		ArrayList<String> mr=new ArrayList<>();
		for(int i=0;i<recresult.size();i++) {
			mr.add(recresult.get(i));
			mr.add(cc+recresult.get(i));
		}
		
		return mr;
		
	}
	
	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recresult = getPermutations(ros);
		for (int i = 0; i < recresult.size(); i++) {
			String recString = recresult.get(i);
			for (int j = 0; j <= recString.length(); j++) {
				String mystring = recString.substring(0, j) + cc + recString.substring(j);
				myResult.add(mystring);
			}
		}
		return myResult;
	}
	
	public static ArrayList<String> getBoardPath(int end,int curr){
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> recResult = null;
		ArrayList<String> myresult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPath(end, curr + dice);
			for (int i = 0; i < recResult.size(); i++) {
				myresult.add(dice + recResult.get(i));
			}

		}
		
		return myresult;
	}
	
	

}
