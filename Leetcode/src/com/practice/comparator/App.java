package com.practice.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> studentList = new ArrayList<>();
		Student s1 = new Student(1, "Amit", "Shetty", 4, new Address(7, "Ajayan", "MG Road", "Bangalore", 560038));
		Student s2 = new Student(3, "Akshay", "Babu", 37, new Address(1, "UT Drive", "Hahah Road", "Mysore", 560039));
		Student s3 = new Student(2, "Mohit", "Saini", 2, new Address(7, "Ajayan", "MG Road", "Bangalore", 560040));
		
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		ListServiceClass listServiceClass = new ListServiceClass();
		
		// Default sort
		listServiceClass.sortThisListDefault(studentList);
		
		
		List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(5, 10, 15));
		numbersList.stream().forEach(System.out::println);
		List<Integer> l2 = numbersList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		System.out.println(l2);
		
		
		//Reverse Order Sorting
		
		Collections.sort(numbersList, (n1, n2) -> (n1 > n2) ? -1 : ((n1 < n2) ? 1: 0));
		System.out.println(numbersList);

	}

}
