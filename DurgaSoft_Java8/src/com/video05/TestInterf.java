package com.video05;

public class TestInterf implements IInterf{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("M1 called");
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2 called");
		
	}
	
	@Override
	public void m3() {
		// TODO Auto-generated method stub
		//IInterf.super.m3();
		System.out.println("World");
	}
	
	public static void main(String[] args) {
		TestInterf ti = new TestInterf();
		ti.m1();
		ti.m2();
		ti.m3();
		System.out.println(ti.whatNumber());
	}
	
	
	
}
