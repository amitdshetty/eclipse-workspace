package com.video01;

import java.util.function.Predicate;

public class EvenNumber {
	
	public static void main(String[] args) {
		Predicate<Integer> checkEven = i -> i%2 == 0;
		System.out.println(checkEven.test(3));
	}

}
