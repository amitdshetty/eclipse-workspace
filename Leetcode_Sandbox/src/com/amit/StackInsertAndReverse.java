package com.amit;

import java.util.Stack;

public class StackInsertAndReverse {
	
	public Stack insertAtBottom(Stack s, int x) {
		
		if(s.isEmpty()) {
			s.push(x);
		} else {
			
			int y = (int) s.peek();
			s.pop();
			insertAtBottom(s, x);
			s.push(y);
		}
		return s;
	}
	
	public Stack reverseAStack(Stack s) {
		
		
		if(s.size() > 0) {
			int x = (int) s.peek();
			s.pop();
			reverseAStack(s);
			insertAtBottom(s, x);
		}
		
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> s = new Stack<>();
		for(int i = 1; i < 5; i++ ) {
			s.push(i);
		}
		StackInsertAndReverse sar = new StackInsertAndReverse();
		int x = 5;
		// s = sar.insertAtBottom(s, x);
		s = sar.reverseAStack(s);
		System.out.println(s.toString());

	}

}
