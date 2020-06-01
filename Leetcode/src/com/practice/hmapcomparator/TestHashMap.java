package com.practice.hmapcomparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestHashMap {

	public void sortByKey(Map<Integer, String> inputMap) {

		System.out.println("Before Sorting");
		Set inputSet = inputMap.entrySet();
		System.out.println(inputSet);
		Iterator it = inputSet.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println("The key " + me.getKey() + " and the value is " + me.getValue());

		}

		System.out.println("After Sorting");
		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(inputMap);
		Set inputSet1 = sortedMap.entrySet();
		System.out.println(inputSet1);
		Iterator it1 = inputSet1.iterator();
		while (it1.hasNext()) {
			Map.Entry me1 = (Map.Entry) it1.next();
			System.out.println("The key " + me1.getKey() + " and the value is " + me1.getValue());

		}

	}
	
	
	public void sortByValue(Map<Integer, String> inputMap) {
		
		System.out.println("Before Sorting");
		Set inputSet = inputMap.entrySet();
		System.out.println(inputSet);
		Iterator it = inputSet.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println("The key " + me.getKey() + " and the value is " + me.getValue());

		}
		
		List list = new LinkedList<>(inputSet);
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((String) (((Map.Entry) (o1)).getValue())).compareToIgnoreCase((String)((Map.Entry) (o2)).getValue());
			}
		});
		
		//System.out.println(list.get(0));
		Map sortedMap = new LinkedHashMap<>();
		for(Iterator it1 = list.iterator(); it1.hasNext();) {
			Map.Entry me = (Map.Entry)it1.next();
			sortedMap.put(me.getKey(), me.getValue());
		}
		
		System.out.println(sortedMap.values());
		
		
	}
	
	
	// TBD https://stackoverflow.com/questions/2864840/treemap-sort-by-value
	
	public static void main(String[] args) {

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "A");
		hmap.put(11, "C");
		hmap.put(4, "aZ");
		hmap.put(77, "Y");
		hmap.put(9, "P");
		hmap.put(66, "Q");
		hmap.put(0, "R");

		TestHashMap thm = new TestHashMap();
		//thm.sortByKey(hmap);
		thm.sortByValue(hmap);
	}

}
