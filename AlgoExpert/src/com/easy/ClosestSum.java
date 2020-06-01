package com.easy;

public class ClosestSum {
	
	public void getClosestSum(int[] nums, int sum) {
		
		int left = 0;
		int right = nums.length - 1;
		int diff = Integer.MAX_VALUE;
		int firstPart = 0;
		int lastPart = 0;
		while(left < right) {
			int temp = Math.abs(nums[left] + nums[right] - sum);
			if (temp < diff) {
				// Store the results and return later
				diff = temp;
				firstPart = nums[left];
				lastPart = nums[right];
			} else if (nums[left] + nums[right] < sum)
				left++;
			else
				right--;
				
		}
		System.out.printf("The closest sum obtained is of %d and %d", firstPart, lastPart);
		
	}
	
	public static void main(String[] args) {
		 int[] nums = {10, 22, 28, 29, 30 ,40};
		 int sum = 54;
		 
		 ClosestSum closestSum = new ClosestSum ();
		 closestSum.getClosestSum(nums, sum);
		 
	}

}
