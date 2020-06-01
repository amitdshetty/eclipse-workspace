package com.monthlychallenge.day24;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	
	Map<Integer, Integer> lrucache = null;
	int size = 0;
	LinkedList<Integer> insertionKeyOrder = new LinkedList<>();
	
	
    public LRUCache(int capacity) {
    	this.size = capacity;
    	this.lrucache = new HashMap<>();
    }
    
    public int get(int key) {
    	
    	if(lrucache.containsKey(key)) {
    		insertionKeyOrder.remove(new Integer(key));
    		insertionKeyOrder.offer(key);
    		return lrucache.get(key);
    	}
    	return -1;
    	
        
    }
    
    public void put(int key, int value) {
    	
    	
    	if(lrucache.size() >= size && !lrucache.containsKey(key)) {
    		int removed = insertionKeyOrder.pollFirst();
    		// System.out.println(removed);
    		lrucache.remove(removed);
    		lrucache.put(key, value);
    	} else 
    	lrucache.put(key, value);
    	insertionKeyOrder.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
