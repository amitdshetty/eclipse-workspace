package com.video03;

public class TestThread {
	
	public static void main(String[] args) {
		
		
		Runnable r = () -> {
			for(int i=0; i < 10; i++) {
				System.out.println("Lambda expression check");
			}
		};
		
		
		Thread t = new Thread(r);
		t.start();
		
		// Note implementing runnable you can only use run method and not start
		ThreadInterfaceCheck t1 = new ThreadInterfaceCheck();
		t1.run();
		ThreadClassTest tct = new ThreadClassTest();
		tct.start();
	}

}
