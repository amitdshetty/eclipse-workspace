package com.video08;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		
		// Write a function to return the date
		Supplier<Date> s = ()->new Date();
		System.out.println(s.get());
		
		// Write a function to return a 6 digit ranom OTP
		
		Supplier<String> s1 = () -> {
			String otp = "";
			for(int i=0; i< 6; i++) {
				otp += (int)(Math.random() * 10);
			}
			return otp;
		};
		
		System.out.println(s1.get());
		
	}

}
