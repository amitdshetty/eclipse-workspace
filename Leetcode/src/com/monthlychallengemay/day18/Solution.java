package com.monthlychallengemay.day18;

import java.util.Arrays;

public class Solution {

	public boolean checkInclusion(String s1, String s2) {

		int[] alphabet = new int[26];
		for (char c : s1.toCharArray()) {
			alphabet[c - 'a']++;
		}
		boolean flag = false;
		System.out.println(Arrays.toString(alphabet));
		int j = 0;
		int rem = s1.length();
		for (int i = 0; i < s2.length(); i++) {
			while (j < s2.length() && j - i < s1.length()) {
				if (alphabet[s2.charAt(j++) - 'a']-- > 0) {
					rem--;
				}
			}
			if (rem == 0 && j - i == s1.length()) {
				return true;
			}
			if (alphabet[s2.charAt(i) - 'a']++ >= 0)
				rem++;
		}
		System.out.println(Arrays.toString(alphabet));
		return flag;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "ab";
		String s2 = "eidboaoo";

		Solution sol = new Solution();
		System.out.println(sol.checkInclusion(s1, s2));

	}

}
