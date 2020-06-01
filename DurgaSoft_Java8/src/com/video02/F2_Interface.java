package com.video02;


/*
 * Functional interface anotation in parent class prevents child class from becoming functional interface as well
 */

@FunctionalInterface
public interface F2_Interface extends F1_Interface {
	public void m1();
}
