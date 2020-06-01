package com.practice.comparator;

import java.util.Comparator;

public class NameCompartor implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		// return (o1.getName() < o2.getName()) ? -1 : (o1.getName() < o2.getName()) ? 1 : 0;
		
		return o1.getFirst_name().compareTo(o2.getFirst_name());
	}

}
