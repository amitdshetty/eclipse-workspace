package com.monthlychallengemay.day06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public int majorityElement(int[] nums) {
		int result = -1;
		
		Map<Integer, Integer> counterMap = new HashMap<>();
		
		for(int i :  nums) {
			counterMap.put(i, counterMap.getOrDefault(i, 0) + 1);
		}
		
		//System.out.println(counterMap.entrySet());
		
		for (Iterator it = counterMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> me = (Entry<Integer, Integer>) it.next();
			//System.out.println("Key ==> " + me.getKey() + " Value ==> " + me.getValue() );
			if(me.getValue() > nums.length/2) {
				result = me.getKey();
			}
		}
		
		return result;

	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] inputNums = new int[] {3, 2, 3};
		
		System.out.println(sol.majorityElement(inputNums));
	}

}
