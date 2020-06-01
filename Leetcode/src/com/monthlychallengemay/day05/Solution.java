package com.monthlychallengemay.day05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public int firstUniqChar(String s) {

		Map<Character, Integer> counter = new LinkedHashMap<>();
		char[] d = s.toCharArray();
		for (char c : d) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}
		int index = -1;
		for (Entry<Character, Integer> me : counter.entrySet()) {

			if (1 == me.getValue()) {
				index = new String(d).indexOf(me.getKey());
				break;
			}

		}
		return index;

	}

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.firstUniqChar("loveleetcode"));

	}

}
