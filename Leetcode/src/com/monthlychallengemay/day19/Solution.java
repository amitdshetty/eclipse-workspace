package com.monthlychallengemay.day19;

import java.util.Stack;

public class Solution {
	
	Stack<int[]> stonks;
	
	public Solution() {
		stonks = new Stack<>();
	}
	
	public int next(int price) {
		
		int span = 1;
		while(!stonks.isEmpty() && price >= stonks.peek()[0]) {
			span += stonks.pop()[1];
		}
		
		stonks.push(new int[] {price, span});
		return span;
		
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.next(100));
		System.out.println(sol.next(80));
		System.out.println(sol.next(60));
		System.out.println(sol.next(70));
		System.out.println(sol.next(60));
		System.out.println(sol.next(75));
		System.out.println(sol.next(85));
	}

}
