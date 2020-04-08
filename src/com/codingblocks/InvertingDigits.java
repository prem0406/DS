package com.codingblocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class InvertingDigits {
    public static void main(String args[]) {
        String numStr = null;
        long finalNum = 0;
        int flag = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
        	numStr = br.readLine().trim();
        } catch (IOException ioe) {
        	System.out.println(ioe);
        }
        char[] charArr = numStr.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
        	int tempNum = Character.getNumericValue(charArr[i]);
        	if (flag==0 && tempNum == 9) {
        		flag = 1;
        	} else {
        		tempNum = Math.min(tempNum, 9-tempNum);
        		flag = 1;
        	}
        	
        	finalNum = finalNum * 10 + tempNum;
        }
        System.out.print(finalNum);
    }
}
