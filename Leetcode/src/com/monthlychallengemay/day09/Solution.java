package com.monthlychallengemay.day09;

public class Solution {
	
	/*
	 * let d be our answer for input number n
 		then n(1/2) = d 
     	apply log2 on both sides
      	log2(n(1/2)) = log2(d)
      	log2(d) = 1/2 * log2(n)
      	d = 2(1/2 * log2(n)) 
      	d = pow(2, 0.5*log2(n)) 
	 */
	public boolean isPerfectSquare(int num) {
		
		double temp = Math.pow(2, 0.5*(Math.log(num)/Math.log(2)));
		temp = Math.round(temp*100.0)/100.0;
		if(temp % 1 == 0)
			return true;
		//System.out.println(Math.round(temp*100.0)/100.0);
		return false;
	}

	public static void main(String[] args) {

		Solution sol = new Solution();
		// positive test case
		int num = 16;
		// negative test case
		int num2 = 9;
		System.out.println(sol.isPerfectSquare(num2));
	}

}
