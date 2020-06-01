package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all possible triplets that sum up to the target
 */

public class ThreeNumberSum {
	
	/*
	 * Since the sorting takes place beforehand 
	 */
	public List<List<Integer>> getAllCombos(int[] nums, int target){
		
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		// [-8, -6, 1, 2, 3, 5, 6, 12]
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < nums.length - 2; i++) {
			int left = i;
			int right = nums.length - 1;
			while(left < right) {
				int temp = nums[i] + nums[left] + nums[right];
				if(temp == target) {
					/*
					 * Note anonymous inner classes don't have access to local variables
					 */
					List<Integer> tempd = new ArrayList<>();
					tempd.add(nums[i]);
					tempd.add(nums[left]);
					tempd.add(nums[right]);
					result.add(tempd);
					
					/*
					 * If this below 2 points are not added then the program goes into a continous loop.
					 * Since the target is met and we want to find further solutions we have to move both pointers
					 */
					left++;
					right--;
				} else if(temp < target) {
					left++;
				} else {
					right--;
				}
				
			}
			left = i+1;
			right = nums.length - 1;
			
			
		}
		
		return result;
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {12, 3, 1, 2, -6, 5, -8, 6};
		int target = 0;
		ThreeNumberSum tns = new ThreeNumberSum();
		List<List<Integer>> result = tns.getAllCombos(nums, target);
		System.out.println(result);
		
		
	}

}
