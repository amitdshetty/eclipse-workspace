package com.monthlychallenge.day17;

public class BinarySearch {

	public static int search(int[] nums, int target) {

		if (nums.length < 1) {
			return -1;
		}

		int m = 0;
		int n = nums.length - 1;

		return binarySearch(m, n, nums, target);

	}

	public static int binarySearch(int low, int high, int[] nums, int target) {

		if (low > high)
			return -1;
		int mid = (low + high) / 2;

		if (target == nums[mid]) {
			return mid;
		} else if (target < nums[mid]) {
			high = mid - 1;
			return binarySearch(low, high, nums, target);
		} else {
			low = mid + 1;
			return binarySearch(low, high, nums, target);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int target = 9;
		int result = search(nums, target);
		System.out.println("Result --> " + result);
	}

}
