package come.amit.itcs6114;

/**
 * 
 * @author Amit
 *
 */
public class PositionCalculator {
	
	/**
	 * Returns the maximum sum by dividing the input array  into multiple sub arrays and then calculates the sum of the elements when the best start and end index are found
	 * @param a Array containing the price difference of the input array
	 * @param low
	 * @param high
	 * @return Object containing the beginning and ending of the sub array along with the sum of the elements
	 */
	public StockPositionBean findMaximumSum(int[] a, int low, int high) {
		if (a == null || a.length == 0 || low > high) {
			return null;
		}
		if(low==high) {
			return new StockPositionBean(low, high, a[low]);
		}
		while (low < high) {
			int mid = (low + high) / 2;
			StockPositionBean leftMax = findMaximumSum(a, low, mid);
			StockPositionBean rightMax = findMaximumSum(a, mid + 1, high);
			StockPositionBean crossMax = findMaxSpan(a, low, mid, high);
			
			//Returns the object containing the maximum sum which indicates the most profit
			if (leftMax.compareTo(crossMax) < 0) {
				return (crossMax.compareTo(rightMax) < 0) ? rightMax : crossMax;
			} else {
				return (leftMax.compareTo(rightMax) < 0) ? rightMax : leftMax;
			}
		}
		return new StockPositionBean(low, high, a[low]);
	}
	
	/**
	 * Calculates the sum of the elements on both the left and right side of the input array and returns find the maximum
	 * @param a Input array
	 * @param low
	 * @param mid
	 * @param high
	 * @return Object containing the beginning and ending of the sub array along with the sum of the elements
	 */
	public StockPositionBean findMaxSpan(int[] a, int low, int mid, int high) {

		int sum = a[mid];
		int leftMaxSum = sum;
		int rightMaxSum = sum;
		int leftIndex = mid;
		int rightIndex = mid;

		for (int i = mid-1; i >= low; i--) {
			sum += a[i];
			if (sum > leftMaxSum) {
				leftMaxSum = sum;
				leftIndex = i;
			}
		}
		//The sum calculated from the left sub array is used to calculate the maximum value for the right sub array
		sum = leftMaxSum;
		for (int j = mid + 1; j <= high; j++) {
			sum += a[j];
			if (sum > rightMaxSum) {
				rightMaxSum = sum;
				rightIndex = j;
			}
		}
		return new StockPositionBean(leftIndex, rightIndex, rightMaxSum);
	}
}
