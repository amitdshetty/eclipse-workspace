package com.easy;

public class BinarySearch {

	public int doBinarySearch(int[] nums, int start, int end, int search) {
		if (start > end)
			return -1;
		else {
			int mid = (start + end) / 2;
			if (nums[mid] == search) {
				return mid;
			} else if (search < nums[mid]) {
				return doBinarySearch(nums, start, mid - 1, search);
			} else {
				return doBinarySearch(nums, mid + 1, end, search);
			}
		}

	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 5, 6, 7, 10, 13, 45 };
		int search = 13;
		BinarySearch bs = new BinarySearch();
		int start = 0;
		int end = nums.length - 1;
		int searchIndex = bs.doBinarySearch(nums, start, end, search);
		System.out.printf("The number %d is found at index %d", search, searchIndex);

	}

}
