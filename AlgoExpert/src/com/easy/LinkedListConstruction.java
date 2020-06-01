package com.easy;

public class LinkedListConstruction {
	
	class Node{
		Node next;
		Node prev;
		int value;
		
		Node(int value){
			this.value = value;
		}
	}
	
	Node head;
	Node tail;
	
	public void setHead(Node node) {
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			insertBefore(this.head, node);
		}
	}
	
	public void setTail(Node node) {
		if(this.tail == null) {
			setHead(node);
		} else
			insertAfter(this.tail, node);
	}
	
	public void insertAtPosition(int position, Node nodeToInsert, Node node) {
		if(position == 1) {
			setHead(nodeToInsert);
			return;
		}
		int count = 1;
		while(node.next != null && count != position) {
			count += 1;
			node = node.next;
		}
		
		
		if(node != null)
			insertBefore(node, nodeToInsert);
		else
			setTail(nodeToInsert);
		
		
	}
	
	
	public void insertBefore(Node node, Node nodeToInsert) {
		
		if(nodeToInsert == this.head || nodeToInsert == this.tail) {
			return;
		}
		remove(nodeToInsert);
		nodeToInsert.prev = node.prev;
		nodeToInsert.next = node;
		if(node.prev == null)
			this.head = nodeToInsert;
		else 
			node.prev.next = nodeToInsert;
		node.prev = nodeToInsert;
		
	}
	
	public void insertAfter(Node node, Node nodeToInsert) {
		if(nodeToInsert == this.head || nodeToInsert == this.tail) {
			return;
		}
		remove(nodeToInsert);
		nodeToInsert.prev = node;
		nodeToInsert.next = node.next;
		if(node.next == null)
			this.tail = nodeToInsert;
		else
			node.next.prev = nodeToInsert;
		node.next = nodeToInsert;
	}
	
	public void removeNodeWithValue(Node node, int value) {
		node = this.head;
		while(node != null) {
			Node nodeToRemove = node;
			node = node.next;
			if(nodeToRemove.value == value) {
				remove(nodeToRemove);
			}
			// The below line won't work since we lose access to the pointer
			// node = node.next;
		}
	}
	
	public boolean containsNodeWithValue(Node node, int value) {
		node = this.head;
		while(node != null && node.value != value) {
			node = node.next;
		}
		return (node != null) ? true : false;
	}
	
	public void remove(Node node) {
		if(node == this.head) {
			this.head = this.head.next;
		}
		if (node == this.tail) {
			this.tail = this.tail.prev;
		}
		
		// Now modify next and prev pointers
		modifyPointers(node);
		
	}
	
	public void modifyPointers(Node node) {
		if(node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		node.prev = null;
		node.next = null;
	}

}
