package com.easy;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
	
	// Space is constant
	public int getFibMethod3(int n) {
		int[] num = new int[] {0, 1};
		int result = 0;
		if(n == 1) {
			return num[0];
		} else if (n == 2) {
			return num[1];
		} else {
			for(int i = 3; i<= n; i++) {
				result = num[0] + num[1];
				num[0] = num[1];
				num[1] = result;
			}
		}
		
		return (n > 1) ? num[1] : num[0];
		//Some edge cases are not being handled by direct return
		//return result;
	}
	
	//  Space is O(n)
	public int getFibMethod2(int n) {
		Map<Integer, Integer> memoize = new HashMap<>();
		memoize.put(1, 0);
		memoize.put(2, 1);
		return getFenMethod2Helper(n, memoize);
	}
	
	public int getFenMethod2Helper(int n, Map<Integer, Integer> memoize) {
		if(memoize.get(n) == null) {
			memoize.put(n, getFenMethod2Helper(n-1, memoize) + getFenMethod2Helper(n-2, memoize));
			return memoize.get(n);
		} else {
			return memoize.get(n);
		}
	}
	
	/*
	 * Basic Method
	 * 
	 */
	public int getFibMehod(int n) {
		if(n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else
			return getFibMehod(n-1) + getFibMehod(n-2);
	}
	
	public static void main(String[] args) {
		
		int n = 8;
		FibonacciNumber fn = new FibonacciNumber();
		System.out.println(fn.getFibMethod3(n));
		
	}

}