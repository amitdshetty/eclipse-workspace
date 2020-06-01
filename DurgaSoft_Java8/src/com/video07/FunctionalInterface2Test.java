package com.video07;

import java.util.function.Function;

public class FunctionalInterface2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> f1 = i -> i*2;
		Function<Integer, Integer> f2 = i -> i*i;
		
		// Difference is that in the first case f1 executes first and then f2
		// In compose f2 executes first and then f1
		System.out.println(f1.andThen(f2).apply(10));
		System.out.println(f1.compose(f2).apply(10));
	}

}
