package com.monthlychallengemay.day07;

import com.monthlychallengemay.day07.model.Pair;
import com.monthlychallengemay.day07.model.TreeNode;

public class Solution2 {
	
	public boolean isCousins(TreeNode root, int x, int y) {
		
		Pair pair1 = checkIfCousin(root, null, x, 0);
		Pair pair2 = checkIfCousin(root, null, y, 0);
		return pair1.index == pair2.index && pair1.parent != pair2.parent;
		
	}
	
	public Pair checkIfCousin(TreeNode root, TreeNode parent, int x, int index) {
		if(root == null)
			return null;
		else if (root.val == x)
			return new Pair(parent, index);
		Pair leftPair = checkIfCousin(root.left, root, x, index + 1);
		Pair rightPair = checkIfCousin(root.right, root, x, index + 1);
		return (leftPair == null) ? rightPair : leftPair;
	}

}
