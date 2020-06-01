package com.monthlychallengemay.day24;

public class BSTFromPreOrderTraversal {

	int index = 0;
	int index2 = 0;

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null || preorder.length == 0) {
			return null;
		}

		return preOrderBSTHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public TreeNode preOrderBSTHelper(int[] preorder, int min, int max) {
		
		if(index >= preorder.length)
			return null;
		
		int key = preorder[index];
		TreeNode node = null;
		if(key > min && key < max) {
			node = new TreeNode(key);
			index++;
			node.left = preOrderBSTHelper(preorder, min, key);
			node.right = preOrderBSTHelper(preorder, key, max);
		}
		return node;
		
	}
	
	public TreeNode bstFromPostOrder(int[] postorder) {
		if(postorder == null || postorder.length == 0)
			return null;
		
		return postOrderBSTHelper(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/*
	 * POst ORDer Need to CHECK
	 */
	public TreeNode postOrderBSTHelper(int[] postOrder, int min, int max) {
		
		if(index2 >= postOrder.length)
			return null;
		
		int key = postOrder[index2];
		TreeNode node = null;
		if(key > min && key < max) {
			index2++;
			node.left = postOrderBSTHelper(postOrder, min, key);
			node.right = postOrderBSTHelper(postOrder, key, max);
			node = new TreeNode(key);
		}
		return node;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTFromPreOrderTraversal sol = new BSTFromPreOrderTraversal();
		int[] nums = { 8, 5, 1, 7, 10, 12 };
		
		// Once BST is constructed we can prepare to traverse it in any fashion we need
		/*
		 * To remember
		 * Preorder = root > left > right
		 * Inorder = left > root >  right
		 * Postorder = left > right > root
		 */
		TreeNode node = sol.bstFromPreorder(nums);
		System.out.println(node.val);
		
		int[] nums2 = {40, 20, 50, 60, 30, 10};
		TreeNode node2 = sol.bstFromPostOrder(nums2);
		System.out.println(node2.val);
		
		

	}

}
