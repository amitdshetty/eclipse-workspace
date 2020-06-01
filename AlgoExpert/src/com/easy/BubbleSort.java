package com.easy;

import java.util.Arrays;

public class BubbleSort {
	
	public int[] doBubbleSort(int[] nums) {
		boolean isSorted = false;
		// This will reduce the number of the number of iterations that need to be done
		int count = 0;
		while(!isSorted) {
			isSorted = true;
			// Using count since the last elements will already be sorted
			for(int i = 0; i < nums.length-1-count; i++) {
				if(nums[i] > nums[i+1]) {
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					isSorted = false;
				}
			}
			count++;
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {8, 5, 2, 9, 5, 6, 3};
		BubbleSort bs = new BubbleSort();
		nums = bs.doBubbleSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
