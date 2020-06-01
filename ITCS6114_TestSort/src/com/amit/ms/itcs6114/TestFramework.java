package com.amit.ms.itcs6114;

import static com.amit.ms.itcs6114.SortingAlgosUtil.TEST_FRAMEWORK_INPUT_MULTIPLIER;
import static com.amit.ms.itcs6114.SortingAlgosUtil.TEST_FRAMEWORK_INPUT_STEP_COUNT;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestFramework {

	public static void main(String[] args) {

		SortingAlgosUtil sortingAlgosUtil = new SortingAlgosUtil();
		SortingAlgosController sortingAlgosController = new SortingAlgosController();
		SortingAlgos sortingAlgos = new SortingAlgos();
		
		/*
		 * Pass string of sorts in this array as long as it is suffixed by "Sort" in the SortingAlgos class methods.
		 * The string in this array are used to dynamically invoke methods and write log files
		 * Refer to SortingAlgosController class 
		 */
		String[] sortingAlgorithms = { "insertion", "selection", "merge", "bubble"};
		
		sortingAlgosUtil.writeToFile("\n===== Averarge Case Scenario =====\n");

		for (int j = 1; j <= TEST_FRAMEWORK_INPUT_MULTIPLIER; j++) {

			int inputArraySize = TEST_FRAMEWORK_INPUT_STEP_COUNT * j;
			sortingAlgosUtil.writeToFile("\n Running Performance Test for input size " + inputArraySize + "\n");
			int[] inputArray = sortingAlgosUtil.generateRandomArray(inputArraySize);

			try {
				for (int i = 0; i < sortingAlgorithms.length; i++) {

					sortingAlgosUtil.writeToFile("===== " + sortingAlgorithms[i] + "Sort begins =====\n");

					sortingAlgosController.performanceTest(sortingAlgos, inputArray, sortingAlgorithms[i], sortingAlgosUtil);

					sortingAlgosUtil.writeToFile("\n===== " + sortingAlgorithms[i] + "Sort ends ===== \n");
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {

				e.printStackTrace();
			}
		}

		sortingAlgosUtil.writeToFile("\n===== Best Case Scenario =====\n");

		for (int j = 1; j <= TEST_FRAMEWORK_INPUT_MULTIPLIER; j++) {

			int inputArraySize = TEST_FRAMEWORK_INPUT_STEP_COUNT * j;
			sortingAlgosUtil.writeToFile("\n Running Performance Test for input size " + inputArraySize + "\n");
			int[] inputArray = sortingAlgosUtil.generateRandomArray(inputArraySize);
			
			// sorting array in ascending order to emulate best case scenario
			Arrays.sort(inputArray);
			
			//System.out.println("Array in ascending order is " + Arrays.toString(inputArray));

			try {
				for (int i = 0; i < sortingAlgorithms.length; i++) {

					sortingAlgosUtil.writeToFile("===== " + sortingAlgorithms[i] + "Sort begins =====\n");

					sortingAlgosController.performanceTest(sortingAlgos, inputArray, sortingAlgorithms[i], sortingAlgosUtil);

					sortingAlgosUtil.writeToFile("\n===== " + sortingAlgorithms[i] + "Sort ends ===== \n");
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {

				e.printStackTrace();
			}
		}

		sortingAlgosUtil.writeToFile("\n===== Worst Case Scenario =====\n");

		for (int j = 1; j <= TEST_FRAMEWORK_INPUT_MULTIPLIER; j++) {

			int inputArraySize = TEST_FRAMEWORK_INPUT_STEP_COUNT * j;
			sortingAlgosUtil.writeToFile("\n Running Performance Test for input size " + inputArraySize + "\n");
			int[] inputArray = sortingAlgosUtil.generateRandomArray(inputArraySize);
			
			// sorting array in descending order to emulate worst case scenario
			int[]descendingOrderArray = sortingAlgosUtil.sortArrayInDescendingOrder(inputArray);
			//System.out.println("Array in descending order is " + Arrays.toString(inputArray));

			try {
				for (int i = 0; i < sortingAlgorithms.length; i++) {

					sortingAlgosUtil.writeToFile("===== " + sortingAlgorithms[i] + "Sort begins =====\n");

					sortingAlgosController.performanceTest(sortingAlgos, descendingOrderArray, sortingAlgorithms[i], sortingAlgosUtil);

					sortingAlgosUtil.writeToFile("\n===== " + sortingAlgorithms[i] + "Sort ends ===== \n");
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {

				e.printStackTrace();
			}
		}

	}

}
