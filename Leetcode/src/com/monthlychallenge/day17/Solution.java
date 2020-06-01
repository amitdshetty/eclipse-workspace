package com.monthlychallenge.day17;

/*
 * 
search in rotated sorted array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
 */

public class Solution {

	public static int search(int[] nums, int target) {

		if (nums.length < 1) {
			return -1;
		}

		int m = 0;
		int n = nums.length - 1;

		return binarySearch(m, n, nums, target);

	}

	public static int binarySearch(int low, int high, int[] nums, int target) {

		while (low <= high) {
			int mid = (low + high) / 2;

			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] <= nums[high]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (target < nums[mid] && target >= nums[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 4, 5, 6, 7, 8, 1, 2 };
		int target = 8;
		int result = search(nums, target);
		System.out.println("Result --> " + result);
	}

}
