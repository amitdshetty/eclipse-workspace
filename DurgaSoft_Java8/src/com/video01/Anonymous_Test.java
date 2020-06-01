package com.video01;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Anonymous_Test {
	
//	() -> System.out.println("Hello World");
//	
//	(int a, int b) -> System.out.println(a+b);
//	
//	(a, b) -> a + b;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Supplier test = () -> {System.out.println("hello"); return "";} ;
		System.out.println(test.get());
	}

}
