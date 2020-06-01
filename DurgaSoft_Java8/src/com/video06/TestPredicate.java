package com.video06;

import java.util.function.Predicate;


/**
 * 
 * @author amitshetty
 *	Predicate is used when checking a boolean condition
 *
 */
public class TestPredicate {
	
	public static void main(String[] args) {
		Predicate<Integer> p1 = i -> i%2 == 0;
		System.out.println("p1 " +p1.test(11));
		System.out.println("p1 " +p1.test(10));
		
		
		
		Predicate<String> p2 = s -> !s.equalsIgnoreCase("Hello") && s.length() == 5;
		System.out.println("p2 " +p2.test("World"));
		System.out.println("p2 " +p2.test("hello"));
		
		
		//predicate joining
		Predicate<Integer> p3 = i -> i > 10;
		System.out.println("p3 " +p3.and(p1).test(10));
		System.out.println("p3 " +p3.or(p1).test(28));
		System.out.println("p3 negates test " + p3.negate().test(9));
	}

}
