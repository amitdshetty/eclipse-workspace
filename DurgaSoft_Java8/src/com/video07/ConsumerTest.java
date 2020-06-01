package com.video07;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		Student s1 = new Student("Amit", 85);
		Consumer<Student> c1 = i -> {
			System.out.printf("The student's name is %s and his score is %d", i.name, i.marks);
		};
		c1.accept(s1);

	}

}
