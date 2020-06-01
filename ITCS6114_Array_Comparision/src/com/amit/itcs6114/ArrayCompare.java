package com.amit.itcs6114;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author amitshetty
 * Problem Statement : Find non matching elements in when presented with 2 arrays where one array is a subset of the other
 * ITCS 6114 Problem Statement
 * 1. You are given n telephone bills and m checks sent to pay the bills (n ≥ m). Assuming that telephone numbers are written on the checks, find out who failed to pay.  
 * (For simplicity, you may also assume that only one check is written for a particular bill and that it covers the bill in full)
 */

public class ArrayCompare {

	public static void main(String[] args) {
		
		//Array of all numbers who have telephones
		Integer[] a = new Integer[] {5, 4, 3, 2, 1};
		//Array of all numbers who have paid their bills
		Integer[] b = new Integer[] {1, 2, 3};
		
		/*
		 * Arrays.asList cannot be modified 
		 * Refer : https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#asList(T...)
		 * Source : https://stackoverflow.com/questions/2965747/why-do-i-get-an-unsupportedoperationexception-when-trying-to-remove-an-element-f
		 * 
		 */
		//List<Integer> parentList = Arrays.asList(a);
		List<Integer> parentList = new LinkedList<Integer>(Arrays.asList(a));
		
		for (int i = 0; i < b.length; i++) {
			/*
			 * From http://bigocheatsheet.com 
			 * Cost of removing an element from a LinkedList is O(1)
			 * 
			 * No check needs to be implemented since as per the problem statement b is a subset of a i.e. b will contain some if not all numbers in a
			 */
			parentList.remove(b[i]);
		}
		
		System.out.println("People who have not paid their bill ==> " + parentList.toString());
		//Sample Output
		//People who have not paid their bill ==> [5, 4]
		

	}

}
