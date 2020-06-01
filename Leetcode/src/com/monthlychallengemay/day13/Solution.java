package com.monthlychallengemay.day13;

import java.util.Stack;

public class Solution {
	
	public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0)  return num;
        if(k == len) return "0";
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        
        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        
        //This is done in case the string is completely parsed and there are still numbers left to remove
        // Since we already have the smallest numbers here
        
        while(k > 0) { 
        	stack.pop();
        	k--;
        }
        
        String smallest = "";
        while(!stack.isEmpty()) smallest = stack.pop() + smallest;
        
		// delete leading zeros
        while(smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);
        
        return smallest;
    }
	
	public static void main(String[] args) {
		String num = "10200";
		int k = 1;
		Solution sol = new Solution();
		System.out.println(sol.removeKdigits(num, k));
	}

}
