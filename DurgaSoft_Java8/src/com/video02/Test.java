package com.video02;

import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> squareit = n -> {return n*n;};
		System.out.println(squareit.apply(2));

	}

}
