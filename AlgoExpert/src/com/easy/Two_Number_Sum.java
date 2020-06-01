package com.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Number_Sum {
	
	/*
	 * Using 2 pointers
	 * Sorting using O(nlogn) and constant space since no new datastructure is used
	 */
	public void get_two_number_sum_1(int[] nums, int sum) {
		
		Arrays.sort(nums); // in place sorting
		//System.out.println(Arrays.toString(nums));
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			int temp = nums[left] + nums[right];
			if(sum  == temp) {
				System.out.printf("The sum can be obtained using %d and %d", nums[left], nums[right]);
				break;
			}
			if(temp < sum)
				left++;
			else
				right--;
		}
	}
	
	/**
	 * Using hashtable having time comlexity of O(n) and space complexity of O(n)
	 * @param nums
	 * @param sum
	 */
	public void get_two_number_sum(int[] nums, int sum) {
		
		Map<Integer, Boolean> sumTable = new HashMap<>();
		
		for (int i : nums) {
			
			int y = sum - i;
			if(sumTable.getOrDefault(y, false)) {
				System.out.printf("The sum of %d are %d and %d", sum ,y ,i);
			} else {
				sumTable.put(i, true);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
		int sum = 10;
		Two_Number_Sum two_number_sum = new Two_Number_Sum();
		//two_number_sum.get_two_number_sum(nums, sum);
		two_number_sum.get_two_number_sum_1(nums, sum);
	}

}
