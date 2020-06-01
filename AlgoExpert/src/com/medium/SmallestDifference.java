package com.medium;

import java.util.Arrays;

/*
 * Calculate the smallest difference between 2 arrays of numbers
 */
public class SmallestDifference {

	public int[] getSmallestDifference(int[] nums1, int[] nums2) {

		int[] result = new int[2];

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int left = 0;
		int right = 0;
		int smallestdiff = Integer.MAX_VALUE;
		
		/*
		 * Used or condition here by mistake the program to generate an ArrayIndexOutofBounds Exception
		 * Also since the left and right pointers are not moving in the same array once one of them reaches the end that means the minimum
		 * value has been found.
		 */
		
		while (left < nums1.length && right < nums2.length) {

			int temp = Math.abs(nums1[left] - nums2[right]);
			if (temp < smallestdiff) {
				smallestdiff = temp;
				result[0] = nums1[left];
				result[1] = nums2[right];
				/*
				 * We are applying this condition since there can be no difference less than 0
				 */
				if (temp == 0)
					break;

			}
			if (nums1[left] < nums2[right])
				left++;
			else if (nums1[left] > nums2[right])
				right++;

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = { -1, 5, 10, 20, 28, 3 };
		int[] nums2 = { 26, 134, 135, 15, 17 };

		SmallestDifference sd = new SmallestDifference();
		int[] result = sd.getSmallestDifference(nums1, nums2);
		System.out.println(Arrays.toString(result));

	}

}
