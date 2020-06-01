package com.monthlychallengemay.day17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> findAnagrams(String s, String p) {
		int[] letters = new int[26];
		for (int i = 0; i < p.length(); i++) {
			letters[p.charAt(i) - 'a']++;
		}
		int j = 0;
		int rem = p.length();
		List<Integer> result = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			while (j < s.length() && j - i < p.length()) {
				if (letters[s.charAt(j++) - 'a']-- > 0) {
					rem--;
				}
			}
			if (rem == 0 && j - i == p.length())
				result.add(i);
			if (letters[s.charAt(i) - 'a']++ >= 0)
				rem++;
		}
		return result;
	}

	public static void main(String[] args) {
		// s: "cbaebabacd" p: "abc"
		String input = "cbaebabacd";
		String check = "abc";
		Solution sol = new Solution();
		sol.findAnagrams(input, check);
	}

}
