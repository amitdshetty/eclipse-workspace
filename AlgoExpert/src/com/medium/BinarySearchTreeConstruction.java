package com.medium;

public class BinarySearchTreeConstruction {
	
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public int getMaxValue(Node node) {
		Node currentNode = node;
		while(currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode.value;
	}
	
	/**
	 * By traversing the tree all the way to the left we will get the minimum value
	 * @param node
	 * @return
	 */
	public int getMinValue(Node node) {
		Node currentNode = node;
		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		
		return currentNode.value;
	}
	
	/*
	 * Average Time O(log n) and Space O(1)
	 * Worst Case O(n) and Space O(1)
	 */
	public Node insert(Node node, int valueToInsert) {
		Node currentNode = node;
		while(true) {
			if(valueToInsert < currentNode.value) {
				if(currentNode.left == null) {
					currentNode.left = new Node(valueToInsert);
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if(currentNode.right == null) {
					currentNode.right = new Node(valueToInsert);
					break;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
		return node;
	}
	
	/*
	 * Average Case Time O(log n) Space O(1)
	 * Worst Case Time O(n) and Space O(1)
	 */
	public boolean contains(Node node, int valueToSearch) {
		Node currentNode = node;
		while(currentNode != null) {
			if(valueToSearch == currentNode.value)
				return true;
			else if (valueToSearch < currentNode.value)
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		}
		return false;
	}
	
	public Node remove(Node node, int valueToRemove, Node parentNode) {
		Node currentNode = node;
		while(currentNode != null) {
			if(valueToRemove  < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else if (valueToRemove  > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.right;
			} else {
				// This is the key logic where the node to delete has been found
				// The value to be replaced has to be the minimum value from the right subtree of that node
				if(currentNode.left != null && currentNode.right != null) {
					// What we are doing is getting the smallest value of the right subtree and replacing it as the currentNode.
					currentNode.value = getMinValue(currentNode.right);
					remove(currentNode.right, currentNode.value, currentNode);
				} else if (parentNode.left == currentNode) {
					if(currentNode.left != null)
						parentNode.left = currentNode.left;
					else
						parentNode.left = currentNode.right;
				} else if (parentNode == null) {
					if(currentNode.left != null) {
						currentNode.value = currentNode.left.value;
						currentNode.right = currentNode.left.right;
						// Order here is important. Currentnode.left has to be assigned last to avoid ambiguity
						currentNode.left = currentNode.left.left;
					} else if (currentNode.right != null) {
						currentNode.value = currentNode.right.value;
						currentNode.left = currentNode.right.left;
						// Order here is important.
						currentNode.right = currentNode.right.right;
					} else {
						// This happens if there is only one node so deleting this is deleting the entire BST
						currentNode = null;
					}
				} 
				else if (parentNode.right == currentNode) {
					if(currentNode.left != null)
						parentNode.right = currentNode.left;
					else
						parentNode.right = currentNode.right;
				}
				break;
			}
		}
		return node;
	}

}
