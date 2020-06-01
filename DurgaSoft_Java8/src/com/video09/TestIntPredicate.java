package com.video09;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntPredicate;

public class TestIntPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * This one ensure autoboxing and autounboxing doesn't happen for every time this lambda expression is used
		 * 
		 * There are similar ones for other primitive types like double, long
		 * 
		 * Refer to https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html for more details
		 * 
		 */
		
		IntPredicate p1 = i -> i%2 == 0;
		System.out.println(p1.test(11));
		
		
		DoubleToIntFunction d1 = a -> (int) a/2;
		System.out.println(d1.applyAsInt(10.5));

	}

}
