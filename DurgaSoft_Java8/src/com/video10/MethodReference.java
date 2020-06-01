package com.video10;

public class MethodReference {
	
	public static void m1() {
		for(int i = 0; i< 10; i++) {
			System.out.println("Child1 Thread");
		}
	}
	
	public void m2() {
		for(int i = 0; i< 10 ; i++) {
			System.out.println("Child2 Thread");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable r = () -> {
			for (int i = 0; i< 10; i++) {
				System.out.println("Child Thread");
			}
		};
		
		/*
		 * This step will prevent writing duplicate code writing lambda expression.
		 * This way one can simply refer to any method written normally in a lambda expression
		 */
		// This works only for static methods
		Runnable r1 = MethodReference::m1;
		
		// For non static methods we need to use the object reference
		MethodReference mr = new MethodReference();
		Runnable r2 = mr::m2;
		
		
		Thread t = new Thread(r2);
		t.start();
		
		for(int i = 0; i< 10; i++) {
			System.out.println("Main Thread");
		}

	}

}
