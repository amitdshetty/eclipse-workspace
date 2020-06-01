package com.amit;

public class Kadande_Algorithm {
	
	
	/*
	 * Time Complexity O(n)
	 * Space Complexity O(1)		
	 */
	public int maxSubArrayConstantSpace(int[] nums) {
		
		int currentSum = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i <  nums.length; i++) {
			currentSum = Math.max(currentSum, 0) + nums[i];
			maxSum = Math.max(currentSum, maxSum);
		}
		
		return maxSum;
		
	}
	
	
	/*
	 * Time Complexity O(n)
	 * Space Complexity O(n)
	 */
	public int maxSubArray(int[] nums) {
		
		int max = 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			
			dp[i] = Math.max(dp[i-1], 0) + nums[i];
			max = Math.max(max, dp[i]);
			
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 7, -3, 2, 9, 6, 16, 22, 21, 29, -14, 10, 12};
		
		Kadande_Algorithm ka = new Kadande_Algorithm();
		System.out.println(ka.maxSubArray(nums));
		//System.out.println(ka.maxSubArrayConstantSpace(nums));
		
	}

}
