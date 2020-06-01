package com.amit;

public class IPDefang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "1.2.3.4";
		//String[] splitAddress = address.split("\\.");
		String finalIP = address.replace(".", "[.]");
		System.out.println(finalIP);
	}

}
