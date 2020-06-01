package com.amit;

class BuddyStrings {
	
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.equals(B)) {
			int[] count = new int[26];
			for (int i = 0; i < A.length(); ++i)
				count[A.charAt(i) - 'a']++;
			/*
			 * If more than one of the same letter is present in the same string then it cna safely be swapped without any issues
			 */
			for (int c : count)
				if (c > 1)
					return true;
			return false;
		} else {
			int first = -1, second = -1;
			for (int i = 0; i < A.length(); ++i) {
				if (A.charAt(i) != B.charAt(i)) {
					if (first == -1)
						first = i;
					else if (second == -1)
						second = i;
					/*
					 * At this point more than 2 characters are different then there is no way they will be buddy strings
					 */
					else
						return false;
				}
			}

			return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
		}
	}
	
	public static void main(String[] args) {
		String A = "aaaaaaabc";
		String B = "aaaaaaabc";
		BuddyStrings bs = new BuddyStrings();
		System.out.println(bs.buddyStrings(A, B));
	}
}
