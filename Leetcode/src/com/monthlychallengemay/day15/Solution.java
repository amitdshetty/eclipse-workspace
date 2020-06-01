package com.monthlychallengemay.day15;

public class Solution {

	public int maxSubarraySumCircular(int[] A) {
		
		int max_kadane = kadane_algorithm(A);
		if(max_kadane < 0)
			return max_kadane;
		int max_wrap = 0;
		for(int i = 0; i< A.length; i++) {
			max_wrap += A[i];
			A[i] = -A[i];	
		}
		
		max_wrap += kadane_algorithm(A);
		
		//System.out.println((max_wrap > max_kadane) ? max_wrap : max_kadane);
		return (max_wrap == 0) ? max_kadane : Math.max(max_wrap, max_kadane); 
		
		

	}
	
	public int kadane_algorithm(int[] nums) {
		
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int i = 0; i < nums.length; i++) {
			
			max_ending_here += nums[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			if(max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}
		return max_so_far;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-2,-3,-1};
		Solution sol = new Solution();
		//System.out.println(sol.kadane_algorithm(nums));
		System.out.println(sol.maxSubarraySumCircular(nums));

	}

}
