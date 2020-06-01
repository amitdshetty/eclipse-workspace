package com.amit;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		
		/*
		 * Note that you cannot simply
		 */
		String[] chunks = s.split("\\s+");
		// System.out.println(chunks[chunks.length - 1].length());
		return (chunks.length > 0) ? chunks[chunks.length - 1].length() : 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = " ";
		LengthOfLastWord lolw = new LengthOfLastWord();
		System.out.println(lolw.lengthOfLastWord(input));
	}

}
