package com.video05;

public interface IInterf {
	
	void m1();
	void m2();
	default void m3() {
		System.out.println("hello");
	}
	
	default int whatNumber() {
		return 1;
	}

}
