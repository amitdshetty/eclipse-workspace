package com.easy;

import java.util.Arrays;

public class ThreeLargestNumbers {
	
	public int[] findThreeLargestNumbers(int[] n) {
		
		int[] temp = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		
		for(int i = 0; i < n.length; i++) {
			
			if(n[i] > temp[0]) {
				temp[2] = temp[1];
				temp[1] = temp[0];
				temp[0] = n[i];
			} else if(n[i] > temp[1]) {
				temp[2] = temp[1];
				temp[1] = n[i];
				
			} else if(n[i] > temp[2]) {
				temp[2] = n[i];
			} 
			
		}
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		
		int[] n = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
		ThreeLargestNumbers tln = new ThreeLargestNumbers();
		int[] result = tln.findThreeLargestNumbers(n);
		System.out.println(Arrays.toString(result));
		
	}

}
