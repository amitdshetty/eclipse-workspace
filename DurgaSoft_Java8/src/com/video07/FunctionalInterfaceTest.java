package com.video07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Function interface definition as per source code
 * 
 * interface Function<T, R> {
 * 	public R apply(T t);
 * }
 * where, 
 * T -> input Type
 * R -> return Type
 * 
 */
public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Write a function that return a square value of an integer it has been given
		
		Function<Integer, Integer> f1 = i->i*i;
		System.out.println(f1.apply(4));
		System.out.println(f1.apply(5));
		System.out.println(f1.apply(49));
		
		// Write a function that returns the length of the string
		Function<String, Integer> f2 = s -> s.length();
		System.out.println(f2.apply("Hello Worlds"));
		
		// Get the grade for a student when marks are given as input
		Function<Student, String> f3 = s -> {
			int marks = s.marks;
			if(marks > 80) return "A [Distinction]";
			else if(marks > 70) return "B [First Class]";
			else if(marks > 60) return "B [First Class]";
			else if(marks > 50) return "C [Second Class]";
			else return "D [Fail]";
		};
		
		Student s1 = new Student("Amit", 85);
		Student s2 = new Student("Mohit", 75);
		Student s3 = new Student("Akshay", 65);
		Student s4 = new Student("Naman", 55);
		Student s5 = new Student("Aroda", 45);
		
		// This is for returning students whose score is greater than 60
		Predicate<Integer> p1 = i -> i >=60;
		
		List<Student> studentList = new ArrayList<Student>() {{
			add(s1);
			add(s2);
			add(s3);
			add(s4);
			add(s5);
		}
		};
		
//		Consumer<Student> c1 = s -> {
//			System.out.printf("The grade for %s is %s \n", s.name, f3.apply(s));
//		};
//		
//		for(Student e : studentList) {
//			if(p1.test(e.marks))
//				c1.accept(e);
//		}
	}

}
