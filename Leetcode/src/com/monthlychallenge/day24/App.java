package com.monthlychallenge.day24;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2);
		
//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.get(1);       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		cache.get(1);       // returns -1 (not found)
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4
		
		/*
		 * ["LRUCache","get","put","get","put","put","get","get"]
			[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
		 */
		
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);
		cache.get(1);
		cache.get(2);
		
	}

}
