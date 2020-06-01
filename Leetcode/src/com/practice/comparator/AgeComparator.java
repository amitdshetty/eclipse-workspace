package com.practice.comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
//		if (o1.getAge() < o2.getAge())
//			return -1;
//		else if (o1.getAge() > o2.getAge())
//			return 1;
//		return 0;
		// ternery operator
		return (o1.getAge() < o2.getAge()) ? -1 : (o1.getAge() > o2.getAge()) ? 1 : 0;  
	}

}
