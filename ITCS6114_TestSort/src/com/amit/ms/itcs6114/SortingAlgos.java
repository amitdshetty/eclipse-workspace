package com.amit.ms.itcs6114;

public class SortingAlgos {

	public int[] insertionSort(int arr[]) {

		int n = arr.length;

		int i, key, j;
		for (i = 1; i < n; i++) {
			
			key = arr[i];
			j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		return arr;

	}

	public int[] selectionSort(int arr[]) {

		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {

			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				
				if (arr[j] < arr[min_idx]) {
					
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	public int[] merge(int arr[], int l, int m, int r) {
		
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

		return arr;
	}

	/*
	 * Utilizes the concept of divide and conquer when splitting the array
	 */
	public int[] prepForSort(int arr[], int l, int r) {

		int[] sortedArray = null;

		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			prepForSort(arr, l, m);
			prepForSort(arr, m + 1, r);

			// Merge the sorted halves
			sortedArray = merge(arr, l, m, r);
		}
		return sortedArray;
	}

	public int[] mergeSort(int arr[]) {
		return prepForSort(arr, 0, arr.length - 1);
	}

	public int[] bubbleSort(int arr[]) {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				
				if (arr[j] > arr[j + 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

}
