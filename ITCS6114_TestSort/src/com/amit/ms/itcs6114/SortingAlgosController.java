package com.amit.ms.itcs6114;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortingAlgosController {
	
	public void performanceTest(SortingAlgos sortingAlgo, int[] inputArray, String sortingMethod, SortingAlgosUtil sortingUtilObj)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		long[] sortDurationArray = new long[10];

		/*
		 * Using Reflection API to dynamically call sorting methods in the SortingAlgos
		 * class and invoking them for every loop.
		 * Prefix for each method is passed as a String sortingMethod from an array in TestFramework class
		 */
		Method getSortingMethod = sortingAlgo.getClass().getDeclaredMethod(sortingMethod + "Sort", new Class[] { int[].class });
		for (int i = 0; i < 10; i++) {

			long start = System.nanoTime();
			Object value = getSortingMethod.invoke(sortingAlgo, inputArray);
			long duration = System.nanoTime() - start;
			
			int[] sortedArray = (int[]) value;
			sortDurationArray[i] = duration;
			sortingUtilObj.writeToFile("Iteration " + i + " for " + sortingMethod + "Sort took " + duration + " ns");
			
			/*
			 * Done for debugging and testing purposes
			 * Print Sorted array only once for entire 10 run cycle
			 */
//			if(i == 9) {
//				
//				sortingUtilObj.writeToFile("The sorted array is " + Arrays.toString(sortedArray));
//			}
		}

		sortingUtilObj.writeToFile("\n" + sortingMethod + " sort timings in nanoseconds ==> " + Arrays.toString(sortDurationArray));

		sortingUtilObj.calculateRunTimeAverageForSort(sortingMethod, sortDurationArray);

	}
}
