package com.video04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ComparatorTest {

	public static void main(String[] args) {
		
		List<String> studentList = new ArrayList<>(Arrays.asList("Naman", "Amit", "Akshay", "Mohit"));
		Collections.sort(studentList, (s1, s2) -> s2.compareTo(s1));
		studentList.stream().forEach(s -> System.out.print(s + ' '));
	}
}
