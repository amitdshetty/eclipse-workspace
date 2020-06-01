package com.video01;

public class Codelity {

	public static int someMethod(int nums) {
		String num = String.valueOf(nums);
		String result = "";
		if (nums < 0) {

			nums = Integer.parseInt(num.substring(1, num.length()));
			num = String.valueOf(nums);
			int low = 0;
			int high = num.charAt(0) - '0';
			char c = '5';
			while (low < num.length() && high <= 5) {

				low++;
				if (low < num.length()) {
					high = num.charAt(low) - '0';
				}

			}
			String s1 = num.substring(0, low);
			String s2 = num.substring(low, num.length());
			result = "-" + s1 + "5" + s2;

		} else {
			int low = 0;
			int high = num.charAt(0) - '0';
			char c = '5';
			while (low < num.length() && high >= 5) {

				low++;
				if (low < num.length()) {
					high = num.charAt(low) - '0';
				}

			}
			String s1 = num.substring(0, low);
			String s2 = num.substring(low, num.length());
			result = s1 + "5" + s2;

		}
		return Integer.parseInt(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(someMethod(-375));

	}

}
