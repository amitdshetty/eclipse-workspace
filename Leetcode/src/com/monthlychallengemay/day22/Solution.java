package com.monthlychallengemay.day22;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	
	/*
	 * This method uses the priority queue
	 */
	public String frequencySort1(String s) {
		
		if(s == null || s.length() == 0) return "";
		
		/*
		 * We are considering all 256 chracters in the ASCII table
		 */
		
		
		int[] count = new int[256];
		
		for(char c : s.toCharArray()) {
			count[c]++;
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
		
		for(int i = 0; i < 256; i++) {
			pq.offer((char) i);
		}
		// System.out.println(pq.toString());
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Character c = pq.poll();
			for(int i = 0; i < count[c]; i++) {
				sb.append(c);
			}
		}
		
		
		return sb.toString();
	}

	public String frequencySort(String s) {
		
		if(s.length() == 0)
			return "";
		if(s.length() == 1)
			return s;
		
		Map<Character, Integer> countMap = new HashMap<>();
		for(char c : s.toCharArray()) {
			
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		// System.out.println(countMap.toString());
		Map<Character, Integer> tempMap = sortByValues(countMap);
		// System.out.println(tempMap.toString());
		StringBuilder s1 = new StringBuilder();
		Set it  = tempMap.entrySet();
		for(Iterator it1 = it.iterator(); it1.hasNext();) {
			Map.Entry<Character, Integer>  me = (Map.Entry<Character, Integer>) it1.next();
			for(int i = 1; i <= me.getValue(); i++)
				s1.append(me.getKey());
		}
		return s1.toString();
	}
	
	public Map sortByValues(Map<Character, Integer> countMap) {
		
		List list = new LinkedList<>(countMap.entrySet());
		
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((Comparable) ((Map.Entry) (o2)).getValue())
		                  .compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		
		Map<Character, Integer> tempMap = new LinkedHashMap<>();
		Iterator it1 = list.iterator();
		while(it1.hasNext()) {
			Map.Entry m1 = (Map.Entry) it1.next();
			tempMap.put((Character) m1.getKey(), (Integer) m1.getValue());
		}
		
		return tempMap;
		
	}

	public static void main(String[] args) {
		
		String input = "tree";
		// Expected output = eert
		
		Solution sol = new Solution();
		System.out.println(sol.frequencySort(input));
		System.out.println(sol.frequencySort1(input));
	}

}
