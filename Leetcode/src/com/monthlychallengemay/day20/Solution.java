package com.monthlychallengemay.day20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public int kthSmallestElement(TreeNode node, int k) {
		List<Integer> finalList = new ArrayList<>();
		inOrderTraversal(node, finalList);
		System.out.println(finalList.toString());
		return finalList.get(k-1);
		
	}
	
	public void inOrderTraversal(TreeNode node, List nodeList) {
		
		if(node == null)
			return;
		inOrderTraversal(node.left, nodeList);
		nodeList.add(node.val);
		inOrderTraversal(node.right, nodeList);
		
	}
	
	/**
	 * IMPORTANT: Construct a binary tree using an integer array which has null values as well
	 * @param nums
	 * @return
	 */
	public TreeNode constructBST(Integer[] nums) {
		
		if (nums == null || nums.length==0) {
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            integerQueue.offer(nums[i]);
        }

        TreeNode treeNode = new TreeNode(nums[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()){
            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal !=null) {
                    TreeNode left = new TreeNode(leftVal);
                    current.left = left;
                    treeNodeQueue.offer(left);
            }
            if (rightVal !=null){
                    TreeNode right = new TreeNode(rightVal);
                    current.right = right;
                    treeNodeQueue.offer(right);
            }
        }
        return treeNode;
		
		
	}
	
	
	public static void main(String[] args) {
		
		Integer[] nums = new Integer[] {3,1,4,null,2};
		Solution sol = new Solution();
		TreeNode root = sol.constructBST(nums);
		int k = 4;
		int result = sol.kthSmallestElement(root, k);
		System.out.printf("The %d th smallest element is %d", k, result);
		
		
	}

}
