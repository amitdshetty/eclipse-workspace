package com.monthlychallengemay.day07;

import com.monthlychallengemay.day07.model.TreeNode;
/**
 * Only 81/103 test cases passed
 * @author amitshetty
 *
 */
public class Solution {
	TreeNode parent = null;
	int index = -1;

	public boolean isCousins(TreeNode root, int x, int y) {
		checkIfCousin(root, parent, x, index);
		int left_index = index;
		TreeNode left_parent = parent;
		resetParams();
		checkIfCousin(root, parent, y, index);
		int right_index = index;
		TreeNode right_parent = parent;

		return left_index == right_index && left_parent != right_parent;
	}
	
	// I have no idea why the y index needs to be reset to -2
	public void resetParams() {
		index = -2;
		parent = null;
	}

	public void checkIfCousin(TreeNode root, TreeNode parent1, int x, int index1) {
		if (root == null)
			index = 0;
		else if (root.val == x)
			index = index1;
		else {
			checkIfCousin(root.left, root, x, index1 + 1);
			checkIfCousin(root.right, root, x, index1 + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node1 =  new TreeNode(1);

	}

}
