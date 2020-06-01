package com.monthlychallengemay.day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindTownJudge {
	
	public int findJudge(int N, int[][] trust) {
		int[] temp = new int[N+1];
		for(int[] temp1: trust) {
			temp[temp1[0]]--;
			temp[temp1[1]]++;
		}
		for(int i = 1; i< temp.length; i++) {
			if(temp[i] == N-1)
				return i;
		}
		return -1;
	}
	
/*
 * With the below method at most 83/89 test cases passed
 */
//	public int findJudge(int N, int[][] trust) {
//
//		if (trust.length == 0)
//			return N;
//
//		Map<Integer, Integer> counter = new HashMap<>();
//		Set<Integer> processed = new HashSet<>();
//
//		for (int i = 0; i < trust.length; i++) {
//
//			if (counter.get(trust[i][0]) == null) {
//				if (!processed.contains(trust[i][0])) {
//					counter.put(trust[i][1], counter.getOrDefault(trust[i][1], 0) + 1);
//				}
//			} else {
//				counter.remove(trust[i][0]);
//			}
//			processed.add(trust[i][0]);
//
//		}
//
//		if (processed.size() == N)
//			return -1;
//		else
//			return getMissingNumber(processed, N);
//
////		if(counter.size() > 0) {
////			int result = counter.keySet().stream().findFirst().get();
////			return result;
////		}
////		return -1;
//
//	}
//
//	public int getMissingNumber(Set<Integer> processed, int n) {
//		Iterator it = processed.iterator();
//		int sumTotal = n * (n + 1) / 2;
//		while (it.hasNext()) {
//			sumTotal -= (int) it.next();
//		}
//		return sumTotal;
//
//	}

	public static void main(String[] args) {

		// int[][] inputNums = {{1,2}}; //Works
		// int[][] inputNums = {{1,3},{2,3}}; //Works
		//int[][] inputNums = { { 1, 3 }, { 2, 3 }, { 3, 1 } }; // Works
		// int[][] inputNums = {}; //Works
		int[][] inputNums = {{1,2},{6,4},{3,2},{2,6},{4,5},{6,1},{1,4},{1,5},{2,3},{2,1},{4,3},{4,2},{2,5},{4,1},{2,4},{6,5},{3,5}};
		//int[][] inputNums = {{1,2},{2,3}};
		int N = 6;

		FindTownJudge ftj = new FindTownJudge();
		System.out.println(ftj.findJudge(N, inputNums));

	}

}
