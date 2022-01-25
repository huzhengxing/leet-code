/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-24 20:02:04
 * @LastEditTime: 2022-01-24 20:09:32
 * @Description: 
https://leetcode.com/problems/search-in-a-binary-search-tree/
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.


 */
package com.huzhengxing.dsI.tree;

public class SearchInABinarySearchTree {

	public TreeNode searchBST(TreeNode root, int val) {

		return traversal(root, val);
	}

	public TreeNode traversal(TreeNode node, int val) {
		if (node == null) {
			return null;
		}
		if (node.val == val) {
			return node;
		}
		TreeNode left = traversal(node.left, val);
		TreeNode right = traversal(node.right, val);
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
}
