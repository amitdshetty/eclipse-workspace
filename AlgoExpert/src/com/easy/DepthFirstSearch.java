package com.easy;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
	List<String> result = new LinkedList<>();
	class Node{
		String value;
		List<Node> children;
		
		Node(String value){
			this.value = value;
			this.children = new LinkedList<>();
		}
		
		void addchild(String value) {
			this.children.add(new Node(value));
		}
	}
	
	List<String> doDFS(Node node){
		result.add(node.value);
		for(Node i : node.children) {
			doDFS(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
