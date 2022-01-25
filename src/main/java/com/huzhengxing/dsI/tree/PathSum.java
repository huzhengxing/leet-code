package com.huzhengxing.dsI.tree;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-23 11:06:30
 * @LastEditTime: 2022-01-24 19:59:10
 * @Description: 
https://leetcode.com/problems/path-sum/
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		return traversal(root, targetSum, 0) == targetSum;
	}

	public int traversal(TreeNode node, int targetSum, int sum) {
		if (node.left == null && node.right == null) {
			return sum + node.val;
		}
		int leftSum;
		int rightSum;
		if (node.left != null && node.right == null) {
			leftSum = traversal(node.left, targetSum, sum + node.val);
			rightSum = 1001;
		} else if (node.left == null && node.right != null) {
			rightSum = traversal(node.right, targetSum, sum + node.val);
			leftSum = 1001;
		} else {
			leftSum = traversal(node.left, targetSum, sum + node.val);
			rightSum = traversal(node.right, targetSum, sum + node.val);
		}
		if (leftSum == targetSum || rightSum == targetSum) {
			return targetSum;
		} else {
			return 1001;
		}
	}

	public boolean hasPathSum1(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		return hasPathSum(root, targetSum, 0);
	}

	public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
		if (root.left == null && root.right == null)
			return sum + root.val == targetSum;
		boolean left = false;
		boolean right = false;
		if (root.left != null) {
			left = hasPathSum(root.left, targetSum, sum + root.val);
		}
		if (root.right != null) {
			right = hasPathSum(root.right, targetSum, sum + root.val);
		}
		return left || right;
	}
}
