package com.video02;


// Annotation will fail if there is no abstract method
@FunctionalInterface
public interface F1_Interface {
	
	public void m1(); // Valid
	
	//More than one abstract method is not allowed
	//public void m4();
	
	default void m2() {
		
	}
	
	static void m3() {
		
	}

}
