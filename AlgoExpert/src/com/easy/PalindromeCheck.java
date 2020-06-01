package com.easy;

public class PalindromeCheck {
	
	/*
	 * This is by far the best approach to solve this problem using pointers
	 * Time O(n) since whole string needs to be traversed anyways
	 * Space O(1) since no new data structure or object is used only pointers
	 */
	public boolean isPalindrome3(String input) {
		
		int i = 0;
		int j = input.length() - 1;
		while(i <= j) {
			if(input.charAt(i) !=input.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	
	/*
	 * This one uses recursive calls 
	 * Time O(n)
	 * Space O(n) due to memory occupied on the call stack
	 */
	public boolean isPalindorme2(String input) {
		
		int i = 0;
		return isPalindrome2Helper(input, i);
	}
	
	public boolean isPalindrome2Helper(String input,int index) {
		int j = input.length() - 1 - index;
		return (index >= j) ? true : (input.charAt(index) == input.charAt(j) && isPalindrome2Helper(input, index + 1));
	}
	
	/*
	 * This one uses a new Stirng object
	 * Time O(n^2)
	 * Space O(n)
	 */
	public boolean isPalindrome1(String input) {
		
		String reverse = "";
		for(int i = input.length() - 1; i >=0; i--) {
			reverse += input.charAt(i);
		}
		System.out.println("Reverse ==> " + reverse);
		return (input.equals(reverse));
	}
	
	public static void main(String[] args) {
		String input = "sdsdad";
		PalindromeCheck pc = new PalindromeCheck();
		//System.out.println(pc.isPalindrome1(input)); // Works
		//System.out.println(pc.isPalindorme2(input)); //Works
		System.out.println(pc.isPalindrome3(input));
	}

}
