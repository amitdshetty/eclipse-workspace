package com.amit;

import java.util.PriorityQueue;

public class NLargestNumberUsingPQ {
	
	// Return the nth largest from an array if the array is being populated at run time.
	
	public int getNthSmallestNumber(int[] arr, int n) {
		
		/*
		 * Base condition checks for 
		 */
		if(n > arr.length)
			return -1;
		
		int[] result = new int[n];
		
		/*
		 * PriorityQueue will only sort the first element then sort the rest  when needed. 
		 * This is a sort of lazy sorting.
		 * Refer: https://stackoverflow.com/questions/25569625/sorting-priority-queue-in-java
		 * 
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return a - b;
		});
		
		for(int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		
		for(int j = 0; j < n; j++) {
			result[j] = pq.poll();
		}
		
		return result[n-1];
	}
	
public int getNthLargestNumber(int[] arr, int n) {
		
		/*
		 * Base condition checks for 
		 */
		if(n > arr.length)
			return -1;
		
		int[] result = new int[n];
		
		/*
		 * PriorityQueue will only sort the first element then sort the rest  when needed. 
		 * This is a sort of lazy sorting.
		 * Refer: https://stackoverflow.com/questions/25569625/sorting-priority-queue-in-java
		 * 
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		
		for(int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		
		for(int j = 0; j < n; j++) {
			result[j] = pq.poll();
		}
		
		return result[n-1];
	}
	
	public static void main(String[] args) {
		
		int[] arr = {14, 5, 22, 18, 28};
		int n = 2;
		NLargestNumberUsingPQ npq = new NLargestNumberUsingPQ();
		int result_smallest = npq.getNthSmallestNumber(arr, n);
		int result_largest = npq.getNthLargestNumber(arr, n);
		System.out.println("The smallest " + n + "th number given by the input is " + result_smallest);
		System.out.println("The largest " + n + "th number given by the input is " + result_largest);
		
		
	}

}
