package com.video08;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiPredicate<Integer, Integer> b1 = (a, b) -> {
			
			return (a+b) % 2 == 0; 
			
		};
		
		System.out.println(b1.test(10, 4));
		
		BiFunction<Integer, Integer, Integer> b2 = (a, b) -> {
			return a*b;
		};
		System.out.println(b2.apply(10, 5));
		
		
		BiConsumer<String, String> b3 = (a , b) -> {
			System.out.printf("The name is %s and %s" ,a, b);
		};
		b3.accept("Amit", "Shetty");
		
	}

}
