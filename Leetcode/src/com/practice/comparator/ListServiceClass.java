package com.practice.comparator;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author amitshetty
 * The purpose of this class is to perform test operations on the lost data structure.
 */
public class ListServiceClass {
	
	public void sortThisListDefault(List<Student> studentList) {
		
		System.out.println("before sort ==> " + Arrays.asList(studentList));
		/**
		 * List doesn't work on primitive variables. Need to cast primitives as Objects.
		 * Objects need to implement the comparable interface
		 */
		Collections.sort(studentList);
//		System.out.println(studentList);
		
		
//		Collections.sort(studentList, new AgeComparator());
//		
//		System.out.println(studentList);
		
		
		Comparator<Student> ageComparator = (o1, o2) -> { return (o1.getAge() < o2.getAge()) ? -1 : (o1.getAge() > o2.getAge()) ? 1 : 0; };
		Collections.sort(studentList, ageComparator);
		
//		System.out.println(studentList);
		
		
		
		Collections.sort(studentList, new NameCompartor());
//		System.out.println(studentList);
		
		
		Comparator<Student> nameReverseComparator = (o1, o2) -> {return o2.getLast_name().compareTo(o1.getLast_name());};
		Collections.sort(studentList, nameReverseComparator);
//		System.out.println(studentList);
		
		studentList.stream().forEach(System.out::println);
		
		List<Student> studentList2 = studentList.stream().filter(i -> i.getAddress().getFlat_no() == 1).collect(Collectors.toList());
		System.out.println(studentList2);
		
		
	}

	private PrintStream println() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
