package com.monthlychallengemay.day02;

public class Solution {

	public static int numJewelsInStones(String J, String S) {
		
		int count = 0;
		for (char d : S.toCharArray()) {
			if(J.indexOf(d) > -1) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		
		System.out.println(numJewelsInStones("z", "ZZ"));

	}

}
