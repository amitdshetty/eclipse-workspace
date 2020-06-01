package com.easy;

import java.util.Arrays;

public class SelectionSort {
	
	public int[] doSelectionSort(int[] nums) {
		
		for(int i=0; i< nums.length-1; i++) {
			int smallestIndex = i;
			 for(int j=i+1; j < nums.length; j++) {
				 if(nums[smallestIndex] > nums[j]) {
					 smallestIndex = j;
				 }
			 }
			 int temp = nums[i];
			 nums[i] = nums[smallestIndex];
			 nums[smallestIndex] = temp;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {8, 5, 2, 9, 5, 6, 3};
		SelectionSort ss = new SelectionSort();
		int[] nums2 = ss.doSelectionSort(nums);
		System.out.println(Arrays.toString(nums2));
	}

}
