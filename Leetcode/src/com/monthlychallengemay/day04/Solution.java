package com.monthlychallengemay.day04;

public class Solution {

	public static int findComplement(int num) {

		String bnum = Integer.toBinaryString(num);
		char[] d = new char[bnum.length()];
		int count = 0;
		for(char c: bnum.toCharArray()) {
			d[count] = (c == '0') ? '1' : '0'; 
			count++;
		} 
		
		
		return Integer.parseInt(new String(d), 2);
		

	}

	public static void main(String[] args) {
		
		System.out.println(findComplement(5));

	}

}
