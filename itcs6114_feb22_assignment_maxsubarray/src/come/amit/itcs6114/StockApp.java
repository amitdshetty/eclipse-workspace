package come.amit.itcs6114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author Amit
 *
 */
public class StockApp {

	public static void main(String[] args) {
		int[] priceDifference = null;
		//Set flag to false if user defined values are needed (Keyboard input)
		//Set flag to true if predefined test case values are needed (refer to performUserGeneratedTestCases())
		boolean testFlag = true;
		if (testFlag) {
			performStaticTestCases();
			System.exit(0);
		} else {
			priceDifference = performUserGeneratedTestCases();
		}
		PositionCalculator positionCalculator = new PositionCalculator();
		StockPositionBean stockPositionBean = positionCalculator.findMaximumSum(priceDifference, 0, priceDifference.length - 1);
		System.out.println(stockPositionBean.toString());
	}

	/**
	 * Takes user generated input and calculates the price difference between daily price changes.
	 * User will have to input the number of days of price data they will be loading followed by the prices
	 * @return Integer array containing the price difference between the daily prices
	 */
	@SuppressWarnings("resource")
	public static int[] performUserGeneratedTestCases() {
		int[] priceDifference;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of days for which stocks are to be traded");
		int noOfDays = in.nextInt();
		System.out.println("Enter the prices for those days");
		int[] userPrices = new int[noOfDays];
		for (int i = 1; i <= noOfDays; i++) {
			userPrices[i - 1] = in.nextInt();
		}
		System.out.println("The user input is " + Arrays.toString(userPrices));
		priceDifference = calculatePriceDifference(userPrices);
		return priceDifference;
	}

	/**
	 * This is a test framework to load static data without getting any user input
	 * To add a new test case , create an array of integers and add it to the list
	 */
	public static void performStaticTestCases() {
		PositionCalculator positionCalculator = new PositionCalculator();
		ArrayList<int[]> testCases = new ArrayList<int[]>();
		int[] a = new int[] {10,11,7,10,6};
		int[] b = new int[] {10,11,7,10,14,12,18};
		int[] c = new int[] {5};
		int[] d = new int[] {1,2,3,4,5,6,7,8,9};
		int[] e = new int[] {2,100,8,7,6,5};
		testCases.add(a);
		testCases.add(b);
		testCases.add(c);
		testCases.add(d);
		testCases.add(e);
		int count = 1;
		for (Iterator<int[]> iterator = testCases.iterator(); iterator.hasNext();) {
			System.out.println("Running Test Case " + count);
			int[] is = (int[]) iterator.next();
			int[] priceDifference = calculatePriceDifference(is);
			StockPositionBean stockPositionBean = positionCalculator.findMaximumSum(priceDifference, 0, priceDifference.length - 1);
			System.out.println("For input ==> " + Arrays.toString(is) + ", results are ==> " + stockPositionBean.toString() + "\n");
			count++;
		}
	}
	
	/**
	 * Calculates the price difference between successive days of the input
	 * @param a Input provided
	 * @return Integer array containing the price difference between the daily prices
	 */
	public static int[] calculatePriceDifference(int[] a) {
		int[] b = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			b[i] = a[i] - a[i - 1];
		}
		System.out.println("The sum difference calculated for " + Arrays.toString(a) + " is " + Arrays.toString(b));
		return b;
	}

}
