package come.amit.itcs6114;

public class PositionCalculatorLinear {
	
	/**
	 * Find the maximum sub array sum using a simple for loop and returns the first and last index of the sub array which has the maximum sum
	 * Uses linear time complexity of traverse the loop only one to give a time complexity of O(n)
	 * @param a
	 * @return
	 */
	public StockPositionBean findMaximumSumLinear(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		//Since array elements are negative we use the minimum integer value to depict the smallest number instead of zero
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum > maxSum) {
				maxSum = sum;
				endIndex = i;
				
			}
			if (sum < 0) {
				sum = 0;
				//If maximum sum is negative move the increase the start index by 1
				startIndex = i+1;
			}
		}
		return new StockPositionBean(startIndex, endIndex, maxSum);
	}
}
