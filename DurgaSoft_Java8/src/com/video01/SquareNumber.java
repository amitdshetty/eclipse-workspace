package com.video01;

import java.util.function.Function;

public class SquareNumber {

	/**
	 * This method won't be needed due to functional programming
	 * 
	 * @param a
	 * @return
	 */
	public static int squares_numbers(int a) {
		return (int) Math.pow(a, 2);
	}

	public static void main(String[] args) {
		int a = 4;
		int b = 5;

		// Functional programming
		// Function <input data type, output data type>
		Function<Integer, Integer> square_function = i -> (int) Math.pow(i, 2);

		System.out.printf("The square of %d and %d is %d and %d respectively", a, b, square_function.apply(a),
				square_function.apply(b));
	}

}
