package com.practice.comparator;

public class Address {

	private int flat_no;
	private String building_name;
	private String street;
	private String city;
	private int pincode;

	public Address(int flat_no, String building_name, String street, String city, int pincode) {
		super();
		this.flat_no = flat_no;
		this.building_name = building_name;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	public int getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}
	

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [flat_no=" + flat_no + ", building_name=" + building_name + ", street=" + street + ", city="
				+ city + ", pincode=" + pincode + "]";
	}

}
