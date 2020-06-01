package com.practice.comparator;

public class Student implements Comparable<Student>{

	private Integer student_id;
	private String first_name;
	private String last_name;
	private int age;
	private Address address;

	public Student(int student_id, String first_name, String last_name, int age, Address address) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.address = address;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", age=" + age + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		Integer pinCode = new Integer(this.getAddress().getPincode());
		Integer toCompare = new Integer(o.getAddress().getPincode());
		return pinCode.compareTo(toCompare);
	}

}
