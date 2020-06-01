package com.easy;

import java.util.Arrays;

public class InsertionSort {
	
	public int[] doInsertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int j = i;
			while(j>0 && nums[j] < nums[j-1]) {
				nums = swap(j, j-1, nums);
				j--;
			}
		}
		return nums;
	}
	
	public int[] swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {8, 5, 2, 9, 5, 6, 3};
		InsertionSort is = new InsertionSort();
		System.out.println(Arrays.toString(is.doInsertionSort(nums)));
	}

}
