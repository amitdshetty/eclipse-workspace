package com.monthlychallengemay.day07;

import com.monthlychallengemay.day07.model.TreeNode;

public class GetMaxDepthBinaryTree {
	
	public int getDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int left_depth = getDepth(root.left);
		int right_depth = getDepth(root.right);
		return Math.max(left_depth, right_depth) +1;
	}

}
