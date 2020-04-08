package com.codingblocks;

public class SquareRootDemo {

	public static void main(String[] args) {
		double result = Math.sqrt(100);
		String afterDecimalFour= null;
		String beforeDecimal = String.valueOf((int)result);
		String afterDecimal = String.valueOf(result%1).substring(2);
		if (afterDecimal.length() > 4) {
			afterDecimalFour = afterDecimal.substring(0,4);
		}
		else if (afterDecimal.length() < 4) {
			if (afterDecimal.length() == 3  ) {
				afterDecimalFour = afterDecimal+ "000";
			}else if (afterDecimal.length() == 2) {
				afterDecimalFour = afterDecimal + "00";
			} else {
				afterDecimalFour = afterDecimal + "0";
			}
		}
		System.out.println(beforeDecimal + "." + afterDecimalFour);
		

	}

}
