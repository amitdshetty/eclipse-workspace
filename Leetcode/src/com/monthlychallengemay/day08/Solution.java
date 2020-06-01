package com.monthlychallengemay.day08;

public class Solution {

	public boolean checkStraightLine(int[][] coordinates) {

		if (coordinates.length == 2)
			return true;
		// Since the first two line are always on the same line we will check from the
		// next line
		int x1 = coordinates[0][0];
		int x2 = coordinates[1][0];
		int y1 = coordinates[0][1];
		int y2 = coordinates[1][1];

		for (int i = 2; i < coordinates.length; i++) {
			int x3 = coordinates[i][0];
			int y3 = coordinates[i][1];
			if ((y2 - y1) * (x3 - x1) != (x2 - x1) * (y3 - y1))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] nums = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		Solution sol = new Solution();
		System.out.println(sol.checkStraightLine(nums));
	}
}
