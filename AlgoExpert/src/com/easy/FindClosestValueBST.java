package com.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindClosestValueBST {

	/**
	 * Takes tree node as input and value to find
	 */
	int diff = Integer.MAX_VALUE;
	int closest = 0;
	public int findClosestValueInTree(ModelClosestSum tree, int value) {
		
		// Returning max value so that null value will not be considered
		if(tree == null)
			return Integer.MAX_VALUE;
		//diff = Math.min(diff, Math.abs(tree.value - value));
		int temp = Math.abs(tree.value - value);
		if(temp < diff){
			closest = tree.value;
			diff = temp;
			// If the diff is 0 that means the values are equal so no need to tranverse the rest of the tree
			if(temp == 0) {
				System.out.println("Done");
				return closest;
			}
		}
		/*
		 * Since it is a binary search tree if the value to be found is greater that the current root value then ignore the left of the tree else ignore right
		 */
		if(value > tree.value) {
			findClosestValueInTree(tree.right, value);
		} else {
			findClosestValueInTree(tree.left, value);
		}
		return closest;
		

	}

	public ModelClosestSum constructBST(int[] nums) {

		int n = nums.length;
		int start = 0;
		int end = n - 1;
		ModelClosestSum root = null;
		return constructBSTHelper(nums, start, end);

	}

	public ModelClosestSum constructBSTHelper(int[] nums, int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		ModelClosestSum node = new ModelClosestSum(nums[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = constructBSTHelper(nums, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of root
		 */
		node.right = constructBSTHelper(nums, mid + 1, end);

		return node;

	}

	public List<Integer> getInorderList(ModelClosestSum root, List<Integer> numsList) {
		if (root == null)
			return null;
		getInorderList(root.left, numsList);
		numsList.add(root.value);
		getInorderList(root.right, numsList);

		return numsList;
	}

	public List<Integer> getPreorderList(ModelClosestSum root, List<Integer> numsList) {

		if (root == null)
			return null;
		numsList.add(root.value);
		getPreorderList(root.left, numsList);
		getPreorderList(root.right, numsList);
		return numsList;
	}

	public List<Integer> getPostorderList(ModelClosestSum root, List<Integer> numsList) {

		if (root == null)
			return null;
		getPreorderList(root.left, numsList);
		getPreorderList(root.right, numsList);
		numsList.add(root.value);
		return numsList;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 5, 10, 13, 14, 15, 22 };
		int checkNumber = 15;
		// Construct binary tree from the given array. Pass to the function
		FindClosestValueBST fcvbst = new FindClosestValueBST();
		System.out.println("Constructing tree");
		ModelClosestSum tree = fcvbst.constructBST(nums);
		System.out.println("Tree is made");

		System.out.println("Printing inorder traversal of tree");
		List<Integer> inorderList = new LinkedList<>();
		System.out.println(Arrays.toString(fcvbst.getInorderList(tree, inorderList).toArray()));
		System.out.println("Inorder traversal printing done");

		System.out.println("Printing preorder traversal of tree");
		List<Integer> preorderList = new LinkedList<>();
		System.out.println(fcvbst.getPreorderList(tree, preorderList));
		System.out.println("Preorder traversal printing done");

		System.out.println("Printing postorder traversal of tree");
		List<Integer> postorderList = new LinkedList<>();
		System.out.println(fcvbst.getPostorderList(tree, postorderList));
		System.out.println("Postorder traversal printing done");
		
		System.out.println(fcvbst.findClosestValueInTree(tree, checkNumber));
		
		
		
	}

}
