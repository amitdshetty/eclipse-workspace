package com.video10;

public class Sample {
	
	public Sample() {
		System.out.println("This is the sample constructor");
	}
	
	public Sample(String name) {
		System.out.println("The name of this constructor is " + name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// This one calls the constructor of the sample class
		I1 i1 = Sample::new;
		
		Sample s1 = i1.get("Amit");
		Sample s2 = i1.get("Shetty");
		

	}

}
