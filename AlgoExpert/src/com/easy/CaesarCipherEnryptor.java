package com.easy;

/*
 * ASCII Value 
 * A-Z = 65-90 (inclusive)
 * a-z = 97-122 (inclusive)
 * 0-9 = 48-57 (inclusive)
 */
public class CaesarCipherEnryptor {
	
	/**
	 * Once benefit of this method over encrypt is that it take constant space since retrieval is happening from an array of size 26
	 * However if there is a different alphabet setup then space might change
	 * 
	 *  Time Complexity O(n)
	 *  Space Complexity O(size of array) = constant space = O(1)
	 * @param input
	 * @param key
	 * @return
	 */
	public String encrypt2(String input, int key) {

		StringBuilder finalString = new StringBuilder();

		/**
		 * This takes care of an edge case where key so greater than 26 since beyond 26
		 * the else conditions will give a different result
		 */
		if (key > 26)
			key = key % 26;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		for (char c : input.toCharArray()) {
			int ascii_value_transform = alphabet.indexOf(c) + key;
			// 25 being the ascii value of z
			if (ascii_value_transform <= 25)
				finalString.append(alphabet.toCharArray()[ascii_value_transform]);
			else
				// -1 will allow us to rotate the array
				finalString.append(alphabet.toCharArray()[((-1 + ascii_value_transform) % 25)]);
		}

		return finalString.toString();

	}

	/**
	 * Time Complexity = O(n) Space Complexity = O(n)
	 * 
	 * @param input
	 * @param key
	 * @return
	 */
	public String encrypt(String input, int key) {

		StringBuilder finalString = new StringBuilder();

		/**
		 * This takes care of an edge case where key so greater than 26 since beyond 26
		 * the else conditions will give a different result
		 */
		if (key > 26)
			key = key % 26;

		for (char c : input.toCharArray()) {
			int ascii_value_transform = (int) c + key;
			// 122 being the ascii value of z
			if (ascii_value_transform <= 122)
				finalString.append((char) ascii_value_transform);
			else
				// 96 because it lies just before the small a so it rotates the array
				finalString.append((char) ((96 + ascii_value_transform) % 122));
		}

		return finalString.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "amit";
		int key = 9;
		CaesarCipherEnryptor cce = new CaesarCipherEnryptor();
		System.out.println(cce.encrypt2(input, key));

	}

}
