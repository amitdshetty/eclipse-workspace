package com.amit.ms.itcs6114;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgosUtil {
	
	/*
	 * Note the 2 integer constants below determine the total number of time the algorithm will run
	 * TEST_FRAMEWORK_INPUT_STEP_COUNT determines the difference between the current input size and next input size and the size of the smallest array
	 * TEST_FRAMEWORK_INPUT_MULTIPLIER determines the number of time the step count will increase
	 * Multiplying the two will give the maximum size of the array to be tested 
	 */
	public static final int TEST_FRAMEWORK_INPUT_MULTIPLIER = 15;
	public static final int TEST_FRAMEWORK_INPUT_STEP_COUNT = 1000;

	public void calculateRunTimeAverageForSort(String sortingMethod, long[] sortDurationArray) {

		long sumOfDurationOfAllIterations = 0;
		for (int i = 0; i < sortDurationArray.length; i++) {

			sumOfDurationOfAllIterations += sortDurationArray[i];
		}
		writeToFile("\nIt took and average of " + (sumOfDurationOfAllIterations / 10) + " ns for " + sortingMethod + "Sort");
	}
	
	/*
	 * Method to generate unique random numbers based on a pre-defined limit
	 */
	public int[] generateRandomArray(int size) {
		
		int low = 1;
		int high = 99999;
		Random random = new Random();
		int[] input = new int[size];
		for (int i = 0; i < input.length; i++) {

			// This ensures that no duplicates are created
			input[i] = (random.nextInt(high - low) + low);
		}
		/*
		 * Uncomment if you want to see the random array generated. 
		 * Note: Uncommenting will write a lots of data to the output file depending on the parameters set
		 */
		//writeToFile("The random array generated is \n" + Arrays.toString(input) + "\n\n");
		return input;
	}
	
	/*
	 * Write output to a file. 
	 * Note : Delete file after run otherwise it will keep appending
	 */
	public void writeToFile(String text) {
		try {

			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(new FileWriter("Performance_Output.txt", true));
			out.write(text + "\n");
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int[] sortArrayInDescendingOrder(int[] arrayToBeSorted) {
		
		// Sort array in ascending order then reverse 
		Arrays.sort(arrayToBeSorted);
		
		int last = arrayToBeSorted.length - 1;
		int middle = arrayToBeSorted.length / 2;
		for (int k = 0; k <= middle; k++) {
			
			int temp = arrayToBeSorted[k];
			arrayToBeSorted[k] = arrayToBeSorted[last - k];
			arrayToBeSorted[last - k] = temp;
		}
		
		return arrayToBeSorted;
	}

}
