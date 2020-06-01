package com.video04;

public class TestThread {

	public static void main(String[] args) {
		
		
		// Anonymous inner Class
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Inner thread class");
				}
			}
		};

		Thread t = new Thread(r);
		t.start();
		for (int j = 0; j < 10; j++) {
			System.out.println("hello");
		}
	}

}
