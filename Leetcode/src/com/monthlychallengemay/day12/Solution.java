package com.monthlychallengemay.day12;

/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears 
 * exactly once. Find this single element that appears only once.
 * 
 * Input: [1,1,2,3,3,4,4,8,8]
	Output: 2
 */

public class Solution {
	
	
//	public int singleNonDuplicate(int[] nums) {
//        int res = nums[0];
//        for (int i = 1; i < nums.length; ++i) 
//        	res ^= nums[i];
//        return res;
//    }
	
	
	/**
	 * Logic is that if in the mid point any one of the two cases are satisfied then upto that point the duplicate is not present
	 * it would be placed after the mid point
	 * if condition is not satisfied it means that pattern of duplicate is broken and non duplicate would be lying before it.
	 * @param nums
	 * @return
	 */
	public int singleNonDuplicate(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left < right) {
			int mid = (left + right)/2;
			if( (mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 > 0 && nums[mid] == nums[mid-1]) ) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,1,2,3,3,4,4,8,8};
		int[] nums = {3,3,7,7,10,10,11};
		Solution sol = new Solution();
		System.out.println(sol.singleNonDuplicate(nums));
		System.out.println((int) ((5+6)/2));

	}

}
