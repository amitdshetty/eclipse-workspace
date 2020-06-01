package com.video02;

public class Demo_Func_interdace {
	
	public static void main(String[] args) {
		F2_Interface f2 = () -> System.out.println("hello");
		// invoked the abstract method directly
		// No need to write a class to implement the interface
		f2.m1();
	}

}
